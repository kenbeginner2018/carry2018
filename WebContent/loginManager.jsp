<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>管理者ログイン</title>
</head>
<body>
	<form action="t-order" method="post">
		<h1>管理者ログイン</h1>
			<strong>管理者番号</strong>
			<input type="text" size="15" name="managerId"  /><br />
			<strong>パスワード　</strong>
			<input type="text" size="15" name="password" /><br />

		<table summary="検索欄">
			<tr>
				<td>
					<input type="submit" name="login" value="ログイン" />
					<input type="hidden" name="act" value="TopManager" />
				</td>
			</tr>
		</table>
	</form>

	<div>
		<c:if test="${requestScope.errorMessage != null}">
			<%=request.getAttribute("errorMessage") %>
		</c:if>
	</div>
</body>
</html>
