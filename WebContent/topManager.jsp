<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>管理者トップ</title>
</head>
	<body>


<center>

<form action="t-order" method="post">
<div align="center"><h1>TOP</h1></div>
				<table summary="検索欄">
						<tr>
						<td align="center">
							<input type="submit" name="Items" value="商品一覧" />
							<input type="hidden" name="act" value="ItemList" />
						</td>
					</tr>
				</table>
</form>
<form action="t-order" method="post">
				<table summary="検索欄">
						<tr>
						<td align="center">
							<input type="submit" name="Reservation" value="予約者一覧" />
							<input type="hidden" name="act" value="ReservationList" />
						</td>
					</tr>
				</table>
</form>
<form action="t-order" method="post">
				<table summary="検索欄">
						<tr>
						<td align="center">
							<input type="submit" name="Show" value="公演一覧" />
							<input type="hidden" name="act" value="ShowList" />
						</td>
					</tr>
				</table>
	</form>
		<form action="t-order" method="post">
				<table summary="検索欄">
						<tr>
						<td align="center">
							<input type="submit" name="login" value="ログイン" />
							<input type="hidden" name="act" value="LoginManager" />
						</td>
					</tr>
				</table>
</form>
</center>
</body>
</html>