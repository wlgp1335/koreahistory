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

<title>프로필</title>
<style>
* {
	margin: 0px;
	padding: 0px;
}

#wrap {
	min-height: 100vh;
	position: relative;
	width: 100%;
}

#container {
	margin-left: 20%;
	padding-top: 60px;
	width: 60%;
}

.update {
	display: flex;
    flex-direction: row;
    justify-content: center;
}

.back {
	display: flex;
    flex-direction: row;
    justify-content: right;
}
</style>
</head>
<body>
	<jsp:include page="../header.jsp" />
	<div id="wrap">
		<div id="container">
			<h5>
				<i class="bi bi-diamond-half"></i> 프로필
			</h5>
			<br>
			<form name="profile_form" method="post">
				<table class="table table-bordered border-dark">
					<colgroup>
						<col width="15%" />
						<col width="35%" />
						<col width="15%" />
						<col width="35%" />
					</colgroup>
					<tbody>
						<tr>
							<th scope="row">이메일</th>
							<td><input type="email" class="form-control" id="id"
								name="id" value="${item.id}" readonly></td>
							<th scope="row">등급</th>
							<td>
							<input type="text" class="form-control" id="gname"
								name="gname" value="${item.gname}" readonly>
							</td>

						</tr>
						<tr>
							<th scope="row">이름</th>
							<td>
								<input type="text" name="name" class="form-control" id="name" value="${item.name}">
							</td>
							<th scope="row">별명</th>
							<td><input type="text" name="nickname" class="form-control"
								id="nickname" value="${item.nickname}" placeholder="댓글/게시물 표시됨">
							</td>
						</tr>
						<tr>
							<th scope="row">전화번호</th>
							<td><input type="tel" name="phone" class="form-control"
								id="phone" value="${item.phone}" placeholder="선택사항"></td>
							<th scope="row">비밀번호 변경</th>
							<td><input type="password" name="passwd"
								class="form-control" id="passwd" value="${item.passwd}"
								placeholder="변경 비밀번호 입력"></td>
						</tr>
						<tr>
							<th scope="row">설명</th>
							<td colspan="3">※비밀번호 변경은 기존 비밀번호를 삭제한 후에 입력해주세요!</td>
						</tr>
					</tbody>
				</table>
				<br>
				<div class="update">
					<button type="button" id="profileUpdate" class="btn btn-warning btn-sm">정보 변경</button>
				</div>
				<div class="back">
					<a href="/member/mypage"><button type="button"
							class="btn btn-secondary btn-sm">목록</button></a>
				</div>
				<br>
				<div style="margin-top: 20%;">
					<a href="/member/delete" class="btn btn-danger btn-sm">회원 탈퇴</a>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
<script>
$(function () {

    $('#profileUpdate').click(function () {
        const form = document.profile_form;

        if (form.passwd.value == '') {
            alert('비밀번호를 입력하세요');
            form.passwd.focus();
            return;
        }
        alert('정보 수정');
        form.submit();
    });
    
});
</script>
</html>