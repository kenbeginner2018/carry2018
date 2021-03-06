<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>予約一覧</title>
</head>
<body>
<form action="t-order" method="post">
	<h1>予約者商品一覧</h1>


	<center>
		<table border="3" summary="注文内容表示">
			<tr bgcolor="#CCFFFF">
				<td colspan="3">
					予約番号:
					<c:out value="${requestScope.reserveNo}" />
				</td>
			</tr>
			<tr>
				<td>
					商品名
				</td>
				<td>
					数量
				</td>
				<td>
					小計
				</td>

			</tr>



		<c:forEach var="oList" items="${requestScope.oList}">
			<tr>
				<td><c:out value="${oList.itemName}" /></td>
				<td><c:out value="${oList.itemCount}" /></td>
				<td><c:out value="${oList.subTotal}" /></td>
			</tr>
		</c:forEach>

			<tr>


				<td align="right" colspan="3">
					<strong>合計金額 ${requestScope.totalPrice}円</strong>
				</td>
			</tr>

		</table>

</center>
	<center>
		<table summary="検索欄">
			<tr>

			</tr>
		</table>
</form>
<form action="t-order" method="post">
		<table summary="検索欄">

			<tr>
				<td>
					<input type="submit" name="Content" value="予約者一覧へ戻る" />
					<input type="hidden" name="act" value="ReservationList" />
				</td>
			</tr>
		</table>
	</center>
	</form>

</body>
</html>