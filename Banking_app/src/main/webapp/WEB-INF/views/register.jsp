<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Welcome</h2>

	<form action="/user/register" method="post" th:object="${user}">
	   <input type="text" th:field="*{email}">
	   <input type="password" th:field="*{password}">
	   <button type="submit">Register</button>
	</form>
	

</body>
</html>