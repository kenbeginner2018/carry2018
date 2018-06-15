package aja.act;

import javax.servlet.http.HttpServletRequest;

public class Item_List_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		System.out.println("test");
		return "/itemList.jsp";
	}

}
