package aja.act;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import aja.bean.CategoryBean;
import aja.bean.ItemBean;
import aja.bean.LoginBean;
import aja.bean.OrderBean;
import aja.dao.ListDAO;
import aja.dao.LoginDAO;

public class Item_List_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {

		//ListDAO listDao = new ListDAO();
		//動作のためにはListDaoとLoginDaoの実装が必要
		//実装後にコメントアウトを外すこと


		//リクエスト処理
		request.setCharacterEncoding("UTF-8");

		//ログイン情報の取得
		HttpSession session = request.getSession(true);
		LoginBean login = (LoginBean) session.getAttribute("login");


		//公演選択画面で選択された公演を保持
		//不正アクセス判定
		if(request.getParameter("showId") != null ){
			int showId = Integer.parseInt(request.getParameter("showId"));
			session.setAttribute("showId",showId);
		}
		else if(session.getAttribute("showId") != null) {

		}
		else {
			return "/top.jsp";
		}

		//ログインページから遷移した場合
		if(request.getParameter("reservNo") != null || request.getParameter("telNo") != null) {
			//ローカル変数上にreservNoとtelNoを取得
			int reservNo = Integer.parseInt(request.getParameter("reservNo"));
			String telNo = request.getParameter("telNo");

			//未入力チェック
			if(request.getParameter("reservNo") == null || request.getParameter("reservNo").equals("") ||
					request.getParameter("telNo") == null || request.getParameter("telNo").equals("")) {
				String errorMessage = "予約番号もしくは電話番号が入力されていません";
				request.setAttribute("errorMessage",errorMessage);

			}

			if(!checkTelNo(telNo)) {
				String errorMessage = "電話番号はxxx-xxxx-xxxxの形式で入力してください";
				request.setAttribute("errorMessage",errorMessage);
				//入力値保持のため、reservNoとtelNoをrequest再転送
				request.setAttribute("reservNo", reservNo);
				request.setAttribute("telNo", telNo);
				return "/loginUser.jsp";
			}

			//LoginDaoを用いて、reservNoとtelNoを含むレコードがあるかを探す
			//該当するレコードがなければエラーを返す
			LoginDAO loginDao = new LoginDAO();
			if(loginDao.login(reservNo,telNo)) {
				String errorMessage = "予約番号もしくは電話番号が間違っています";
				request.setAttribute("errorMessage",errorMessage);
				//入力値保持のため、reservNoとtelNoをrequest再転送
				request.setAttribute("reservNo", reservNo);
				request.setAttribute("telNo", telNo);
				return "/loginUser.jsp";
			}

			//エラーが発生しなかった場合、LoginBean型loginを作成してsession転送
			login = new LoginBean();
			login.setReservNo(reservNo);
			login.setTelNo(telNo);
			session.setAttribute("login",login);
		}else {			//ログインページ以外から遷移した場合
			ListDAO listDao = new ListDAO();

			//select.jspから遷移のとき
			if(request.getParameter("categoryId") == null){

				//全件表示に設定
				request.setAttribute("categoryId", 0);

			}
			else {
				int categoryId = Integer.parseInt(request.getParameter("categoryId"));

				request.setAttribute("categoryId", categoryId);
			}

			ArrayList<ItemBean> items = listDao.item_List(request);
			session.setAttribute("items",items);
		}

		//session.categoryが存在しない場合、カテゴリの取得を行う
		//ArrayList<CategoryBean> category = (ArrayList<CategoryBean>)session.getAttribute("category");
		if(session.getAttribute("category") == null) {
			ArrayList<CategoryBean> category = new ArrayList<>();
			ListDAO listDao = new ListDAO();
			category = listDao.category_List();
			session.setAttribute("category", category);
		}


		//itemCount!=0ならばカートに商品を追加

		else if(request.getParameter("itemCount") != null) {
			//if(Integer.parseInt(request.getParameter("itemCount")) != 0 ) {
			OrderBean order = new OrderBean();
			order.setReservNo(login.getReservNo());
			order.setItemName(request.getParameter("itemName"));
			order.setItemCount(Integer.parseInt(request.getParameter("itemCount")));
			//order.setItemCount(1);
			order.setItemPrice(Integer.parseInt(request.getParameter("itemPrice")));
			order.setSubTotal((Integer.parseInt(request.getParameter("itemCount")))*(Integer.parseInt(request.getParameter("itemPrice"))));
			if(session.getAttribute("cart") != null) {
				ArrayList<OrderBean> cart = (ArrayList<OrderBean>) session.getAttribute("cart");
				cart.add(order);
				session.setAttribute("cart", cart);
			}
			else {
				ArrayList<OrderBean> cart = new ArrayList<>();
				cart.add(order);
				session.setAttribute("cart", cart);
			}
			//}
		}

		String btn = request.getParameter("btn");
		if( btn != null) {
			if(btn.equals("更新")) {
				int i = Integer.parseInt(request.getParameter("updateNo"));
				ArrayList<OrderBean> cart = (ArrayList<OrderBean>) session.getAttribute("cart");
				OrderBean get_cart = new OrderBean();
				get_cart.setItemName(cart.get(i).getItemName());
				get_cart.setItemPrice(cart.get(i).getItemPrice());
				get_cart.setReservNo(cart.get(i).getReservNo());
				get_cart.setItemCount(Integer.parseInt(request.getParameter("itemcount")));
				get_cart.setSubTotal(cart.get(i).getItemPrice() * Integer.parseInt(request.getParameter("itemcount")));

				cart.set(i, get_cart);
				session.setAttribute("cart", cart);
			}

			else if(btn.equals("削除") && btn != null){
				int i = Integer.parseInt((String)request.getParameter("deleteNo"));
				ArrayList<OrderBean> cart = (ArrayList<OrderBean>) session.getAttribute("cart");
				cart.remove(i);
				session.setAttribute("cart", cart);
			}

		}




		return "/itemList.jsp";
	}

	//電話番号の正規表現チェック(ハイフンが正しい位置に入力されているか否か)
	private boolean checkTelNo(String telNo) {
		String regex = "^[0-9]+-[0-9]+-[0-9]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(telNo);
		return matcher.matches();
	}
}
