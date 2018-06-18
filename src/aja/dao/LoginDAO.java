package aja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import aja.bean.LoginBean;
import aja.bean.Manager_LoginBean;

public class LoginDAO {
	private Connection connection;
	private PreparedStatement p_statement_User_Login;
	private PreparedStatement p_statement_Manager_Login;

	// SELECTの結果を格納するResultSet
	ResultSet rs = null;

	public LoginDAO() throws ClassNotFoundException, SQLException {

		/*
		MySQLへ接続
		 */
		String url = "jdbc:mysql://localhost:3306/latte_station";
		String user = "root";
		String password = "root";
		connection = DriverManager.getConnection(url, user, password);

		/*
		PrepareStatementの利用。
		最初に枠となるSQLを設定する。
		 */
		// ?(INパラメータ)のところは、後から設定できる。
		String Ticket_Pruche_sql = "SELECT * FROM Ticket_Prucher WHERE reservNo=? AND  telNo=?";
		String Manager_sql = "SELECT * FROM Ticket_Prucher WHERE managerId=? AND  password=?";

		//ユーザーログインの予約番号と電話番号で検索するためのSQL
		 p_statement_User_Login = connection.prepareStatement(Ticket_Pruche_sql);
		//管理者ログインの予約番号と電話番号で検索するためのSQL
		 p_statement_Manager_Login = connection.prepareStatement(Manager_sql);
	}

	public boolean Userlogin(int reservNo, String telNo) throws Exception {

		LoginBean lb = new LoginBean();

		try {

			 p_statement_User_Login.setInt(1, reservNo);
			 p_statement_User_Login.setString(2, telNo);
			 p_statement_User_Login.executeUpdate();

			// DBから取得したデータをlbオブジェクトに格納
			lb.setReservNo(rs.getInt("ReservNo"));
			lb.setTelNo(rs.getString("TelNo"));

			if (rs.next()) {
				return true;
			} else {

			}
		} catch (Exception e) {

		}
		return false;
	}

	public boolean Managerlogin(int managerId, String password) throws Exception {

		Manager_LoginBean mlb = new Manager_LoginBean();
		try {

			p_statement_Manager_Login.setInt(1, managerId);
			p_statement_Manager_Login.setString(2, password);
			p_statement_Manager_Login.executeUpdate();

			// DBから取得したデータをmlbオブジェクトに格納
			mlb.setManagerId(rs.getInt("managerId"));
			mlb.setPassword(rs.getString("password"));

			if (rs.next()) {
				return true;
			} else {

			}
		} catch (Exception e) {

		}
		return false;
	}

}

