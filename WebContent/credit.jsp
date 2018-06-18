<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>クレジット照合</title>
</head>
<body>
<form action="t-order" method="post">
	<h1>クレジットカード情報</h1>
		<strong>1.カード番号</strong>
		<table summary="検索欄">
		<tr>
			<td><input type="text" size="5" name="number" />
			<input type="text" size="5"name="number" />
			<input type="text" size="5" name="number" /></td>
		</tr>
		</table>


		<strong>2.カード名義人</strong>

		<tr>
			<td><input type="text" name="number" value=""/></td>
		</tr>

		<strong>3.有効期限</strong>
		<tr>
			<td><input type="text" name="number" value=""/></td>
		</tr>
			<tr>
				<td>
					<input type="submit" name="Items" value="確認" />
					<input type="hidden" name="act" value="ContentList" />
				</td>
			</tr>
		</table>
</form>
<form action="t-order" method="post">
		<table summary="検索欄">
			<tr>
				<td>
					<input type="submit" name="Items" value="グッズ一覧へ" />
					<input type="hidden" name="act" value="ItemList" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>