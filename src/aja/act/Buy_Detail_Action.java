package aja.act;

import javax.servlet.http.HttpServletRequest;

public class Buy_Detail_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {

		int reservNo = Integer.parseInt(request.getParameter("reservNo"));

		//reservNoをキーとしてListDaoのorderList()メソッドにより対応した顧客の購入情報を取得する
		//ListDao実装後、コメントアウト状態を外すこと

		/*
		ListDao listDao = new ListDao();
		ArrayList<OrderBean> oList = listDao.orderList(request);
		request.setAttribute("oList", oList);
		*/

		return "/buyDetail.jsp";
	}
}
