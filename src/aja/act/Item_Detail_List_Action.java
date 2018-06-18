package aja.act;

import javax.servlet.http.HttpServletRequest;

public class Item_Detail_List_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		//リクエスト処理
		request.setCharacterEncoding("UTF-8");

		//ListDaoのsitemDetailList()を利用してグッズの詳細情報を取得
		//ListDao実装後importしたあと、コメントアウト状態を解除すること

		/*
		ListDAO listDao = new ListDAO();
		ItemBean detail = listDao.itemDetailList(request);
		request.setAttribute("detail",detail);
		*/

		return "/itemDetailList.jsp";
	}

}
