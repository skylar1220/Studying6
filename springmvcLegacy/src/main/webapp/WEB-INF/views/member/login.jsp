<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#login").click(function(event){
			event.preventDefault();  	
			let formData = $('form').serialize(); 
			
			$.ajax({
				url: '/login',
				type:'POST',
				data:formData,
				success:function(response){					
					window.location.href = 'http://localhost:8080/select';
				},
				error:function(){
					alert("로그인 실패. \n\n아이디와 패스워드를 확인해 주세요");
				}			
			});			
		});
	});
</script>

<body>

<form class="container">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">이메일</label>
    <input type="email" class="form-control" name = 'email'>
    <!-- <div id="emailHelp" class="form-text">이메일 형식으로 입력하세요</div> -->
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">비밀번호</label>
    <input type="password" class="form-control" name="user_psw">
  </div>  
  <button class="btn btn-primary" id="login">로그인</button>
  <a href="http://localhost:8080/regist" class="btn btn-success" >회원가입</a>
</form>

</body>
</html>