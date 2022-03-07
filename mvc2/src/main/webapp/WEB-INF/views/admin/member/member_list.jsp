<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CGV-회원 리스트</title>
<link href="http://localhost:8899/mvc2/resources/css/cgv.css" rel="stylesheet">
</head>
<body>
	<!-- header start -->
	<iframe src="http://localhost:8899/mvc2/header"  scrolling="no" frameborder="0" width="100%" height="150px"></iframe>
	
	
	<div class="content">
		<section class="login">
			<h1>회원리스트</h1>
			<table class="notice_list" >
				<tr>
					<th>번호</th>
					<th>회원ID</th>
					<th>성명</th>
					<th>이메일</th>
					<th>폰번호</th>
					<th>취미</th>
				</tr>
				<c:forEach var="member" items="${list}"> <!-- AdminController의 회원 리스트 페이지에서 보내는 객체 -->
					<tr>
						<td>${member.rno}</td>
						<td><a href="#">${member.id }</a></td>
						<td>${member.name }</td>
						<td>${member.email }</td>
						<td>${member.hp_num }</td>
						<td>${member.hobby }</td>
					</tr>
				</c:forEach>
				
				<tr>
					<td colspan="6"><< 1  2  3  4  5  >></td>					
				</tr>
			</table>
		</section>		
		
	</div>
	
	<!-- footer start -->
	<iframe src="http://localhost:8899/mvc2/footer"  scrolling="no" frameborder="0" width="100%" height="500px"></iframe>
	
</body>
</html>







