package aja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import aja.bean.OrderBean;

public class UpdateDAO {

	 private Connection connection;
	 private PreparedStatement p_statement_Item_Update;

	 public UpdateDAO()throws ClassNotFoundException, SQLException {

		//MySQLへ接続
			String url = "jdbc:mysql://localhost:3306/t_order";
			String user = "root";
			String password = "root";
			connection = DriverManager.getConnection(url, user, password);

			//PrepareStatementの利用。最初に枠となるSQLを設定する。
			 // ?(INパラメータ)のところは、後から設定できる。
			 String Item_Update_sql = "Update Item SET stock = stock - ? WHERE itemName= ?";

			 //Item表の在庫数を更新するためのSQL
			 p_statement_Item_Update = connection.prepareStatement(Item_Update_sql);

	 }
	 @SuppressWarnings("unchecked")
		public void updateItem(HttpServletRequest request) throws SQLException{

		//Sessionオブジェクトの取得
			HttpSession session = request.getSession(false);

		 //Itemの在庫数を更新
		 try {


			 //カート情報をItem_Reserver表に反映

			 ArrayList<OrderBean> cart = new ArrayList<>();
			 cart =null;

			 if(session != null) {
				 cart = (ArrayList<OrderBean>)session.getAttribute("cart");

				 for (int i=0; i<cart.size(); i++) {

				 // ?(INパラメータ)に、Buy_Detailオブジェクトの値を設定
				 //cartから取得する。
				 p_statement_Item_Update.setInt(1,cart.get(i).getItemCount());	//count
				 p_statement_Item_Update.setString(2,cart.get(i).getItemName());    //ItemName

				//Item表にインサート！
				 p_statement_Item_Update.executeUpdate();
				 }
			 }
		 }
		 finally {
			 if (p_statement_Item_Update != null) {
				 p_statement_Item_Update.close();
			 }
			 if (connection != null) {
				 connection.close();
			 }
		 }
	 }
}
