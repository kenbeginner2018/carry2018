package aja.act;

import javax.servlet.http.HttpServletRequest;

public class Select_Show_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {

		//ListDaoのshowList()を利用して表示させる公演を取得
		//ListDao実装後importしたあと、コメントアウト状態を解除すること

		/*
		ListDAO listDao = new ListDAO();
		ArrayList<ShowBean> show = listDao.showList();
		request.setAttribute("show",show);
		*/

		return "/select.jsp";
	}

}
