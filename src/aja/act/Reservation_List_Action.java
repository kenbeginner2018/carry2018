package aja.act;

import javax.servlet.http.HttpServletRequest;

public class Reservation_List_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {

		//受け取ったrequest情報をキーとしてListDaoのreservationList()メソッドを用いて
		//条件に当てはまる予約情報を取得する（設計書から微妙に仕様が変更。要確認。）
		//ListDaoが実装され次第、コメントアウト状態を解除すること

		/*
		ListDAO listDao = new ListDAO();
		ArrayList<Reservation_ListBean> rList = listDao.reservationList(request);
		request.setAttribute("rList",rList);
		*/

		return "/reservationList.jsp";
	}
}