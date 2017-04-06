<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
          url: 'questions' ,  
          type: 'GET',  
          data: formData,  
          async: false,  
          cache: false,  
          success: function (returndata) {  
        		$("#content").replaceWith(returndata);
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
	<thead><tr><td colspan="8">反馈问题查看</td></tr></thead>
	<tr>
	<td>问题内容：</td>
	<td><input type="text" name="questionContent" value="${que.questionContent }"/></td>
	<td>答复人：</td>
	<td><input type="text" name="answerPerson" value="${que.answerPerson }"/></td>
	</tr>
	<tr>
	<td>反馈人：</td>
	<td><input type="text" name="stuName" value="${que.stuName }"/></td>
	<td>反馈人学号：</td>
	<td><input type="text" name="stunum" value="${que.stunum }"/></td>
	</tr>
	<tr>
	<td >反馈状态：</td>
	<td><select id ="finshStatus" name="finshStatus" class="_select">
	<option value="-1">全部</option>
	<option value="1">答复</option>
	<option value="0">未答复</option>
	</select></td>
	<td colspan="2">
	<a href="JavaSript:void(0);"  onclick="return query();" class="mybutton">查询</a>
	</tr>
	</table>
	</form>
<form name="contentForm" id="contentForm">
	<table width="970" cellspacing="0" cellPadding="0" id="listTable">
		<thead>
		<tr>
			<td>编号</td>
			<td>反馈问题内容</td>
			<td>反馈人</td>
			<td>反馈人学号</td>
			<td>反馈时间</td>
			<td>答复时间</td>
			<td>答复人</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
		</thead>
		<tbody>
		<c:if test="${ques.datas.size()>=1 }">
		<c:forEach items="${ques.datas}" var="que">
			<tr>
				<td>${ques.datas.indexOf(que)+1}&nbsp;</td>
				<td><a href="${que.questionUuid}" class="list_link">${fn:substring(que.questionContent, 0, 6)}...</a></td>
				<td>${que.stuName }</td>
				<td>${que.stunum }</td>
				<td><fmt:formatDate value="${que.createTime}" pattern="yyyy年MM月dd日  HH时mm分ss秒"/></td>
				<td>  <fmt:formatDate value="${que.answertime}" pattern="yyyy年MM月dd日  HH时mm分ss秒"/></td>
				<td>${que.answerPerson}</td>
				<c:if test="${que.finshStatus ==0 }">
				<td>未答复</td>
				</c:if>
				<c:if test="${que.finshStatus ==1 }">
				<td>已答复</td>
				</c:if>
				<td>
				<c:if test="${que.finshStatus ==0}">
					<a href="update/${que.questionUuid}" class="list_op" >答复</a>			
				</c:if>
			    </td>
			</tr>
		</c:forEach>
		</c:if>
		<c:if test="${cfs.datas.size()<1}">
		<td colspan="8" align="center"><c:out value="暂无反馈问题！"></c:out></td>
		</c:if>
		</tbody>
		<tfoot>
		<tr>
			<td colspan="11" style="text-align:right;margin-right:10px;">
			<jsp:include page="/jsp/pager.jsp">
				<jsp:param value="${ques.total }" name="totalRecord"/>
				<jsp:param value="stuquestions" name="url"/>
				<jsp:param value="${ques.size}" name="size"/>
			</jsp:include>
			</td>
		</tr>
		</tfoot>
	</table>
	</form>
</div>
</body>
</html>