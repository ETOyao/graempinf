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
	</h3>
   
	<sf:form method="post" modelAttribute="que" id="addForm">
	<table class="addTable" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="7">问题反馈答复页面</td></tr></thead>
		<tr>
			<td class="rightTd" >学号:</td>
			<td class="leftTd"><input name="stunum"  readonly="readonly" id ="stunum" value="${que.stunum }"/>
			<input type="hidden" name="stuuuid" value="${que.stuuuid }"/>
			<input type="hidden" name="questionUuid" value="${que.questionUuid }"/>
			<input type="hidden" name="createTime" value="${que.createTime }"/>
			</td>
			<td class="rightTd" >姓名:</td>
			<td class="leftTd"><input name="stuName"  readonly="readonly" id ="stuName" value="${que.stuName }"/></td>
		</tr>
		<tr>
			<td class="rightTd" ><font color="red">*</font>反馈问题:</td>
			<td class="leftTd" colspan="4"><sf:textarea  readonly="true" rows="10" cols="100"  path="questionContent" /><sf:errors cssClass="errorContainer" path="questionContent"/></td>
		</tr>
		<tr>
			<td class="rightTd" ><font color="red">*</font>答复内容:</td>
			<td class="leftTd" colspan="4"><sf:textarea  rows="10" cols="100"  path="questionAnswer" /><sf:errors cssClass="errorContainer" path="questionAnswer"/></td>
		</tr>
		<tr>
			<td colspan="7" class="centerTd"><input type="submit" value="答复" class="btn"/>&nbsp;&nbsp;&nbsp;<input type="reset" value="重     置"/></td>
		</tr>
	</table>
	</sf:form>
</div>
</body>
</html>