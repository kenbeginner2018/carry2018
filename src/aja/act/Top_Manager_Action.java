package aja.act;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import aja.bean.Manager_LoginBean;
import aja.dao.LoginDAO;

public class Top_Manager_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {



		//リクエスト処理
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(true);
		Manager_LoginBean mLogin = (Manager_LoginBean) session.getAttribute("mLogin");


		//ログインが出来ていない場合(mLogin == null)は、ログイン処理を行う
		if(mLogin == null) {

			//managerIdもしくはpasswordのから入力と不正アクセスチェック
			//エラーメッセージをrequest転送しloginManager.jspへ
			if(request.getParameter("managerId") == null || request.getParameter("managerId").equals("") ||
					request.getParameter("password") == null || request.getParameter("password").equals("")) {
				String errorMessage = "IDもしくはパスワードが入力されていません";
				request.setAttribute("errorMessage", errorMessage);
				return "/loginManager.jsp";
			}

			//managerIdが正規チェック
			//合っていなければ、エラーメッセージをrequest転送しloginManagerへ遷移
			if(!checkManagerId(request.getParameter("managerId"))) {
				String errorMessage = "IDもしくはパスワードを間違えています。";
				request.setAttribute("errorMessage", errorMessage);
				return "/loginManager.jsp";
			}

			int managerId = Integer.parseInt(request.getParameter("managerId"));
			String password = request.getParameter("password");

			//loginDaoを用いて入力値と一致するレコードがあるかを確認する
			//loginManager()メソッドの返り値の型を確認すること
			LoginDAO loginDao = new LoginDAO();
			boolean checkLogin = loginDao.loginManager(managerId,password);

			//一致するレコードがあった場合以下の処理を行う
			if(checkLogin) {
				//mLoginをsessionに登録してtopManager.jspへ遷移
				Manager_LoginBean mLoginBean = new Manager_LoginBean();
				mLoginBean.setManagerId(managerId);
				mLoginBean.setPassword(password);
				session.setAttribute("mLogin", mLoginBean);
				return "/topManager.jsp";
			}
			//一致するレコードがなければ以下の処理を行う
			else {
				//エラーメッセージをrequest転送しloginManager.jspへ遷移
				String errorMessage = "IDもしくはパスワードを間違えています。";
				request.setAttribute("errorMessage", errorMessage);
				return "/loginManager.jsp";
			}
		}
		//ログインしている場合(mLogin != null)は、topManager.jspに遷移する
		else {
			return "/topManager.jsp";
		}
	}

	//マネージャーIDの形式チェック(1-9の数字のみの形式か否か)
	private boolean checkManagerId(String manaId) {
		String regex = "^[0-9]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(manaId);
		return matcher.matches();
	}


}