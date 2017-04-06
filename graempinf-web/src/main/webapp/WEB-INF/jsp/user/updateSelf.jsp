<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../commonresource.jsp" %>
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
	<sf:form method="post" modelAttribute="userDto" id="addForm">
	<table class="addTable" cellspacing="0" cellPadding="0">
	<sf:hidden path="userUuid"/><sf:hidden path="userName"/>
	<sf:hidden path="userPassWord"/>
		<thead><tr><td colspan="2">修改用户-->${userDto.userName}</td></tr></thead>
		<c:if test="${isStudent}">
		<tr>
			<td class="rightTd">显示名称(可以是中文):</td><td class="leftTd"><sf:input readonly="true" path="userNickName" size="30"/></td>
		</tr>
		</c:if>
		<c:if test="${isTeacher }">
		<tr>
			<td class="rightTd">显示名称(可以是中文):</td><td class="leftTd"><sf:input path="userNickName" size="30"/></td>
		</tr>
		</c:if>
		<c:if test="${isAdmin }">
		<tr>
			<td class="rightTd">显示名称(可以是中文):</td><td class="leftTd"><sf:input path="userNickName" size="30"/></td>
		</tr>
		</c:if>
		<tr>
			<td class="rightTd">联系电话:</td><td><sf:input path="userPhone" size="30"/></td>
		</tr>
		<tr>
			<td class="rightTd">电子邮件:</td><td><sf:input path="userEmail" size="30"/><sf:errors path="userEmail"/></td>
		</tr>
		<tr>
			<td colspan="2" class="centerTd"><input type="submit" value="修改个人信息"/><input type="reset"/></td>
		</tr>
	</table>
	</sf:form>
</div>
</body>
</html>