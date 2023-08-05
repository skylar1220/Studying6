<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
</head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#find").click(function(event){
			event.preventDefault();  	
			let formData = $('form').serialize(); 
			
			$.ajax({
				url: '/find',
				type:'POST',
				data:formData,
				success:function(response){	
					if(response == 'true'){
					alert("있는메일");
					let contents = '<input type="text" class="form-control" name = "confirm"  placeholder="인증번호를 입력해주세요" >'+
			    	'<button type="submit" class="btn btn-success" style="margin-top: 10px" id="" >확인</button>' ;
			    	$('#confirm').empty().append(contents);
					}else{
						alert("없는메일");
						$('#confirm').empty();
					}
					
				},
				error:function(){
					alert("오류 발생");
				}			
			});			
		});
	});
	
	
</script>
<body>
<div  class="container">
	<form>
	  <div class="mb-3">
	    <label   class="form-label">이메일</label>
	    <input type="email" class="form-control" name = 'email' placeholder="가입시 기입한 이메일을 입력해주세요.">
	    <div id="emailHelp" class="form-text">찾기 버튼을 눌러서 이메일에 전송된 번호를 확인해주세요.</div> 
	  </div>
	  <!-- <div class="mb-3">
	    <label   class="form-label">비밀번호</label>
	    <input type="password" class="form-control" name="user_psw">
	  </div>  --> 
	  <button class="btn btn-primary" id="find">찾기</button>
	</form>
	<div id = "confirm" style="margin-top : 30px">
	</div>
</div>
</body>
</html>