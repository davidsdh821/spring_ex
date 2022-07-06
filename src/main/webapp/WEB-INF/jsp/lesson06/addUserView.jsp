<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 추가</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


 <script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
 	
 	<div class="container">
 		<h1>회원 정보 추가</h1>
 		
 		<form method="post" action="/lesson06/add_user">
 			<div class="form-group">
 				<label for="name">이름</label>
 				<input type="text" id="name" name="name" class="form-control" placeholder="이름을 입력하세요">
 			</div>
 			<div class="form-group">
 				<label for="yyyymmdd">생년월일</label>
 				<input type="text" id="yyyymmdd" name="yyyymmdd" class="form-control" placeholder="예)200001231">
 			</div>
 			<div class="form-group">
 				<label for="email">email</label>
 				<input type="text" id="email" name="email" class="form-control" placeholder="이메일 입력">
 			</div>
 			<div class="form-group">
 				<label for="introduce">자기소개</label>
 				<textarea id="introduce" name="introduce" class="form-control" rows="10" cols=""></textarea>
 			</div>
 			 
 			 <input type="button" id="addBtn" class="btn btn-success" value="회원가입"> <%--submit이 반드시 아니어야 한다 --%>
 		</form>
 	
 	</div>
 	<script>
 		$(document).ready(function() {
 			$('form').on('submit', function(e) {
	 				e.preventDefault(); //submit 되는 것을 막는다
 	 				
 			});
 			//(2) jquery의 ajax통신을 이용하기
 			$('#addBtn').on('click', function() {
 	 			//1)jquery의 submit 기능 이용하기
 				

 	 				//alert("추가 버튼 클릭");
 	 				// validation
 	 				let name =  $('#name').val().trim();
 	 				if (name == "") { // name.length < 1도 가능 value input값이 비워져 있으면 ""으로 표시됨
 	 					alert("이름을 입력해주세요");
 	 					
 	 					return; //submit일 때만 false를 붙인다
 	 					
 	 				}
 	 				
 	 				let yyyymmdd =  $('#yyyymmdd').val().trim();
 	 				if(yyyymmdd == "") {
 	 					alert("생년월일을 입력해주세요");
 	 					return;
 	 					
 	 				}
 	 				if(isNaN(yyyymmdd)) {
 	 					alert("숫자만 입력해주세요.");
 	 					return;
 	 				}
 	 				//아직은 보내기 전이다
 	 				let email = $('#email').val().trim();
 	 				let introduce= $('textarea[name=introduce]').val(); //text area의 name이 introduce인 것을 가져온다
					//검증
					console.log(email);
 	 				console.log(introduce);
 	 				
 	 				//서버에 전송
 	 				//ajax: 폼태그와 상관없이 비동기로 별도 요청(request)
 	 				$.ajax({
 	 					// request
 	 					type:"POST" //requset의 메소드
 	 					, url:"/lesson06/add_user"	//Actuin URL
 	 					, data: {"name": name, "yyyymmdd":yyyymmdd, "email":email, "introduce":introduce} //서버에 정해져 있는 key로 부른다, name일경우 name 속성의 requestparm과 비교, ""안에 있는 것은 key, 나머지는 변수값, 이름이 다를경우 에러를 찾기가 힘들다.

 	 					//response
 	 					//위의 것과 이어서 하는것이기 때문에 ,붙이기
 	 					, success: function(data) {
 	 						alert(data);
 	 					}
 	 					, complete: function(data) { 
 	 						alert("완료");
 	 					}
 	 					, error: function(e) {
 	 						alert("error " + e);
 	 					}
 	 					
 	 				});

 			});
 			
 		});
 	
 	</script>
 	
 	
 	

</body>
</html>