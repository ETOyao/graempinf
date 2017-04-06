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
            _defaultvalue3:'${student.stuTeamid}'
		  };
		 $("#_select").myremoteselect(opts); 
	});

});
function choseFile(){
	  $('#dlg').dialog('open');
}


//图片选择
function isOk(event){
	  var uploadFile = $('#filebox_file_id_1')[0];
	  var filesrc = uploadFile.value;
	  var extStart=filesrc.lastIndexOf(".");
	  var ext=filesrc.substring(extStart,filesrc.length).toUpperCase();
	  if(filesrc==null ||filesrc==""){
			showInfo("您还未选择照片！请选择!");
	  }if(ext!=".BMP" &&ext!=".PNG" &&ext!=".GIF"&&ext!=".JPG"&&ext!=".JPEG"){
			showInfo("请选择图片进行上传！");
	  }
	  else{
			var fil = uploadFile.files;
			for (var i = 0; i < fil.length; i++) {
				  reads(fil[i]);
			}
			$('#dlg').dialog('close');
	  }
}
//图片预览
function reads(fil){
	  var reader = new FileReader();
	  reader.readAsDataURL(fil);
	  reader.onload = function()
	  {
			$('#stuImg').attr("src",reader.result);
	  };
	}
//图片上传
function upImg(){
	  var uploadFile = $('#filebox_file_id_1')[0];
	  var filesrc = uploadFile.value;
	  if(filesrc=null || filesrc==""){
			showInfo("没有选择照片不能上传，请选择照片！");
			return;
	  }
	  $.messager.confirm('操作确认', "确认上传这张照片吗？", function(r){
			if(r){
				  var formData = new FormData($( "#upForm" )[0]);  
				     $.ajax({  
			          url: '<%=request.getContextPath() %>/admin/student/imgUp' ,  
			          type: 'POST',  
			          data: formData,  
			          async: false,  
			          cache: false,  
			          contentType: false,
			          dataType: "text",
			          processData: false,  
			          success: function (returndata) {  
			        		showInfo(returndata);
			          },  
			          error: function (returndata) {  
			        		showInfo(returndata);
			          }  
				     });    
			}
	  });
}
</script>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<!--选择图片的对话框  -->
	<div id="dlg" class="easyui-dialog" title="照片选择" data-options="iconCls:'icon-save',buttons:'#but'" style="width:400px;height:200px;padding:50px" closed="true">
	<form id="upForm"  enctype="multipart/form-data">
		<input name="stuUuid" type="hidden" value="${student.stuUuid}"/>		
		<input    id="stuimg" name="stuimg" class="easyui-filebox"  data-options="prompt:'选择文件',buttonText:'&nbsp;选&nbsp;择&nbsp;'"  style="width:260px;">
	</form>	
</div>
	<div id="but">
	<a href="javaScript:void(0);" class="easyui-linkbutton" onclick="return isOk($('#upImg'))" >确认</a>
	<a href="javaScript:void(0);" class="easyui-linkbutton" onclick="javaScript:$('#dlg').dialog('close');">取消</a>
   </div>
	<sf:hidden path="stuUuid"/>
	<sf:form method="post" modelAttribute="student" id="addForm">
	<sf:hidden path="finshStatus"/>
	<table width="970" class="addTable" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="7">更新学生信息</td></tr></thead>
		<tr>
			<td class="rightTd" ><font color="red">*</font>学号:</td>
			<td class="leftTd"><sf:input path="stuNum" /><sf:errors cssClass="errorContainer" path="stuNum"/></td>
			<td class="rightTd" ><font color="red">*</font>姓名:</td>
			<td class="leftTd"><sf:input path="sutName" /><sf:errors cssClass="errorContainer" path="sutName"/></td>
			<td  rowspan="7" colspan="2">
			<center><img alt="学生照片" height="160" id="stuImg" width="130" src="<%=request.getContextPath() %>${student.imgurl}" border="1"/></center>
			<br>
			<br>
			&nbsp;&nbsp;&nbsp;&nbsp;<a href="javaScript:void(0);" class="list_op" onclick=" return choseFile();" >选择照片</a> 
			<input   id="uploadImg" name="uploadImg" style="display:none;">
			<a href="javaScript:void(0);" class="list_op" onclick="upImg()" >上传照片</a></td>
		</tr>
		<tr>
			<td class="rightTd" ><font color="red">*</font>身份证号:</td>
			<td class="leftTd"><sf:input path="idCardNum" /><sf:errors cssClass="errorContainer" path="idCardNum"/></td>
			<td class="rightTd" ><font color="red">*</font>考试号:</td>
			<td class="leftTd"><sf:input path="examineeNum" /><sf:errors cssClass="errorContainer" path="examineeNum"/></td>
		</tr>
		<tr>
			<td class="rightTd" >性别:</td>
			<td class="leftTd"><input type="radio"  name="gender" value="1" ${student.gender eq 1 ?'checked' : ''}/>男 &nbsp;<input type="radio" ${student.gender eq 0 ?'checked' : ''} value="0" name="gender" />女
			<td class="rightTd" >学制:</td>
			<td class="leftTd"><sf:input path="eductionalSystme"/></td>
		</tr>
		<tr>
			<td class="rightTd" >专业方向:</td>
			<td class="leftTd"><sf:input path="majordirection" /></td>
			<td class="rightTd" >贫困等级:</td>
			<td><sf:select path="povertyLevel"  class="_select">
				<sf:options items="${types}"/>
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
			<td class="leftTd"><select id="coll" name="colid" class="_select"></td>
			<td class="rightTd" >院系:</td>
			<td class="leftTd"><select id="dep" name="depid" class="_select"></td>
			<td class="rightTd" >班级:</td>
			<td class="leftTd"><select id="team" name="teaid" class="_select"></td>
		</tr>
		<tr>
			<td class="rightTd" >出生日期:</td>
			<td class="leftTd"><input class="easyui-datebox" value ="${student.birthDate}" name="birthDate"></input></td>
			<td class="rightTd" >入学时间:</td>
			<td class="leftTd"><input class="easyui-datebox" value ="${student.enterTime}" name="enterTime"></input></td>
			<td class="rightTd" >毕业时间:</td>
			<td class="leftTd"><input class="easyui-datebox" value ="${student.graduateTime}" name="graduateTime"></input></td>
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
			<td colspan="7" class="centerTd"><input type="submit" value="更新学生信息" />&nbsp;&nbsp;&nbsp;<input type="reset" value="重     置"/></td>
		</tr>
	</table>
	</sf:form>
</div>
</body>
</html>