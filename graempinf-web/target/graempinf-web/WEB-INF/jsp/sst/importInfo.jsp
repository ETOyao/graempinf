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
<script type="text/javascript">

function importInfo(){
	  var uploadFile = $('#filebox_file_id_1')[0];
	  var filesrc = uploadFile.value;
	  var extStart=filesrc.lastIndexOf(".");
	  var ext=filesrc.substring(extStart,filesrc.length).toUpperCase();
	  if(filesrc=null || filesrc==""){
	  		showInfo("没有选择文件不能导入，请选择文件！");
	  		return false;
	  } if(ext!=".XLS" &&  ext!=".XLSX"){
			showInfo("请选择Excel文件进行上传！");
			return false;
	  }
	  $.messager.confirm('操作确认', "确认导入数据吗？", function(r){
	  		if(r){
	  			$.messager.progress({
	  			    title: '提示',
	  			    msg: '请稍后！',
	  			    text: '正在导入数据......'
	  			});	  			
	  			  var formData = new FormData($( "#importForm" )[0]);  
	  			     $.ajax({  
	  		          url: '<%=request.getContextPath() %>/admin/student/importstus' ,  
	  		          type: 'POST',  
	  		          data: formData,  
	  		          async: true,  
	  		          cache: false,  
	  		          contentType: false,
	  		          dataType: "text",
	  		          processData: false,  
	  		          success: function (returndata) {  
	  		        	//关闭遮罩
	  			  			$.messager.progress('close');
	  		        		showInfo(returndata);
	  		          },  
	  		          error: function (returndata) {  
	  		        	//关闭遮罩
	  			  			$.messager.progress('close');
	  		        		showInfo(returndata);
	  		          }  
	  			     });    
	  		} 
	  });
	//弹出加载层
	  function load() {  
	      $("<div class=\"datagrid-mask\"></div>").css({ display: "block", width: "100%", height: $(window).height() }).appendTo("body");  
	      $("<div class=\"datagrid-mask-msg\"></div>").html("邮件发送中，请稍候。。。").appendTo("body").css({ display: "block", left: ($(document.body).outerWidth(true) - 190) / 2, top: ($(window).height() - 45) / 2 });  
	  }
	  //取消加载层  
	  function disLoad() {  
	      $(".datagrid-mask").remove();  
	      $(".datagrid-mask-msg").remove();  
	  }
}
</script>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<form id="importForm"  enctype="multipart/form-data">
	<table class="addTable" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="2">学生信息导入</td></tr></thead>
		
		<tr>
			<td class="rightTd" width="200px">文件位置:</td>
			<td class="leftTd"><input  class="easyui-filebox" id="fileImport"  data-options="prompt:'选择文件',buttonText:'&nbsp;选&nbsp;择&nbsp;'"  style="width:260px;" name="stuInfos"></td>
		</tr>
		<tr>
			<td class="rightTd" width="200px">导入说明:</td>
			<td class="leftTd" style="color:red;">
			<p>1、本系统提供导入学生信息功能，只提供excel格式的模板进行导入！</p>
			<p>2、导入学生信息时，学号为必填项，如没有学号则不能导入。</p>
			<p>3、本系统提供模板，该模板格式不允许修改。</p>
			</td>
		</tr>
		<tr>
			<td class="rightTd"></td>
			
			<td  class="leftTd">
			<a href="javaScript:void(0);" value="开始导入"  class="mybutton" onclick="return importInfo()">导入学生信息</a>
			<a href="downloadstu_template" class="mybutton" >下载模板</a></p>
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>
