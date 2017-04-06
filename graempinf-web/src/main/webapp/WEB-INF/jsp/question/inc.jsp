<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${isAdmin }">
<span>
<a href="<%=request.getContextPath() %>/admin/question/questions" class="admin_link">问题信息列表</a>
</span>
</c:if>
<c:if test="${isTeacher}">
<span>
<a href="<%=request.getContextPath() %>/admin/question/questions" class="admin_link">问题信息列表</a>
</span>
</c:if>
<c:if test="${isStudent}">
<span>
<a href="<%=request.getContextPath() %>/admin/question/stuquestions" class="admin_link">问题信息列表</a>
</span>
</c:if>
