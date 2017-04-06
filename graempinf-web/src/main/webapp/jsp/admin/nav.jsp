<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--easyui样式引入  -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<!--easyui 脚本引入  -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/easyui/easyui-lang-zh_CN.js"></script>
<title>${baseInfo.name}</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.graempinf.core.js"></script>
<script type="text/javascript">
$(function(){
	$("#left").myaccordion();
});
</script>
</head>
<body>
<div id="left">
<c:if test="${isAdmin }">
<ul class="navMenu">
	<h3 class="navTitle">
		<span class="navTilteTxt">系统配置</span>
	</h3>
	<li class="navChild">
		<a href="<%=request.getContextPath() %>/admin/user/users" target="content">用户信息管理</a>
	</li>
	<li class="navChild">
		<a href="<%=request.getContextPath() %>/admin/group/groups" target="content">用户组管理</a>
	</li>
	<li class="navChild">
		<a href="<%=request.getContextPath() %>/admin/role/roles" target="content">用户角色管理</a>
	</li>
	<li class="navChild">
		<a href="<%=request.getContextPath() %>/admin/org/orgs" target="content">组织机构管理</a>
	</li>
	<li class="navChild">
		<a href="<%=request.getContextPath() %>/admin/user/onlineUsers" target="content">在线用户查看</a>
	</li>
</ul>
</c:if>
<c:if test="${isAdmin }">
<ul class="navMenu">
	<h3 class="navTitle">
		<span class="navTilteTxt">菜单栏目管理</span>
	</h3>
	<li class="navChild">
		<a href="<%=request.getContextPath() %>/admin/channel/channels" target="content">菜单栏目管理</a>
	</li>
</ul>
</c:if>
<c:forEach items="${channels}" var="channel1">
<ul class="navMenu">
	<c:if test="${channel1.pid eq 0}">
		<h3 class="navTitle"><span class="navTilteTxt">${channel1.name}</span></h3>
		<c:forEach items="${channels }" var="channel2">
	 <c:if test="${channel2.pid == channel1.id}">
	   <li class="navChild">
		<a href="<%=request.getContextPath() %>/${channel2.url}" target="content">${channel2.name}</a>
	  </li>
	</c:if>
	</c:forEach>
  </c:if>
</ul>
</c:forEach>
</div>
</body>
</html>