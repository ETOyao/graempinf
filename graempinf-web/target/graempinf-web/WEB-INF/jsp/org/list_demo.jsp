<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../commonresource.jsp" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/zTree/zTreeStyle.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/tree/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.graempinf.core.js"></script>
<script type="text/javascript">
$(function(){
	  var opts = {
		  id:"#_select",
		  chlid:"#_select1",
		  chlid2:"#_select2",
          type:"1",
          chltype:"2",
          chltype2:"3",
          _url:"<%=request.getContextPath() %>/admin/org/orgs/orgList",
          _value:"0"
	  };
	 $("#_select").myremoteselect(opts); 
});
	
</script>
</head>
<body>
<br>
<div id="content">
<center>
<span class="label">学院：</span>
<select id="_select" class="_select">
</select>
<span class="label">院系：</span>
<select id="_select1" class="_select">
</select>
<span class="label">班级：</span>
<select id="_select2" class="_select">
</select>
</center>

</div>
</body>
</html>