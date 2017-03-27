<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/validate/main.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.graempinf.core.js"></script>
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
	          _value:"0"
		  };
		 $("#_select").myremoteselect(opts); 
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
   
	<sf:form method="post" modelAttribute="student" id="addForm">
	<table class="addTable" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="7">添加学生信息</td></tr></thead>
		<tr>
			<td class="rightTd" ><font color="red">*</font>学号:</td>
			<td class="leftTd"><sf:input path="stuNum" /><sf:errors cssClass="errorContainer" path="stuNum"/></td>
			<td class="rightTd" ><font color="red">*</font>姓名:</td>
			<td class="leftTd"><sf:input path="sutName" /><sf:errors cssClass="errorContainer" path="sutName"/></td>
			<td  rowspan="7" colspan="2">
			<center><img alt="学生照片" height="160" width="130" border="1"/></center>
		</tr>
		<tr>
			<td class="rightTd" ><font color="red">*</font>身份证号:</td>
			<td class="leftTd"><sf:input path="idCardNum" /><sf:errors cssClass="errorContainer" path="idCardNum"/></td>
			<td class="rightTd" ><font color="red">*</font>考试号:</td>
			<td class="leftTd"><sf:input path="examineeNum" /><sf:errors cssClass="errorContainer" path="examineeNum"/></td>
		</tr>
		<tr>
			<td class="rightTd" >性别:</td>
			<td class="leftTd"><input type="radio"  name="gender" value="1" checked="checked"/>男 &nbsp;<input type="radio" value="0" name="gender" />女
			<td class="rightTd" >学制:</td>
			<td class="leftTd"><sf:input path="eductionalSystme"/></td>
		</tr>
		<tr>
			<td class="rightTd" >专业方向:</td>
			<td class="leftTd"><sf:input path="majordirection" /></td>
			<td class="rightTd" >贫困等级:</td>
			<td><sf:select path="povertyLevel"  class="_select">
				<sf:options items="${types}" />
			</sf:select></td>
		</tr>
		<tr>
			<td class="rightTd" >入学期户籍所在地:</td>
			<td class="leftTd"><sf:input path="beforecensusaddr" /></td>
			<td class="rightTd" >入学期档案所在地:</td>
			<td class="leftTd"><sf:input path="beforerecordaddr" /></td>
		</tr>
		<tr>
			<td class="rightTd" >政治面貌:</td>
			<td class="leftTd"><sf:input path="politicalStatus" /></td>
			<td class="rightTd" >民族</td>
			<td class="leftTd"><sf:input path="nation" /></td>
		</tr>
		<tr>
			<td class="rightTd" >户籍是否转入:</td>
			<td><sf:select path="censusIsTranSchool"  class="_select" >
				<sf:options items="${isTran}"/>
			</sf:select></td>
			<td class="rightTd" >档案是否转入:</td>
			<td><sf:select path="recordIsTranSchool" class="_select">
				<sf:options items="${isTran}"/>
			</sf:select></td>
		</tr>
		<tr>
			<td class="rightTd" >学院:</td>
			<td class="leftTd"><select id="coll" name="colid" class="_select" ></select></td>
			<td class="rightTd" >院系:</td>
			<td class="leftTd"><select id="dep" name="depid" class="_select"></select></td>
			<td class="rightTd" >班级:</td>
			<td class="leftTd"><select id="team" name="teaid" class="_select"></select></td>
		</tr>
		<tr>
			<td class="rightTd" >出生日期:</td>
			<td class="leftTd"><input class="easyui-datebox" name="birthDate"></input></td>
			<td class="rightTd" >入学时间:</td>
			<td class="leftTd"><input class="easyui-datebox" name="enterTime"></input></td>
			<td class="rightTd" >毕业时间:</td>
			<td class="leftTd"><input class="easyui-datebox" name="graduateTime"></input></td>
		</tr>
		<tr>
			<td class="rightTd" >学历:</td>
			<td class="leftTd"><sf:input path="education" /></td>
			<td class="rightTd" >培养方式:</td>
			<td class="leftTd"><sf:input path="trainingMethod" /></td>
			<td class="rightTd" >专业:</td>
			<td class="leftTd"><sf:input path="major" /></td>
		</tr>
		<tr>
			<td class="rightTd" >电话:</td>
			<td class="leftTd"><sf:input path="phone" /></td>
			<td class="rightTd" >QQ号:</td>
			<td class="leftTd"><sf:input path="qqNum" /></td>
			<td class="rightTd" >邮箱:</td>
			<td class="leftTd"><sf:input path="email" /></td>
		</tr>
		<tr>
			<td colspan="7" class="centerTd"><input type="submit" value="添加学生信息" class="btn"/>&nbsp;&nbsp;&nbsp;<input type="reset" value="重     置"/></td>
		</tr>
	</table>
	</sf:form>
</div>
</body>
</html>