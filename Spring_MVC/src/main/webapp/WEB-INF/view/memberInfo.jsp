<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center">
		<caption>고객 정보</caption>
		<tr><td> 이  름  </td><td> ${ member.name } </td></tr>
		<tr><td> 비  번  </td><td> ${ member.pw } </td></tr>
		<tr><td> 아이디  </td><td> ${ member.id } </td></tr>
		<tr><td> 이메일  </td><td> ${ member.email } </td></tr>
		<tr><td> 주  소  </td><td> ${ member.address } </td></tr>
	</table>
</body>
</html>






