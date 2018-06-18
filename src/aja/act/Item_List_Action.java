package aja.act;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class Item_List_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {

		//動作のためにはListDaoとLoginDaoの実装が必要
		//実装後にコメントアウトを外すこと

		/*

		//リクエスト処理
		request.setCharacterEncoding("UTF-8");

		//ログイン情報の取得
		HttpSession session = request.getSession(true);
		LoginBean login = (LoginBean) session.getAttribute("login");

		//ログインページから遷移した場合
		if(request.getParameter("reservNo") != null || request.getParameter("telNo") != null) {
			//変数上にreservNoとtelNoを取得
			int reservNo = Integer.parseInt(request.getParameter("reservNo"));
			String telNo = request.getParameter("telNo");

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
			LoginDao loginDao = new LoginDao();
			if(!loginDao.login(request)) {
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
			ListDao listDao = new ListDao();
			ArrayList<ItemBean> items = listDao.itemList(request);
			session.setAttribute("items",items);
		}


		//session.categoryが存在しない場合、カテゴリの取得を行う
		ArrayList<CategoryBean> category = (ArrayList<CategoryBean>)session.getAttribute("category");
		if(category != null) {
			ListDao listDao = new ListDao();
			category = listDao.CategoryList();
			session.setAttribute("category", category);
		}


		//itemCount!=0ならばカートに商品を追加
		if(Integer.parseInt(request.getParameter("itemCount")) != 0) {
			OrderBean order = new OrderBean();
			order.setReservNo(login.getReservNo());
			order.setItemName(request.getParameter("itemName"));
			order.setItemCount(Integer.parseInt(request.getParameter("itemCount")));
//			order.setItemPrice(Integer.parseInt(request.getParameter("itemPrice")));
			order.setSubTotal(Integer.parseInt(request.getParameter("SubTotal")));
			ArrayList<OrderBean> cart = (ArrayList<OrderBean>) session.getAttribute("cart");
			cart.add(order);
			session.setAttribute("cart", cart);
		}

		*/

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
