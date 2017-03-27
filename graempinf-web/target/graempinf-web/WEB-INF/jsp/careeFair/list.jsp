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
	<thead><tr><td colspan="8">招聘会信息查询</td></tr></thead>
	<tr>
	<td>招聘会名称：</td>
	<td><input type="text" name="careerFairName" value="${cf.careerFairName }"/></td>
	<td>招聘会地点：</td>
	<td><input type="text" name="careerFairAddr" value="${cf.careerFairAddr}" /></td>
	<td>招聘会举行时间：</td>
	<td><input type="text" name="careerFairDate" value="${cf.careerFairDate }"/></td>
	</tr>
	<tr>
	<td>招聘会承办单位:</td>
	<td><input type="text" name="careerFairUndertaker" value="${cf.careerFairUndertaker }"/></td>
	<td >添加人：</td>
	<td><input type="text" name="careerPerson" value="${cf.careerPerson }"/></td>
	</tr>
	<tr>
	<td >招聘会状态：</td>
	<td >
	<select name="finshStatus"  class="_select">
				<option value="-1">全部</option>
				<option value="0">未发布</option>
				<option value="1">已发布</option>
				<option value="2">已举行</option>
			</select>
	</td>
	<td colspan="5">
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
			<td>招聘会名称</td>
			<td>招聘会类型</td>
			<td>招聘会地点</td>
			<td>招聘会举行时间</td>
			<td>发布时间</td>
			<td>发布人</td>
			<td>招聘会承办单位</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${cfs.datas}" var="cf">
			<tr>
				<td>${cfs.datas.indexOf(cf)+1}&nbsp;</td>
				<td><a href="${cf.careerFairUuid}" class="list_link">${cf.souName}</a></td>
				<td>${cf.careerFairTypeName}<td>
				<td>${cf.careerFairAddr }</td>
				<td>${cf.careerFairDate }</td>
				<td>${cf.createCareerFairDate}</td>
				<td>${cf.careerPerson}</td>
				<td>${cf.careerFairUndertaker}</td>
				<td>
				<c:if test="${sst.finshStatus eq 0}">未发布</c:if>
				<c:if test="${sst.finshStatus eq 1}">已发布</c:if>
				<c:if test="${sst.finshStatus eq 2}">已举行</c:if>
				</td>
				<td>
					<a href="update/${cf.careerFairUuid }" class="list_op">更新</a>
					<a href="delete/${cf.careerFairUuid }" class="list_op">删除</a>
					<a href="apply/${cf.careerFairUuid }" class="list_op">发布</a>
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