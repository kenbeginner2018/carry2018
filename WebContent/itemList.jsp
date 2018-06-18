<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>商品一覧</title>
</head>


<body>
<form action="t-order" method="post">
	<h1>商品一覧</h1>
		<table border="1" summary="カテゴリー検索" align="center">
			<tr>
				<th>カテゴリー</th>
				<td>
					<select name="category">
					<option value="組トップグッズ" selected="selected">組トップグッズ</option>
					<option value="公演グッズ">公演グッズ</option>
					<option value="雑誌">雑誌</option>
					<option value="写真">写真</option>
					<option value="雑貨">雑貨</option>
					</select>
				</td>
			</tr>
		</table>
	</form>
	<form action="t-order" method="post">
		<table border="3" width="600" height="100">
			<tr>
				<td align="center">
					<input type="image" src="img/1_bracelet.png" alt="グッズA" />
					<input type="hidden" name="act" value="ItemDetailList" /><br/>
					ブレスレット/望海風斗<br/>
					¥3,300
				</td>
				<td align="center">
					<input type="image" src="img/1_eaudetoilette.png" alt="グッズB" />
					<input type="hidden" name="act" value="ItemDetailList" /><br/>
					オードトワレ/望海風斗<br/>
					¥4,600
				</td>
				<td align="center">
					<input type="image" src="img/2_charm.png" alt="グッズC" />
					<input type="hidden" name="act" value="ItemDetailList" /><br/>
					チャーム／雪組「凱旋門」<br/>
					「Gato Bonito!!」<br/>
					¥800
				</td>
			</tr>
			<tr>
				<td align="center">
					<input type="image" src="img/2_bag.png" alt="グッズD" />
					<input type="hidden" name="act" value="ItemDetailList" /><br/>
					観劇バッグ／雪組「凱旋門」<br/>
					「Gato Bonito!!」<br/>
					¥3,300
				</td>
				<td align="center">
					<input type="image" src="img/3_program.png" alt="グッズE" />
					<input type="hidden" name="act" value="ItemDetailList" /><br/>
					宝塚大劇場公演プログラム<br/>
					「凱旋門」「Gato Bonito!!」<br/>
					＜雪組＞<br/>
					¥1,000
				</td>
				<td align="center">
					<input type="image" src="img/3_magazine.png" alt="グッズF" />
					<input type="hidden" name="act" value="ItemDetailList" /><br/>
					歌劇6月号（2018年）<br />
					¥720<br/>
				</td>
			</tr>
		</table>
	</form>
	<form action="t-order" method="post">
		<table summary="検索欄">
			<tr>
				<td>
					<input type="submit" name="Items" value="買い物終了" />
					<input type="hidden" name="act" value="LoginUser" />
				</td>
			</tr>
		</table>
	</form>
	<form action="t-order" method="post">
		<table summary="検索欄">
			<tr>
				<td>
					<input type="submit" name="Items" value="戻る" />
					<input type="hidden" name="act" value="Select" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>