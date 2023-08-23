<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">

<script src="/js/signup.js"></script>

<title>회원 가입</title>
<style>
*{
	margin:0px;
	padding:0px;	  
}
body {
	background: snow;
}
#container {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 1;
}
#signBox {
	width: 500px;
	padding: 2%;
	background-color: #ffffff;
	border: 1px solid #252525;
}
.borderBox{
	padding: 20px;
	border: 1px solid #d1cfcf;
}
#BoxTitle {
  	color:#000000;
  	padding: 5px;
  	margin: 20px;
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
}
#formBox {
  margin: 10px;
}
#formBox button {
  margin-top : 20px;
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
}
.loginBox {
  text-align: center;
  background-color: #ffffff;
}
</style>
</head>
<body>
	<div id="container">
		<div id="signBox">
			<div class="borderBox">
				<div id="BoxTitle">
					<a class="navbar-brand" href="/"><img src="/images/logo2.png"
					alt="KoreaHistory" alt="KoreaHistory" width="150" height="100"></a>
				</div>
				
				<hr class="mb-4">
				<div class="input-form col-md-12 mx-auto">
					<h5 class="mb-3">회원 가입</h5>
					<form name="signup_form" class="validation-form" id="formBox" method="post">
						<div class="row">
							<div class="col-md-6 mb-3">
								<label for="name">이름</label>
								<input type="text" name="name" class="form-control" id="name">
							</div>
							
							<div class="col-md-6 mb-3">
								<label for="nickname">별명</label>
								<input type="text" name="nickname" class="form-control" id="nickname" placeholder="선택사항">
							</div>
						</div>
						<div class="col-md mb-3">
							<label for="id">이메일</label>
							<input type="email" class="form-control" id="id" name="id">
						</div>
						<div class="row">
							<div class="col-md-6 mb-3">
								<label for="passwd">비밀번호</label>
								<input type="password" name="passwd" class="form-control" id="passwd">
							</div>
							
							<div class="col-md-6 mb-3">
								<label>비밀번호 확인</label>
								<input type="password" name="passwd_2" class="form-control" id="passwd_2">
							</div>
						</div>
						
						<div class="mb-4">
							<label for="phone">전화번호</label>
							<input type="tel" name="phone" class="form-control" id="phone" placeholder="선택사항">
						</div>
						
						<hr class="mb-3">
						<div class="custom-control custom-checkbox">
		            		<input type="checkbox" class="custom-control-input" id="aggrement" required>
		           			<label class="custom-control-label" for="aggrement"><small>개인정보 수집 및 이용에 동의합니다.</small></label>
		          		</div>
		          		
						<hr class="mb-3">
						<div class="d-grid gap-2 col-6 mx-auto">
							<button type="button" class="btn btn-secondary" id="checkId">이메일 중복확인</button>
						</div>
						<div class="d-grid gap-2 col-6 mx-auto">
							<button  type="button" class="btn btn-success" id="infoCheck">회원가입</button>
						</div>
					</form>
				</div>
				<div class="loginBox">
					<a href="login">로그인</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>