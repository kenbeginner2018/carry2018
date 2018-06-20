package aja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import aja.bean.CategoryBean;
import aja.bean.ItemBean;
import aja.bean.OrderBean;
import aja.bean.Reservation_ListBean;
import aja.bean.ShowBean;

public class ListDAO {

	private Connection connection;
	private PreparedStatement p_statement_Show_List;
	private PreparedStatement p_statement_Category_List;
	private PreparedStatement p_statement_item_List_noCategoryId;
	private PreparedStatement p_statement_item_List;
	private PreparedStatement p_statement_item_Detail_List;
	private PreparedStatement p_statement_reservation_List_noDeliveryFlag;
	private PreparedStatement p_statement_reservation_List;
	private PreparedStatement p_statement_order_List;

	public ListDAO()throws ClassNotFoundException, SQLException {
		//MySQLへ接続
		String url = "jdbc:mysql://localhost:3306/t_order";
		String user = "root";
		String password = "root";
		connection = DriverManager.getConnection(url, user, password);

		//PrepareStatementの利用。最初に枠となるSQLを設定する。
	    // ?(INパラメータ)のところは、後から設定できる。
		 String show_List_sql = "SELECT * FROM t_order.showd";
		 String category_List_sql = "SELECT * FROM t_order.category";
		 String item_List_noCategoryId_sql = "SELECT * FROM t_order.category,t_order.item WHERE showId = ? AND item.categoryId = category.categoryId ";
		 String item_List_sql = "SELECT * FROM t_order.category,t_order.item WHERE showId = ? AND item.categoryId = category.categoryId AND category.categoryId = ? ";
		 String item_Detail_List_sql = "SELECT * FROM t_order.category,t_order.item WHERE showId = ? AND item.categoryId = category.categoryId AND item.itemName = ' ? '";
		 String reservation_List_noDelivaryFlag_sql ="SELECT * FROM t_order.ticket_purchaser,t_order.item_reserver WHERE ticket_purchaser.reserveNo = item_reserver.reserveNo AND showDay = '?'";
		 String reservation_List_sql ="SELECT * FROM t_order.ticket_purchaser,t_order.item_reserver WHERE ticket_purchaser.reserveNo = item_reserver.reserveNo AND showDay = ' ? 'AND deliveryFlag = ?";
		 String order_List_sql = "SELECT * FROM t_order.item_reserver,t_order.buy_detail,t_order.item WHERE buy_detail.reserveNo = item_reserver.reserveNo AND buy_detail.itemId = item.itemId AND buy_detail.reserveNo = ? ";

		//SQLを保持するPreparedStatementを生成
		p_statement_Show_List = connection.prepareStatement(show_List_sql);
		p_statement_Category_List = connection.prepareStatement(category_List_sql);
		p_statement_item_List_noCategoryId = connection.prepareStatement(item_List_noCategoryId_sql);
		p_statement_item_List = connection.prepareStatement(item_List_sql);
		p_statement_item_Detail_List = connection.prepareStatement(item_Detail_List_sql);
		p_statement_reservation_List_noDeliveryFlag = connection.prepareStatement(reservation_List_noDelivaryFlag_sql);
		p_statement_reservation_List = connection.prepareStatement(reservation_List_sql);
		p_statement_order_List = connection.prepareStatement(order_List_sql);


	}
	public ArrayList<ShowBean>show_List()throws SQLException{

		//ResultSet型の変数をnullで初期化する
		ResultSet rs_shows = null;

		ShowBean show = null;
		ArrayList<ShowBean> shows = null;

		try {
			//SQLの発行をし、抽出結果が格納されたResultオブジェクトを取得
			 rs_shows = p_statement_Show_List.executeQuery();

			//ArrayListを生成し、代入する。
			shows = new ArrayList<ShowBean>();
			while(rs_shows.next()) {
				show = new ShowBean();
				show.setShowId(rs_shows.getInt("showId"));
				show.setShowName(rs_shows.getString("showName"));
				show.setShowimage(rs_shows.getString("showimage"));
				shows.add(show);
			}
			if(rs_shows != null) {
				rs_shows.close();
			}
		}
		finally {
			if(p_statement_Show_List != null) {
					p_statement_Show_List.close();
			}

			if(connection != null) {
				connection.close();
			}
		}
			return shows;
	}

	public ArrayList<CategoryBean> category_List()throws SQLException{

		//ResultSet型の変数をnullで初期化する
		ResultSet rs_categorys = null;

		CategoryBean category = null;
		ArrayList<CategoryBean> categorys = null;

		try {
			//SQLの発行をし、抽出結果が格納されたResultオブジェクトを取得
			 rs_categorys = p_statement_Category_List.executeQuery();

			//ArrayListを生成し、代入する。
			categorys = new ArrayList<CategoryBean>();
			while(rs_categorys.next()) {
				category = new CategoryBean();
				category.setCategoryId(rs_categorys.getInt("categoryId"));
				category.setCategoryName(rs_categorys.getString("categoryName"));
				categorys.add(category);
			}
			if(rs_categorys != null) {
				rs_categorys.close();
			}
		}
		finally {
			if(p_statement_Category_List != null) {
					p_statement_Category_List.close();
			}

			if(connection != null) {
				connection.close();
			}
		}
			return categorys;
	}

	public ArrayList<ItemBean> item_List(HttpServletRequest request) throws SQLException{

		//Sessionオブジェクトの取得
		HttpSession session = request.getSession(false);

		//ResultSet型の変数をnullで初期化する
		ResultSet rs_items = null;

		ItemBean item = null;
		ArrayList<ItemBean> items = null;

		try {

			 if(session != null) {
				 int showId = (Integer)session.getAttribute("showId");
				 //もしcategoryId = 0だったら以下の処理を行う
				 if ((Integer)request.getAttribute("category") == 0) {
					 //フィールド変数 p_statement_item_List_noCategoryIdの設定
					 p_statement_item_List_noCategoryId.setInt(1,showId);

					 //SQLの発行をし、抽出結果が格納されたResultオブジェクトを取得
					 rs_items = p_statement_item_List_noCategoryId.executeQuery();
				 }
				 else {
				//フィールド変数 p_statement_item_Listの設定
				p_statement_item_List.setInt(1, showId);
				p_statement_item_List.setInt(2,(Integer)request.getAttribute("categoryId"));

				 //SQLの発行をし、抽出結果が格納されたResultオブジェクトを取得
				 rs_items = p_statement_item_List.executeQuery();
				 }

				 //ArrayListを生成し、代入する。
				 items = new ArrayList<ItemBean>();
				 while(rs_items.next()) {
					 item = new ItemBean();
					 item.setItemName(rs_items.getString("itemName"));
					 item.setItemPrice(rs_items.getInt("price"));
					 item.setItemImage(rs_items.getString("itemImage"));
					 item.setItemDetail(rs_items.getString("itemDetail"));
					 item.setItemStock(rs_items.getInt("stock"));
					 item.setCategoryName(rs_items.getString("categoryName"));

					 items.add(item);
				 }
				 if(rs_items != null) {
					 rs_items.close();
				 }
			 }
		}
		finally {
			if(p_statement_item_List_noCategoryId != null) {
				p_statement_item_List_noCategoryId.close();
			}
			if(p_statement_item_List != null) {
				p_statement_item_List.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
		return items;
	}

	public ArrayList<ItemBean> item_Detail_List(HttpServletRequest request) throws SQLException{

		//Sessionオブジェクトの取得
		HttpSession session = request.getSession(false);

		//ResultSet型の変数をnullで初期化する
		ResultSet rs_itemDetails = null;

		ItemBean itemDetail = null;
		ArrayList<ItemBean> itemDetails = null;

		try {

			 if(session != null) {
				 int showId = (Integer)session.getAttribute("showId");
				 //もしitemName != null だったら以下の処理を行う
				 if ((String)request.getAttribute("itemName") != null) {

					 //フィールド変数 p_statement_item_Detail_Listの設定
					 p_statement_item_Detail_List.setInt(1,showId);
					 p_statement_item_Detail_List.setString(2, (String)request.getAttribute("itemName"));

					 //SQLの発行をし、抽出結果が格納されたResultオブジェクトを取得
					 rs_itemDetails = p_statement_item_Detail_List.executeQuery();
				 }

				 //ArrayListを生成し、代入する。
				 itemDetails = new ArrayList<ItemBean>();
				 while(rs_itemDetails.next()) {
					 itemDetail = new ItemBean();
					 itemDetail.setItemName(rs_itemDetails.getString("item_name"));
					 itemDetail.setItemPrice(rs_itemDetails.getInt("price"));
					 itemDetail.setItemImage(rs_itemDetails.getString("itemImage"));
					 itemDetail.setItemDetail(rs_itemDetails.getString("itemDetail"));
					 itemDetail.setItemStock(rs_itemDetails.getInt("stock"));
					 itemDetail.setCategoryName(rs_itemDetails.getString("categoryName"));

					 itemDetails.add(itemDetail);
				 }
				 if(rs_itemDetails != null) {
					 rs_itemDetails.close();
				 }
			 }
		}
		finally {
			if(p_statement_item_Detail_List != null) {
				p_statement_item_Detail_List.close();
			}

			if(connection != null) {
				connection.close();
			}
		}
		return itemDetails;
	}

	public ArrayList<Reservation_ListBean>reservation_List(HttpServletRequest request)throws SQLException{

		//ResultSet型の変数をnullで初期化する
		ResultSet rs_reservationLists = null;

		Reservation_ListBean reservation = null;
		ArrayList<Reservation_ListBean> reservationLists = null;

		try {

			if ((String)request.getAttribute("showYear") != null && (String)request.getAttribute("showMonth") != null && (String)request.getAttribute("showDay") != null) {

				if((Integer)request.getAttribute("deliveryFlag") != null) {
					 p_statement_reservation_List_noDeliveryFlag.setString(1,(String)request.getAttribute("showYear")+"-"+(String)request.getAttribute("showMonth")+"-"+(String)request.getAttribute("showDay"));

					 //SQLの発行をし、抽出結果が格納されたResultオブジェクトを取得
					 rs_reservationLists = p_statement_reservation_List_noDeliveryFlag.executeQuery();
				}
				else {
					p_statement_reservation_List.setString(1,(String)request.getAttribute("showYear")+"-"+(String)request.getAttribute("showMonth")+"-"+(String)request.getAttribute("showDay"));
					p_statement_reservation_List.setInt(2, (Integer)request.getAttribute("deliveryFlag"));
					//SQLの発行をし、抽出結果が格納されたResultオブジェクトを取得
					rs_reservationLists = p_statement_reservation_List.executeQuery();
				}
			}

			//ArrayListを生成し、代入する。
			reservationLists = new ArrayList<Reservation_ListBean>();
			while(rs_reservationLists.next()) {
				reservation = new Reservation_ListBean();
				reservation.setReservNo(rs_reservationLists.getInt("reserveNo"));
				reservation.setTotalCount(rs_reservationLists.getInt("totalCount"));
				reservation.setTotalPrice(rs_reservationLists.getInt("totalPrice"));
				reservationLists.add(reservation);
			}
			if(rs_reservationLists != null) {
				rs_reservationLists.close();
			}
		}
		finally {
			if(p_statement_reservation_List_noDeliveryFlag != null) {
					p_statement_reservation_List.close();
			}
			if(p_statement_reservation_List != null) {
				p_statement_reservation_List.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
			return reservationLists;
	}
	public ArrayList<OrderBean>order_List(HttpServletRequest request)throws SQLException{

		//ResultSet型の変数をnullで初期化する
		ResultSet rs_orderLists = null;

		OrderBean order = null;
		ArrayList<OrderBean> orderLists = null;

		try {

			if(request.getAttribute("reserveNo") != null) {

				p_statement_order_List.setInt(1, Integer.parseInt((String)request.getAttribute("reserveNo")));
				//SQLの発行をし、抽出結果が格納されたResultオブジェクトを取得
				rs_orderLists = p_statement_order_List.executeQuery();
			}
			//ArrayListを生成し、代入する。
			orderLists = new ArrayList<OrderBean>();
			while(rs_orderLists.next()) {
				order = new OrderBean();
				order.setReservNo(rs_orderLists.getInt("reserveNo"));
				order.setItemName(rs_orderLists.getString("itemName"));
				order.setItemCount(rs_orderLists.getInt("count"));
				order.setSubTotal(rs_orderLists.getInt("subTotal"));

				orderLists.add(order);
			}
			if(rs_orderLists != null) {
				rs_orderLists.close();
			}
		}
		finally {
			if(p_statement_order_List != null) {
					p_statement_order_List.close();
			}

			if(connection != null) {
				connection.close();
			}
		}
			return orderLists;
	}
}
