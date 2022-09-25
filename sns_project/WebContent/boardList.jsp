<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.DBUtil, board.*, java.util.ArrayList" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${boardList}" var="board">
		보드아이디 :${board.boardId}
		유저아이디 :${board.userId}<br>
		제목 : ${board.title}<br>
		내용 : ${board.text}
		<form action="delete" method="post">
			<input type="submit" value="삭제">
			<input type="hidden" value="${board.boardId}" name="boardId">   
			<input type="hidden" value="${board.userId}" name="userId">   
		</form>
		
		<form action="update" method="post">
			<input type="submit" value="수정">
			<input type="hidden" value="${board.boardId}" name="boardId">   
			<input type="hidden" value="${board.userId}" name="userId">
			<input type="hidden" value="${board.title}" name="title">
			<input type="hidden" value="${board.text}" name="text">
		</form>
		<form action="like" method="post">
			<input type="submit" value="좋아요">
			<input type="hidden" value="${board.boardId}" name="boardId">
			<input type="hidden" value="${board.userId}" name="userId">
			
		</form>
		<br><br><br>
	</c:forEach>
</body>
</html>