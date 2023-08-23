<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">

<title>마이페이지</title>
<style>
*{
	margin: 0;
	padding: 0;
}
#wrap {
	min-height: 100vh;
	position: relative;
	width: 100%;
}
.container{
	margin-top: 5%;
	margin-left: 20%;
    padding-top: 60px;
    width: 60%;
    border: 1px solid #757474;
}
#contentBox {
	display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
}
i {
	display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
}
.buttonBox {
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
}
</style>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div id="wrap">
		<div class="container">
			<div>
			<hr>
				<i class="bi bi-person-circle" style="font-size:5em;"></i>
			<hr>
				<h5 id="contentBox">
					<i class="bi bi-incognito"></i> 마이페이지 <i class="bi bi-incognito"></i>
				</h5>
			</div>
			<hr>
			<div class="d-grid gap-2 col-6 mx-auto">
				<a href="/member/profile" class="btn btn-outline-dark">프로필</a>
				<a href="/member/post" class="btn btn-outline-dark">게시글</a>
				<c:if test="${sessionScope.member.gradeId==1}">
					<a href="/member/list" class="btn btn-outline-dark" class="gradeCheck">권한 설정</a>
					<a href="/grade/list" class="btn btn-outline-dark" class="gradeCheck">등급 설정</a>
				</c:if>
			</div>
			<hr>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>