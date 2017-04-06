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
	<table class="addTable" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="2">组织机构详细信息：组织id[${org.id }]</td></tr></thead>
		<tr>
			<td class="rightTd" width="200px">机构名称:</td><td class="leftTd">${org.name }&nbsp;</td>
		</tr>
		<tr>
			<td class="rightTd">机构描述:</td><td class="leftTd">${org.att1 }&nbsp;</td>
		</tr>
		<tr>
			<td class="rightTd">机构地址:</td><td class="leftTd">${org.address }&nbsp;</td>
		</tr>
		<tr>
			<td class="rightTd">机构排序:</td><td class="leftTd">${org.orderNum }&nbsp;</td>
		</tr>
		<tr>
			<td class="rightTd">机构代码:</td><td class="leftTd">${org.orgCode }&nbsp;</td>
		</tr>
		<tr>
			<td class="rightTd">机构电话:</td><td class="leftTd">${org.phone }&nbsp;</td>
		</tr>
		<tr>
			<td class="rightTd">机构类型:</td><td class="leftTd">
			<c:if test="${org.typeId eq 0 }">
			学校
			</c:if>
			<c:if test="${org.typeId ==1 }">
			学院
			</c:if>
			<c:if test="${org.typeId ==2}">
			院系
			</c:if>
			<c:if test="${org.typeId ==3 }">
			班级
			</c:if>
			&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2" class="centerTd"><a href="<%=request.getContextPath() %>/admin/org/orgs/${parent.id }/update/${org.id}" class="list_op">更新机构</td>
		</tr>
	</table>
</div>
</body>
</html>