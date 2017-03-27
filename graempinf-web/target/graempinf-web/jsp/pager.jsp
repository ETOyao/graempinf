<%@page import="com.wanglei.basic.hibernate.model.SystemContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
$(document).ready(function() { 
    $("#pageSize").change(function(){
    	  var url = '${pageUrl}';
  		//获取表单值，并以json的数据形式保存到params中   
  		var formData = $( "#queryFrom" ).serialize(); 
  		url=url+"?pageSize="+$(this).val()+"&curPage=0&"+formData; 
  		$.ajax({
  			cache: false,
  			async: false,
  			url : url,
  			type : 'GET',
  			success : function(data) {
  				$("#content").replaceWith(data);
  			},
  			
  		 });
   });
  $('.pager_link').click(function(){
		var formData = $( "#queryFrom" ).serialize(); 
		var url = $(this).attr("href");
		url=url+"&"+formData;
		$.ajax({
	  			cache: false,
	  			async: false,
	  			url : url,
	  			type : 'GET',
	  			success : function(data) {
	  				$("#content").replaceWith(data);
	  			},
	  			
	  		 });
	return false;
  });  
});
</script>
<pg:pager export="curPage=pageNumber" 
	items="${param.totalRecord }" 
	maxPageItems="<%=SystemContext.getPageSize() %>"
	url="${param.url }">
	<span style="float:right;padding:6px;">
	共
	<pg:param  name="size" value="${param.size}"/> 
	<pg:last>
		${pageNumber } 页[${param.totalRecord }条记录],每页显示
		<select id="pageSize">
	             <c:forEach var="s" begin="1" end="${param.totalRecord}">
	             <c:if test="${s%5==0}">
	             <c:if test="${s == param.size}">
	               <option value="${s }" selected="selected" >
	                    ${s }
	                </option>
	             </c:if>
	             <c:if test="${s != param.size}">
	                <option value="${s }" >
	                    ${s}
	                </option>
	              </c:if>
	             </c:if>
	             </c:forEach>
	             <c:if test="${param.totalRecord<5}">
	              <option value="${5}">
	                    5
	                </option>
	             </c:if>
	        </select> 条记录 
	</pg:last>
	<c:forEach items="${param.params }" var="p">
		<pg:param name="${p }"/>
	</c:forEach>
	<pg:first>
		<a href="${pageUrl}"  class="pager_link">首页</a>
	</pg:first>
	<pg:prev>
		<a href="${pageUrl}" class="pager_link">上一页</a>
	</pg:prev>
	<pg:pages>
		<c:if test="${curPage eq pageNumber }">
			[${pageNumber }]
		</c:if>
		<c:if test="${curPage != pageNumber }">
			<a href="${pageUrl}" class="pager_link">${pageNumber }</a>
		</c:if>
	</pg:pages>
	<pg:next>
		<a href="${pageUrl}" class="pager_link">下一页</a>
	</pg:next>
	<pg:last>
		<a href="${pageUrl}" class="pager_link">尾页</a>
	</pg:last>
	</pg:pager>
	</span>