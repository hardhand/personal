<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

	<br>
	<br>
	<br>


	<div class="container">

		<div class="col-lg-12"></div>
		<div class="col-lg-12">
			<h1 style="text-align: center:">게시글 목록</h1><br>
			<form class="navbar-form pull-left" action="boardList.do">

				<div class="input-group">

					<select name="type">
						<option value="1">제목
						<option value="2">내용
						<option value="3">제목+내용
						<option value="4">이름
					</select> 
					<input type="text" class="form-control" placeholder="검색 키워드를 입력하세요!" name="keyword"> 
						<span class="input-group-btn">
							<button class="btn btn-secondary" type="button" value="검색" onclick="location.href='boardList.do'">찾기</button>
						</span>
				</div>
			</form>
			<br>

			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th style="background-color: #eeeeee; text-align: center;">글번호</th>
						<th style="background-color: #eeeeee; text-align: center;">제목</th>
						<th style="background-color: #eeeeee; text-align: center;">작성일</th>
						<th style="background-color: #eeeeee; text-align: center;">조회수</th>
						<th style="background-color: #eeeeee; text-align: center;">작성자</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:forEach items="${boardList }" var="board">
							<tr>
								<td align="center">${board.num }</td>
								<td><a href="view.do?num=${board.num }">${board.title }</a></td>
								<td align="center"><fmt:formatDate
										value="${board.writedate }" pattern="yyyy-MM-dd" /></td>

								<td align="center">${board.readCount }</td>
								<td align="center">${board.name }</td>
							</tr>
						</c:forEach>

					</tr>
				</tbody>
				<tr>
					<td width="1250px" colspan="5"><c:if test="${start != 1 }">
							<a href="boardList.do?page=1">[처음]</a>
							<a href="boardList.do?page=${start-1 }">[이전]</a>
						</c:if> <c:forEach begin="${start }" end="${end }" var="i">
							<c:choose>
								<c:when test="${i == current }">
										[${i }]
									</c:when>
								<c:otherwise>
									<a href="boardList.do?page=${i }">[${i }]</a>
								</c:otherwise>
							</c:choose>
						</c:forEach> <c:if test="${end != last }">
							<a href="boardList.do?page=${end+1 }">[다음]</a>
							<a href="boardList.do?page=${last }">[끝]</a>
						</c:if></td>


				</tr>

			</table>

			<td><input type="button" class="btn btn-info pull-left"
				value="목록으로" onclick="location.href='boardList.do'"></td>
				
			<td><input type="button" class="btn btn-primary pull-right"
				value="글쓰기" onclick="location.href='writeForm.do'"></td>


		</div>

	</div>


	<!-- /#wrapper -->

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>





