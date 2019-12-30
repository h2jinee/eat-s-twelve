<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/user/login" id="loginFrm" method="post" >
	<input type="text" name="memberId" id="memberId" placeholder="아이디" tabindex="1"/>
	<input type="text" name="password" id="password" placeholder="비밀번호" tabindex="1"/>
	<input type="submit" value="로그인" tabindex="3"/>
	
	</form>
</body>
</html>