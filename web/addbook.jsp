<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addbookservlet" method="post">
		图书名称:<input type="text" name="bookName"><br>
		图书作者:<input type="text" name="auothor"><br>
		图书价格:<input type="text" name="price"><br>
		<input type="submit" value="增加">
	</form>

</body>
</html>