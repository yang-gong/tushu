<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<a href="addbook.jsp">新增图书</a>
	<form action="queryservlet" method="post">
		图书书名:<input type="text" name="bookName">
		 <input	type="submit" value="查询">
	</form>
	<table>
		<tr>
			<td>编号</td>
			<td>书名</td>
			<td>作者</td>
			<td>价格</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.bookList }" var="book">

			<tr>
				<td>${book.id }</td>
				<td>${book.bookName}</td>
				<td>${book.auothor }</td>
				<td>${book.price }</td>
				<td><a href="delbooservlet?id=${book.id }">删除</a>
				<a href="tobook.jsp?id=${book.id }&bookName=${book.bookName }&auothor=${book.auothor }&price=${book.price }">修改</a></td>
			</tr>
		</c:forEach>

	</table>
	<br/>
	当前第${page.currPageNo}页,共${page.totalPageCount}页,共${page.totalCount}条记录
	<a href="bookServlet?pageNo=1">首页</a>
	<a href="bookServlet?pageNo=${page.currPageNo-1}">上一页</a>
	<a href="bookServlet?pageNo=${page.currPageNo+1}">下一页</a>
	<a href="bookServlet?pageNo=${page.totalPageCount}">末页</a></body>
</html>