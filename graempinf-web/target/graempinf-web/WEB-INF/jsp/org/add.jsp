<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../commonresource.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/validate/main.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.graempinf.validate.js"></script>
<script type="text/javascript">
$(function(){
	$("#addForm").graempinfValidate();
});
</script>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<sf:form method="post" modelAttribute="org" id="addForm">
	<table class="addTable" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="2">添加[${parent.name}]下级组织机构功能</td></tr></thead>
		<tr>
			<td class="rightTd" width="96px">机构名称:</td><td class="leftTd"><sf:input path="name" size="30"/><sf:errors cssClass="errorContainer" path="name"/></td>
		</tr>
		<tr>
			<td class="rightTd">地址:</td>
			<td><sf:input path="address" size="50"/></td>
		</tr>
		<tr>
			<td class="rightTd">机构描述:</td>
			<td class="leftTd"><sf:textarea path="att1" cols="60" rows="4"/></td>
		</tr>
		<tr>
			<td class="rightTd">机构类型:</td>
			<td><sf:select path="typeId">
				<sf:options items="${types}"/>
			</sf:select></td>
		</tr>
		<tr>
			<td class="rightTd">机构排序:</td>
			<td><sf:input path="orderNum" size="50" value="${parent.orderNum }"/></td>
		</tr>
		<tr>
			<td class="rightTd">机构代码:</td>
			<td><sf:input path="orgCode" size="50" value="${parent.orgCode }"/></td>
		</tr>
		<tr>
			<td class="rightTd">机构电话:</td>
			<td><sf:input path="phone" size="50"/></td>
		</tr>
		<tr>
			<td colspan="2" class="centerTd"><input type="submit" value="添加机构"/><input type="reset"/></td>
		</tr>
	</table>
	</sf:form>
</div>
</body>
</html>