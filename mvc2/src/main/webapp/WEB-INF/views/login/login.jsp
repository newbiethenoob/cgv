<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CGV-로그인</title>
<link href="http://localhost:8899/mvc2/resources/css/cgv.css" rel="stylesheet">
<script src="http://localhost:8899/mvc2/resources/js/cgv.js"></script>
</head>
<script>
//alert('${result}');
	if('${result}' == 'ok'){
		alert("회원가입에 성공하셨습니다.");
	}
	
	if('${result}' == 'fail'){
		alert("아이디 또는 패스워드가 정확하지 않습니다. 다시 로그인 하십시오.")
	}
</script>
<body>
	<!-- header start -->
	<iframe src="http://localhost:8899/mvc2/header"  scrolling="no" frameborder="0" width="100%" height="150px"></iframe>
	
	<div class="content">
		<section class="login">
			<h1>로그인</h1>
			<form name="loginForm" action="login" method="post">
				<ul>
					<li>
						<label>아이디</label>
						<input type="text" name="id" id="id">
					</li>
					<li>
						<label>패스워드</label>
						<input type="password" name="pass" id="pass">
					</li>
					<li>
						<button type="button" class="btn_style" onclick="loginFormCheck()">로그인</button>
						<button type="reset" class="btn_style">다시쓰기</button>
					</li>
				</ul>
			
			</form>
		</section>		
		
	</div>
	
	<!-- footer start -->
	<iframe src="http://localhost:8899/mvc2/footer"  scrolling="no" frameborder="0" width="100%" height="500px"></iframe>
</body>
</html>







