<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">

<title>로그인</title>
<style>
* {
	margin: 0px;
	padding: 0px;
}

body {
	background: snow;
}

#container {
	display: flex;
	flex-direction: row;
	justify-content: center;
	align-items: center;
	height: 100%;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	z-index: 1;
}

#loginBox {
	width: 350px;
	padding: 5%;
	text-align: center;
	background-color: #ffffff;
}

#BoxTitle {
	padding: 5px;
	margin: 20px;
}

#formBox {
	margin: 10px;
}

#formBox button {
	margin-top: 20px;
}
</style>
</head>
<body>
	<div id="container">
		<div id="loginBox">
			<div id="BoxTitle">
				<a class="navbar-brand" href="/"><img src="/images/logo2.png"
					alt="KoreaHistory" alt="KoreaHistory" width="150" height="100"></a>
			</div>
			<div id="formBox">
				<form name="login_form" method="post">
					<div class="form-floating mb-3">
						<input type="email" name="id" class="form-control"
							id="floatingInput" placeholder="name@example.com"> <label
							for="floatingInput">Email address</label>
					</div>

					<div class="form-floating">
						<input type="password" name="passwd" class="form-control"
							id="floatingPassword" placeholder="Password"> <label
							for="floatingPassword">Password</label>
					</div>

					<div class="d-grid gap-2">
						<button id="loginCheck" class="btn btn-success">로그인</button>
					</div>
				</form>
			</div>
			<div>
				<a href="signup">회원가입</a>
			</div>
			<div>
				<!-- <a href="#">아이디찾기</a> -->
				<!-- <a href="#">비밀번호 찾기</a> -->
			</div>
		</div>
	</div>
</body>

</html>