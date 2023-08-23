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

<title>글쓰기</title>
<script>
	$("#addList").click(function(){
		const form = document.grade_form;
		form.submit();
	});
</script>
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
	margin-left: 20%;
    padding-top: 60px;
    width: 60%;
}
h5 {
    font-weight: bold;
    margin-bottom: 20px;
}
#formBox {
  margin-top : 20px;
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
<jsp:include page="../header.jsp"/>
	<div id="wrap">	
		<div class="container">
			<h5>
				<i class="bi bi-diamond-half"></i> 글쓰기
			</h5>
			<hr>
			<form id="formBox" method="post">
				<div>
					<div>
						<label>★번호:</label>
						<input type="number" name="id" value="${item.id}" readonly>
					</div>
				<hr>
					<div>
						<label>등급명:</label>
						<input type="text" name="name" value="${item.name}">
					</div>
				</div>
				<div class="buttonBox" style="margin-left:20px;">
					<button class="btn btn-warning me-md-2">변경</button>
					<a href="/grade/list"><button type="button" class="btn btn-light">취소</button></a>
				</div>
			</form>
			<hr>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>