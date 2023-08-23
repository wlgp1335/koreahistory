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

<title>게시글</title>
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
.box {
	width: 60%;
	margin-left: 20%;
	margin-top: 5%;
}

table {
	text-align: center;
}

.addBox {
	margin-left: 94%;
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<jsp:include page="../header.jsp" />
	
	<div id="wrap">
		<div class="box">
			<h4>
				<i class="bi bi-balloon-fill"></i> 게시글
			</h4>
			<hr>
			
			<div>
				<h5>
					<i class="bi bi-diamond-half"></i> Q & A
				</h5>
				<div class="addBox">
					<a href="/qa/add" class="btn btn-primary btn-sm">
						<i class="bi bi-pencil-square"></i>
					</a>
				</div>
				<table class="table table-bordered">
					<thead>
						<tr>
							<!-- 기본 요소 -->
							<!-- <th>번호</th> -->
							<th>Questions</th>
							<th>작성자</th>
							<th>등록일</th>
							<!-- 기능 요소 -->
							<th>관리</th>
						</tr>
					</thead>
	
					<tbody>
						<c:forEach var="item" items="${qa}">
							<tr>
							<c:if test="${sessionScope.member.id==item.memberId}">
								<!-- 기본 요소 -->
								<!-- <td>${item.id}</td> -->
								<td><a href="/qa/detail/${item.id}" class="list-group-item list-group-item-action">${item.title}</a>
								<td>${item.writer}</td>
								<td><fmt:formatDate value="${item.regDate}"
										pattern="yyyy-MM-dd" /></td>
								<!-- 기능 요소 -->
								<td>
									<a href="/qa/delete/${item.id}" class="btn btn-outline-danger btn-sm">삭제</a>
									<a href="/qa/update/${item.id}" class="btn btn-outline-warning btn-sm">변경</a>
								</td>
							</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br>
				<div>
					<div class="pagination pagination-sm justify-content-center">
						<div class="page-item">
							<a href="?page=1&${pager.query}" class="page-link">처음</a>
						</div>
						<div class="page-item">
							<a href="?page=${pager.prev}&${pager.query}" class="page-link">◀</a>
						</div>
	
						<c:forEach var="page" items="${pager.list}">
							<div class="page-item">
								<a href="?page=${page}&${pager.query}" class="page-link">${page}</a>
							</div>
						</c:forEach>
	
						<div class="page-item">
							<a href="?page=${pager.next}&${pager.query}" class="page-link">▶</a>
						</div>
						<div class="page-item">
							<a href="?page=${pager.last}&${pager.query}" class="page-link">마지막</a>
						</div>
					</div>
				</div>
			</div>
			<br>
			<hr>
			<div>
				<h5>
					<i class="bi bi-diamond-half"></i> 한국사
				</h5>
				<div class="addBox">
					<a href="/history/add" class="btn btn-primary btn-sm">
						<i class="bi bi-pencil-square"></i>
					</a>
				</div>
				<table class="table table-bordered">
					<thead>
						<tr>
							<!-- 기본 요소 -->
							<!-- <th>번호</th> -->
							<th>KoreaHistory</th>
							<th>작성자</th>
							<th>등록일</th>
							<th>관리</th>
						</tr>
					</thead>
	
					<tbody>
						<c:forEach var="item" items="${history}">
							<tr>
							<c:if test="${sessionScope.member.id==item.memberId}">
								<!-- 기본 요소 -->
								<!-- <td>${item.id}</td> -->
								<td><a href="/history/detail/${item.id}"
								class="list-group-item list-group-item-action">${item.title}</a></td>
								<td>${item.writer}</td>
								<td><fmt:formatDate value="${item.regDate}"
										pattern="yyyy-MM-dd" /></td>
								<!-- 기능 요소 -->
								<td>
									<a href="/history/delete/${item.id}" class="btn btn-outline-danger btn-sm">삭제</a> 
									<a href="/history/update/${item.id}" class="btn btn-outline-warning btn-sm">변경</a>
								</td>
							</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br>
				<div>
					<div class="pagination pagination-sm justify-content-center">
						<div class="page-item">
							<a href="?page=1&${pager.query}" class="page-link">처음</a>
						</div>
						<div class="page-item">
							<a href="?page=${pager.prev}&${pager.query}" class="page-link">◀◀</a>
						</div>
	
						<c:forEach var="page" items="${pager.list}">
							<div class="page-item">
								<a href="?page=${page}&${pager.query}" class="page-link">${page}</a>
							</div>
						</c:forEach>
	
						<div class="page-item">
							<a href="?page=${pager.next}&${pager.query}" class="page-link">▶▶</a>
						</div>
						<div class="page-item">
							<a href="?page=${pager.last}&${pager.query}" class="page-link">마지막</a>
						</div>
					</div>
				</div>
			</div>
			<br>
			<hr>
			<c:if test="${sessionScope.member.gradeId < 3}">
			<div>
				<h5>
					<i class="bi bi-diamond-half"></i> 공지사항
				</h5>
				<div class="addBox">
					<a href="/notice/add" class="btn btn-primary btn-sm">
						<i class="bi bi-pencil-square"></i>
					</a>
				</div>
				<table class="table table-bordered">
					<thead>
						<tr>
							<!-- 기본 요소 -->
							<!-- <th>번호</th> -->
							<th>Notice</th>
							<th>작성자</th>
							<th>등록일</th>
							<!-- 기능 요소 -->
							<th>관리</th>
						</tr>
					</thead>
	
					<tbody>
						<c:forEach var="item" items="${notice}">
							<tr>
							<c:if test="${sessionScope.member.id==item.memberId}">
								<!-- 기본 요소 -->
								<!-- <td>${item.id}</td> -->
								<td><a href="/notice/detail/${item.id}"
									class="list-group-item list-group-item-action">${item.title}</a>
								</td>
								<td>${item.writer}</td>
								<td><fmt:formatDate value="${item.regDate}"
										pattern="yyyy-MM-dd" /></td>
								<!-- 기능 요소 -->
								<td>
									<a href="/notice/delete/${item.id}" class="btn btn-outline-danger btn-sm">삭제</a>
									<a href="/notice/update/${item.id}" class="btn btn-outline-warning btn-sm">변경</a>
								</td>
							</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br>
				<div>
					<div class="pagination pagination-sm justify-content-center">
						<div class="page-item">
							<a href="?page=1&${pager.query}" class="page-link">처음</a>
						</div>
						<div class="page-item">
							<a href="?page=${pager.prev}&${pager.query}" class="page-link">◀◀</a>
						</div>
	
						<c:forEach var="page" items="${pager.list}">
							<div class="page-item">
								<a href="?page=${page}&${pager.query}" class="page-link">${page}</a>
							</div>
						</c:forEach>
	
						<div class="page-item">
							<a href="?page=${pager.next}&${pager.query}" class="page-link">▶▶</a>
						</div>
						<div class="page-item">
							<a href="?page=${pager.last}&${pager.query}" class="page-link">마지막</a>
						</div>
					</div>
				</div>
			</div>
			<br>
			<hr>
			<div>
				<h5>
					<i class="bi bi-diamond-half"></i> 자주하는 질문
				</h5>
				<div class="addBox">
					<a href="/oftenqa/add" class="btn btn-primary btn-sm">
						<i class="bi bi-pencil-square"></i>
					</a>
				</div>
				<table class="table table-bordered">
					<thead>
						<tr>
							<!-- 기본 요소 -->
							<!-- <th>번호</th> -->
							<th>Question</th>
							<th>작성자</th>
							<th>등록일</th>
							<!-- 기능 요소 -->
							<th>관리</th>
						</tr>
					</thead>
	
					<tbody>
						<c:forEach var="item" items="${often}">
							<tr>
							<c:if test="${sessionScope.member.id==item.memberId}">
								<!-- 기본 요소 -->
								<!-- <td>${item.id}</td> -->
								<td><a href="/oftenqa/detail/${item.id}" class="list-group-item list-group-item-action">${item.title}</a>
								<td>${item.writer}</td>
								<td><fmt:formatDate value="${item.regDate}"
										pattern="yyyy-MM-dd" /></td>
								<!-- 기능 요소 -->
								<td>
									<a href="/oftenqa/delete/${item.id}" class="btn btn-outline-danger btn-sm">삭제</a>
									<a href="/oftenqa/update/${item.id}" class="btn btn-outline-warning btn-sm">변경</a>
								</td>
							</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br>
				<div>
					<div class="pagination pagination-sm justify-content-center">
						<div class="page-item">
							<a href="?page=1&${pager.query}" class="page-link">처음</a>
						</div>
						<div class="page-item">
							<a href="?page=${pager.prev}&${pager.query}" class="page-link">◀◀</a>
						</div>
	
						<c:forEach var="page" items="${pager.list}">
							<div class="page-item">
								<a href="?page=${page}&${pager.query}" class="page-link">${page}</a>
							</div>
						</c:forEach>
	
						<div class="page-item">
							<a href="?page=${pager.next}&${pager.query}" class="page-link">▶▶</a>
						</div>
						<div class="page-item">
							<a href="?page=${pager.last}&${pager.query}" class="page-link">마지막</a>
						</div>
					</div>
				</div>
			</div>
			<br>
			<hr>
			</c:if>
			<br>
			<div class="d-grid gap-2 col-6 mx-auto">
				<a href="/member/mypage" class="btn btn-secondary btn-sm">목록</a>
			</div>
		</div>
		
		<br>
		<br>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>