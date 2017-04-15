<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width,initial-scale=1">
<%@ include file="../commonresource.jsp" %>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<table width="975" cellspacing="0" cellPadding="0" id="listTable">
		<thead>
		<tr>
			<td>用户标识</td>
			<td>用户名称</td>
			<td>用户昵称</td>
			<td>用户状态</td>
			<td>用户邮箱</td>
			<td>用户操作</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${users.datas}" var="user">
			<tr>
				<td>${users.datas.indexOf(user)+1}&nbsp;</td>
				<td><a href="${user.userUuid }" class="list_link">${user.userName }</a></td>
				<td>${user.userNickName }&nbsp;</td>
				<td>
					<c:if test="${user.userStatus eq 0 }">
						<span class="emp">停用</span>
						<a href="updateStatus/${user.userUuid }" class="list_op">启用</a>
					</c:if>
					<c:if test="${user.userStatus eq 1 }">
						<span>启用</span>
						<a href="updateStatus/${user.userUuid }" class="list_op">停用</a>
					</c:if>
					&nbsp;
				</td>
				<td>
					<a href="mailto:${user.userEmail }" class="list_link">${user.userEmail }</a>
					&nbsp;
				</td>
				<td>
					<a href="delete/${user.userUuid }" title="${user.userUuid }" class="list_op delete">删除</a>
					<a href="update/${user.userUuid }" class="list_op">更新</a>
					<a href="resetpasswd/${user.userUuid }" class="list_op delete">重置密码</a>
					<a href="<%=request.getContextPath() %>/admin/user/listChannels/${user.userUuid }" class="list_op">管理模块</a>
				&nbsp;
				</td>
			</tr>
		</c:forEach>
		</tbody>
		<tfoot>
		<tr>
			<td colspan="6" style="text-align:right;margin-right:10px;">
			<jsp:include page="/jsp/pager.jsp">
				<jsp:param value="${users.total }" name="totalRecord"/>
				<jsp:param value="users" name="url"/>
				<jsp:param value="${users.size}" name="size"/>
			</jsp:include>
			</td>
		</tr>
		</tfoot>
	</table>
</div>
</body>
</html>