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
<title>질문 내용</title>
<style>
* {
	margin: 0;
	padding: 0;
}
.content{
	margin: 5%;
}
.replyFrom{
	width: 100%;
}
.replyList{
	border: 1px solid #ffffff;
	padding: 1%;
	margin-top: 5%;
}
.replyTag {
	border: 1px solid #d4d2d2;
	padding: 1%;
}
.replyTag .btn {
    --bs-btn-padding-x: 0.25rem;
    --bs-btn-padding-y: 0.325rem;
}
</style>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div id="wrap">
		<div class="container">
			<h5>| Q & A</h5>
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
				<c:if
					test="${sessionScope.member.id==item.memberId || sessionScope.member.gradeId == 1}">
					<a href="/qa/delete/${item.id}" class="btn btn-danger me-2 btn-sm">삭제</a>
					<a href="/qa/update/${item.id}" class="btn btn-warning me-2 btn-sm">변경</a>
				</c:if>
				<button type="button" class="btn btn-light btn-sm" id="goBack">목록</button>
				<script>
					$("#goBack").click(function() {
						history.back();
					});
				</script>
			</div>
			<hr>
	<!----------------------- 댓글 영역 : 이현주 -------------------------------------------->
			<div class="content">

				<!-- 댓글 입력 -->
				<div class="replyFrom">
					<form action="/qa/replyAdd" method="post" class="row g-2">
						<div>
							<textarea class="form-control" cols="50" name="contents" placeholder="로그인 후에 가능합니다"></textarea>
							<input type="hidden" name="qaId" value="${item.id}">
						</div>
						<div>
							<c:if test="${sessionScope.member != null}">
								<button class="btn btn-success btn-sm">댓글 작성</button>
							</c:if>
						</div>
					</form>
				</div>
				<!-- 댓글 목록 -->
				<div class="replyList">
					<c:forEach var="reply" items="${reply}">
							<div>
								<div class="replyTag" style="background:beige;">
									<span><strong>${reply.writer}</strong></span> 
									<span><small><fmt:formatDate value="${reply.regDate}" pattern="yyyy-MM-dd hh:mm" /></small></span>
									<span> 
										<c:if test="${sessionScope.member.id == reply.memberId || sessionScope.member.gradeId == 1}">
											<a href="/qa/replyDelete/${reply.id}?id=${item.id}" class="btn btn-outline-danger">
												<i class="bi bi-trash3"></i>
											</a>
										</c:if>
									</span>
								</div>

								<div class="replyTag">
									${reply.contents}
								</div>
							</div>
					</c:forEach>
				</div>
			</div>
			<hr>
	<!-- -------------------------------------------------댓글 영역 끝--------------------------------------------- -->
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>