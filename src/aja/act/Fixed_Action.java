package aja.act;

import javax.servlet.http.HttpServletRequest;

public class Fixed_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {

		//addDaoのaddOrder()を利用して、Buy_Detail,Item_Reserverにレコードを追加
		//addDao実装後importしたあと、コメントアウト状態を解除すること

		/*
		AddDao addDao = new AddDao();
		addDao.addOrder();
		*/

		return "/fixed.jsp";
	}

}
