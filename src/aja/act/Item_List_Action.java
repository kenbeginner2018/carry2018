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

		//動作のためにはListDaoとLoginDaoの実装が必要
		//実装後にコメントアウトを外すこと

		//リクエスト処理
		request.setCharacterEncoding("UTF-8");

		//ログイン情報の取得
		HttpSession session = request.getSession(true);
		LoginBean login = (LoginBean) session.getAttribute("login");

		//公演選択画面で選択された公演を保持
		if(request.getParameter("showId") != null){
			session.setAttribute("showId",request.getParameter("showId"));
		}

		//カテゴリIDの実装(未)
		//とりあえずhidden使わないパターンで実装
		//明日のミーティングで確認する
		if(request.getParameter("selectCategory") == null ) {
			int selectCategory = 0;
		}else {
			int selectCategory = Integer.parseInt(request.getParameter("selectCategory"));
		}

		//ログインページから遷移した場合
		if(request.getParameter("reservNo") != null || request.getParameter("telNo") != null) {
			//ローカル変数上にreservNoとtelNoを取得
			int reservNo = Integer.parseInt(request.getParameter("reservNo"));
			String telNo = request.getParameter("telNo");

			//未入力チェック
			if(request.getAttribute("reservNo") == null || request.getAttribute("reservNo").equals("") ||
					request.getAttribute("telNo") == null || request.getAttribute("telNo").equals("")) {
				String errorMessage = "予約番号もしくは電話番号が入力されていません";
				request.setAttribute("errorMessage",errorMessage);
				//入力値保持のため、reservNoとtelNoをrequest再転送
				request.setAttribute("reservNo", reservNo);
				request.setAttribute("telNo", telNo);
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
			if(!loginDao.login(reservNo,telNo)) {
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
			ArrayList<ItemBean> items = listDao.itemList(request);
			session.setAttribute("items",items);
		}


		//session.categoryが存在しない場合、カテゴリの取得を行う
		ArrayList<CategoryBean> category = (ArrayList<CategoryBean>)session.getAttribute("category");
		if(category != null) {
			ListDAO listDao = new ListDAO();
			category = listDao.CategoryList();
			session.setAttribute("category", category);
		}


		//itemCount!=0ならばカートに商品を追加
		if(Integer.parseInt(request.getParameter("itemCount")) != 0) {
			OrderBean order = new OrderBean();
			order.setReservNo(login.getReservNo());
			order.setItemName(request.getParameter("itemName"));
			order.setItemCount(Integer.parseInt(request.getParameter("itemCount")));
			order.setItemPrice(Integer.parseInt(request.getParameter("itemPrice")));
			order.setSubTotal(Integer.parseInt(request.getParameter("SubTotal")));
			ArrayList<OrderBean> cart = (ArrayList<OrderBean>) session.getAttribute("cart");
			cart.add(order);
			session.setAttribute("cart", cart);
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
