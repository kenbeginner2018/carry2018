package aja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import aja.bean.OrderBean;
import aja.bean.Reservation_ListBean;


public class AddDAO {
	 private Connection connection;
	 private PreparedStatement p_statement_Buy_Detail;
	 private PreparedStatement p_statement_Item_Reserver;


	@SuppressWarnings("unchecked")
	public void addOrder(HttpServletRequest request,Reservation_ListBean rList ) throws ClassNotFoundException, SQLException{

		//Buy_Detailに追加処理

		//Sessionオブジェクトの取得
		HttpSession session = request.getSession(false);
		//MySQLへ接続

		String url = "jdbc:mysql://localhost:3306/t_order";
		String user = "root";
		String password = "root";
		connection = DriverManager.getConnection(url, user, password);


		try {
	    /*
			PrepareStatementの利用。
			最初に枠となるSQLを設定する。
	    */
	    // ?(INパラメータ)のところは、後から設定できる。
		 String Buy_Detail_sql = "INSERT INTO t_order.Buy_Detail (reserveNo,itemName,price,count,subTotal) VALUES (?,?,?.?,?)";
		 String Item_Reserver_sql = "INSERT INTO t_order.Item_Reserver (reserveNo,totalCount,totalPrice,deliveryFlag) VALUES (?,?,?,?)";

		 //カートの中身をBuy_Detail表に登録するためのSQL
		 p_statement_Buy_Detail = connection.prepareStatement(Buy_Detail_sql);
		 p_statement_Item_Reserver = connection.prepareStatement(Item_Reserver_sql);

		 /*
	       カート情報をBuy_Detail表に登録
	     */

		 ArrayList<OrderBean> cart = new ArrayList<>();
		 cart =null;

		 if(session != null) {
			 cart = (ArrayList<OrderBean>)session.getAttribute("cart");

			 for (int i=0; i<cart.size(); i++) {

			 // ?(INパラメータ)に、Buy_Detailオブジェクトの値を設定
			 //cartから取得する。

			 p_statement_Buy_Detail.setInt(0,cart.get(i).getReservNo());    //ReservNo
			 p_statement_Buy_Detail.setString(1,cart.get(i).getItemName());    //ItemName
			 p_statement_Buy_Detail.setInt(2, cart.get(i).getItemPrice());		//price
			 p_statement_Buy_Detail.setInt(3,cart.get(i).getItemCount());	//count
			 p_statement_Buy_Detail.setInt(4, cart.get(i).getSubTotal());	//subTotal
			/*
 				Itemオブジェクトの情報をorderItem表にインサート！
			 */
			 p_statement_Buy_Detail.executeUpdate();

			 }

			 if(rList != null) {
				 p_statement_Item_Reserver.setInt(0, rList.getReservNo());
				 p_statement_Item_Reserver.setInt(1,rList.getTotalCount());
				 p_statement_Item_Reserver.setInt(2,rList.getTotalPrice());
				 p_statement_Item_Reserver.setInt(3, rList.getDeliveryFlag());

				 p_statement_Item_Reserver.executeUpdate();
			 }
		 }
		 }

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
