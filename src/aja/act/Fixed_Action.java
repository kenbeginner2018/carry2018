package aja.act;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import aja.bean.LoginBean;
import aja.bean.OrderBean;
import aja.bean.Reservation_ListBean;
import aja.dao.AddDAO;
import aja.dao.UpdateDAO;

public class Fixed_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(true);

		ArrayList<OrderBean> cart = (ArrayList<OrderBean>) session.getAttribute("cart");
		LoginBean login = (LoginBean) session.getAttribute("login");



		//カートの中の商品合計数と,合計金額を算出する
		int totalCount = 0;
		int totalPrice = 0;

		//カートに入っている商品の種類の回数ぶん繰り返す
		for(OrderBean addOrder: cart) {
			//それぞれの商品の個数を足していき、合計個数を求める
			totalCount += addOrder.getItemCount();
			//小計を足していき、合計金額を求める
			totalPrice += addOrder.getSubTotal();
		}

		//Item_Reserverに登録するデータを設定
		Reservation_ListBean rList = new Reservation_ListBean();
		rList.setReservNo(login.getReservNo());
		rList.setTotalCount(totalCount);
		rList.setTotalPrice(totalPrice);
		rList.setDeliveryFlag(0);

		//addDaoのaddOrder()を利用して、Buy_Detail,Item_Reserverにレコードを追加
		AddDAO addDao = new AddDAO();
		addDao.addOrder(request,rList);

		//注文完了と同時に、購入された商品の数在庫を減らす
		UpdateDAO updateDao = new UpdateDAO();
		updateDao.updateItem(request);

		//予約の追加が終了したので、session(カート内情報とログイン情報)を削除
		session.invalidate();

		return "/fixed.jsp";
	}

}
