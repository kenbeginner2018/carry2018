package aja.act;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import aja.bean.OrderBean;

public class Content_List_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(true);
		ArrayList<OrderBean> cart = (ArrayList<OrderBean>) session.getAttribute("cart");

	//session.cart実装をスムーズに行うため、いったんクレカの処理を止めています。

		//16桁のcreditNoを生成する。

		String creditNo = (request.getParameter("creditNo1-4")) + "-" + (request.getParameter("creditNo5-8")) + "-" +
				(request.getParameter("creditNo9-12")) + "-" + (request.getParameter("creditNo13-16"));
		String name = request.getParameter("name");
		String securityCode = request.getParameter("securityCode");

		//creditNoのから入力、不正アクセスチェック
		if(request.getParameter("creditNo1-4") == null || request.getParameter("creditNo1-4").equals("") ||
				request.getParameter("creditNo5-8") == null || request.getParameter("creditNo5-8").equals("")||
				request.getParameter("creditNo9-12") == null || request.getParameter("creditNo9-12").equals("")||
				request.getParameter("creditNo13-16") == null || request.getParameter("creditNo13-16").equals("")) {
			request.setAttribute("errorMessage", "クレジット番号が入力されていません");
			return "/credit.jsp";
		}
		//名前のから入力、不正アクセス
		else if(name == null || name.equals("")){
			request.setAttribute("errorMessage", "名前が入力されていません");
			return "/credit.jsp";
		}
		//securityCodeの空入力、不正アクセス
		else if(securityCode == null || securityCode.equals("")) {
			request.setAttribute("errorMessage", "セキュリティコードが入力されていません");
			return "/credit.jsp";
		}
		//creditNoの正規チェック
		else if(!checkCreditNo(creditNo)) {
			request.setAttribute("errorMessage", "クレジット番号を半角数字で正しく入力してください");
			return "/credit.jsp";
		}
		//名前の正規チェック
		else if(!checkName(name)) {
			request.setAttribute("errorMessage", "名前は以下のように半角大文字で入力してください<br />(例)TANAKA TARO");
			return "/credit.jsp";
		}
		//securityCodeの正規チェック
		else if(!checkSecurityCode(securityCode)) {
			request.setAttribute("errorMessage", "セキュリティコードを半角数字で正しく入力してください");
			return "/credit.jsp";
		}

		//お買い上げ総額計算用
		cart = (ArrayList<OrderBean>) session.getAttribute("cart");
		int totalPrice = 0;

		//カートの中の商品種類の回数繰り返す
		for(OrderBean oBean : cart) {
			//小計を足していき合計金額を求める
			totalPrice += oBean.getSubTotal();
		}

		request.setAttribute("totalPrice", totalPrice);

		return "/contentList.jsp";
	}

	//クレジット番号の形式チェック(xxxx-xxxx-xxxx-xxxxの形式か否か)
	private boolean checkCreditNo(String creditNo) {
		String regex = "^[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(creditNo);
		return matcher.matches();
	}

	//カード名義人の形式チェック(大文字アルファベットのみの形式か否か)
	private boolean checkName(String name) {
		String regex = "^[A-Z]+ [A-Z]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}


	//セキュリティコードの形式チェック(3桁の整数か否か)
	private boolean checkSecurityCode(String securityCode) {
		String regex = "^[0-9]{3}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(securityCode);
		return matcher.matches();
	}

}
