package aja.act;

import javax.servlet.http.HttpServletRequest;

public class Top_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		return "/top.jsp";
	}
}