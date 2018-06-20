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



		//order要素のItemCountと,ItemPriceの総計を算出する
		int totalCount = 0;
		int totalPrice = 0;
		for(OrderBean addOrder: cart) {
			totalCount += addOrder.getItemCount();
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
		UpdateDAO updateDao = new UpdateDAO();
		updateDao.updateItem(request);

		//予約の追加が終了したので、cartを解放
		session.setAttribute("cart", null);

		return "/fixed.jsp";
	}

}
