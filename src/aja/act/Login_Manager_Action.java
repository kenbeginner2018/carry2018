package aja.act;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import aja.bean.Manager_LoginBean;

public class Login_Manager_Action extends Action {


	@Override
	public String execute(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(true);
		Manager_LoginBean mLogin = (Manager_LoginBean) session.getAttribute("mLogin");

		//すでにmanagerでログインしている場合、ログインをスキップする
		if(mLogin == null) {
			return "/loginManager.jsp";
		}else {
			return "/topManager.jsp";
		}
	}

}
