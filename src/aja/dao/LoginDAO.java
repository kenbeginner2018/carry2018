package aja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import aja.bean.ShowBean;

public class LoginDAO {
	private Connection connection;
	private PreparedStatement p_statement_User_Login;
	private PreparedStatement p_statement_Manager_Login;
	private PreparedStatement p_statement_ticket_Purchaser_showDay;
	private PreparedStatement p_statement_Show_by_id;

	// SELECTの結果を格納するResultSet
	ResultSet rs = null;

	public LoginDAO() throws ClassNotFoundException, SQLException {

		/*
		MySQLへ接続
		 */
		String url = "jdbc:mysql://localhost:3306/t_order";
		String user = "root";
		String password = "root";
		connection = DriverManager.getConnection(url, user, password);

		/*
		PrepareStatementの利用。
		最初に枠となるSQLを設定する。
		 */
		// ?(INパラメータ)のところは、後から設定できる。
		String Ticket_Pruche_sql = "SELECT * FROM t_order.ticket_purchaser WHERE ticket_purchaser.reserveNo=? AND  ticket_purchaser.telNo=?";
		String Manager_sql = "SELECT * FROM t_order.manager WHERE managerId=? AND  password=?";
		String ticket_Purchaser_showDay = "SELECT * FROM t_order.ticket_purchaser WHERE reserveNo= ? ";
		String show_by_id_sql = "SELECT * FROM t_order.showd WHERE showId = ? ";


		//ユーザーログインの予約番号と電話番号で検索するためのSQL
		 p_statement_User_Login = connection.prepareStatement(Ticket_Pruche_sql);
		//管理者ログインの予約番号と電話番号で検索するためのSQL
		 p_statement_Manager_Login = connection.prepareStatement(Manager_sql);
		 //日時判定用のSQL
		 p_statement_ticket_Purchaser_showDay = connection.prepareStatement(ticket_Purchaser_showDay);
		 p_statement_Show_by_id = connection.prepareStatement(show_by_id_sql);
	}

	public boolean login(HttpServletRequest request) throws SQLException {

		//LoginBean lb = new LoginBean();

		try {

			p_statement_User_Login.setInt(1, Integer.parseInt(request.getParameter("reservNo")));
			p_statement_User_Login.setString(2, request.getParameter("telNo"));
			rs = p_statement_User_Login.executeQuery();

			//if (rs.next()) {
				// DBから取得したデータをlbオブジェクトに格納
				//lb.setReservNo(rs.getInt("ReserveNo"));
				//lb.setTelNo(rs.getString("TelNo"));
				//return true;
			//} else {
				//return false;

			//}
			 return rs.next();
		}
		 finally {
			 if ( p_statement_User_Login != null) {
				 p_statement_User_Login.close();
			 }
			 if (connection != null) {
				 connection.close();
			 }
		 }

	}

	public boolean loginManager(int managerId, String password) throws Exception {

//		Manager_LoginBean mlb = new Manager_LoginBean();

		try {

			p_statement_Manager_Login.setInt(1, managerId);
			p_statement_Manager_Login.setString(2, password);
			rs = p_statement_Manager_Login.executeQuery();

			// DBから取得したデータをmlbオブジェクトに格納
//			mlb.setManagerId(rs.getInt("managerId"));
//			mlb.setPassword(rs.getString("password"));

//			if (rs.next()) {
//				return true;
//			} else {
//
//			}
			return rs.next();
		}finally {
			 if ( p_statement_Manager_Login != null) {
				 p_statement_Manager_Login.close();
			 }
			 if (connection != null) {
				 connection.close();
			 }
		 }
	}

	//idを利用して、1つの公演情報を取得する
	public ShowBean show_Date(int id)throws SQLException{

		//ResultSet型の変数をnullで初期化する
		ResultSet rs_show = null;
		ShowBean show = null;


		try {
			//SQLの発行をし、抽出結果が格納されたResultオブジェクトを取得
		     p_statement_Show_by_id.setInt(1, id);
			 rs_show = p_statement_Show_by_id.executeQuery();

			if(rs_show.next()) {
				//showBeanに結果を生成する
				show = new ShowBean();
				show.setShowId(rs_show.getInt("showId"));
				show.setShowName(rs_show.getString("showName"));
				show.setShowimage(rs_show.getString("showimage"));
				show.setShowStartDay(rs_show.getDate("showStartDay"));
				show.setShowEndDay(rs_show.getDate("showEndDay"));
			}

			if(rs_show != null) {
				rs_show.close();
			}
		}
		finally {

			if(p_statement_Show_by_id != null) {
				p_statement_Show_by_id.close();
			}

			if(connection != null) {
				connection.close();
			}

		}
		return show;

	}


	//reserveNoを用いて、該当チケットの公演日を検索する
	public Date ticket_Day(int reserveNo)throws SQLException{

		//ResultSet型の変数をnullで初期化する
		ResultSet rs_day = null;
		Date ticketDay=null;

		try {

			//SQLの発行をし、抽出結果が格納されたResultオブジェクトを取得
			 p_statement_ticket_Purchaser_showDay.setInt(1, reserveNo);
			 rs_day = p_statement_ticket_Purchaser_showDay.executeQuery();

			 if(rs_day.next()) {
				  ticketDay = rs_day.getDate("showDay");
			 }

			 if(rs_day != null) {
					rs_day.close();
				}
		}
		finally {

			if(p_statement_ticket_Purchaser_showDay != null) {
				p_statement_ticket_Purchaser_showDay.close();
			}

			if(connection != null) {
				connection.close();
			}
		}
		return ticketDay;
	}

}

