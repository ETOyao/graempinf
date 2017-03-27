<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${isAdmin }">
<span>
<a href="<%=request.getContextPath() %>/admin/user/add" class="admin_link">添加用户</a>
<a href="<%=request.getContextPath() %>/admin/user/users" class="admin_link">用户列表</a>
</span>
</c:if>
