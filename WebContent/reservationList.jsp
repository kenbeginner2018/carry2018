<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>予約者一覧</title>
</head>
<body>
<h1>予約者検索画面</h1>
<form action=" " method="post">
	<p>検索したい公演日を入力してください</p>
	<p>
		<input type="text" name="" value="" />
		<input type="hidden" name="" value="showDaySerth" />
		<input type="submit"  value="検索" />
	</p>
</form>

<%--		<c:if test="${not empty requestScope.message}">
		<p class="message">${requestScope.message}</p>
	</c:if>

	<c:if test="${not empty sessionScope.     }">
--%>
		<h2>検索結果</h2>
		<table border="1" summary="検索結果をまとめた表">
			<tr>
				<th>予約番号</th>
				<th>商品総数</th>
				<th>合計金額</th>
				<th>&nbsp;</th>
			</tr>
<%--
		<c:forEarth var=" " items="${requestScope. List}">
			<tr>
				<td><c:out value="${   .reserveNo}" /></td>
				<td><c:out value="${   .count}" /></td>
				<td><c:out value="${   .totalcount}" /></td>
				<td>
					<form action="delete" method="get">
						<input type="hedden" neme=" " value="${  .reserveNo}" />
--%>
					<input type="submit" value="削除" />
					</form>
				</td>
			</tr>
		<%--</c:forEath>--%>
	</table>
	<%--</c:if>--%>



</body>
</html>