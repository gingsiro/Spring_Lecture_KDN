<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#msg{
	color : red;
	font-size : 20px;
	font-style : bold;
}
</style>
</head>
<body>
	<img src='images/Lighthouse.jpg' width='50'>
	<img src='/javaee/images/Lighthouse.jpg' width='50'>
	<%
		String msg = (String) request.getAttribute("msg");
		if(msg != null){
			%>
			<span id='msg'><%=msg %></span>
			<%
		}
	%>
	
	<form action="login.do" method="get">
		<table align="center">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" id="id" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw" id="pw" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="로그인" /></td>
			</tr>
		</table>
	</form>
</body>
</html>