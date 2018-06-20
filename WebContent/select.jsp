<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="aja.bean.ShowBean" %>
<%
	@SuppressWarnings("unchecked")
	ArrayList<ShowBean> shows = (ArrayList<ShowBean>)request.getAttribute("show");
%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>公演選択</title>
</head>
<body>
<center>

	<h1>公演選択</h1>


		<table summary="検索欄">
		<%
			for(int i = 0; i<shows.size(); i++){
				ShowBean show = (ShowBean)shows.get(i);
		%>
		<form action="t-order" method="post">
			<tr>
				<td align="center">
					<%
						String imgsrc = "img/" + show.getShowimage();
					%>
					<input type="image" src= "<%=imgsrc %>" alt="グッズ<%=i %>" width="150" height="200" />
				</td>
				<td align="center" width="300" >
					<font size="6"><%=show.getShowName() %></font>
					<input type="hidden" name="showId" value=<%=show.getShowId() %> />
					<input type="hidden" name="act" value="ItemList" />
				</td>
			</tr>
		</form>
		<%
			}
		%>
				</table>



	<form action="t-order" method="post">
		<table summary="検索欄">

			<tr>
				<td>
				<br/>
					<input type="submit" name="ShowName" value="戻る" />

					<input type="hidden" name="act" value="Top" />
				</td>
			</tr>

		</table>
	</form>
	</center>
</body>
</html>