<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${isAdmin }">
<span>
<a href="<%=request.getContextPath() %>/admin/sst/ssts" class="admin_link">生源地信息列表</a>
</span>
</c:if>
<c:if test="${isTeacher}">
<span>
<a href="<%=request.getContextPath() %>/admin/sst/ssts" class="admin_link">生源地信息列表</a>
</span>
</c:if>
