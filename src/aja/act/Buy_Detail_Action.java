package aja.act;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import aja.bean.Manager_LoginBean;
import aja.bean.OrderBean;
import aja.dao.ListDAO;

public class Buy_Detail_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(true);
		Manager_LoginBean mLogin = (Manager_LoginBean) session.getAttribute("mLogin");
		//マネージャーとしてログインしていない場合、マネージャー向けログインページへ遷移
		if(mLogin == null) {
			return "/loginManager.jsp";
		}

		//次画面でも用いるため、再度request転送
		request.setAttribute("reserveNo",request.getParameter("reserveNo"));
		request.setAttribute("totalPrice", request.getParameter("totalPrice"));

		//reservNoをキーとしてListDaoのorderList()メソッドにより対応した顧客の購入情報を取得する
		//ListDao実装後、コメントアウト状態を外すこと

		ListDAO listDao = new ListDAO();
		ArrayList<OrderBean> oList = listDao.order_List(request);
		request.setAttribute("oList", oList);

		return "/buyDetail.jsp";
	}
}