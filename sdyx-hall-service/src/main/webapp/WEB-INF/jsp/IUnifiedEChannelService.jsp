<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>getOrderInfo</title>
</head>
<body>
	<form method="POST" action="/sdyx-hall-service/showOrderInfo.htmls">
		<table>
			<tr>
				<td>cityFlag:</td>
				<td><select id="cityFlag" name="cityFlag">
						<option value="JS">济南</option>
						<option value="ZB">淄博</option>
						<option value="DY">东营</option>
						<option value="YT">烟台</option>
						<option value="WF">潍坊</option>
						<option value="JN">济宁</option>
						<option value="TA">泰安</option>
						<option value="WH">威海</option>
						<option value="RZ">日照</option>
						<option value="LW">莱芜</option>
						<option value="LY">临沂</option>
						<option value="BZ">滨州</option>
						<option value="HZ">菏泽</option>
						<option value="LC">济南历城</option>
				</select>
				</td>
			</tr>
			<td>orderNumber:</td>
			<td><input type="text" name="orderNumber">
			</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>