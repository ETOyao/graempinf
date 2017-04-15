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
		<thead><tr><td colspan="7">招聘会信息查看：招聘会id[${cf.careerFairUuid}]</td></tr></thead>
		<tr>
			<td class="rightTd" >招聘会名称</td>
			<td class="leftTd">${cf.careerFairName} </td>
			<td class="rightTd" >招聘会描述:</td>
			<td class="leftTd">${cf.careerFairDesc}</td>
			<td class="rightTd" >招聘会名称:</td>
			<td class="leftTd">${cf.careerFairTypeName}</td>
		</tr>
		<tr>
			<td class="rightTd" >招聘会地点</td>
			<td class="leftTd">${cf.careerFairAddr}</td>
			<td class="rightTd" >招聘会举行时间:</td>
			<td class="leftTd"><fmt:formatDate value="${cf.careerFairDate}" pattern="yyyy年MM月dd日 "/></td>
			<td class="rightTd" >招聘会信息状态:</td>
			<td>
				<c:if test="${cf.finshStatus eq 0}">已发布</c:if>
				<c:if test="${cf.finshStatus eq 1}">未发布</c:if>
				<c:if test="${cf.finshStatus eq 2}">已举行</c:if>
				</td>
		</tr>
		<tr>
			<td class="rightTd" >招聘会创建时间</td>
			<td class="leftTd"> <fmt:formatDate value="${cf.createCareerFairDate}" pattern="yyyy年MM月dd日  HH时mm分ss秒"/></td>
			<td class="rightTd" > 招聘会发布时间:</td>
			<td class="leftTd"> <fmt:formatDate value="${cf.applayCareerFairDate}" pattern="yyyy年MM月dd日  HH时mm分ss秒"/></td>
			<td class="rightTd" >招聘会创建人:</td>
			<td class="leftTd">${cf.careerPerson}</td>
		</tr>
		<tr>
			<td class="rightTd" >招聘会发布人:</td>
			<td class="leftTd">${cf.applyPerson}</td>
			<td class="rightTd" >招聘会承办单位:</td>
			<td class="leftTd" colspan="3">${cf.careerFairUndertaker}</td>
		</tr>
		<c:if test="${cf.finshStatus eq 0}">
		<tr>
			<td colspan="7" class="centerTd">
				<c:if test="${isAdmin}">
				<c:if test="${cf.finshStatus eq 0}">
				<a href="update/${cf.careerFairUuid }" class="list_op">修改息信</a>
				</c:if>
				</c:if>
				<c:if test="${isTeacher}">
				
				<a href="update/${cf.careerFairUuid }" class="list_op">修改信息</a>
				</c:if>
				<c:if test="${isAdmin}">
				<a href="aduit/${cf.careerFairUuid }/yes" class="list_op">同意发布</a>
				<a href="aduit/${cf.careerFairUuid }/no" class="list_op">不同意发布</a>
				</c:if>
			</td>
		</tr>
		</c:if>
	</table>
</div>
</body>
</html>