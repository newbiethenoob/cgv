<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CGV-게시판</title>
<link href="http://localhost:8899/mvc2/resources/css/cgv.css" rel="stylesheet">
</head>
<body>
	<!-- header start -->
	<iframe src="http://localhost:8899/mvc2/header"  scrolling="no" frameborder="0" width="100%" height="150px"></iframe>
	
	
	<div class="content">
		<section class="login">
			<h1>게시판</h1>
			<table class="board_content">
				<tr>					
					<th>제목</th>
					<td>${board.btitle}</td>					
				</tr>
				<tr>					
					<th>내용</th>
					<td>${board.bcontent}<br><br><br></td>					
				</tr>
				<tr>					
					<th>조회수</th>
					<td>${board.bhit}</td>					
				</tr>
				<tr>					
					<th>작성일자</th>
					<td>${board.bdate}</td>					
				</tr>
				<!-- 파일 업로드 -->
				<tr>					
					<th>파일1</th>
					<td>
						<c:if test="${board.bfile != null }">
							${board.bfile }<br><br><br>	
							<img src="http://localhost:8899/mvc2/resources/upload/${board.bsfile }"
							   width="200" height="100">
						  <form action="download" method="get">
							<input type="hidden" name="filename" value="${board.bsfile}">
							<input type="submit" value="다운로드">
						</form>
						</c:if>
						
					</td>					
				</tr>
				<tr>					
					<th>파일2</th>
					<td>
						<c:if test="${board.bfile2 != null }">
							${board.bfile2 }<br><br><br>	
							<img src="http://localhost:8899/mvc2/resources/upload/${board.bsfile2 }"
							   width="200" height="100">
						  <form action="download" method="get">
							<input type="hidden" name="filename" value="${board.bsfile2}">
							<input type="submit" value="다운로드">
						</form>
						</c:if>
						
					</td>					
				</tr>
				<!-- 파일 다운로드 -->
<%-- 				<tr>					
					<th>파일다운로드</th>
					<td>
						<form action="download" method="get">
							<input type="hidden" name="filename" value="${board.bsfile}">
							<input type="submit" value="다운로드">
						</form>
					</td>					
				</tr> --%>
				<tr>					
					<td colspan="2">
						<a href="board_update?bid=${board.bid}">
							<button type="button" class="btn_style3">수정하기</button>
						</a>
						<a href="board_delete?bid=${board.bid}">
							<button type="button" class="btn_style3">삭제하기</button>
						</a>
						<a href="board_list">
							<button type="button" class="btn_style3">리스트</button>
						</a>
						<a href="http://localhost:8899/mvc2/main">
							<button type="button" class="btn_style3">홈으로</button>
						</a>
					</td>		
				</tr>
				
			</table>
		</section>		
		
	</div>
	
	<!-- footer start -->
	<iframe src="http://localhost:8899/mvc2/footer"  scrolling="no" frameborder="0" width="100%" height="500px"></iframe>
	
	
</body>
</html>







