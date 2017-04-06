<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../commonresource.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/engine.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/interface/dwrService.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/setChannel.js"></script>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<div>
		<c:forEach items="${cids }" var="cid">
			<input type="hidden" name="cids" value="${cid }">
		</c:forEach>
		<input type="hidden" id="gid" value="${group.gruopUuid }"/>
		<input type="hidden" id="treePath" value="<%=request.getContextPath()%>/admin/channel/treeAll"/>
		<div style="padding-left:10px;font-size:12px;">当前组名称:${group.groupName }</div>
		<div id="tree" class="ztree"></div>
	</div>
</div>
</body>
</html>