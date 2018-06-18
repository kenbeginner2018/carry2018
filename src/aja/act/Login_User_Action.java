package aja.act;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import aja.bean.LoginBean;

public class Login_User_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(true);
		LoginBean login = (LoginBean) session.getAttribute("login");

		//itemName,itemCountをsessionで再度転送する
		request.setAttribute("itemName", request.getAttribute("itemName"));
		request.setAttribute("itemCount", request.getAttribute("itemCount"));

		//loginがsessionに存在すれば、loginページをスキップしてitemList.jspへ遷移

		if(login != null) {
			return "/itemList.jsp";
		}else {
			return "/loginUser.jsp";
		}

		//return "/loginUser.jsp";
	}

}
