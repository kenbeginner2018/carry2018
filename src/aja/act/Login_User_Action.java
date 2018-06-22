package aja.act;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import aja.bean.LoginBean;

public class Login_User_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(true);
		LoginBean login = (LoginBean) session.getAttribute("login");

		//itemName,itemCountをrequestで再度転送する
		request.setAttribute("itemName", request.getParameter("itemName"));
		request.setAttribute("itemCount", request.getParameter("itemCount"));
		request.setAttribute("itemPrice", request.getParameter("itemPrice"));

		//loginがsessionに存在すれば、loginページをスキップしてitemList.jspへ遷移

		if(login != null) {

			//公演日時と選択された公演の日付をチェック

			//公演内のチケットだったら
			return "/itemList.jsp";

			//そうでなかったら
				//エラーメッセージに”異なるチケットでログイン中でした”
				//return "/loginUser.jsp";
		}else {
			return "/loginUser.jsp";
		}

		//return "/loginUser.jsp";
	}

}
