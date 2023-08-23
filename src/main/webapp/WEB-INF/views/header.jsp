<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<header>
	<nav class="navbar navbar-expand-lg" style="background-color: #252525;">
		<div class="container-fluid">
			<a class="navbar-brand" href="/" style="margin-left: 5%;"><img
				src="/images/logo2.png" alt="KoreaHistory" width="100" height="70"></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02"
				aria-controls="navbarTogglerDemo02" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
				<ul class="nav justify-content-center">
					<li><a class="nav-link text-light" href="/history/list">한국사</a></li>
					<li><a class="nav-link text-light" href="/notice/list">공지사항</a></li>
					<li><a class="nav-link text-light" href="/oftenqa/list">자주하는질문</a></li>
					<li><a class="nav-link text-light" href="/qa/list">Q&A</a></li>

					<c:if test="${sessionScope.member == null}">
						<li><a class="nav-link text-light" href="/login">로그인</a></li>
					</c:if>

					<c:if test="${sessionScope.member != null}">
						<li><a class="nav-link text-light" href="/member/mypage">마이페이지</a></li>
						<li><a class="nav-link text-light" href="/logout">로그아웃</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>
	<nav>
		<div style="width: 40%; margin: 20px; margin-left: 30%;">
			<form action="/search" method="get">
				<div id="search" class="mx-auto search-bar input-group mb-3">
					<input name="keyword" type="text" class="form-control" id="search" placeholder="검색어를 입력하세요"
						aria-label="Recipient's username" aria-describedby="button-addon2">
				</div>
			</form>
		</div>
	</nav>
	<hr>
</header>