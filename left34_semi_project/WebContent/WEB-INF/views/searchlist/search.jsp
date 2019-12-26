<%@page import="Photo.model.vo.Photo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/search.css" />
<!DOCTYPE html>

<%@ include file="/WEB-INF/views/common/header.jsp" %>
<% 
	List<Photo> list = (List)request.getAttribute("list");
	String pageBar = (String)request.getAttribute("pageBar");
%>
<div id="search-header">
</div>
<div id="search-container">
	<aside>
		<div id="search-side-nav">
			<div class="sort" style="margin-top:30px;margin-bottom:30px;">
				<label for="grade">&nbsp;&nbsp;평점순&nbsp;&nbsp;</label> &nbsp; &nbsp;
				<label for="like">&nbsp;&nbsp;인기순&nbsp;&nbsp;</label>
			</div>
			<hr style="border: 3px solid #2ecc71;border-radius: 5px;" />
	
		</div>
	</aside>
	<div id="photo-container1">
		<table class="photo-tbl">
		<%
		if(list!=null) {
			for(int i=0;i<list.size();i++) {
				Photo p = list.get(i);
				if(i%2==0) {
		%>
			<tr>
				<td><img src="<%=request.getContextPath()%>/images/<%=p.getImgName() %>" alt="" /></td>		
		<% }else{%>
		
				<td><img src="<%=request.getContextPath()%>/images/<%=p.getImgName() %>" alt="" /></td>
			</tr>			
		<%}
			}
		} else { 
		%>
		<tr><td colspan="2">조회된 결과가 없습니다.</td></tr>
		<%} %>
		</table>
		<div id='pageBar'><%=pageBar %></div>
	</div>
	<aside>
		<div id="search-side-map">


		</div>
	</aside>
</div>

<style>
.sort label{
	background-color: #2ecc71;
	border-radius:25%;
}
.photo-tbl tr td {
	width: 400px;
	height:400px;
	border: 1px solid black;
	
}
.photo-tbl{
	margin:0 auto;
	border-spacing: 20px;
}
</style>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>