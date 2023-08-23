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

<title>Main</title>
<style>
*{
	margin: 0;
	padding: 0;
}
#wrap {
	min-height: 100vh;
	position: relative;
	width: 100%;
    margin-bottom: 15%;
}

.box {
	margin-left: 20%;
	margin-top: 10%;
}

tr td p {
	margin: 0;
}

table {
	width: 93%;
	margin-left: 30px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="wrap">
		<c:if test="${mode == 'search'}">
			<jsp:include page="search.jsp" />
		</c:if>
		<c:if test="${mode != 'search'}">
			<div class="box">
				<div>
					<img src="/images/main.png" alt="main" width="75%">
				</div>
				<br> 
				<br>
				<div>
					<p>
						이 사이트는 공무원되려고 한국사를 공부하다가 개발쪽으로 진로를 변경하여 <br>코딩을 시작하게된 초보코딩의
						첫번째 프로젝트(한국사 정보 공유 사이트)이다.
					</p>
				</div>
			</div>
		</c:if>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>