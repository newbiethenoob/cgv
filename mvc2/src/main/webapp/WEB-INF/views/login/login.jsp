<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CGV-�α���</title>
<link href="http://localhost:8899/mvc2/resources/css/cgv.css" rel="stylesheet">
<script src="http://localhost:8899/mvc2/resources/js/cgv.js"></script>
</head>
<script>
//alert('${result}');
	if('${result}' == 'ok'){
		alert("ȸ�����Կ� �����ϼ̽��ϴ�.");
	}
	
	if('${result}' == 'fail'){
		alert("���̵� �Ǵ� �н����尡 ��Ȯ���� �ʽ��ϴ�. �ٽ� �α��� �Ͻʽÿ�.")
	}
</script>
<body>
	<!-- header start -->
	<iframe src="http://localhost:8899/mvc2/header"  scrolling="no" frameborder="0" width="100%" height="150px"></iframe>
	
	<div class="content">
		<section class="login">
			<h1>�α���</h1>
			<form name="loginForm" action="login" method="post">
				<ul>
					<li>
						<label>���̵�</label>
						<input type="text" name="id" id="id">
					</li>
					<li>
						<label>�н�����</label>
						<input type="password" name="pass" id="pass">
					</li>
					<li>
						<button type="button" class="btn_style" onclick="loginFormCheck()">�α���</button>
						<button type="reset" class="btn_style">�ٽþ���</button>
					</li>
				</ul>
			
			</form>
		</section>		
		
	</div>
	
	<!-- footer start -->
	<iframe src="http://localhost:8899/mvc2/footer"  scrolling="no" frameborder="0" width="100%" height="500px"></iframe>
</body>
</html>







