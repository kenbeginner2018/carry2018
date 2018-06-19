<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>チケット照会</title>
</head>
<body>
<form action="t-order" method="post">
	<h1>チケット照会</h1>


	<strong>予約番号（チケット番号）</strong>
		<table>
			<tr>
			<td><input type="text" size="15" name="number" /></td>
			<td><input type="hidden" name="act" value="reserveNo" /></td>
		</tr>
		</table>


	<strong>電話番号</strong>
		<table>
			<tr>
			<td><input type="text" size="15" name="number" /></td>
			<td><input type="hidden" name="act" value="telNo" /></td>
		</tr>
		</table>





		<table summary="検索欄">
			<tr>
				<td>
					<input type="submit" name="Items" value="紹介" />
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
					<input type="hidden" name="act" value="ItemList" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>