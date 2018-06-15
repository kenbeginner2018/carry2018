package aja.act;

import javax.servlet.http.HttpServletRequest;

public class Top_Manager_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		return "/topManager.jsp";
	}
}
