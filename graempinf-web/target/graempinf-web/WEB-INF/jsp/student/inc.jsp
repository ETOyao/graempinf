<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${isAdmin }">
<span>
<a href="<%=request.getContextPath() %>/admin/student/add" class="admin_link">添加学生信息</a>
<a href="<%=request.getContextPath() %>/admin/student/import" class="admin_link">导入学生信息</a>
<a href="<%=request.getContextPath() %>/admin/student/students" class="admin_link">学生信息列表</a>
</span>
</c:if>
<c:if test="${isTeacher }">
<span>
<a href="<%=request.getContextPath() %>/admin/student/add" class="admin_link">添加学生信息</a>
<a href="<%=request.getContextPath() %>/admin/student/import" class="admin_link">导入学生信息</a>
<a href="<%=request.getContextPath() %>/admin/student/students" class="admin_link">学生信息列表</a>
</span>
</c:if>

