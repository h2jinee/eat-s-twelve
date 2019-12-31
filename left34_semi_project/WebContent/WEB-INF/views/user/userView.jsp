<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<link rel="styleSheet" href="<%=request.getContextPath() %>/css/user.css" />

<div class =userTab>
	<li>
		<a href="<%=request.getContextPath() %>/searchList">검색후 화면</a>	
		<a href="<%=request.getContextPath() %>/restaurants">상세화면</a>	
	</li>
</div>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>