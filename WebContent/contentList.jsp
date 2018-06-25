<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>内容確認</title>
</head>
<body>

	    <div style="float:right;" width="30%">
			<c:if test = "${sessionScope.login !=null }">
				<form action="t-order" method="post">

					<input type="submit" name="btn" value="ログアウト" />
					<input type="hidden" name="act" value="LogOut" />
				</form>
			</c:if>
		</div>

<form action="t-order" method="post">
	<h1>ご注文内容確認</h1>


	<center>
		<table border="3" summary="注文内容表示" cellspacing="1">
			<tr bgcolor="#b3b3b3" align="center">
				<th>商品名</th>
				<th>単価</th>
				<th>数量</th>
				<th>小計</th>

			</tr>

			<tr align="center">
				<c:forEach var="cart" items="${sessionScope.cart}">
					<tr>
						<td><c:out value="${cart.itemName}" /></td>
						<td><c:out value="${cart.itemPrice}" /></td>
						<td><c:out value="${cart.itemCount}" /></td>
						<td><c:out value="${cart.subTotal}" /></td>
					</tr>
				</c:forEach>
			</tr>


			<tr>
				<td colspan="4">支払い方法：クレジット一括</td>
			</tr>
			<tr>
				<td colspan="4">合計金額 ${requestScope.totalPrice}円</td>
			</tr>





		</table>

</center>
	<center>
		<table summary="検索欄">
			<tr>
				<td>
					<input type="submit" name="contents" value="注文を確定する" />
					<input type="hidden" name="act" value="Fixed" />
				</td>
			</tr>
		</table>
</form>
<form action="t-order" method="post">
		<table summary="検索欄">
			<tr>
				<td>
					<input type="submit" name="Items" value="商品一覧へ" />
					<input type="hidden" name="act" value="ItemList" />
				</td>
			</tr>
		</table>
	</form>
	<form action="t-order" method="post">
		<table summary="検索欄">
			<tr>
				<td>
					<input type="submit" name="Items" value="支払方法変更" />
					<input type="hidden" name="act" value="Credit" />
				</td>
			</tr>
		</table>
	</center>
	</form>
</body>
</html>