<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>인혜의 게시판</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<style>
body {
	padding-top: 54px;
}

@media ( min-width : 992px) {
	body {
		padding-top: 56px;
	}
}
</style>

</head>
<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="index.html">INHYE'S Notice Board</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link" href="main.do">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="joinForm.do">Join</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="loginForm.do">Login</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="memberList.do">MemberList</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="boardList.do">BoardList</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="daumMap.do">Map</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="logout.do">Logout</a>
				</li>
			</ul>
		</div>
	</div>
	</nav>

	<!-- Page Content -->

		<center>
			<div class="container">
			<h1 style="text-align: center:">게시글 수정하기</h1>
				<div class="row">
					<form method="post" action="modify.do">
						<table class="table table-striped"
							style="text-align: center; border: 1px solid #dddddd">
							<thead>

								<tr>
									<th style="background-color: #eeeeee; text-align: center;">글번호</th>
									<th style="background-color: #eeeeee; text-align: center;">제목</th>
									<th style="background-color: #eeeeee; text-align: center;">작성일</th>
									<th style="background-color: #eeeeee; text-align: center;">조회수</th>
									<th style="background-color: #eeeeee; text-align: center;">작성자</th>
									<th style="background-color: #eeeeee; text-align: center;">이메일</th>
									<th style="background-color: #eeeeee; text-align: center;">파일</th>
								</tr>

							</thead>
							<tbody>

								<tr>
									<td><input type="text" readonly="readonly"
										class="form-control" value="${board.num }" name="num"></td>

									<td><input type="text" class="form-control"
										value="${board.title }" name="title"></td>

									<td><input type="text" readonly="readonly"
										value="<fmt:formatDate value="${board.writedate }"
							pattern="yyyy-MM-dd" />" name="writedate"></td>

									<td><input type="text" readonly="readonly"
										class="form-control" value="${board.readCount }"
										name="readCount"></td>

									<td><input type="text" readonly="readonly"
										class="form-control" value="${board.name }" name="name"></td>

									<td><input type="text" readonly="readonly"
										class="form-control" value="${board.email }" name="email"></td>

									<td><input type="file" readonly="readonly"
										class="form-control" value="${board.file }" name="file"></td>
								</tr>

								<tr>
									<td style="color: black;" bgcolor="#eeeeee" align="center"
										colspan="7">내용</td>
								</tr>

								<tr>
									<td align="center" colspan="7" height="500"><textarea
											rows="15" cols="120" name="content">${board.content }</textarea></td>
								</tr>

							</tbody>
						</table>
						<input type="password" name="pass" placeholder="비밀번호를 입력하세요.">
						<input type="submit" class="btn btn-primary pull-right"
							value="수정하기"> <input type="button"
							class="btn btn-primary pull-left" value="뒤로가기"
							onclick="location.href='view.do?num=${board.num }&page=${page }'">
					</form>
				</div>


			</div>
		</center>

	</div>
	<!-- /#wrapper -->

	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Menu Toggle Script -->
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>

</body>
</html>