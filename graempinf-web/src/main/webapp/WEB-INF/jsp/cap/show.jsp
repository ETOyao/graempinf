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
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
		<table id="listTable" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="7">预约信息查看：预约会id[${cap.capUUid}]</td></tr></thead>
		<tr>
			<td class="rightTd" >预约编号</td>
			<td class="leftTd">${cap.capAppCode} </td>
			<td class="rightTd" >预约人学号:</td>
			<td class="leftTd">${cap.capstuNum}</td>
			<td class="rightTd" >预约人姓名:</td>
			<td class="leftTd">${cap.capstuName}</td>
		</tr>
		<tr>
			<td class="rightTd" >专业</td>
			<td class="leftTd">${cap.capObject} </td>
			<td class="rightTd" >预约人学号:</td>
			<td class="leftTd">${cap.capstuNum}</td>
			<td class="rightTd" >招聘会名称:</td>
			<td class="leftTd">${cap.careeFairName}</td>
		</tr>
		<tr>
			<td class="rightTd" >就业意愿1</td>
			<td class="leftTd">${cap.jobDirecttion1} </td>
			<td class="rightTd" >就业意愿2:</td>
			<td class="leftTd">${cap.jobDirecttion2}</td>
			<td class="rightTd" >就业意愿3:</td>
			<td class="leftTd">${cap.jobDirecttion3}</td>
		</tr>
		<tr>
			<td class="rightTd" >联系电话</td>
			<td class="leftTd">${cap.attr1} </td>
			<td class="rightTd" >邮箱:</td>
			<td class="leftTd" colspan="1">${cap.atrtr2}</td>
			<td class="rightTd" >意见:</td>
			<td class="leftTd" colspan="1">${cap.capAdvice}</td>
		</tr>
	</table>
</div>
</body>
</html>