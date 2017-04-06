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
</head>
<body>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
		<table class="listTable" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="7">学生信息查看：学生id[${student.stuUuid }]</td></tr></thead>
		<tr>
			<td class="rightTd" >学号:</td>
			<td class="leftTd">${student.stuNum }</td>
			<td class="rightTd" >姓名:</td>
			<td class="leftTd">${student.sutName }</td>
			<td  rowspan="7" colspan="2">
		<center><img alt="学生照片" height="160" id="stuImg" width="130" src="<%=request.getContextPath() %>${student.imgurl}" border="1"/></center>		</tr>
		<tr>
			<td class="rightTd" >身份证号:</td>
			<td class="leftTd">
			${student.idCardNum}
			</td>
			<td class="rightTd" >考试号:</td>
			<td class="leftTd">${student.examineeNum }</td>
		</tr>
		<tr>
			<td class="rightTd" >性别:</td>
			<td class="leftTd">${student.gender eq 0 ?'女':'男' }
			<td class="rightTd" >学制:</td>
			<td class="leftTd">${student.eductionalSystme }</td>
		</tr>
		<tr>
			<td class="rightTd" >专业方向:</td>
			<td class="leftTd">${student.majordirection }</td>
			<td class="rightTd" >贫困等级:</td>
			<td class="leftTd">
			<c:if test="${student.povertyLevel eq 1}">一般贫困</c:if>
			<c:if test="${student.povertyLevel eq 2}">特别贫困</c:if>
			<c:if test="${student.povertyLevel eq 3}">无贫困档案</c:if>
			</td>
		</tr>
		<tr>
			<td class="rightTd" >入学期户籍所在地:</td>
			<td class="leftTd">${student.beforecensusaddr }</td>
			<td class="rightTd" >入学期档案所在地:</td>
			<td class="leftTd">${student.beforecensusaddr }</td>
		</tr>
		<tr>
			<td class="rightTd" >政治面貌:</td>
			<td class="leftTd">${student.politicalStatus }</td>
			<td class="rightTd" >民族</td>
			<td class="leftTd">${student.nation }</td>
		</tr>
		<tr>
			<td class="rightTd" >户籍是否转入:</td>
			<td class="leftTd">
			<c:if test="${student.censusIsTranSchool eq 1}">转入</c:if>
			<c:if test="${student.censusIsTranSchool eq 2}">未转入</c:if>
		   </td>
			<td class="rightTd" >档案是否转入:</td>
			<td class="leftTd">
			<c:if test="${student.recordIsTranSchool eq 1}">转入</c:if>
			<c:if test="${student.recordIsTranSchool eq 2}">未转入</c:if>
			</td>
		</tr>
		<tr>
			<td class="rightTd" >学院:</td>
			<td class="leftTd">${student.collegeName }</td>
			<td class="rightTd" >院系:</td>
			<td class="leftTd">${student.deptName }</td>
			<td class="rightTd" >班级:</td>
			<td class="leftTd">${student.stuTeam}&nbsp;&nbsp;&nbsp;</td>
		</tr>
		<tr>
			<td class="rightTd" >出生日期:</td>
			<td class="leftTd"><fmt:formatDate value="${student.birthDate }" pattern="yyyy年MM月dd日"/> </td>
			<td class="rightTd" >入学时间:</td>
			<td class="leftTd"><fmt:formatDate value="${student.enterTime }" pattern="yyyy年MM月dd日"/></td>
			<td class="rightTd" >毕业时间:</td>
			<td class="leftTd"><fmt:formatDate value="${student.graduateTime }" pattern="yyyy年MM月dd日"/></td>
		</tr>
		<tr>
			<td class="rightTd" >学历:</td>
			<td class="leftTd">${student.education }</td>
			<td class="rightTd" >培养方式:</td>
			<td class="leftTd">${student.trainingMethod }</td>
			<td class="rightTd" >专业:</td>
			<td class="leftTd">${student.major }</td> 
		</tr>
		<tr>
			<td class="rightTd" >电话:</td>
			<td class="leftTd">${student.phone }</td>
			<td class="rightTd" >QQ号:</td>
			<td class="leftTd">${student.qqNum }</td>
			<td class="rightTd" >邮箱:</td>
			<td class="leftTd">${student.email }</td>
		</tr>
		<tr>
			<td colspan="7" class="centerTd">
				<c:if test="${isAdmin}">
				<a href="update/${student.stuUuid }" class="list_op">修改学生信息</a>
				</c:if>
			</td>
		</tr>
	</table>
</div>
</body>
</html>