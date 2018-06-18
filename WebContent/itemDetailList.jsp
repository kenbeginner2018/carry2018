<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>商品詳細</title>
</head>
<body>
<center>
	<form action="t-order" method="post">
	<h1>商品詳細</h1>
	<table style="border-style: none;"border="1">
			<tr>
				<td style="border-style: none;" align="center" >
				<img src="img/1_bracelet.png" /><br />
				</td>
			</tr>
			<tr>
				<td style="border-style: none;" align="center">ブレスレット/望海風斗</td>
			</tr>
			<tr>
				<td style="border-style: none;" align="center">¥3,300</td>
			</tr>

			<tr>
				<td style="border-style: none;">望海風斗デザイン監修グッズより、ブレスレットが登場！<br />
					“幸運を受けとめる”形をしている、といわれる馬蹄チャームが使われたアイテム！<br />
					どんなシーンでも合わせられるようにと、シンプルかつ上品に仕上がりました。<br />
					ブレスレットは、ゴム仕様なのでつけ外しはとっても便利☆<br />
				</td>
			</tr>
		</table>
		<table summary="検索欄">
			<tr>
				<td>
					<input type="submit" name="add" value="カートに入れる" />
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
</center>
</body>
</html>