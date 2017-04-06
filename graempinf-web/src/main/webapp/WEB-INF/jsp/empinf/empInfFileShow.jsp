<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../commonresource.jsp" %>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<table width="970" class="addTable" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="7">就业协议材料查看</td></tr></thead>
		<tr>
		<c:if test="${empImgutl == null}">
		<td align="center"><span style="color:red;">改用户暂时没有上传就业材料！ </span></td>
		</c:if>
		<c:if test="${empImgutl != null}">
		<td colspan="2">
		<center><img alt="就业协议图片预览"  height="500" src="<%=request.getContextPath() %>${empImgutl}" id="empImg" width="800"></center>
		</td>
		</c:if>
		
		</tr>
	</table>
</div>
</body>
</html>