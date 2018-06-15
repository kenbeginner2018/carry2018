package aja.act;

import javax.servlet.http.HttpServletRequest;

public class Content_List_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		
		
		return "/contentList.jsp";
	}

}
