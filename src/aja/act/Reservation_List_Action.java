package aja.act;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import aja.bean.Manager_LoginBean;
import aja.bean.Reservation_ListBean;
import aja.dao.ListDAO;

public class Reservation_List_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(true);
		Manager_LoginBean mLogin = (Manager_LoginBean) session.getAttribute("mLogin");
		//マネージャーとしてログインしていない場合、マネージャー向けログインページへ遷移
		if(mLogin == null) {
			return "/loginManager.jsp";
		}

		//日付指定用：yearの上限設定
		Calendar calendar = Calendar.getInstance();
		int listYear = calendar.get(Calendar.YEAR);
		request.setAttribute("listYear", listYear);

		//受け取ったrequest情報をキーとしてListDaoのreservationList()メソッドを用いて
		//条件に当てはまる予約情報を取得する


		//初遷移の場合(showYear,showMonth,showDayがnullの場合)、処理を飛ばす
		if(request.getParameter("showYear") != null && request.getParameter("showMonth") != null &&
				request.getParameter("showDay") != null) {

			//日時に未指定があった場合、エラーメッセージをrequest転送
			if(request.getParameter("showYear").equals("") || request.getParameter("showMonth").equals("") ||
					request.getParameter("showDay").equals("")) {
				String errorMessage="日時を指定してください";
				request.setAttribute("errorMessage",errorMessage);

			}else {
				ListDAO listDao = new ListDAO();
				ArrayList<Reservation_ListBean> rList = listDao.reservation_List(request);
				request.setAttribute("rList",rList);
			}
		}

		return "/reservationList.jsp";
	}
}
