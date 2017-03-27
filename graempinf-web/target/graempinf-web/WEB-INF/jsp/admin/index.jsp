<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${baseInfo.name}</title>
<style>
.bac{
	background-color: #FFF8F8;
}
</style>
</head>
	<frameset rows="120,*"  frameborder="0" noresize frameSpacing="0">
		<frame name="top" class="bac"  src="<%=request.getContextPath() %>/jsp/admin/top.jsp" frameborder="0" frameSpacing="0"/>
		<frameset cols="180,*" id="content" frameborder="0" frameSpacing="0">
			<frame name="nav"  class="bac" src="<%=request.getContextPath() %>/jsp/admin/nav.jsp" style=""frameborder="0"/>
			<frame name="content" class="bac" id="content" src="<%=request.getContextPath() %>/resources/admin/01.html" frameborder="0"/>
		</frameset>
	</frameset>
</html>