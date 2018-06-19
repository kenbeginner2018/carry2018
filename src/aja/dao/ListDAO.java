package aja.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import aja.bean.CategoryBean;
import aja.bean.ShowBean;

public class ListDAO {

	private Connection connection;
	private PreparedStatement p_statement_Show_List;
	private PreparedStatement p_statement_Category_List;

	public ListDAO()throws ClassNotFoundException, SQLException {
		//MySQLへ接続
		String url = "jdbc:mysql://localhost:3306/t_order";
		String user = "root";
		String password = "root";
		connection = DriverManager.getConnection(url, user, password);

		//PrepareStatementの利用。最初に枠となるSQLを設定する。
	    // ?(INパラメータ)のところは、後から設定できる。
		 String show_List_sql = "SELECT * FROM t_order.show";
		 String category_List_sql = "SELECT * FROM t_order.category";

		//SQLを保持するPreparedStatementを生成
		p_statement_Show_List = connection.prepareStatement(show_List_sql);
		p_statement_Category_List = connection.prepareStatement(category_List_sql);
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
}
