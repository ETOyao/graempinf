<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<input type="hidden" id="contextPath" value="<%=request.getContextPath()%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/validate/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/login.css"/>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/core/jquery.graempinf.validate.js"></script>
<script type="text/javascript">
$(function(){
	$("#myForm").graempinfValidate();
	var logginTimeOut ="${logginTimeOut}";
	if(logginTimeOut){
		  window.parent.location.href = $("#contextPath").val()+"/login";
		  logginTimeOut=false;
	}
	$("#loginForm").submit(function() {
	  if (($("#validateCode").val() == null || $("#validateCode").val() == "")) {
			$("#validateCode").focus();
			$("#tip").addClass("errorContainer");
			$("#tip").text("请输入验证码");
			$("#tip").css("display", "inline");
			return false;
		} else if (($("#validateCode").val().length != 4)) {
			  $("#tip").addClass("errorContainer");
			$("#validateCode").focus();
			$("#tip").text("验证码错误");
			$("#tip").css("display", "inline");
			return false;
		} else if(ischeckode()){
			 $("#tip").addClass("errorContainer");
			$("#tip").text("验证码错误");
			$("#tip").css("display", "inline");
			return false;
		}	 
});
	if('${error}'!=""){
		  $('#error').addClass("errorContainer");
		 $('#error').text('${error}'); 
	}
});
/*动态验证验证码是否正确*/
function ischeckode(){
     var url = 'validateCheckcode';
     var flag = true;
			//获取表单值，并以json的数据形式保存到params中   
			var params = {
				dataType : "JSON",
				checkcode : $("#validateCode").val()
			};
			$.ajax({
				cache: false,
 			async: false,
				url : url,
				type : 'POST',
				data : params,
				dataType : "JSON",
				success : function(data) {
				 if(data==true) {	
					 flag = false;
				  }
				}
			 });
	  return flag;
	}
</script>
<title>后台管理登录</title>
<script type="text/javascript">
function reCheckcode(img) {
	img.src="drawCheckCode?"+Math.random();
}

</script>
<style>
	.loginInpu{
	height:28px;
	width:200px;
	}
</style>
</head>
<body>
	<div id="container">
		<div id="top">
		
		</div>
		<div id="loginBar">
		<marquee  direction="left"><span id="showDate">欢迎你使用${baseInfo.name }，请登录!</span></marquee>
			
		</div>
		<div id="content">
			<div id="loginForm">
					<form method="post" id="myForm" action="">
					<table cellpadding="0" cellspacing="0" id="loginTable">
					<tr>
					<td align="right"></td>
					<td align="left"><span id = "error"></span>
					</td>
					</tr>
						<tr>
							<td align="right">登录用户:</td>
							<td align="left"><input type="text" class="loginInpu" name="userName"/> </td>
						</tr>
						<tr>
							<td align="right">登录密码:</td>
							<td align="left"><input type="password" class="loginInpu" name="userPassWord" /></td>
						</tr>
						<tr>
							<td align="right">验证码    :    </td>
							<td align="left">
							<input type="text" name="checkcode"  class="loginInpu" id="validateCode"/>
							<span id="tip" ></span>
							</td>
						</tr>
						<tr>
					     	<td></td>
							<td align="left">
							<span style="cursor:pointer">
							<img src="drawCheckCode" onclick="reCheckcode(this)"/></span>
							</td>
						</tr>
						<tr>
						<td></td>
							<td align="left">
								<input type="submit" value="登录">&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"/>
							</td>
						</tr>
					</table>
					</form>
			</div>
		</div>
	</div>	
</body>
</html>