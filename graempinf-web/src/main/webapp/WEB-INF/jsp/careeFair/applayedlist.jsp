<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../commonresource.jsp" %>
</head>
<script type="text/javascript">
	function query(){
	  var formData = $( "#queryFrom" ).serialize();  
	     $.ajax({  
          url: 'appcareeFairs' ,  
          type: 'GET',  
          data: formData,  
          async: false,  
          cache: false,  
          success: function (returndata) {  
        		$("#content").replaceWith(returndata);
          }
	     });   
	}
	function exPort(event){
	 var formData = $( "#queryFrom" ).serialize();  
	 var url = "exportcfinfo";
		url=url+"?"+formData; 
		console.info(url);
		$(event).attr("href",url);
	}
	$(function(){
	$("#addForm").graempinfValidate();
	 var opts = {
			 id:"#careerFairType",
			  _url:"<%=request.getContextPath() %>/admin/empinfo/getSelect",
			  _tyep:"1002",
			  _defaultvalue:'${cf.careerFairType}'
		  };
	 $("#careerFairType").initselect(opts); 
	});
	function appointment (id){
		 $.ajax({  
	          url: 'initCap' ,  
	          type: 'GET',  
	          data: {'uuid':id},  
	          async: false,  
	          cache: false,  
	          success: function (data) {  
	        	if(data.message!=""){
	        		showInfo(data.message);
	        	}else{
	        		$('#careerFairName1').val(data.cf.careerFairName);
		        	$('#capAppCode').val(data.capCode);
		        	$('#capstuName').val(data.stuName);
		        	$('#capstuNum').val(data.stuNum);
		        	$('#capstuUuid').val(data.capstuUuid);
		        	$('#careeFairUuid').val(data.cf.careerFairUuid);
		        	$('#attr1').val(data.attr1);
		        	$('#attr2').val(data.attr2);
		        	$('#dlg').dialog('open');
		     	    $('#appointment').css("display","block");
		     		$('#but').css("display","block");
	        	}
	          }
		     });   
		
	}
	
	function  makeAppointment(){
		 $.messager.confirm('操作确认', "确定预约吗？", function(r){
			 if(r){
				 var formData = $( "#appointment" ).serialize();  
			     $.ajax({  
		          url: '<%=request.getContextPath() %>/admin/cap/addCap' ,  
		          type: 'POST',  
		          data: formData,  
		          async: false,  
		          cache: false,  
		          success: function (returndata) {  
		        	  if(returndata.res=="success"){
		        		  showInfo("恭喜你！预约成功！");
		        		  window.location.href='appcareeFairs';
		        		  $('#dlg').dialog('close');
			     	      $('#appointment').css("display","none");
			     		  $('#but').css("display","none"); 
		        	  }else if(returndata.res=="error"){
		        		  showInfo("很遗憾！预约失败！");
		        	  }else{
		        		  showInfo("系统错误！");
		        	  }
		          }
			     });   
				    
			 }
		 });
	}
</script>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<form id="queryFrom">
	<table cellspacing="0" class="querytable"  cellPadding="0" border="0" >
	<thead><tr><td colspan="8">可预约招聘会信息查看</td></tr></thead>
	<tr>
	<td>招聘会名称：</td>
	<td><input type="text" name="careerFairName" value="${cf.careerFairName }"/></td>
	<td>招聘会地点：</td>
	<td><input type="text" name="careerFairAddr" value="${cf.careerFairAddr}" /></td>
	</tr>
	<tr>
	<td>招聘会承办单位:</td>
	<td><input type="text" name="careerFairUndertaker" value="${cf.careerFairUndertaker }"/></td>
	<td >招聘会时间：</td>
	<td><input class="easyui-datebox" style="width:50%;" name="careerFairDate" ></input></td>
	
	</tr>
	<tr>
	<td >招聘会类型：</td>
	<td><select id ="careerFairType" name="careerFairType" class="_select"></select></td>
	<td colspan="7">
	<a href="JavaSript:void(0);"  onclick="return query();" class="mybutton">查询</a>
	</tr>
	</table>
	</form>
<form name="contentForm" id="contentForm">
	<table width="970" cellspacing="0" cellPadding="0" id="listTable">
		<thead>
		<tr>
			<td>编号</td>
			<td>招聘会名称</td>
			<td>招聘会类型</td>
			<td>招聘会地点</td>
			<td>招聘会举行时间</td>
			<td>发布时间</td>
			<td>招聘会承办单位</td>
			<c:if test="${isStudent }">
			<td>操作</td>
			</c:if>
		</tr>
		</thead>
		<tbody>
		<c:if test="${cfs.datas.size()>=1 }">
		<c:forEach items="${cfs.datas}" var="cf">
			<tr>
				<td>${cfs.datas.indexOf(cf)+1}&nbsp;</td>
				<td><a href="${cf.careerFairUuid}" class="list_link">${cf.careerFairName}</a></td>
				<td>${cf.careerFairTypeName}</td>
				<td>${cf.careerFairAddr}</td>
				<td><fmt:formatDate value="${cf.careerFairDate}" pattern="yyyy年MM月dd日  "/></td>
				<td><fmt:formatDate value="${cf.applayCareerFairDate}" pattern="yyyy年MM月dd日  HH时mm分ss秒"/></td>
				<td>${cf.careerFairUndertaker}</td>
				<c:if test="${isStudent }">
				<td>
					<a href="javaScript:void(0);" class="list_op"  onclick="appointment('${cf.careerFairUuid}')">预约</a>			
				</td>
				</c:if>
			</tr>
		</c:forEach>
		</c:if>
		<c:if test="${cfs.datas.size()<1}">
		<td colspan="8" align="center"><c:out value="暂无可预约招聘会信息！"></c:out></td>
		</c:if>
		</tbody>
		<tfoot>
		<tr>
			<td colspan="11" style="text-align:right;margin-right:10px;">
			<jsp:include page="/jsp/pager.jsp">
				<jsp:param value="${cfs.total }" name="totalRecord"/>
				<jsp:param value="appcareeFairs" name="url"/>
				<jsp:param value="${cfs.size}" name="size"/>
			</jsp:include>
			</td>
		</tr>
		</tfoot>
	</table>
	</form>
</div>
<div id="dlg" class="easyui-dialog" title="预约信息录入" data-options="iconCls:'icon-save',buttons:'#but'" style="width:600px;height:300px;padding:50px;" closed="true">
 <center>
  <form action="" id="appointment" style="display: none;" class="dlgform" method="POST">
  <table style="width:100%;cellpadding:0;cellspacing:0;">
  <tr>
   <td>预约编号：</td>
  <td><input id="capAppCode" type="text" readonly="readonly" name="capAppCode" /></td>
   <td>招聘会名：</td>
  <td><input id="careerFairName1" type="text" readonly="readonly" name="careeFairName"/></td>
  </tr>
  <tr>
   <td>姓名：</td>
  <td><input id="capstuName" type="text" readonly="readonly"  name="capstuName"/></td>
  <td>学号：</td>
  <td><input id="capstuNum" readonly="readonly" type="text" name="capstuNum" />
  <input id="capstuUuid" type="hidden" name="capstuUuid" />
  </td>
  <tr>
 	<td>电话：</td>
  <td><input id="attr1" type="text" name="attr1"/></td>
  <td>邮箱：</td>
  <td><input id="attr2" type="text" name="attr2"/></td>
  </tr>
  <tr>
 	<td>专业：</td>
  <td><input id="capObject" type="text" name="capObject"/></td>
   <td>就业意愿1：</td>
  <td><input id="jobDirecttion1" type="text" name="jobDirecttion1" /></td>
  </tr>
   <tr>
  <td>就业意愿2：</td>
  <td><input id="jobDirecttion2" type="text" name="jobDirecttion2" /></td>
  <td>就业意愿3：</td>
  <td><input id="jobDirecttion3" type="text" name="jobDirecttion3"/>
  <input id="careeFairUuid" type="hidden" name="careeFairUuid"/>
  </td>
  </table>
  </form>
  </center>
</div>
	<div id="but" style="display: none;" >
	<a href="javaScript:void(0);" class="easyui-linkbutton" onclick="makeAppointment()" >确认</a>
	<a href="javaScript:void(0);" class="easyui-linkbutton" onclick="javaScript:$('#dlg').dialog('close');">取消</a>
   </div>
</body>
</html>