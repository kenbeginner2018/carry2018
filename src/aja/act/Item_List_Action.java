
package aja.act;

import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import aja.bean.CategoryBean;
import aja.bean.ItemBean;
import aja.bean.LoginBean;
import aja.bean.OrderBean;
import aja.bean.ShowBean;
import aja.dao.ListDAO;
import aja.dao.LoginDAO;
/**
 * itemList.jspへの遷移（表示)に関する処理を行う
 * @author
 *
 */
public class Item_List_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {

		//ListDAO listDao = new ListDAO();

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
		//一度選択していたら処理を飛ばす
		else if(session.getAttribute("showId") != null) {
		}
		//不正アクセスの場合topへ遷移する
		else {
			return "/top.jsp";
		}


		//ログインページから遷移した場合
		if(request.getParameter("reservNo") != null || request.getParameter("telNo") != null) {
			//6/24追加
			//itemName,itemCountをrequestで再度転送する
			request.setAttribute("itemName", request.getParameter("itemName"));
			request.setAttribute("itemCount", request.getParameter("itemCount"));
			request.setAttribute("itemPrice", request.getParameter("itemPrice"));

			//6/24変更
			//未入力チェック
			if(request.getParameter("reservNo").equals("") || request.getParameter("telNo").equals("")) {
				String errorMessage = "予約番号もしくは電話番号が入力されていません";
				request.setAttribute("errorMessage",errorMessage);

				return "/loginUser.jsp";
			}

			//6/24追加
			//予約番号の正規表現チェック
			if(!checkReservNo(request.getParameter("reservNo"))) {
				String errorMessage = "予約番号は数字のみで入力してください";
				request.setAttribute("errorMessage",errorMessage);

				return "/loginUser.jsp";
			}


			//ローカル変数上にreservNoとtelNoを取得
			int reservNo = Integer.parseInt(request.getParameter("reservNo"));
			String telNo = request.getParameter("telNo");



			//電話番号のバリテーションチェック
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

			if(!loginDao.login(request)) {
				String errorMessage = "予約番号もしくは電話番号が間違っています";
				request.setAttribute("errorMessage",errorMessage);

				//入力値保持のため、reservNoとtelNoをrequest再転送
				request.setAttribute("reservNo", reservNo);
				request.setAttribute("telNo", telNo);
				return "/loginUser.jsp";
			}


			loginDao = new LoginDAO();
			ShowBean showDate = loginDao.show_Date((Integer)session.getAttribute("showId"));
			loginDao = new LoginDAO();
			Date ticketDay = loginDao.ticket_Day(reservNo);

			if(showDate.getShowStartDay().before(ticketDay) && ticketDay.before(showDate.getShowEndDay())) {
				//エラーが発生しなかった場合、LoginBean型loginを作成してsession転送
				login = new LoginBean();
				login.setReservNo(reservNo);
				login.setTelNo(telNo);
				session.setAttribute("login",login);
			}else {
				String errorMessage = "この予約番号は選択された公演の予約番号ではありません";
				request.setAttribute("errorMessage",errorMessage);

				return "/loginUser.jsp";
			}


		}
		//ログインページ以外から遷移した場合
		else {
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

			//表示する商品一覧を取得
			ArrayList<ItemBean> items = listDao.item_List(request);
			session.setAttribute("items",items);

			if(session.getAttribute("all_items") == null) {
				session.setAttribute("all_items", items);
			}
		}


		//session.categoryが存在しない場合、カテゴリの取得を行う
		if(session.getAttribute("category") == null) {
			ArrayList<CategoryBean> category = new ArrayList<>();
			ListDAO listDao = new ListDAO();
			category = listDao.category_List();
			session.setAttribute("category", category);
		}

		//TODO
		//カートに追加されたならばカートに商品を追加
		else if(request.getParameter("itemCount") != null) {

			//カート確認フラグ
			boolean check = false;

			//カートに入れられたものをListに追加
			OrderBean order = new OrderBean();
			order.setReservNo(login.getReservNo());
			order.setItemName(request.getParameter("itemName"));
			order.setItemCount(Integer.parseInt(request.getParameter("itemCount")));
			order.setItemPrice(Integer.parseInt(request.getParameter("itemPrice")));
			order.setSubTotal((Integer.parseInt(request.getParameter("itemCount")))*(Integer.parseInt(request.getParameter("itemPrice"))));

			//現在カートの中に商品が入っている場合
			if(session.getAttribute("cart") != null) {
				ArrayList<OrderBean> cart = (ArrayList<OrderBean>) session.getAttribute("cart");

				//カートの回数処理を繰り返す
				for(int i = 0;i<cart.size();i++) {
					//新しくカートに追加したものがカートにあったら以下の処理
					if(cart.get(i).getItemName().equals(order.getItemName())) {

						//カートの中の商品の個数と小計を更新する
						OrderBean insert_cart = new OrderBean();
						insert_cart.setItemName(order.getItemName());
						insert_cart.setItemPrice(order.getItemPrice());
						insert_cart.setReservNo(order.getReservNo());
						insert_cart.setItemCount(cart.get(i).getItemCount()+order.getItemCount());
						insert_cart.setSubTotal(cart.get(i).getItemPrice() * insert_cart.getItemCount());

						cart.set(i, insert_cart);
						session.setAttribute("cart", cart);
						check = true;
						break;
					}
				}
				//カートの中に同じ商品がなかったら以下の処理
				if(!check) {
						//カートの中身をリストに追加する
						cart.add(order);
						session.setAttribute("cart",cart);
				}
			}

			//始めて商品をカートに入れたときの処理
			else {
				ArrayList<OrderBean> cart = new ArrayList<>();
				cart.add(order);
				session.setAttribute("cart",cart);

			}
		}

		//カートの中身を更新もしくは削除されたときの処理
		String btn = request.getParameter("btn");
		if( btn != null) {

			//更新ボタンをおされたときの処理
			if(btn.equals("更新")) {

				//更新されたカートの番号を取得
				int i = Integer.parseInt(request.getParameter("updateNo"));

				//現在のカートを取得する
				ArrayList<OrderBean> cart = (ArrayList<OrderBean>) session.getAttribute("cart");

				//更新された商品の個数と小計を更新する
				OrderBean get_cart = new OrderBean();
				get_cart.setItemName(cart.get(i).getItemName());
				get_cart.setItemPrice(cart.get(i).getItemPrice());
				get_cart.setReservNo(cart.get(i).getReservNo());
				get_cart.setItemCount(Integer.parseInt(request.getParameter("itemcount")));
				get_cart.setSubTotal(cart.get(i).getItemPrice() * Integer.parseInt(request.getParameter("itemcount")));

				cart.set(i, get_cart);
				session.setAttribute("cart", cart);
			}

			//削除ボタンを押されたときのしょり
			else if(btn.equals("削除") && btn != null){

				//削除されたカートの番号を取得
				int i = Integer.parseInt((String)request.getParameter("deleteNo"));
				ArrayList<OrderBean> cart = (ArrayList<OrderBean>) session.getAttribute("cart");
				cart.remove(i);

				if(cart.size() == 0) {
					session.removeAttribute("cart");
				}
				else {
					session.setAttribute("cart", cart);
				}

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

	//6/24追加コード
	//予約番号の形式チェック(数字のみの形式か否か)
	private boolean checkReservNo(String reservNo) {
		String regex = "^[0-9]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(reservNo);
		return matcher.matches();
	}
}
