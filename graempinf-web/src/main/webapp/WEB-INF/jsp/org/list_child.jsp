<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../commonresource.jsp" %>


<script type="text/javascript">
$(function(){
	if($("#refresh").val()=="1") {
		parent.refreshTree();
	}
});
</script>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<input type="hidden" id="refresh" value="${refresh}"/>
	<table id="listTable" cellspacing="0" cellPadding="0" class="listTable">
		<thead>
		<tr>
			<td>组织机构名称</td>
			<td>组织机构排序</td>
			<td>组织机构代码</td>
			<td>组织机构电话</td>
			<td>组织机构描述</td>
			<Td>操作</Td>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${childs.datas}" var="c">
			<tr id="id_${c.id }">
				<td><a href="<%=request.getContextPath() %>/admin/org/${pid}/show/${c.id }" class="list_link">${c.name}</a>&nbsp;</td>
				<td>
				${c.orderNum }&nbsp;
				</td>
				<td>
				${c.orgCode}&nbsp;
				</td>
				<td>
				${c.phone }&nbsp;
				</td>
				<td>
				${c.att1 }&nbsp;
				</td>
				<td class="centerTd">
					<a href="<%=request.getContextPath() %>/admin/org/orgs/${pid}/update/${c.id}" class="list_op">
					更新</a>
					<a href="<%=request.getContextPath() %>/admin/org/orgs/${pid}/delete/${c.id}"  class="list_op delete">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
		<tfoot>
		<tr>
			<td colspan="6" style="text-align:right;margin-right:10px;">
			<jsp:include page="/jsp/pager.jsp">
				<jsp:param value="${childs.total }" name="totalRecord"/>
				<jsp:param value="" name="url"/>
				<jsp:param value="${childs.size}" name="size"/>
			</jsp:include>
			</td>
		</tr>
		</tfoot>
	</table>
</div>
</body>
</html>