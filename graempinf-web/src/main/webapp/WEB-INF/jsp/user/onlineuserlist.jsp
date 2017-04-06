<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<td>编号</td>
			<td>用户名</td>
			<td>IP</td>
			<td>创建时间</td>
			<td>最近访问时间</td>
		</tr>
		</thead>
		<tbody>
		<c:if test="${onlineUsers!=null}">
		<c:forEach items="${onlineUsers}" var="ou">
			<tr>
				<td>${onlineUsers.indexOf(ou)+1}&nbsp;</td>
				<td>${ou.user.userNickName }</td>
				<td>${ou.ip }</td>
				<td><fmt:formatDate value="${ou.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
				<td><fmt:formatDate value="${ou.lastAccessedTime }" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
			</tr>
		</c:forEach>
		</c:if>
		<c:if test="${onlineUsers==null}">
		<td colspan="6" align="center"><c:out value="暂无用户登录！"></c:out></td>
		</c:if>
		</tbody>
		<tfoot>
		</tfoot>
	</table>
</div>
</body>
</html>