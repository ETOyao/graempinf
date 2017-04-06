<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<input type="hidden" id="contextPath" value="<%=request.getContextPath()%>"/>
<div id="top">
	<div id="topIntro">
		<span id="logo"></span>
		<span id="user_operator">
			 <a href="<%=request.getContextPath()%>/admin/user/showSelf"  target="content">查询个人信息</a>
			| <a href="<%=request.getContextPath()%>/admin/user/updateSelf"  target="content">修改个人信息</a>
			| <a href="<%=request.getContextPath()%>/admin/user/updatePwd"  target="content">修改密码</a>
			| <a href="javascript:exitSystem()">退出系统</a>
		</span>
	</div>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/admin/inc_top.js">
	</script>
	<script type="text/javascript">
	  var user ="${loginUser.userNickName }";
	  var name= "${baseInfo.name }";
	  var userCount ='';
	$(function(){	
		$.ajax({  
	          url: '<%=request.getContextPath()%>/getCount' ,  
	          type: 'GET',   
	          dataType:"json",
	          async: false,  
	          cache: false,  
	          success: function (returndata) {  
	        	  userCount=returndata.count;
	          }
		     });  
	    systemTime();
	});
	</script>
	<div id="remind">
		<span id="showDate">
		</span>
	</div>
</div>
