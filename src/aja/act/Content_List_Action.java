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
	//実装終了後、コメントアウトを解除してください

	/*

		//16桁のcreditNoを生成する。

		String creditNo = (request.getParameter("creditNo1-4")) + "-" + (request.getParameter("creditNo5-8")) + "-" +
				(request.getParameter("creditNo9-12")) + "-" + (request.getParameter("creditNo13-16"));
		String name = request.getParameter("name");
		String securityCode = request.getParameter("securityCode");

		//creditNo,securityCodeの空入力チェック および 正規表現チェック

		if(request.getParameter("creditNo1-4") == null || request.getParameter("creditNo1-4").equals("") ||
				request.getParameter("creditNo5-8") == null || request.getParameter("creditNo5-8").equals("")||
				request.getParameter("creditNo9-12") == null || request.getParameter("creditNo9-12").equals("")||
				request.getParameter("creditNo13-16") == null || request.getParameter("creditNo13-16").equals("")) {
			request.setAttribute("errorMessage", "クレジット番号が入力されていません");
			return "/credit.jsp";
		}else if(name == null || name.equals("")){
			request.setAttribute("errorMessage", "名前が入力されていません");
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

	/*
		//以下、session.cartをでっちあげます。
		//テスト終了後、削除してください
		HttpSession session = request.getSession(true);
		ArrayList<OrderBean> cart = new ArrayList<OrderBean>();

		OrderBean addItem = new OrderBean();
		addItem.setReservNo(1111111);
		addItem.setItemName("ブレスレット");
		addItem.setItemPrice(3300);
		addItem.setItemCount(1);
		addItem.setSubTotal(3300);
		cart.add(addItem);
		addItem = new OrderBean();
		addItem.setReservNo(1111111);
		addItem.setItemName("オードトワレ");
		addItem.setItemPrice(4600);
		addItem.setItemCount(2);
		addItem.setSubTotal(9200);
		cart.add(addItem);

		LoginBean login = new LoginBean();
		login.setReservNo(1111111);
		login.setTelNo("test");
		session.setAttribute("login",login);

		session.setAttribute("cart",cart);

	*/

		//お買い上げ総額計算用
		cart = (ArrayList<OrderBean>) session.getAttribute("cart");
		int totalPrice = 0;
		for(OrderBean oBean : cart) {
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

	//セキュリティコードの形式チェック(3桁の整数か否か)
	private boolean checkSecurityCode(String securityCode) {
		String regex = "^[0-9]{3}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(securityCode);
		return matcher.matches();
	}

}
