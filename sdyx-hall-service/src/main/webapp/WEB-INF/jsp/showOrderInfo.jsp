<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>orderInfo</title>
</head>
<body>
	<table>
		<c:forEach var="orderItemInfo" items="${orderInfo }" varStatus="status">
			<c:if test="${orderItemInfo.orderType==1 }">
				<tr>
					<td>客户编码:</td>
					<td><c:out value="${orderItemInfo.customerCode }" />
					</td>
				</tr>
				<tr>
					<td>姓名:</td>
					<td><c:out value="${orderItemInfo.customerName }" />
					</td>
				</tr>
				<tr>
					<td>地址:</td>
					<td><c:out value="${orderItemInfo.manageAddressFullName }" />
					</td>
				</tr>
				<tr>
					<td>续费</td>
					<td><c:out value="${orderItemInfo.commodityName }" /></td>
					<td><c:out value="${orderItemInfo.payMonth }" />
					<td>个月</td>
					</td>
					<td><c:out value="${orderItemInfo.commodityPrice }" />
					</td>
					<td>元</td>
				</tr>
				<tr>
					<td>卡号:</td>
					<td><c:out value="${orderItemInfo.caNumber }" /></td>
				</tr>
			</c:if>
			<c:if test="${orderItemInfo.orderType==2 }">
				<tr>
					<td>客户编码:</td>
					<td><c:out value="${orderItemInfo.customerCode }" />
					</td>
				</tr>
				<tr>
					<td>姓名:</td>
					<td><c:out value="${orderItemInfo.customerName }" />
					</td>
				</tr>
				<tr>
					<td>地址:</td>
					<td><c:out value="${orderItemInfo.manageAddressFullName }" />
					</td>
				</tr>
				<tr>
					<td>充值</td>
					<td><c:out value="${orderItemInfo.commodityPrice }" />
					</td>
					<td>元</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
</body>
</html>