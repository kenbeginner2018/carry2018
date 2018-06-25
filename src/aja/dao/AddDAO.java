package aja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import aja.bean.OrderBean;
import aja.bean.Reservation_ListBean;


public class AddDAO {
	 private Connection connection;
	 private PreparedStatement p_statement_Buy_Detail;
	 private PreparedStatement p_statement_ItemId_Search;
	 private PreparedStatement p_statement_Item_Reserver;
	 private PreparedStatement p_statement_Del_Buy_Detail;
	 private PreparedStatement p_statement_Del_Item_Reserver;
	 private PreparedStatement p_statement_Sel_Buy_Detail;
	 private PreparedStatement p_statement_Sel_Item_Reserver;


	 public AddDAO()throws ClassNotFoundException, SQLException {
			//MySQLへ接続
			String url = "jdbc:mysql://localhost:3306/t_order";
			String user = "root";
			String password = "root";
			connection = DriverManager.getConnection(url, user, password);

			 //PrepareStatementの利用。最初に枠となるSQLを設定する。
		    // ?(INパラメータ)のところは、後から設定できる。
			 String Buy_Detail_sql = "INSERT INTO t_order.buy_detail (reserveNo,itemId,count,subTotal) VALUES (?,?,?,?)";
			 String ItemId_Search_sql = "SELECT * FROM t_order.item WHERE item.itemName =  ? AND showId = ?";
			 String Item_Reserver_sql = "INSERT INTO t_order.item_reserver (reserveNo,totalCount,totalPrice,deliveryFlag) VALUES (?,?,?,?)";
			 String Del_Item_Reserver_sql = "DELETE FROM t_order.item_reserver WHERE reserveNo= ? ";
			 String Del_Buy_Detail_sql = "DELETE FROM t_order.buy_detail WHERE reserveNo= ? AND itemId = ?";
			 String Sel_Item_Reserver_sql = "SELECT * FROM t_order.item_reserver WHERE reserveNo= ? ";
			 String Sel_Buy_Detail_sql = "SELECT * FROM t_order.buy_detail WHERE reserveNo= ? AND itemId = ?";

			 //カートの中身をBuy_Detail表に登録するためのSQL
			 p_statement_Buy_Detail = connection.prepareStatement(Buy_Detail_sql);
			 p_statement_ItemId_Search = connection.prepareStatement(ItemId_Search_sql);
			 p_statement_Del_Buy_Detail = connection.prepareStatement(Del_Buy_Detail_sql);
			 p_statement_Sel_Buy_Detail = connection.prepareStatement(Sel_Buy_Detail_sql);
			 //Item_Reserverの中身をItem_Reserver表に登録するためのSQL
			 p_statement_Item_Reserver = connection.prepareStatement(Item_Reserver_sql);
			 p_statement_Del_Item_Reserver = connection.prepareStatement(Del_Item_Reserver_sql);
			 p_statement_Sel_Item_Reserver = connection.prepareStatement(Sel_Item_Reserver_sql);
	 }
	@SuppressWarnings("unchecked")

	/**
	 * カートの中身をBuy_Detailテーブルに登録する
	 * また、Item_Reserverテーブルも登録
	 * @param request
	 * @param rList		顧客の注文状況
	 * @throws SQLException
	 */
	public void addOrder(HttpServletRequest request,Reservation_ListBean rList ) throws SQLException{

		//Sessionオブジェクトの取得
		HttpSession session = request.getSession(false);


		try {

		//Buy_Detailへ登録
		 ArrayList<OrderBean> cart = new ArrayList<>();
		 cart =null;

		 if(session != null) {

			 //カートの中身を取得
			 cart = (ArrayList<OrderBean>)session.getAttribute("cart");

			 //カートに入っている種類の回数繰り返す
			 for (int i=0; i<cart.size(); i++) {

				//ResultSet型の変数をnullで初期化する
				ResultSet rs_items = null;

				//カートに入っている商品名から商品Idを取得する
				String itemName = cart.get(i).getItemName();
				p_statement_ItemId_Search.setString(1,itemName);
				p_statement_ItemId_Search.setInt(2,(Integer)session.getAttribute("showId"));
				rs_items = p_statement_ItemId_Search.executeQuery();

				//商品Idが取得されていたら以下を実行
				while(rs_items.next()) {
					int itemId = rs_items.getInt("itemId");

					//ResultSet型の変数をnullで初期化する
					ResultSet rs = null;

					//前に注文されていたっらそのDBを更新するため、予約番号と商品番号でDBを取得する
					p_statement_Sel_Buy_Detail.setInt(1,cart.get(i).getReservNo());
					p_statement_Sel_Buy_Detail.setInt(2,itemId);
					rs = p_statement_Sel_Buy_Detail.executeQuery();

					int itemCount;
					int subTotal;

					//前に同じ商品を注文していたら以下を実行
					if (rs.next()) {
						//注文個数と小計を更新して、現在のDBを削除する
						itemCount = rs.getInt("count") + cart.get(i).getItemCount();
						subTotal = rs.getInt("subTotal") + cart.get(i).getSubTotal();
						p_statement_Del_Buy_Detail.setInt(1,cart.get(i).getReservNo());
						p_statement_Del_Buy_Detail.setInt(2,itemId);
						p_statement_Del_Buy_Detail.executeUpdate();
					} else {
						//カートの中の個数と小計を取得する
						itemCount = cart.get(i).getItemCount();
						subTotal = cart.get(i).getSubTotal();
					}

					// ?(INパラメータ)に、Buy_Detailオブジェクトの値を設定
					//cartから取得する。
					p_statement_Buy_Detail.setInt(1, cart.get(i).getReservNo());    //ReservNo
					p_statement_Buy_Detail.setInt(2, itemId);					    //ItemId
					p_statement_Buy_Detail.setInt(3, itemCount);	//count
					p_statement_Buy_Detail.setInt(4, subTotal);	//subTotal

					 //Buy_Detail表にインサート！
					 p_statement_Buy_Detail.executeUpdate();
				}
			 }

			 //Reservation_Listに登録
			 // ?(INパラメータ)に、Item_Reserverオブジェクトの値を設定
			 //Reservation_ListBeanから取得する。

			 //顧客の情報があったら以下の処理を実行
			 if(rList != null) {
				//ResultSet型の変数をnullで初期化する
				ResultSet rs = null;

				//現在の注文状況を予約番号で確認
				p_statement_Sel_Item_Reserver.setInt(1,rList.getReservNo());
				rs = p_statement_Sel_Item_Reserver.executeQuery();

				int totalCount;
				int totalPrice;

				//すでに予約されていたら以下の処理を実行
				if (rs.next()) {
					//今回の注文の合計金額、合計個数を追加する
					totalCount = rs.getInt("totalCount") + rList.getTotalCount();
					totalPrice = rs.getInt("totalPrice") + rList.getTotalPrice();
					p_statement_Del_Item_Reserver.setInt(1,rList.getReservNo());
					p_statement_Del_Item_Reserver.executeUpdate();
				} else {
					//今回の注文の内容を取得
					totalCount = rList.getTotalCount();
					totalPrice = rList.getTotalPrice();
				}

				p_statement_Item_Reserver.setInt(1, rList.getReservNo());
				p_statement_Item_Reserver.setInt(2, totalCount);
				p_statement_Item_Reserver.setInt(3, totalPrice);
				p_statement_Item_Reserver.setInt(4, rList.getDeliveryFlag());

				//Item_Reserver表にインサート！
				p_statement_Item_Reserver.executeUpdate();
			 }
		 }
		 }

		//finally
		 finally {
			 if (p_statement_Buy_Detail != null) {
				 p_statement_Buy_Detail.close();
			 }
			 if (p_statement_Item_Reserver != null) {
				 p_statement_Item_Reserver.close();
			 }
			 if (connection != null) {
				 connection.close();
			 }
		 }
	}
}
