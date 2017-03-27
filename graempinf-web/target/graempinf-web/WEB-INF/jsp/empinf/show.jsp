<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../commonresource.jsp" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/admin/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/validate/main.css"/>
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
		<table id="listTable" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="7">就业信息查看：就业信息id[${empinf.empUuid }]</td></tr></thead>
		<tr>
			<td class="rightTd" >考试号</td>
			<td class="leftTd">${empinf.empExaNum} </td>
			<td class="rightTd" >学号:</td>
			<td class="leftTd">${empinf.empStuNum}</td>
			<td class="rightTd" >姓名:</td>
			<td class="leftTd">${empinf.empName}</td>
		</tr>
		<tr>
			<td class="rightTd" >三方协议编号:</td>
			<td class="leftTd">${empinf.empAgreementNum} </td>
			<td class="rightTd" >就业方向:</td>
			<td class="leftTd">${empinf.empDirectionName}</td>
			<td class="rightTd" >就业单位名称:</td>
			<td class="leftTd">${empinf.empUnitName}</td>
		</tr>
		<tr>
			<td class="rightTd" >就业单位编码</td>
			<td class="leftTd">${empinf.empUnitCode} </td>
			<td class="rightTd" >就业单位地址:</td>
			<td class="leftTd">${empinf.empUnitAddr}</td>
			<td class="rightTd" >就业单位联系人:</td>
			<td class="leftTd">${empinf.empUnitContactPerson}</td>
		</tr>
		<tr>
			<td class="rightTd" >职位类别</td>
			<td class="leftTd">${empinf.empWorkTypeName} </td>
			<td class="rightTd" >就业单位性质:</td>
			<td class="leftTd">${empinf.empUnitTypeName}</td>
			<td class="rightTd" >就业单位行业类型:</td>
			<td class="leftTd">${empinf.empUnitStyleName}</td>
		</tr>
		<tr>
			<td class="rightTd" >联系邮箱</td>
			<td class="leftTd">${empinf.empUintContactEmail} </td>
			<td class="rightTd" >传真:</td>
			<td class="leftTd">${empinf.empUintcontactFox}</td>
			<td class="rightTd" >档案邮寄地址:</td>
			<td class="leftTd">${empinf.empRecordTranAddr}</td>
		</tr>
		<tr>
			<td class="rightTd" >档案接收单位名称</td>
			<td class="leftTd">${empinf.empRecordTranUnitName} </td>
			<td class="rightTd" >档案接收单位邮编:</td>
			<td class="leftTd">${empinf.empRecordTranUintPostCode}</td>
			<td class="rightTd" >户籍转入地址:</td>
			<td class="leftTd">${empinf.emptyCensusRegisterTranAddr}</td>
		</tr><tr>
			<td class="rightTd" >联系电话：</td>
			<td class="leftTd" colspan="7">${empinf.empUnitContactPhone} </td>
		</tr>
		<tr>
			<td colspan="7" class="centerTd">
				<c:if test="${isAdmin}">
				<a href="update/${empinf.empUuid }" class="list_op">修改就业信息</a>
				</c:if>
			</td>
		</tr>
	</table>
</div>
</body>
</html>