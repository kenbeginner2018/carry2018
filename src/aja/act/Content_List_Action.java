package aja.act;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class Content_List_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		//16桁のcreditNoを生成する。
		String creditNo = (request.getParameter("creditNo.1-4")) + "-" + (request.getParameter("creditNo.5-8")) + "-" +
				(request.getParameter("creditNo.9-12")) + "-" + (request.getParameter("creditNo.13-16"));
		String securityCode = request.getParameter("securityCode");

		//creditNo,securityCodeの空入力チェック および 正規表現チェック
		//credit.jsp実装後、コメントアウトを外すこと

		/*

		if(creditNo == null || creditNo.equals("")) {
			request.setAttribute("errorMessage", "クレジット番号が入力されていません");
			return "/credit.jsp";
		}else if(securityCode == null || securityCode.equals("")) {
			request.setAttribute("errorMessage", "セキュリティコードが入力されていません");
			return "/credit.jsp";
		}else if(!checkCreditNo(creditNo)) {
			request.setAttribute("errorMessage", "クレジット番号を正しく入力してください");
			return "/credit.jsp";
		}else if(!checkSecurityCode(securityCode)) {
			request.setAttribute("errorMessage", "セキュリティコードを正しく入力してください");
			return "/credit.jsp";
		}

		*/


		return "/contentList.jsp";
	}

	//クレジット番号の形式チェック(xxxx-xxxx-xxxx-xxxxの形式か否か)
	private boolean checkCreditNo(String creditNo) {
		String regex = "^[0-9]{3}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(creditNo);
		return matcher.matches();
	}

	//セキュリティコードの形式チェック(3桁の整数か否か)
	private boolean checkSecurityCode(String securityCode) {
		String regex = "^[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(securityCode);
		return matcher.matches();
	}

}
