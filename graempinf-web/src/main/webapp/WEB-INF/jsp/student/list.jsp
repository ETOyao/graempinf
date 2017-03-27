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
function deleteItem() {
		var flag = false;
		var ids ="";
		for (var i = 0;i < document.getElementsByName("selectflag").length; i++) {
			if (document.getElementsByName("selectflag")[i].checked) {
				var id= document.getElementsByName("selectflag")[i].value;
				ids+=id+",";
				flag = true;
			}		
		}
		if (!flag) {
			showInfo("请选择需要删除的信息！");
			return;
		}
		 $.messager.confirm('操作确认', "操作不可逆确认继续吗？", function(r){
				if (r){
					  $.messager.progress({
			  			    title: '提示',
			  			    msg: '请稍后！',
			  			    text: '正在删除......'
			  			});	
					  $.ajax({
						    url: "delete",
						    type: "POST",
						    data: {
						        "ids": ids
						    },
						    traditional: true,//这里设置为true
						    success: function(data) {
						    	//关闭遮罩
			  			  			$.messager.progress('close');
						    	  $.messager.alert("提示","删除成功!","info", function () {
							        window.location.reload() ;});
						    },
						    error:function(){
						    	  //关闭遮罩
			  			  			$.messager.progress('close');
						    	  showInfo("删除失败！");}
						});
				}
		});
	}

	function checkAll() {
		for (var i = 0; i < document.getElementsByName("selectflag").length; i++) {
			document.getElementsByName("selectflag")[i].checked = document.getElementById("allChoose").checked;
		}
	}
	function query(){
	  var formData = $( "#queryFrom" ).serialize();  
	     $.ajax({  
          url: 'students' ,  
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
	 var url = "exportstuinfo";
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
	<thead><tr><td colspan="8">学生信息查询</td></tr></thead>
	<tr>
	<td>姓名：</td>
	<td><input type="text" name="sutName" value="${stu.sutName }"/></td>
	<td>学号：</td>
	<td><input type="text" name="stuNum" value="${stu.stuNum}" /></td>
	<td>身份证号：</td>
	<td><input type="text" name="idCardNum" value="${stu.idCardNum }"/></td>
	</tr>
	<tr>
	<td>学院：</td>
	<td><input type="text" name="collegeName" value="${stu.collegeName }"/></td>
	<td>院系：</td>
	<td ><input type="text" name="deptName" value="${stu.deptName }"/></td>
	<td >班级：</td>
	<td ><input type="text" name="stuTeam" value="${stu.stuTeam }" /></td>
	</tr>
	<tr>
	<td>考号：</td>
	<td><input type="text" name="examineeNum" value="${stu.examineeNum }"/></td>
	<td >学籍地址：</td>
	<td ><input type="text" name="beforerecordaddr" value="${stu.beforerecordaddr }" /></td>
	<td>户籍地址：</td>
	<td><input type="text" name="beforecensusaddr" value="${stu.beforecensusaddr }"/>	</td>
	</tr>
	<tr>
	<td>完成状态：</td>
	<td>
	<select name="finshStatus"  class="_select">
      	<option value=" ">全部</option>
		<option value="0">未完善</option>
		<option value="9">完善</option>
	</select>
	</td>
	<td colspan="4">
	<a href="JavaSript:void(0);" style="margin-left:30%;" onclick="return query(); " class="mybutton query" >查询</a>
	<a href="JavaSript:void(0)" style=" margin-left:10%;" onclick="return exPort(this);" class="mybutton export" >导出</a>
	</tr>
	</table>
	</form>
<form name="contentForm" id="contentForm">
	<table width="970" cellspacing="0" cellPadding="0" id="listTable">
		<thead>
		<tr>
			 <td><input class="allChoose"name="allChoose" id="allChoose" type="checkbox" onClick="checkAll()"></td>
			<td>编号</td>
			<td>准考证号</td>
			<td>学号</td>
			<td>姓名</td>
			<td>身份证号</td>
			<td>学院</td>
			<td>院系</td>
			<td>班级</td>
			<td>性别</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${students.datas}" var="stu">
			<tr>
				<td class="tc"><input name="selectflag" value="${stu.stuUuid}" type="checkbox"></td>
				<td>${students.datas.indexOf(stu)+1}&nbsp;</td>
				<td>${stu.examineeNum }</td>
				<td>${stu.stuNum}<td>
				<a href="${stu.stuUuid}" class="list_link">${stu.sutName}</a>
				<td>${stu.idCardNum }</td>
				<td>${stu.collegeName }</td>
				<td>${stu.deptName}</td>
				<td>${stu.stuTeam}</td>
				<td>
				<c:if test="${stu.gender eq 1}">男</c:if>
				<c:if test="${stu.gender eq 0}">女</c:if>
				</td>
				<td>
				<c:if test="${stu.finshStatus eq 0}">未完善</c:if>
				<c:if test="${stu.finshStatus eq 9}">已完善</c:if>
				</td>
				<td>
					<%-- <a href="*" title="${user.userUuid }" class="list_op ">审核</a> --%>
					<a href="update/${stu.stuUuid }" class="list_op">更新</a>
				&nbsp;
				</td>
			</tr>
		</c:forEach>
		</tbody>
		<tfoot>
		<tr>
			<td colspan="11" style="text-align:right;margin-right:10px;">
			<jsp:include page="/jsp/pager.jsp">
				<jsp:param value="${students.total }" name="totalRecord"/>
				<jsp:param value="students" name="url"/>
				<jsp:param value="${students.size}" name="size"/>
			</jsp:include>
			</td>
			<td><a href="javascript:void(0)" title="" class="list_op "  onclick="return deleteItem()" >删除</a></td>
		</tr>
		</tfoot>
	</table>
	</form>
</div>
</body>
</html>