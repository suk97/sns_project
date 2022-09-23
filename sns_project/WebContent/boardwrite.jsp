<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.*, user.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<h2>게시글 작성</h2>
	<form action="board" method="post">
		<input type="text" name="title" placeholder="제목을 입력하세요."> <br>
		<input type="text" name="text" placeholder="내용을 입력하세요."> <br>
		<input type="submit" value="작성">
	</form>
</body>
</html>