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
			$('#empImg').attr("src",reader.result);
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
			          url: '<%=request.getContextPath() %>/admin/empinfo/uploadEmpfile' ,  
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
		<input id="empUuid" type="hidden" name="empUuid" value="${empUuid}"/>	
		<input    id="stuimg" name="empimg" class="easyui-filebox"  data-options="prompt:'选择文件',buttonText:'&nbsp;选&nbsp;择&nbsp;'"  style="width:260px;">
	</form>	
</div>
	<div id="but">
	<a href="javaScript:void(0);" class="easyui-linkbutton" onclick="return isOk($('#upImg'))" >确认</a>
	<a href="javaScript:void(0);" class="easyui-linkbutton" onclick="javaScript:$('#dlg').dialog('close');">取消</a>
   </div>
	<table width="970" class="addTable" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="7">上传就业协议</td></tr></thead>
		<tr>
			<td>
			<a href="javaScript:void(0);" class="list_op" onclick=" return choseFile();" >选择就业协议照片</a> 
			</td>
			<td>
			<a href="javaScript:void(0);" class="list_op" onclick="upImg()" >上传就业协议照片</a>
			</td>
		</tr>
		<tr>
		<td colspan="2">
		<center><img alt="就业协议图片预览"  height="500" src="<%=request.getContextPath() %>${empImgutl}" id="empImg" width="800"></center>
		</td>
		</tr>
	</table>
</div>
</body>
</html>