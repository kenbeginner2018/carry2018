package aja.act;

import javax.servlet.http.HttpServletRequest;

public class Content_List_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		//creditNoを生成する
		String creditNo = (request.getParameter("creditNo.1-4")) + (request.getParameter("creditNo.5-8")) +
				(request.getParameter("creditNo.9-12")) + (request.getParameter("creditNo.13-16"));
		int securityCode = Integer.parseInt(request.getParameter("securityCode"));


		//
		if(request.getParameter("creditNo") == null) {
			request.setAttribute("errorMessage", "クレジット番号が入力されていません");
		}
		if(request.getParameter("securityCode") == null) {
			request.setAttribute("errorMessage", "セキュリティコードが入力されていません");
		}

		return "/contentList.jsp";
	}

}
