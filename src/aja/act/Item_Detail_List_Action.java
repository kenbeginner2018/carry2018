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
<<<<<<< HEAD
		ListDao listDao = new ListDao();
=======
		ListDAO listDao = new ListDAO();
>>>>>>> branch 'master' of https://github.com/kenbeginner2018/carry2018.git
		ItemBean detail = listDao.itemDetailList(request);
		request.setAttribute("detail",detail);
		*/

		return "/itemDetailList.jsp";
	}

}
