<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../commonresource.jsp" %>
</head>
<script type="text/javascript">
$(function(){
	$("#addForm").graempinfValidate();
});
</script>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<sf:form method="post" modelAttribute="group" id="addForm">
	<table class="addTable"  cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="2">添加用户组功能</td></tr></thead>
		<tr>
			<td class="rightTd" width="200px"><span><font color="red">*</font>组名称:</td>
			<td class="leftTd"></span><sf:input path="groupName" size="30"/><sf:errors cssClass="errorContainer" path="groupName"/></td>
		</tr>
		<tr>
			<td class="rightTd">组描述:</td>
			<td class="leftTd"><sf:textarea path="groupDesc" cols="60" rows="4"/></td>
		</tr>
		<tr>
			<td colspan="2" class="centerTd"><input type="submit" value="添加用户组"/><input type="reset"/></td>
		</tr>
	</table>
	</sf:form>
</div>
</body>
</html>