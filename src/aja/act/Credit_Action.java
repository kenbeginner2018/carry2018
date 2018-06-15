package aja.act;

import javax.servlet.http.HttpServletRequest;

public class Credit_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		return "/credit.jsp";
	}

}
