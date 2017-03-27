<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${isAdmin }">
<span>
<a href="<%=request.getContextPath() %>/admin/careeFair/careeFairs" class="admin_link">招聘会信息列表</a>
<a href="<%=request.getContextPath() %>/admin/careeFair/add" class="admin_link">添加招聘会信息</a>
</span>
</c:if>
<c:if test="${isTeacher}">
<span>
<a href="<%=request.getContextPath() %>/admin/careeFair/careeFairs" class="admin_link">招聘会信息列表</a>
<a href="<%=request.getContextPath() %>/admin/careeFair/add" class="admin_link">添加招聘会信息</a>
</span>
</c:if>
