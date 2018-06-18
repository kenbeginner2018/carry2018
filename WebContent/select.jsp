<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>公演選択</title>
</head>
<body>
<center>
	<form action="t-order" method="post">
	<h1>公演選択</h1>
		<table border="2">
			<tr>
				<td>
					<input type="image" src="img/gaisenmon.jpg" alt="公演A" width="150" height="200" />
					<input type="hidden" name="act" value="ItemList" />
				</td>
				<td align="center" width="300" >
					<font size="6">凱旋門</font><br/>
					6月8日（金）～7月9日（月）
				</td>
			</tr>
			<tr>
				<td>
					<input type="image" src="img/messiah.jpg" alt="公演B" width="150" height="200" />
					<input type="hidden" name="act" value="ItemList" />
				</td>
				<td align="center" width="300">
					<font size="6">MESSIAH</font><br/>
					メサイア<br/>
					7月13日（金）～8月20日（月）
				</td>
			</tr>
		</table>
	</form>
	<form action="t-order" method="post">

		<table summary="検索欄">
			<tr>
				<td>
				<br/>
					<input type="submit" name="ShowName" value="戻る" />
					<input type="hidden" name="act" value="Top" />
				</td>
			</tr>
		</table>
	</form>
	</center>
</body>
</html>