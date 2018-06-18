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
	<h1>ご注文内容確認</h1>


	<center>
		<table border="3" summary="注文内容表示">
			<tr bgcolor="#CCFFFF">
				<th>商品名</th><th>価格</th><th>数量</th><th>小計</th>

			</tr>

			<tr><td><input type="image" src="img/1_bracelet.png" alt="グッズA" />
				</td>
				<td>商品名
				</td>
				<td>価格
				</td>
				<td>数量
				</td>
			</tr>


					<tr>
					<td>支払い方法：クレジット一括</td>
					</tr>
				<tr><td>合計金額 円
					</td>
				</tr>





		</table>

</center>
	<center>
		<table summary="検索欄">
			<tr>
				<td>
					<input type="submit" name="content" value="注文を確定する" />
					<input type="hidden" name="act" value="Fixed" />
				</td>
			</tr>
		</table>
</form>
<form action="t-order" method="post">
		<table summary="検索欄">
			<tr>
				<td>
					<input type="submit" name="Items" value="商品一覧へ" />
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
	</center>
	</form>
</body>
</html>