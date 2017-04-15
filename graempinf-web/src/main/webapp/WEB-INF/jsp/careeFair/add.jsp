<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../commonresource.jsp" %>
<script type="text/javascript">
$(function(){
	$("#addForm").graempinfValidate();
	 var opts = {
			 id:"#careerFairType",
			  _url:"<%=request.getContextPath() %>/admin/empinfo/getSelect",
			  _tyep:"1002",
			  _defaultvalue:'${cf.careerFairType}'
		  };
	 $("#careerFairType").initselect(opts); 
	 $("#careerFairType").change(function(){
			$("#careerFairTypeName").val($(this).find("option:selected").text());
		});
});
</script>
<style type="text/css">
  
</style>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
   
	<sf:form method="post" modelAttribute="cf" id="addForm">
	<table class="addTable" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="7">添加招聘会信息</td></tr></thead>
		<tr>
			<td class="rightTd" ><font color="red">*</font>招聘会名称:</td>
			<td class="leftTd"><sf:input path="careerFairName" /><sf:errors cssClass="errorContainer" path="careerFairName"/></td>
			<td class="rightTd" >招聘会描述:</td>
			<td class="leftTd"><sf:textarea path="careerFairDesc" /></td>
			
		</tr>
		<tr>
		<td class="rightTd" >招聘会类型:</td>
			<td class="leftTd">
			<select id="careerFairType" class="_select" name="careerFairType"></select>
			<input name="careerFairTypeName" id="careerFairTypeName" type="hidden" value="${cf.careerFairTypeName }">
			</td>
			<td class="rightTd" >招聘会地址:</td>
			<td class="leftTd"><sf:input path="careerFairAddr" /></td>
		</tr>
		<tr>
			<td class="rightTd" >招聘会举行时间:</td>
			<td class="leftTd">
			<input class="easyui-datebox" name="careerFairDate"></input>
			<td class="rightTd" >招聘会承办单位:</td>
			<td class="leftTd"><sf:input path="careerFairUndertaker" /></td>
		</tr>
		<tr>
			<td colspan="7" class="centerTd"><input type="submit" value="添加招聘会信息" class="btn"/>&nbsp;&nbsp;&nbsp;<input type="reset" value="重     置"/></td>
		</tr>
	</table>
	</sf:form>
</div>
</body>
</html>