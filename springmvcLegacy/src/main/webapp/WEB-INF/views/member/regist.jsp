<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		$('#checkemail').focusout(function(){
			let checkemail = $(this).val();
			$.ajax({
				url: '/checklogin',
				type:'POST',
				data:checkemail,
				success:function(response){
					if(response == 'true'){
						let buttons = '<a href="/login" class="btn btn-primary" style="margin:10px;" id="login">로그인</a>'+
				    	'<a href="#" class="btn btn-success" id="regisst" >비밀번호 찾기</a>'
				    	$('#confirm_email').empty().append(buttons);
					}
					else{
						$('#confirm_email').empty();
					}
					
				},
				error:function(response){
					
				}			
			});	
			
		});
		
	});
	
	
</script>

<body>


<form class="container">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">이메일</label>
    <input type="email" class="form-control" id = 'checkemail' name = 'email'>
    <!-- <div id="emailHelp" class="form-text">이메일 형식으로 입력하세요</div> -->    
    <div class="mb-3" id = 'confirm_email'>    	
    </div>    
  </div>
  <div class="mb-3">
    <label class="form-label">이름</label>
    <input type="email" class="form-control" name = 'name'>
    <!-- <div id="emailHelp" class="form-text">이메일 형식으로 입력하세요</div> -->
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">비밀번호</label>
    <input type="password" class="form-control" name="user_psw">
  </div>  
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">비밀번호 확인</label>
    <input type="password" class="form-control" name="user_psw_confirm">
  </div>
  <button class="btn btn-primary" id="regisst" >회원가입</button>  
</form>

</body>
</html>