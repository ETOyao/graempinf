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
		<thead><tr><td colspan="7">反馈问题信息查看：信息id[${que.questionUuid}]</td></tr></thead>
		<tr>
			<td class="rightTd" >问题反馈人</td>
			<td class="leftTd">${que.stuName} </td>
			<td class="rightTd" >问题反馈人学号:</td>
			<td class="leftTd">${que.stunum}</td>
			<td class="rightTd" >反馈内容:</td>
			<td class="leftTd">${que.questionContent}</td>
		</tr>
		<tr>
		<td class="rightTd" >问题反馈时间</td>
			<td><fmt:formatDate value="${que.createTime}" pattern="yyyy年MM月dd日  HH时mm分ss秒"/></td>
			<td class="rightTd" >问题答复时间:</td>
			<td>  <fmt:formatDate value="${que.answertime}" pattern="yyyy年MM月dd日  HH时mm分ss秒"/></td>
			<td class="rightTd" >问题状态:</td>
				<c:if test="${que.finshStatus ==0 }">
				<td>未答复</td>
				</c:if>
				<c:if test="${que.finshStatus ==1 }">
				<td>已答复</td>
				</c:if>
		</tr>
		<tr>
			<td class="rightTd" >问题答复人:</td>
			<td class="leftTd">${que.answerPerson}</td>
			<td class="rightTd" >问题答复内容</td>
			<td class="leftTd" colspan="4">${que.questionAnswer} </td>
			
		</tr>
		<tr>
			<td colspan="7" class="centerTd">
				<c:if test="${isAdmin}">
				<c:if test="${que.finshStatus ==0 }">
				<a href="update/${que.questionUuid }" class="list_op">答复该问题</a>
				</c:if>
				</c:if>
				<c:if test="${isTeacher}">
				<c:if test="${que.finshStatus ==0 }">
				<a href="update/${que.questionUuid }" class="list_op">答复该问题</a>
				</c:if>
				</c:if>
			</td>
		</tr>
	</table>
</div>
</body>
</html>