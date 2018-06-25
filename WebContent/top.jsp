<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
</head>
<body >
	<center>

	<form action="t-order" method="post">
		<div align="center"><h1>TOP</h1></div>
		<table summary="検索欄">
			<tr>
				<td align="center">
					<input type="submit" name="Shows" value="公演選択" />
					<input type="hidden" name="act" value="Select" />
				</td>
			</tr>
		</table>
	</form>
	<form action="t-order" method="post">
		<table summary="検索欄">
			<tr>
				<td align="center">
					<input type="submit" name="Cancel" value="キャンセル" />
					<input type="hidden" name="act" value="Cancel" />
				</td>
			</tr>
		</table>
	</form>
	<form action="t-order" method="post">
		<table summary="検索欄">
			<tr>
				<td align="center">
					<input type="submit" name="Select" value="購入履歴" />
					<input type="hidden" name="act" value="Order_List" />
				</td>
			</tr>
		</table>
	</form>
	<form action="t-order" method="post">
		<table summary="検索欄">
			<tr>
				<td align="center">
					<input type="submit" name="Login" value="ログイン" />
					<input type="hidden" name="act" value="Login" />
				</td>
			</tr>
		</table>
	</form>
</center>
<hr/>
	<h5>【劇場情報】
			<ul>
				<li>宝塚大劇場<br /></li>
				<li>住所<br />
					〒665-8558　兵庫県宝塚市栄町1-1-57<br /></li>

				<li>TEL　0570-00-5100  (宝塚歌劇インフォメーションセンター)<br />
					※一部の携帯電話、IP電話等からはご利用いただけません。<br/>
				<br /></li>

				<li>劇場営業時間<br/>
	  				10:00〜18:00（水曜定休）<br/>
					※当日の公演内容により営業時間は変更致します。<br/></li>
			</ul>
	</h5>
</body>
</html>