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
          url: 'caps' ,  
          type: 'GET',  
          data: formData,  
          async: false,  
          cache: false,  
          success: function (returndata) {  
        		$("#content").replaceWith(returndata);
          }
	     });   
	}
	var url ='';
	var oper='';
	var id = '';
	function appointment (_id,_oper){
		$('#dlg').dialog('open');
 	    $('#appointment').css("display","block");
 		$('#but').css("display","block");
 		oper=_oper;
 		id =_id;
	}
	function toOper(){
		var _data = $('#advic').val();
		if(oper=="enter"){
 			url = "updateEnter/"+id+"?advic="+_data;
 			  $.ajax({  
	          url: url,  
	          type: 'GET',  
	          async: false,  
	          success: function (data) {  
	        	if(data.message!=""){
	        		$('#dlg').dialog('close');
	         	    $('#appointment').css("display","none");
	         		$('#but').css("display","none");
	         		$.messager.alert("提示", data.message, "info", function () { window.location.href='caps'; });  
	        	}else{
	        		showInfo("参加失败！");
	        	}
	          }
		     }); 
 		}else {
		 $.messager.confirm('操作确认', "确定取消预约吗？取消后将不能再次预约", function(r){
			 if(r){
				url = "updateCancel/"+id+"?advic="+_data;
			     $.ajax({  
		          url: url,  
		          type: 'GET',  
		          async: false,  
		          success: function (data) {  
		        	if(data.message!=""){
		        		$('#dlg').dialog('close');
			     	    $('#appointment').css("display","none");
			     		$('#but').css("display","none");
			     		$.messager.alert("提示", data.message, "info", function () { window.location.href='caps'; });  
		        	}else{
		        		showInfo("取消失败！");
		        	}
		          }
			     });
			 }
		 });
 		}
	}
</script>
<body>
<div id="content">
	<form id="queryFrom">
	<table cellspacing="0" class="querytable"  cellPadding="0" border="0" >
	<thead><tr><td colspan="8">招聘会信息预约查询</td></tr></thead>
	<tr>
	<td>招聘会名称：</td>
	<td><input type="text" name="careeFairName" value="${cap.careeFairName }"/></td>
	<td>预约编号：</td>
	<td><input type="text" name="capAppCode" value="${cap.capAppCode}" /></td>
	<tr>
	<td >预约状态：</td>
	<td >
	<select name="finshStatus"  class="_select">
				<option value="-1">全部</option>
				<option value="0">已取消</option>
				<option value="1">预约</option>
				<option value="3">逾期</option>
				<option value="2">已参加</option>
			</select>
	</td>
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
			<td>预约编号</td>
			<td>预约人姓名</td>
			<td>预约人学号</td>
			<td>招聘会名称</td>
			<td>就业意愿1</td>
			<td>就业意愿2</td>
			<td>就业意愿3</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
		</thead>
		<tbody>
		<c:if test="${caps.datas.size()>=1}">
		<c:forEach items="${caps.datas}" var="cap">
			<tr>
				<td>${caps.datas.indexOf(cap)+1}&nbsp;</td>
				<td><a href="${cap.capUUid}" class="list_link">${cap.capAppCode}</a></td>
				<td>${cap.capstuName}</td>
				<td>${cap.capstuNum}</td>
				<td>${cap.careeFairName}</td>
				<td>${cap.jobDirecttion1}</td>
				<td>${cap.jobDirecttion2}</td>
				<td>${cap.jobDirecttion3}</td>
				<td>
				<c:if test="${cap.finshStatus eq 0}">取消预约</c:if>
				<c:if test="${cap.finshStatus eq 2}">已参加</c:if>
				<c:if test="${cap.finshStatus eq 1}">已预约</c:if>
				<c:if test="${cap.finshStatus eq 3}">逾期</c:if>
				</td>
				<td>
					<c:if test="${cap.finshStatus eq 1}">
					<a href="javaScript:void(0)" onclick="appointment('${cap.capUUid }','cancel')" class="list_op">取消预约</a>
					<a href="javaScript:void(0)"  onclick="appointment('${cap.capUUid }','enter')" class="list_op">已参加</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		</c:if>
		<c:if test="${caps.datas.size()<1}">
		<td colspan="11" align="center"><c:out value="暂无预约信息！"></c:out></td>
		</c:if>
		</tbody>
		<tfoot>
		<tr>
			<td colspan="11" style="text-align:right;margin-right:10px;">
			<jsp:include page="/jsp/pager.jsp">
				<jsp:param value="${caps.total }" name="totalRecord"/>
				<jsp:param value="ssts" name="url"/>
				<jsp:param value="${caps.size}" name="size"/>
			</jsp:include>
			</td>
		</tr>
		</tfoot>
	</table>
	</form>
</div>
<div id="dlg" class="easyui-dialog" title="预约意见" data-options="iconCls:'icon-edit',buttons:'#but'" style="width:400px;height:300px;padding:50px;" closed="true">
 <center>
  <form action="" id="appointment" style="display: none;" class="dlgform" method="POST">
  <table style="width:100%;cellpadding:0;cellspacing:0;">
  <tr>
   <td>建议或评价</td>
   </tr>
   <tr>
  <td><textarea rows="6" cols="40" name="advic" id="advic"></textarea></td>
  </tr>
  </table>
  </form>
  </center>
</div>
	<div id="but" style="display: none;" >
	<a href="javaScript:void(0);" class="easyui-linkbutton" onclick="toOper()" >确认</a>
	<a href="javaScript:void(0);" class="easyui-linkbutton" onclick="javaScript:$('#dlg').dialog('close');">取消</a>
   </div>
</body>
</html>