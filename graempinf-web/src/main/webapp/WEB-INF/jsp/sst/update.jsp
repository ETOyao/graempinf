<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../commonresource.jsp" %>
<script type="text/javascript">
$(function(){
	$("#addForm").graempinfValidate();
	$(function(){
		  var opts = {
			  id:"#coll",
			  chlid:"#dep",
			  chlid2:"#team",
	          type:"1",
	          chltype:"2",
	          chltype2:"3",
	          _url:"<%=request.getContextPath() %>/admin/org/orgs/orgList",
	          _value:"0",
	        _defaultvalue1:'${student.collegeid}',
            _defaultvalue2:'${student.deptid}',
            _defaultvalue3:'${student.stuTeamid}',
            _isUpdate:true
		  };
		 $("#_select").myremoteselect(opts); 
	});

});
</script>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<sf:hidden path="souUuid"/>
	<sf:form method="post" modelAttribute="sst" id="addForm">
	<sf:hidden path="finshStatus"/>
	<sf:hidden path="souStuUUid"/>
	<table  class="addTable" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="7">修改生源地信息</td></tr></thead>
		<tr>
			<td class="rightTd" >考试号</td>
			<td class="leftTd"><sf:input readonly="true" path="souExamNum" /></td>
			<td class="rightTd" >学号:</td>
			<td class="leftTd"><sf:input readonly="true"  path="souStuNum" /></td>
			<td class="rightTd" >身份证号:</td>
			<td class="leftTd"><sf:input readonly="true" path="souIdcardNum" /></td>
		</tr>
		<tr>
			<td class="rightTd" >姓名</td>
			<td class="leftTd"><sf:input readonly="true" path="souName" /></td>
			<td class="rightTd" >生源地:</td>
			<td class="leftTd"><sf:input path="souAddr" /></td>
			<td class="rightTd" >生源地类型:</td>
			<td class="leftTd">
			<sf:select path="souSouceType"  class="_select">
				<sf:options items="${souType}" />
			</sf:select></td>
		</tr>
		<tr>
			<td class="rightTd" >家庭住址</td>
			<td class="leftTd"><sf:input path="souHomeAddr" /></td>
			<td class="rightTd" > 电话:</td>
			<td class="leftTd"><sf:input path="souHomePhoe" /></td>
			<td class="rightTd" >邮编:</td>
			<td class="leftTd"><sf:input path="souHomePostCode" /></td>
		</tr>
		<tr>
			<td class="rightTd" >是否低保</td>
			<td class="leftTd" colspan="5"><sf:select path="souIsLowPro" style="width:15%" class="_select">
				<sf:options items="${isLowpro}" />
			</sf:select></td>
		</tr>
		<tr>
			<td colspan="7" class="centerTd"><input type="submit" value="更  新" />&nbsp;&nbsp;&nbsp;<input type="reset" value="重     置"/></td>
		</tr>
	</table>
	</sf:form>
</div>
</body>
</html>