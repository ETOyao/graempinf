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
          url: 'empinfs' ,  
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
	 var url = "exportempinfo";
		url=url+"?"+formData; 
		console.info(url);
		$(event).attr("href",url);
	}
$(function(){
		 var opts = {
				 id:"#empUnitType",
				  _url:"<%=request.getContextPath() %>/admin/empinfo/getSelect",
				  _tyep:"1001",
				  _defaultvalue:'${empinf.empUnitType}'
			  };
		 var opts1 = {
				 id:"#empDirection",
				  _url:"<%=request.getContextPath() %>/admin/empinfo/getSelect",
				  _tyep:"1004",
				  _defaultvalue:'${empinf.empDirection}'
			  };
		
			 $("#empUnitType").initselect(opts); 
			 $("#empDirection").initselect(opts1); 

	});
</script>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<form id="queryFrom">
	<table cellspacing="0" class="querytable"  cellPadding="0" border="0" >
	<thead><tr><td colspan="8">就业信息查询</td></tr></thead>
	<tr>
	<td>姓名：</td>
	<td><input type="text" name="empName" value="${empinf.empName }"/></td>
	<td>学号：</td>
	<td><input type="text" name="empStuNum" value="${empinf.empStuNum}" /></td>
	<td>准考证号：</td>
	<td><input type="text" name="empExaNum" value="${empinf.empExaNum }"/></td>
	</tr>
	<tr>
	<td>就业协议编号：</td>
	<td><input type="text" name="empAgreementNum" value="${empinf.empAgreementNum }"/></td>
	<td>就业单位名称：</td>
	<td ><input type="text" name="empUnitName" value="${empinf.empUnitName }"/></td>
	<td >毕业去向：</td>
	<td ><select name="empDirection" id="empDirection" class="_select">
		</select>
	</tr>
	<tr>
	<td >就业单位性质：</td>
	<td ><select name="empUnitType" id ="empUnitType" class="_select">
		 </select>
	</td>
	<td>完成状态：</td>
	<td>
	<select name="finshStatus"  class="_select">
      	<option value=" ">全部</option>
		<option value="0">未完善</option>
		<option value="9">完善</option>
	</select>
	</td>
	<td colspan="2">
	<a href="JavaSript:void(0); "onclick="return query();" class="mybutton " >查询</a>
	<a href="JavaSript:void(0)"  onclick="return exPort(this);" class="mybutton " >导出</a>
	</td>
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
			<td>就业协议编号</td>
			<td>就业单位名称</td>
			<td>职位类别</td>
			<td>就业单位性质</td>
			<td>毕业去向</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${empinfs.datas}" var="emf">
			<tr>
				<td>${empinfs.datas.indexOf(emf)+1}&nbsp;</td>
				<td>${emf.empExaNum }</td>
				<td>${emf.empStuNum}<td>
				<a href="${emf.empUuid}" class="list_link">${emf.empName}</a>
				<td>${emf.empAgreementNum }</td>
				<td>${emf.empUnitName }</td>
				<td>${emf.empWorkTypeName }</td>
				<td>${emf.empUnitTypeName }</td>
				<td>${emf.empDirectionName }</td>
				<td>
				<c:if test="${emf.finshStatus eq 0}">未完善</c:if>
				<c:if test="${emf.finshStatus eq 9}">已完善</c:if>
				</td>
				<td>
			    <c:if test="${emf.finshStatus eq 9}">
				<a href="toUploadEmpfile/${emf.empUuid}" class="list_op">上传就业协议</a>
				</c:if>
				&nbsp;
				<c:if test="${isAdmin }">
					  <a href="update/${emf.empUuid }" class="list_op">更新</a>
				&nbsp;
				</c:if>
				<c:if test="${not isAdmin }">
				<c:if test="${emf.finshStatus != 9}">
					  <a href="update/${emf.empUuid }" class="list_op">更新</a>
					&nbsp;
				</c:if>
				</c:if>
				</td>
			</tr>
		</c:forEach>
		</tbody>
		<tfoot>
		<tr>
			<td colspan="12" style="text-align:right;margin-right:10px;">
			<jsp:include page="/jsp/pager.jsp">
				<jsp:param value="${empinfs.total }" name="totalRecord"/>
				<jsp:param value="empinfs" name="url"/>
				<jsp:param value="${empinfs.size}" name="size"/>
			</jsp:include>
			</td>
		</tr>
		</tfoot>
	</table>
	</form>
</div>
</body>
</html>