<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<br><br>
		<div class="container">
			<h1 style="text-align: center:">글쓰기</h1><br>
			<div class="col-lg-12">

				<div class="jumbotron" style="padding-top: 20px; text-align: center">

					<div class="container" align="center">
						<div class="row">
							<form method="post" action="write.do"
								enctype="multipart/form-data">
								<table class="table table-striped"
									style="text-align: center; border: 1px solid #dddddd">
									<thead>

										<tr>
											<td><input type="text" class="form-control"
												placeholder="글 제목" name="title"></td>
										</tr>
										<tr>
											<td><input type="password" class="form-control"
												placeholder="비밀번호" name="pass"></td>
										</tr>
										<tr>
											<td><input type="text" class="form-control"
												placeholder="이름" name="name" value="${id }" readonly="readonly"></td>
										</tr>
										<tr>
											<td><input type="text" class="form-control"
												placeholder="이메일" name="email"></td>
										</tr>
										<tr>
											<td><input type="file" class="form-control"
												placeholder="첨부파일" name="ufile"></td>
										</tr>

									</thead>
									<tbody>

										<tr>

											<td style="color: black" bgcolor="#eeeeee" align="center"
												colspan="7">내용</td>
										</tr>
										<tr>
											<td align="center" colspan="7"><textarea
													class="form-control" placeholder="글 내용" name="content"
													maxlength="2048" style="height: 350px"></textarea></td>
										</tr>
									</tbody>
								</table>
								<input type="submit" class="btn btn-primary pull-right"
									value="글쓰기"> <input type="button"
									class="btn btn-warning pull-left" value="게시판목록"
									onclick="location.href='boardList.do'">
							</form>
						</div>
					</div>
				</div>
			</div>

		</div>
	</center>
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="js/bootstrap.min.js"></script>

</body>
</html>