package aja.act;

import javax.servlet.http.HttpServletRequest;

public class Login_Manager_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {

		return "/loginManager.jsp";
	}

}
