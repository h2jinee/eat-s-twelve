<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<h4>header/footer 테스트</h4>

<a href="<%=request.getContextPath() %>/searchList">검색후 화면</a>	
<a href="<%=request.getContextPath() %>/restaurants">상세화면</a>	


<%@ include file="/WEB-INF/views/common/footer.jsp" %>