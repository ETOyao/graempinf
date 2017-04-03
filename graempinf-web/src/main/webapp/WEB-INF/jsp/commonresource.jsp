<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--easyui样式引入  -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<!--easyui 脚本引入  -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/easyui/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/easyui/easyui-lang-zh_CN.js"></script>
<!--项目核心脚本引入  -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.graempinf.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.graempinf.core.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/main.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.form.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/AreaData_min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/Area.js"></script>
<script>
function showInfo(mesg){
	  $.messager.alert('提示！',mesg,'info');

}
function showError(mesg){
	  $.messager.alert('错误！',mesg,'error');
  
}
function showWarn(mesg){
	  $.messager.alert('警告',mesg,'warning');
  
}
function showQuestion(mesg){
	  $.messager.alert('问题',mesg,'question');
  
}

$(function(){
	  var is_msg = '${oper_success}';
	  if(null!=is_msg && is_msg!=""){
			showInfo('${oper_success}');
	  }
});
function beforSubmint(){
	 $.messager.confirm('操作确认', "确认提交吗?提交之后信息不能修改", function(r){
		 if(r){
			 $('#finshStatus').val(9);
			 $("#addForm").submit();
		 }
	});
}
 </script>