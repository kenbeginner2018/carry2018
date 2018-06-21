<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>予約者一覧</title>
</head>
<body>
<center>
<h1>予約者検索画面</h1>
<form action="t-order" method="post">
	<p>検索したい公演日を入力してください</p>
	<p>
	<!-- 年の指定 -->
		<select name="showYear">
		<option value="">--</option>
		<%
			int year = (Integer)request.getAttribute("listYear");
			for(int i = year - 3 ; i <= year + 3 ; i++ ){
		%>
	  		<option value="<%=i %>"><%=i %></option>
		<%
			}
		%>
		</select>
		年


	<!-- 月の指定 -->
		<select name="showMonth">
		<option value="">--</option>
		<%
			for(int i = 1 ; i <= 12 ; i++ ){
		%>
			<option value="<%=i %>"><%=i %></option>
		<%
			}
		%>
		</select>
		月

	<!-- 日の指定 -->
		<select name="showDay">
		<option value="">--</option>
		<%
			for(int i = 1 ; i <= 31 ; i++ ){
		%>
			<option value="<%=i %>"><%=i %></option>
		<%
			}
		%>
		</select>
		日


		<input type="submit" name="Reservation" value="検索" />
		<input type="hidden" name="act" value="ReservationList" />
	</p>
</form>

<c:if  test="${requestScope.rList != null}">
	<c:if  test="${requestScope.rList.size() != 0}">

		<h2>検索結果</h2>
		<table border="1" summary="検索結果をまとめた表">
			<tr>
				<td>予約番号</td>
				<td>商品総数</td>
				<td>合計金額</td>
			</tr>
			<c:forEach var="rList" items="${requestScope.rList}">
				<tr>
					<td><c:out value="${rList.reservNo}" /></td>
					<td><c:out value="${rList.totalCount}" /></td>
					<td><c:out value="${rList.totalPrice}" /></td>
					<td>
					<form>
						<input type="submit" name="reservNo" value="詳細確認" />
						<input type="hidden" name="reserveNo" value="${rList.reservNo}" />
						<input type="hidden" name="totalPrice" value="${rList.totalPrice}" />
						<input type="hidden" name="act" value="BuyDetail" />
					</form>
					</td>
				</tr>
			</c:forEach>
		</table><br/>
	</c:if>

	<c:if  test="${requestScope.rList.size() == 0}">
		<div>
			<strong>指定された日時の予約はありません</strong>
		</div>
	</c:if>

</c:if>
	<div>
		<c:if test="${requestScope.errorMessage != null}">
			<strong><%=request.getAttribute("errorMessage") %></strong>
		</c:if>
	</div>

	<div>
		<form>
			<input type="submit" name="reservNo" value="戻る" />
			<input type="hidden" name="act" value="TopManager" />
		</form>
	</div>


</center>
</body>
</html>