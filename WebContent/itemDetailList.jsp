<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="aja.bean.ItemBean" %>
<%@ page import="aja.bean.LoginBean" %>
<%
	@SuppressWarnings("unchecked")
	ArrayList<ItemBean> details = (ArrayList<ItemBean>)request.getAttribute("detail");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>商品詳細</title>
</head>
<body>
	<center>
		<form action="t-order" method="post">
			<h1>商品詳細</h1>
			<table style="border-style: none;"border="1">
				<%
					for(int i = 0; i<details.size(); i++){
					ItemBean detail = (ItemBean)details.get(i);
				%>
				<tr>
					<td style="border-style: none;" align="center" >
						<img src="img/<%=detail.getItemImage() %>" /><br />
					</td>
				</tr>
				<tr>
					<td style="border-style: none;" align="center"><%=detail.getItemName() %></td>
						<input type="hidden" name="itemName" value=<%=detail.getItemName() %> />
				</tr>
				<tr>
					<td style="border-style: none;" align="center">¥<%=detail.getItemPrice() %></td>
					<input type="hidden" name="itemPrice" value=<%=detail.getItemPrice() %> />
				</tr>
				<tr>
					<td style="border-style: none;"><%=detail.getItemDetail() %></td>
				</tr>
				<%
					}
				%>
			</table>
			<table summary="検索欄">
				<tr>
					<td>
						<select name="itemCount">
							<option value="1" selected="selected">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</td>
					<td>
					<%
						LoginBean login = (LoginBean)session.getAttribute("login");
						if(login != null){
					%>
					<input type="hidden" name="act" value="ItemList" />
					<%
						}
					%>
					<input type="submit" name="add" value="カートに入れる" />
					<input type="hidden" name="act" value="LoginUser" />
					</td>
				</tr>
			</table>
		</form>
		<form action="t-order" method="post">
			<table summary="検索欄">
				<tr>
					<td>
						<input type="submit" name="Items" value="戻る" />
						<input type="hidden" name="act" value="ItemList" />
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>