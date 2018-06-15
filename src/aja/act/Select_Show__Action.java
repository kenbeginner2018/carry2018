package aja.act;

import javax.servlet.http.HttpServletRequest;

public class Select_Show__Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		
		return "/select.jsp";
	}

}
