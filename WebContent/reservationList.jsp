<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>予約者一覧</title>
</head>
<body>
<center>
<h1>予約者検索画面</h1>
<form action=" " method="post">
	<p>検索したい公演日を入力してください</p>
	<p>
		<select name="select">
		<option value="">--</option>
		<option value="2000">2000</option>
		<option value="2001">2001</option>
		<option value="2002">2002</option>
		<option value="2003">2003</option>
		<option value="2004">2004</option>
		<option value="2005">2005</option>
		<option value="2006">2006</option>
		<option value="2007">2007</option>
		<option value="2008">2008</option>
		<option value="2009">2009</option>
		<option value="2010">2010</option>
		<option value="2011">2011</option>
		<option value="2012">2012</option>
		<option value="2013">2013</option>
		<option value="2014">2014</option>
		<option value="2015">2015</option>
		<option value="2016">2016</option>
		<option value="2017">2017</option>
		<option value="2018">2018</option>
		<option value="2019">2019</option>
		<option value="2020">2020</option>
		</select>
		年
		<select name="month">
		<option value="">--</option>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		<option value="6">6</option>
		<option value="7">7</option>
		<option value="8">8</option>
		<option value="9">9</option>
		<option value="10">10</option>
		<option value="11">11</option>
		<option value="12">12</option>
		</select>
		月
		<select name="day">
		<option value="">--</option>
		<option value="1">1</option>
		<option value="2">2</option>
		<option value="3">3</option>
		<option value="4">4</option>
		<option value="5">5</option>
		<option value="6">6</option>
		<option value="7">7</option>
		<option value="8">8</option>
		<option value="9">9</option>
		<option value="10">10</option>
		<option value="11">11</option>
		<option value="12">12</option>
		<option value="13">13</option>
		<option value="14">14</option>
		<option value="15">15</option>
		<option value="16">16</option>
		<option value="17">17</option>
		<option value="18">18</option>
		<option value="19">19</option>
		<option value="20">20</option>
		<option value="21">21</option>
		<option value="22">22</option>
		<option value="23">23</option>
		<option value="24">24</option>
		<option value="25">25</option>
		<option value="26">26</option>
		<option value="27">27</option>
		<option value="28">28</option>
		<option value="29">29</option>
		<option value="30">30</option>
		<option value="31">31</option>
		</select>
		日


		<input type="hidden" name="" value="showDaySerth" />
		<input type="submit"  value="検索" />
	</p>
</form>

<%--		<c:if test="${not empty requestScope.message}">
		<p class="message">${requestScope.message}</p>
	</c:if>

	<c:if test="${not empty sessionScope.     }">
--%>
		<h2>検索結果</h2>
		<table border="1" summary="検索結果をまとめた表">
			<tr>
				<td>予約番号</td>
				<td>商品総数</td>
				<td>合計金額</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			</table><br/>
<%--
		<c:forEarth var=" " items="${requestScope. List}">
			<tr>
				<td><c:out value="${   .reserveNo}" /></td>
				<td><c:out value="${   .count}" /></td>
				<td><c:out value="${   .totalcount}" /></td>
				<td>
					<form action="delete" method="get">
						<input type="hedden" neme=" " value="${  .reserveNo}" />
--%>
					<input type="submit" value="戻る" />
					</form>
				</td>
			</tr>
		<%--</c:forEath>--%>
	<%--</c:if>--%>


</center>
</body>
</html>