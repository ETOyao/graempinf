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
          url: 'cacaps' ,  
          type: 'GET',  
          data: formData,  
          async: false,  
          cache: false,  
          success: function (returndata) {  
        		$("#content").replaceWith(returndata);
          }
	     });   
	}
	$(function(){
		 var opts = {
				 id:"#careerFairType",
				  _url:"<%=request.getContextPath() %>/admin/empinfo/getSelect",
				  _tyep:"1002",
				  _defaultvalue:'${cacap.careerFairType}'
			  };
		 $("#careerFairType").initselect(opts); 
		});
	function exPort(event){
		 var formData = $( "#queryFrom" ).serialize();  
		 var url = "cacapExport";
			url=url+"?"+formData; 
			$(event).attr("href",url);
		}
</script>
<body>
<div id="content">
	<form id="queryFrom">
	<table cellspacing="0" class="querytable"  cellPadding="0" border="0" >
	<thead><tr><td colspan="8">招聘会信息预约查询</td></tr></thead>
	<tr>
	<td>招聘会名称：</td>
	<td><input type="text" name="careerFairName" value="${cacap.careerFairName }"/></td>
	<td >招聘会类型：</td>
	<td><select id ="careerFairType" name="careerFairType" class="_select"></select></td>
	<tr>
	<td colspan="3" ></td>
	<td colspan="6">
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
			<td>未参加人数</td>
			<td>参加人数</td>
			<td>逾期人数</td>
			<td>取消预约人数</td>
			<td>预约总数</td>
		</tr>
		</thead>
		<tbody>
		<c:if test="${cacaps.datas.size()>=1}">
		<c:forEach items="${cacaps.datas}" var="ca">
			<tr>
			<td>${cacaps.datas.indexOf(ca)+1}&nbsp;</td>
				<td>${ca[0]}</td>
				<td>${ca[1]}</td>
				<td>${ca[3] ==null ? '0':ca[3]}</td>
				<td>${ca[4] ==null ? '0':ca[4]}</td>
				<td>${ca[5] ==null ? '0':ca[5]}</td>
				<td>${ca[6] ==null ? '0':ca[6]}</td>
				<td>${ca[7] ==null ? '0':ca[7]}</td>
			</tr>
		</c:forEach>
		</c:if>
		<c:if test="${cacaps.datas.size()<1}">
		<td colspan="11" align="center"><c:out value="暂无预约信息！"></c:out></td>
		</c:if>
		</tbody>
		<tfoot>
		<tr>
			<td colspan="11" style="text-align:right;margin-right:10px;">
			<jsp:include page="/jsp/pager.jsp">
				<jsp:param value="${cacaps.total }" name="totalRecord"/>
				<jsp:param value="cacaps" name="url"/>
				<jsp:param value="${cacaps.size}" name="size"/>
			</jsp:include>
			</td>
		</tr>
		</tfoot>
	</table>
	</form>
</div>
</body>
</html>