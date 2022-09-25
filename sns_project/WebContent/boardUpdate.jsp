<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 수정 페이지</h2>
	<form action="update" method="post">
		<!-- 업데이트 된 값과 아닌 값 넘기기 -->
		<input type="text" name="updateTitle" placeholder="제목을 입력하세요." value="${title}"> <br>
		<input type="text" name="updateText" placeholder="내용을 입력하세요." value="${text}"> <br>
		<input type="hidden" name="boardId" value="${boardId}">   
		<input type="hidden" name="userId" value="${userId}">
		<input type="hidden" name="title" value="${title}">
		<input type="hidden" name="text" value="${text}">
		<input type="submit" value="작성">
	</form>
</body>
</html>