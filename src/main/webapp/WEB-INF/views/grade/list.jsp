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

<title>등급 설정</title>
<link rel="stylesheet" href="/css/listStyle.css">
</head>
<body>
<jsp:include page="../header.jsp" />
	<div id="wrap">
		<div class="box">
			<h5>
				<i class="bi bi-diamond-half"></i> 등급 설정
			</h5>
			<table class="table table-bordered">
				<thead>
					<tr>
					<!-- 기본요소 -->
						<th>등급번호</th>
						<th>등급명</th>
					<!-- 기능요소 -->
						<th>관리</th>
					</tr>
				</thead>
				
				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="3">검색된 정보가 없습니다</td>
						</tr>
					</c:if>
					
					<c:forEach var="item" items="${list}">
						<tr>
							<!-- 기본 요소 -->
							<td>${item.id}</td>
							<td>${item.name}</td>
							<!-- 추가 요소 -->
							<!-- 기능 요소 -->
							<td>
								<c:if test="${item.id > 3}">
									<a href="/grade/delete/${item.id}" class="btn btn-danger btn-sm">삭제</a>
								</c:if>
								<a href="/grade/update/${item.id}" class="btn btn-warning btn-sm">변경</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<div class="addBox">
				<div><a href="/grade/add" class="btn btn-primary me-md-2">추가</a></div>
				<div><a href="/member/mypage" class="btn btn-secondary">목록</a></div>
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>