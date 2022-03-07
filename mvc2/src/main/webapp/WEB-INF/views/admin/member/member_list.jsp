<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<tr>
					<td>1</td>
					<td><a href="#">test</a></td>
					<td>홍길동</td>
					<td>test@naver.com</td>
					<td>010-1111-1234</td>
					<td>영화감상</td>
				</tr>
				
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







