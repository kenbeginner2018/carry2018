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

		<table border="1" summary="カテゴリー検索" align="center">
			<tr>
				<th>カテゴリー</th>
				<td>
					<select name="categoryId">
					<option value=0 selected="selected">全件表示</option>
					<c:forEach var="category" items="${sessionScope.category}" >
					<option value="${category.categoryId}">${category.categoryName}</option>
					</c:forEach>
					</select>
				</td>
				<td>
					<input type="submit" name="btn" value="検索" />

					<input type="hidden" name="act" value="ItemList" />
				</td>
			</tr>

		</table>
	</form>

	<%
		//表作成用変数
		int i = 0;
	%>
		<table border="3" height="100">
			<c:forEach var="item" items="${sessionScope.items}" >
			<form action="t-order" method="post">

				<%
					if(i == 0){
				%>
					<tr>
				<%
					}
				%>
						<td align="center" width="200">
							<input type="image" src="img/${item.itemImage}" alt="${ item.itemName}" />
							<input type="hidden" name="act" value="ItemDetailList" /><br/>
							${item.itemName}<br/>
							￥${item.itemPrice}
							<input type="hidden" name="itemName" value="${item.itemName}" />
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
				</form>
			</c:forEach>
		</table>

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
		<td>
		</td>
		<td>

		</td>
	</tr>
	<% int l = 0; %>
	<c:forEach var="cart" items="${sessionScope.cart}" >
			<form action="t-order" method="post">
					<tr>
						<td>
							${cart.itemName}
						</td>

						<td>
							¥${cart.itemPrice}円
						</td>
						<td>
							${cart.itemCount}
						</td>
						<td>
							<select name="itemcount">
							<option value="1" selected="selected">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							</select>
						</td>
						<td>
							<input type="hidden" name="update" value="update" />
							<input  type="hidden"name="act" value="ItemList" />
							<input type="hidden" name="updateNo" value = <%=l %> />
							<input type="submit"name="btn" value="更新"/>
						</td>
						<td>
							<input type="hidden" name="delete" value="delete" />
							<input  type="hidden"name="act" value="ItemList" />
							<input type="hidden" name="deleteNo" value = <%=l %> />
							<input type="submit" name="btn" value="削除"/>
						</td>
					</tr>
			</form>
			<%
			l++;
			%>
		</c:forEach>


</table>
</div>
</body>
</html>

