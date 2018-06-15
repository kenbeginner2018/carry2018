package aja.act;

import javax.servlet.http.HttpServletRequest;

public class Item_Detail_List_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		return "/itemDetailList.jsp";
	}

}
