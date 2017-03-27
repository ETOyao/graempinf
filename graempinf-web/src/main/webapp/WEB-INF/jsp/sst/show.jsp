<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../commonresource.jsp" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/validate/main.css"/>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
		<table id="listTable" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="7">学生信息查看：学生id[${sst.souUuid}]</td></tr></thead>
		<tr>
			<td class="rightTd" >考试号</td>
			<td class="leftTd">${sst.souExamNum} </td>
			<td class="rightTd" >学号:</td>
			<td class="leftTd">${sst.souStuNum}</td>
			<td class="rightTd" >身份证号:</td>
			<td class="leftTd">${sst.souIdcardNum}</td>
		</tr>
		<tr>
			<td class="rightTd" >姓名</td>
			<td class="leftTd">${sst.souName}</td>
			<td class="rightTd" >生源地:</td>
			<td class="leftTd">${sst.souAddr }</td>
			<td class="rightTd" >生源地类型:</td>
			<td>
				<c:if test="${sst.souSouceType eq 1}">城市</c:if>
				<c:if test="${sst.souSouceType eq 2}">农村</c:if>
				</td>
		</tr>
		<tr>
			<td class="rightTd" >家庭住址</td>
			<td class="leftTd">${sst.souHomeAddr}</td>
			<td class="rightTd" > 电话:</td>
			<td class="leftTd">${sst.souHomePhoe}</td>
			<td class="rightTd" >邮编:</td>
			<td class="leftTd">${sst.souHomePostCode}</td>
		</tr>
		<tr>
			<td class="rightTd" >是否低保</td>
			<td colspan="4">
				<c:if test="${sst.souIsLowPro eq 1}">是</c:if>
				<c:if test="${sst.souIsLowPro eq 2}">否</c:if>
				<td>
		</tr>
		<tr>
			<td colspan="7" class="centerTd">
				<c:if test="${isAdmin}">
				<a href="update/${sst.souUuid }" class="list_op">修改信息</a>
				</c:if>
			</td>
		</tr>
	</table>
</div>
</body>
</html>