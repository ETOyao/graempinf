<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
          url: 'ssts' ,  
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
	 var url = "exportsst";
		url=url+"?"+formData; 
		console.info(url);
		$(event).attr("href",url);
	}
	
</script>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<form id="queryFrom">
	<table cellspacing="0" class="querytable"  cellPadding="0" border="0" >
	<thead><tr><td colspan="8">生源地信息查询</td></tr></thead>
	<tr>
	<td>姓名：</td>
	<td><input type="text" name="souName" value="${sst.souName }"/></td>
	<td>学号：</td>
	<td><input type="text" name="souStuNum" value="${sst.souStuNum}" /></td>
	<td>身份证号：</td>
	<td><input type="text" name="souIdcardNum" value="${sst.souIdcardNum }"/></td>
	</tr>
	<tr>
	<td>生源地地址:</td>
	<td><input type="text" name="souAddr" value="${sst.souAddr }"/></td>
	<td>家庭住址：</td>
	<td ><input type="text" name="souHomeAddr" value="${sst.souHomeAddr }"/></td>
	<td >生源地类型：</td>
	<td >
	<select name="souSouceType"  class="_select">
				<option value="0">全部</option>
				<option value="1">城市</option>
				<option value="2">农村</option>
			</select>
	</td>
	</tr>
	<tr>
	<td >准考证号：</td>
	<td ><input type="text" name=souExamNum value="${sst.souExamNum }" /></td>
	<td>完成状态：</td>
	<td>
	<select name="finshStatus"  class="_select">
      	<option value=" ">全部</option>
		<option value="0">未完善</option>
		<option value="9">完善</option>
	</select>
	</td>
	<td colspan="3">
	<a href="JavaSript:void(0);"  onclick="return query();" class="mybutton">查询</a>
	<a href="JavaSript:void(0)"  onclick="return exPort(this);" class="mybutton" >导出</a>
	</tr>
	</table>
	</form>
<form name="contentForm" id="contentForm">
	<table width="970" cellspacing="0" cellPadding="0" id="listTable">
		<thead>
		<tr>
			<td>编号</td>
			<td>准考证号</td>
			<td>学号</td>
			<td>姓名</td>
			<td>身份证号</td>
			<td>生源地地址</td>
			<td>家庭住址</td>
			<td>生源地类型</td>
			<td>是否低保</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${ssts.datas}" var="sst">
			<tr>
				<td>${ssts.datas.indexOf(sst)+1}&nbsp;</td>
				<td>${sst.souExamNum}</td>
				<td>${sst.souStuNum}<td>
				<a href="${sst.souUuid}" class="list_link">${sst.souName}</a>
				<td>${sst.souIdcardNum }</td>
				<td>${sst.souAddr }</td>
				<td>${sst.souHomeAddr}</td>
				<td>
				<c:if test="${sst.souSouceType eq 1}">城市</c:if>
				<c:if test="${sst.souSouceType eq 2}">农村</c:if>
				</td>
				<td>
				<c:if test="${sst.souIsLowPro eq 1}">是</c:if>
				<c:if test="${sst.souIsLowPro eq 2}">否</c:if>
				<td>
				<c:if test="${sst.finshStatus eq 0}">未完善</c:if>
				<c:if test="${sst.finshStatus eq 9}">已完善</c:if>
				</td>
				<td>
					<a href="update/${sst.souUuid }" class="list_op">更新</a>
				&nbsp;
				</td>
			</tr>
		</c:forEach>
		</tbody>
		<tfoot>
		<tr>
			<td colspan="11" style="text-align:right;margin-right:10px;">
			<jsp:include page="/jsp/pager.jsp">
				<jsp:param value="${ssts.total }" name="totalRecord"/>
				<jsp:param value="ssts" name="url"/>
				<jsp:param value="${ssts.size}" name="size"/>
			</jsp:include>
			</td>
		</tr>
		</tfoot>
	</table>
	</form>
</div>
</body>
</html>