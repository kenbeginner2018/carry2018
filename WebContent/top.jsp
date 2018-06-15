<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
</head>
<body>

<form action="t-order" method="post">
<h1>TOP</h1>
				<table summary="検索欄">
						<tr>
						<td>
							<a href="select" >公演選択</a>
						</td>
					</tr>
				</table>
</form>
<form action="t-order" method="post">
				<table summary="検索欄">
						<tr>
						<td>
							<a href type="submit" name="cancel" value="キャンセル">
							キャンセル
							</a>
						</td>
					</tr>
				</table>
</form>
<form action="t-order" method="post">
				<table summary="検索欄">
						<tr>
						<td>
							<a href="submit" name="select" value="購入履歴" >
							購入履歴
							</a>
						</td>
					</tr>
				</table>
</form>
<form action="t-order" method="post">
				<table summary="検索欄">
						<tr>
						<td>
							<a href type="submit" name="loginUser" value="ログイン">
							ログイン
							</a>
						</td>
					</tr>
				</table>
</form>
<form action="t-order" method="post">
				<table summary="検索欄">
						<tr>
						<td>
							<a href type="submit" name="topManager" value="管理者へ">
							管理者へ
							</a>
						</td>
					</tr>
				</table>
</form>
</body>
</html>