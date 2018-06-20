package aja.act;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import aja.bean.OrderBean;
import aja.dao.ListDAO;

public class Buy_Detail_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {

		//次画面でも用いるため、再度request転送
		request.setAttribute("reserveNo","5465756");

		//reservNoをキーとしてListDaoのorderList()メソッドにより対応した顧客の購入情報を取得する
		//ListDao実装後、コメントアウト状態を外すこと


		ListDAO listDao = new ListDAO();
		ArrayList<OrderBean> oList = listDao.order_List(request);
		request.setAttribute("oList", oList);


		return "/buyDetail.jsp";
	}
}