<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>内容確認</title>
</head>
<body>
<form action="t-order" method="post">
	<h1>内容確認</h1>
		<table summary="検索欄">
			<tr>
				<td>
					<input type="submit" name="content" value="確定" />
					<input type="hidden" name="act" value="Fixed" />
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
	<form action="t-order" method="post">
		<table summary="検索欄">
			<tr>
				<td>
					<input type="submit" name="Items" value="支払方法変更" />
					<input type="hidden" name="act" value="Credit" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>