package aja.act;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import aja.bean.ItemBean;
import aja.dao.ListDAO;

public class Item_Detail_List_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {
		//リクエスト処理
		request.setCharacterEncoding("UTF-8");

		//ListDaoのsitemDetailList()を利用してグッズの詳細情報を取得
		//表示したい商品名で処理を行う。
		if (request.getParameter("itemName") != null) {
			request.setAttribute("itemName", request.getParameter("itemName"));
		}

		ListDAO listDao = new ListDAO();
		ArrayList<ItemBean> detail = listDao.item_Detail_List(request);
		request.setAttribute("detail",detail);


		return "/itemDetailList.jsp";
	}

}
