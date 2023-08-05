<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" ></script>
<script type="text/javascript">
	function check() {
		let checknum = $("#checknum").val();
		$.ajax({
			url: '/checknum',
			type:'POST',
			data:checknum,
			success:function(response){		
				if(response == "success"){
					alert("인증번호 인증 성공");
					$("#resetpsw").css('display', 'block');
				}
				/* let contents = '<input type="text" id="checknum">'+
				'<button class="btn btn-primary" style="margin: 10px;"  onclick="check()">확인</button>';					
				$('#confirm').empty().append(contents); */
			},
			error:function(){
				alert("인증실패");
			}			
		});
			
	}
	
	$(document).ready(function(){
		$("#find").click(function(event){
			event.preventDefault(); // 기본 폼 제출 동작 중지			
			let formData = $('form').serialize(); // 폼 데이터를 직렬화
			
			$.ajax({
				url: '/find',
				type:'POST',
				data:formData,
				success:function(response){		
					if(response == "success"){ // @?
						let contents = '<input type="text" class="form-control"  id="checknum" placeholder="인증번호 입력하세요">'+
						'<button class="btn btn-primary" style="margin-top: 10px;"  onclick="check()">확인</button>';					
						$('#confirm').empty().append(contents);
					}
					else{
						$('#confirm').empty().append("<h2>전송에 실패했습니다.</h2> <p2>"+response+"</p2>");  // @?
					}
				},
				error:function(){
					alert("찾기실패");
				}			
			});			
		});
	});
</script>


</head>
<body>
<div class="container">
	<form >
	  <div class="mb-3">
	    <label class="form-label">이메일</label>
	    <input type="email" class="form-control" name = 'email' placeholder="가입시 기록한 이메일을 적어주세요">
	    <div id="emailHelp" class="form-text">찾기버튼을 눌러서 이메일에 전송된 번호를 확인해 주세요</div>
	  </div>
	  <button class="btn btn-primary" id="find">찾기</button>
	</form>
	<div id = 'confirm' style="margin-top: 50px; margin-bottom : 50px;"></div>
	
	<div id="resetpsw"  class="container" style="display: none;">
		<form  class="container" action="/resetpassword"> <!-- 양이 많아서 ajax에서 안하고 hidden으로 함 -->
		  <div class="mb-3">
		    <label class="form-label">비밀번호</label>
		    <input type="password" class="form-control" name="user_psw">
		  </div>  
		  <div class="mb-3">
		    <label class="form-label">비밀번호 확인</label>
		    <input type="password" class="form-control" name="user_psw_confirm">
		  </div>
		  <input type="submit" class="btn btn-primary" value="수정하기" >
		</form>
	</div>

</div>
</body>
</html>