package aja.act;

import javax.servlet.http.HttpServletRequest;

public class Login_User_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		return "/loginUser.jsp";
	}

}
