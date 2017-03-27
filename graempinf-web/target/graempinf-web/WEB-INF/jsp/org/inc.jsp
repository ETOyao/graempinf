<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<span>
当前机构:${parent.name }[${parent.id }]&nbsp;
<a href="<%=request.getContextPath() %>/admin/org/orgs/${id}/add" class="admin_link">添加子机构</a>
<a href="<%=request.getContextPath() %>/admin/org/orgs/${pid} "class="admin_link">机构列表</a>
</span>