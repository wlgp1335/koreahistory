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

<title>공지사항</title>
<link rel="stylesheet" href="/css/listStyle.css">
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div id="wrap">
		<div class="box">
			<h5>
				<i class="bi bi-diamond-half"></i> 공지사항
			</h5>
			<table class="table table-sm">
				<thead>
					<tr>
						<!-- 기본 요소 -->
						<!-- <th>번호</th> -->
						<th>Notice</th>
						<th>작성자</th>
						<th>등록일</th>
					</tr>
				</thead>

				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="5">검색된 정보가 없습니다</td>
						</tr>
					</c:if>

					<c:forEach var="item" items="${list}">
						<tr>
							<!-- 기본 요소 -->
							<!-- <td>${item.id}</td> -->
							<td>
								<a href="/notice/detail/${item.id}" class="list-group-item list-group-item-action">${item.title}</a>
							</td>
							<td>${item.writer}</td>
							<td><fmt:formatDate value="${item.regDate}" pattern="yyyy-MM-dd" /></td>
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
			<br>
			<div class="addBox">
				<div>
					<c:if test="${sessionScope.member.gradeId == 1}">
					<a href="/notice/add" class="btn btn-primary">글쓰기</a>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>