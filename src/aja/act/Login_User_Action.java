package aja.act;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import aja.bean.LoginBean;
import aja.bean.ShowBean;
import aja.dao.LoginDAO;

public class Login_User_Action extends Action {

	@Override
	public String execute(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession(true);
		LoginBean login = (LoginBean) session.getAttribute("login");

		//itemName,itemCountをrequestで再度転送する
		request.setAttribute("itemName", request.getParameter("itemName"));
		request.setAttribute("itemCount", request.getParameter("itemCount"));
		request.setAttribute("itemPrice", request.getParameter("itemPrice"));

		//loginがsessionに存在すれば、loginページをスキップしてitemList.jspへ遷移
		if(login != null) {

			//公演日時と選択された公演の日付をチェック
			LoginDAO loginDao = new LoginDAO();

			//公演の日付

			ShowBean showDate = loginDao.show_Date((Integer)session.getAttribute("showId"));
			loginDao = new LoginDAO();

			//購入者が持っている公演日時
			Date ticketDay = loginDao.ticket_Day(login.getReservNo());

			if(showDate.getShowStartDay().before(ticketDay) && showDate.getShowEndDay().after(ticketDay)) {
				//公演内のチケットだったら
				return "/itemList.jsp";
			}
			//そうでなかったら
			else {
				String errorMessage = "この予約番号は選択された公演の予約番号ではありません";
				request.setAttribute("errorMessage",errorMessage);

				return "/loginUser.jsp";
			}
		}else {
			return "/loginUser.jsp";
		}
	}

}
