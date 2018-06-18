package aja.act;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import aja.bean.LoginBean;
import aja.bean.OrderBean;
import aja.bean.Reservation_ListBean;

public class Fixed_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(true);

		ArrayList<OrderBean> order = (ArrayList<OrderBean>) session.getAttribute("order");
		LoginBean login = (LoginBean) session.getAttribute("login");

		//order要素のItemCountと,ItemPriceの総計を算出する
		int totalCount = 0;
		int totalPrice = 0;
		for(OrderBean addOrder: order) {
			totalCount += addOrder.getItemCount();
			totalPrice += addOrder.getItemPrice();
		}

		//Item_Reserverに登録するデータを設定
		Reservation_ListBean rList = new Reservation_ListBean();
		rList.setReservNo(login.getReservNo());
		rList.setTotalCount(totalCount);
		rList.setTotalPrice(totalPrice);
		rList.setDeliveryFlag(0);

		//addDaoのaddOrder()を利用して、Buy_Detail,Item_Reserverにレコードを追加
		//addDao実装後importしたあと、コメントアウト状態を解除すること

		/*
		AddDao addDao = new AddDao();
		addDao.addOrder(request,rList);
		UpdateDao updatedao = new Update();
		update.updateItem(request);
		*/

		return "/fixed.jsp";
	}

}
