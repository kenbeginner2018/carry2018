package aja.act;

import javax.servlet.http.HttpServletRequest;

public class Fixed_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		return "/fixed.jsp";
	}

}
