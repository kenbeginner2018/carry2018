package aja.act;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Credit_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(true);

		//カテゴリーと商品のセッションを削除
		session.removeAttribute("category");
		session.removeAttribute("items");
		return "/credit.jsp";
	}

}
