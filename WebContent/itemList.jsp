<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

</head>

<title>商品一覧</title>
<body>
<div class= "本文" style="float: left;" width="70%">
<form action="t-order" method="post">
	<h1>商品一覧</h1>
	<%=session.getAttribute("showId") %>
		<table border="1" summary="カテゴリー検索" align="center">
			<tr>
				<th>カテゴリー</th>
				<td>
					<select name="category">
					<option value="組トップグッズ" selected="selected">組トップグッズ</option>
					<option value="公演グッズ">公演グッズ</option>
					<option value="雑誌">雑誌</option>
					<option value="写真">写真</option>
					<option value="雑貨">雑貨</option>
					</select>
				</td>
			</tr>
		</table>
	</form>
	<form action="t-order" method="post">
	<%
		//表作成用変数
		int i = 0;
	%>
		<table border="3" height="100">
			<c:forEach var="item" items="${sessionScope.items}" >

				<%
					if(i == 0){
				%>
					<tr>
				<%
					}
				%>
						<td align="center" width="200">
							<input type="image" src="img/${item.itemImage}" alt="グッズA" />
							<input type="hidden" name="act" value="ItemDetailList" /><br/>
							${item.itemName}<br/>
							￥${item.itemPrice}
						</td>
				<%
					i++;
					if(i == 3){
				%>
					</tr>
				<%
					i = 0;
					}
				%>
			</c:forEach>
		</table>
	</form>
	<form action="t-order" method="post">
		<table summary="検索欄">
			<tr>
				<td>
					<input type="submit" name="Items" value="買い物終了" />
					<input type="hidden" name="act" value="Credit" />
				</td>
			</tr>
		</table>
	</form>
	<form action="t-order" method="post">
		<table summary="検索欄">
			<tr>
				<td>
					<input type="submit" name="Items" value="戻る" />
					<input type="hidden" name="act" value="Select" />
				</td>
			</tr>
		</table>
	</form>
</div>
<div class= "サイド" style="float: right;border-left:#000000 solid 7px;height:600px;">
<h1 align="center">カート一覧</h1>
<table border="4"  rules="rows">
	<tr>
		<td>
		　
		</td>
		<td>
		金額
		</td>
		<td>
		数量
		</td>
		<td>
		　
		</td>
	</tr>
	<tr>
		<td>
		ブレスレット/望海風斗
		</td>
		<td>
		¥3,300
		</td>
		<td>
		<select name="kosuu">
					<option value="1" selected="selected">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					</select>
		</td>
		<td>
		<input type="submit" value="削除"/>
		</td>
	</tr>
</table>
</div>
</body>
</html>