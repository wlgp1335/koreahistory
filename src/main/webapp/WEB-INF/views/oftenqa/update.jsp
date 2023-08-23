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
<link href="/resources/summernote/summernote-lite.css" rel="stylesheet">
<script src="/resources/summernote/summernote-lite.js"></script>
<script src="/resources/summernote/lang/summernote-ko-KR.js"></script>

<script src="/js/attach.js"></script>
<link rel="stylesheet" href="/css/writeStyle.css">
<title>변경</title>

</head>
<body>
	<jsp:include page="../header.jsp" />
	<div id="wrap">
		<div class="box">
			<h5>
				<i class="bi bi-diamond-half"></i> 글쓰기 변경
			</h5>
			<hr>
			<form method="post" enctype="multipart/form-data">
				<div>
					<input type="text" name="title" value="${item.title}"
						class="form-control" id="title" placeholder="제목을 입력해주세요">
				</div>
				<hr>
				<div>
					<textarea id="summernote" name="contents">${item.contents}</textarea>
				</div>
				<hr>
				<div class="buttonBox">
					<button class="btn btn-warning me-md-2">변경</button>
					<button type="button" class="btn btn-light btn-sm" id="goBack">목록</button>
				<script>
					$("#goBack").click(function(){
				        history.back();
				    });
				</script>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="../footer.jsp" />
</body>
</html>