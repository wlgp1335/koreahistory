<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<link rel="stylesheet" href="/css/detailStyle.css">
<title>자주질문 내용</title>

</head>
<body>
	<jsp:include page="../header.jsp" />
	<div id="wrap">
		<div class="container">
			<h5>| 자주하는 질문</h5>
			<hr>
			<table class="table table-bordered">
				<colgroup>
					<col width="15%" />
					<col width="35%" />
					<col width="15%" />
					<col width="35%" />
				</colgroup>
				<tbody>
					<tr>
						<th scope="row">작성자</th>
						<td>${item.writer}</td>
						<th scope="row">작성일</th>
						<td><fmt:formatDate value="${item.regDate}"
								pattern="yyyy.MM.dd HH:mm:ss" /></td>
					</tr>
					<tr>
						<th scope="row">제목</th>
						<td colspan="3">${item.title}</td>
					</tr>
					<tr>
						<td colspan="4" class="view_text">${item.contents}</td>
					</tr>
				</tbody>
			</table>
			<hr>
			<div class="buttonBox">
				<c:if test="${sessionScope.member.gradeId == 1}">
					<a href="/oftenqa/delete/${item.id}" class="btn btn-danger me-2 btn-sm">삭제</a> 
					<a href="/oftenqa/update/${item.id}" class="btn btn-warning me-2 btn-sm">변경</a> 
				</c:if>
				<button type="button" class="btn btn-light btn-sm" id="goBack">목록</button>
				<script>
					$("#goBack").click(function(){
				        history.back();
				    });
				</script>
			</div>
			<hr>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>