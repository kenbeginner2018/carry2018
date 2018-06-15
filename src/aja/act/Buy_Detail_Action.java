package aja.act;

import javax.servlet.http.HttpServletRequest;

public class Buy_Detail_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		
		
		return "/buyDetail.jsp";
	}
}
