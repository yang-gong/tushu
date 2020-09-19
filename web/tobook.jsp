<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="updataservlet" method="post">
	<input type="hidden" name="id" value="${param.id }">
		图书名称:<input type="text" name="bookName" value="${param.bookName }"><br>
		图书作者:<input type="text" name="auothor" value="${param.auothor }"><br>
		图书价格:<input type="text" name="price" value="${param.price }"><br>
		<input type="submit" value="修改">
	</form>
</body>
</html>