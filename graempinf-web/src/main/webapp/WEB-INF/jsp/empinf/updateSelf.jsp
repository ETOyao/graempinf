<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../commonresource.jsp" %>
<script type="text/javascript">
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
	 var opts2 = {
			 id:"#empWorkType",
			  _url:"<%=request.getContextPath() %>/admin/empinfo/getSelect",
			  _tyep:"1003",
			  _defaultvalue:'${empinf.empWorkType}'
		  };
	 var opts3 = {
			 id:"#empUnitStyle",
			  _url:"<%=request.getContextPath() %>/admin/empinfo/getSelect",
			  _tyep:"1002",
			  _defaultvalue:'${empinf.empUnitStyle}'
		  };
		 $("#empUnitType").initselect(opts); 
		 $("#empDirection").initselect(opts1); 
		 $("#empWorkType").initselect(opts2); 
		 $("#empUnitStyle").initselect(opts3); 
$("#empDirection").change(function(){
	$("#empDirectionName").val($(this).find("option:selected").text());
});$("#empUnitType").change(function(){
	$("#empUnitTypeName").val($(this).find("option:selected").text());
});
$("#empWorkType").change(function(){
	$("#empWorkTypeName").val($(this).find("option:selected").text());
});
$("#empUnitStyle").change(function(){
	$("#empUnitStyleName").val($(this).find("option:selected").text());
});
$(function (){
	initComplexArea('seachprov', 'seachcity', 'seachdistrict', area_array, sub_array, '44', '0', '0');
});

});
//得到地区码
function getAreaID(){
	var area = 0;          
	if($("#seachdistrict").val() != "0"){
		area = $("#seachdistrict").val();                
	}else if ($("#seachcity").val() != "0"){
		area = $("#seachcity").val();
	}else{
		area = $("#seachprov").val();
	}
	return area;
}

function showAreaID() {
	//地区码
	var areaID = getAreaID();
	//地区名
	var areaName = getAreaNamebyID(areaID) ;
	$("#empUnitAddr").val(areaName);
	$("#empUnitAddrCode").val(areaID);
	$('#dlg').dialog('close');
}
function choseArea(){
	  $('#dlg').dialog('open');
}
//根据地区码查询地区名
function getAreaNamebyID(areaID){
	var areaName = "";
	if(areaID.length == 2){
		areaName = area_array[areaID];
	}else if(areaID.length == 4){
		var index1 = areaID.substring(0, 2);
		areaName = area_array[index1] + " " + sub_array[index1][areaID];
	}else if(areaID.length == 6){
		var index1 = areaID.substring(0, 2);
		var index2 = areaID.substring(0, 4);
		areaName = area_array[index1] + " " + sub_array[index1][index2] + " " + sub_arr[index2][areaID];
	}
	return areaName;
}
</script>
</head>
<body>
<div id="dlg" class="easyui-dialog" title="地址选择" data-options="iconCls:'icon-save',buttons:'#but'" style="width:400px;height:200px;padding:50px" closed="true">
<select id="seachprov"  name="seachprov" onChange="changeComplexProvince(this.value, sub_array, 'seachcity', 'seachdistrict');"></select>&nbsp;&nbsp;
<select id="seachcity"  name="homecity" onChange="changeCity(this.value,'seachdistrict','seachdistrict');"></select>&nbsp;&nbsp;
<span id="seachdistrict_div">
<select id="seachdistrict"  name="seachdistrict"></select></span>
</div>
	<div id="but">
	<a href="javaScript:void(0);" class="easyui-linkbutton" onclick="showAreaID()" >确认</a>
	<a href="javaScript:void(0);" class="easyui-linkbutton" onclick="javaScript:$('#dlg').dialog('close');">取消</a>
   </div>
<div id="content">
	<h3 class="admin_link_bar">
		<jsp:include page="inc.jsp"></jsp:include>
	</h3>
	<sf:form method="post" modelAttribute="empinf" action="/admin/empinfo/updateSelf/${empinf.empUuid}" id="addForm">
	 <input name="finshStatus" type="hidden" id="finshStatus" value="${empinf.finshStatus }">
    <sf:hidden path="empStuUUid"/>
    <sf:hidden path="empUuid"/>
	<table  class="addTable" cellspacing="0" cellPadding="0">
		<thead><tr><td colspan="7">编辑就业信息</td></tr></thead>
		<tr>
			<td class="rightTd" >考试号:</td>
			<td class="leftTd"><sf:input readonly="true" path="empExaNum" /></td>
			<td class="rightTd" >学号:</td>
			<td class="leftTd"><sf:input readonly="true" path="empStuNum" /></td>
			<td class="rightTd" >姓名:</td>
			<td class="leftTd"><sf:input readonly="true" path="empName" /></td>
		</tr>
		<tr>
			<td class="rightTd" >三方协议编号:</td>
			<td class="leftTd"><sf:input path="empAgreementNum" /></td>
			<td class="rightTd" >毕业去向:</td>
			<td class="leftTd">
			<select name="empDirection" id="empDirection" class="_select">
			</select>
			<input type="hidden" id="empDirectionName" name="empDirectionName" value="${empinf.empDirectionName }">
			</td>
			<td class="rightTd" >就业单位名称:</td>
			<td class="leftTd"><sf:input  path="empUnitName" /></td>
		</tr>
		<tr>
			<td class="rightTd" >就业单位编码:</td>
			<td class="leftTd"><sf:input  path="empUnitCode" /></td>
			<td class="rightTd" >就业单位地址:</td>
			<td class="leftTd">
			<input readonly="readonly" id ="empUnitAddr" onclick="choseArea()" name="empUnitAddr" value="${empinf.empUnitAddr }"/>
			<input name="empUnitAddrCode" type="hidden" id="empUnitAddrCode" value="${empinf.empUnitAddrCode }"/>
			</td>
			<td class="rightTd" >就业单位联系人:</td>
			<td class="leftTd"><sf:input  path="empUnitContactPerson" /></td>
		</tr>
		<tr>
			<td class="rightTd" >职位类别:</td>
			<td class="leftTd">
			<select name="empWorkType" id = "empWorkType" class="_select">
			</select>
			<input type="hidden" id="empWorkTypeName" name="empWorkTypeName" value="${empinf.empWorkTypeName}">
			</td>
			<td class="rightTd" >就业单位性质:</td>
			<td class="leftTd">
			<select name="empUnitType" id ="empUnitType" class="_select">
			 </select>
			 	<input type="hidden" id="empUnitTypeName" name="empUnitTypeName" value="${empinf.empUnitTypeName}">
			<td class="rightTd" >就业单位行业类型:</td>
			<td class="leftTd">
			<select name="empUnitStyle" id="empUnitStyle" class="_select">
			</select>
				<input type="hidden" id="empUnitStyleName" name="empUnitStyleName" value="${empinf.empUnitStyleName }">
			</td>
		</tr>
		<tr>
			<td class="rightTd" >联系邮箱:</td>
			<td class="leftTd"><sf:input  path="empUintContactEmail" /></td>
			<td class="rightTd" >传真:</td>
			<td class="leftTd"><sf:input  path="empUintcontactFox" /></td>
			<td class="rightTd" >档案邮寄地址:</td>
			<td class="leftTd"><sf:input  path="empRecordTranAddr" /></td>
		</tr>
		<tr>
			<td class="rightTd" >档案接收单位名称:</td>
			<td class="leftTd"><sf:input  path="empRecordTranUnitName" /></td>
			<td class="rightTd" >档案接收单位邮编:</td>
			<td class="leftTd"><sf:input  path="empRecordTranUintPostCode" /></td>
			<td class="rightTd" >户籍转入地址:</td>
			<td class="leftTd"><sf:input  path="emptyCensusRegisterTranAddr" /></td>
		</tr>	
		<tr>
			<td class="rightTd" >联系电话:</td>
			<td class="leftTd"  colspan="7"><sf:input  path="empUnitContactPhone" /></td>
		</tr>
		<tr>
			<td colspan="7" class="centerTd"><a href="javaScript:void(0);" class=list_op style="padding:0.8%;" onclick="return beforSubmint()">提交就业信息</a><input type="submit" value="保存就业信息" />&nbsp;&nbsp;&nbsp;<input type="reset" value="重     置"/></td>
		</tr>
	</table>
	</sf:form>
</div>
</body>
</html>