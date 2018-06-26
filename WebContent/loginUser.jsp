<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>チケット照会</title>
</head>
<body>
	<form action="t-order" method="post">
		<h1>チケット照会</h1>
		<table>
			<tr>
				<td><strong>予約番号(チケット番号)</strong></td>
				<td><input type="text" size="15" name="reservNo" /></td>
			</tr>
			<tr>
				<td><strong>電話番号</strong></td>
				<td><input type="text" size="15" name="telNo" /></td>
			</tr>
		</table>

		<table summary="検索欄">
			<tr>
				<td>
					<input type="hidden" name="itemCount" value=${requestScope.itemCount} />
					<input type="hidden" name="itemPrice" value=${requestScope.itemPrice} />
					<input type="hidden" name="itemName" value=${requestScope.itemName} />
					<input type="submit" name="Items" value="照会" />
					<input type="hidden" name="act" value="ItemList" />
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
	<hr />

<!-- 6/24追加 -->
	<c:if test="${requestScope.errorMessage == null }">
		電話番号はハイフンを入れて入力してください。<br />
		例）090-4532-xxxx
	</c:if>
	<c:if test="${requestScope.errorMessage != null }">
		${requestScope.errorMessage}
	</c:if>


</body>
</html>