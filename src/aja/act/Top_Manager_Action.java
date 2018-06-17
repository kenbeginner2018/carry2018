package aja.act;

import javax.servlet.http.HttpServletRequest;

public class Top_Manager_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		//リクエスト処理
		request.setCharacterEncoding("UTF-8");

		//LoginDaoが実装でき次第、コメントアウトを解除すること

		/*
		HttpSession session = request.getSession(true);
		Manager_LoginBean mLogin = (Manager_LoginBean) session.getAttribute("mLogin");
		//ログインが出来ていない場合(mLogin == null)は、ログイン処理を行う
		//ログインしている場合(mLogin != null)は、何も行わずにtopManager.jspに遷移する
		if(mLogin == null) {
			int managerId = Integer.parseInt(request.getParameter("managerId"));
			String password = request.getParameter("password");

			//managerIdもしくはpasswordが未入力の場合、エラーメッセージをrequest転送しloginManager.jspへ
			if(request.getParameter("managerId") == null || request.getParameter("managerId").equals("") ||
					password == null || password.equals("")) {
				String errorMessage = "IDもしくはパスワードが入力されていません";
				request.setAttribute("errorMessage", errorMessage);
				return "/loginManager.jsp";
			}

			//loginDaoを用いて入力値と一致するレコードがあるかを確認する
			//loginManager()メソッドの返り値の型を確認すること
			LoginDao loginDao = new LoginDao();
			boolean checkLogin = loginDao.loginManager(managerId,password);

			if(checkLogin) {
				//一致するレコードがあった場合、mLoginをsessionに登録してtopManager.jspへ遷移
				Manager_LoginBean mLoginBean = new Manager_LoginBean();
				mLoginBean.setManagerId(managerId);
				mLoginBean.setPassword(password);
				session.setAttribute("mLogin", mLoginBean);
				return "/topManager.jsp";
			}else {
				//一致するレコードがなければ、エラーメッセージをrequest転送しloginManager.jspへ遷移
				String errorMessage = "IDもしくはパスワードを間違えています。";
				request.setAttribute("errorMessage", errorMessage);
				return "/loginManager.jsp";
			}
		}else {
			return "/topManager.jsp";
		}

		*/

		return "/topManager.jsp";
	}
}
