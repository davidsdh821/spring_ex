<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
 		
 		<form method="post" action="/lesson04/add_user">
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
 			 
 			 <input type="submit" class="btn btn-success" value="회원가입">
 		</form>
 	
 	</div>
 	
 	

</body>
</html>