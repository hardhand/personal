<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보 수정 페이지</h1>
	<form action="memberUpdate.do">
		<table>
			<tr>
				<td><input type="text" name="userid" value="${userid }"></td>
			</tr>
			<tr>
				<td><input type="password" name="pwd" value=""></td>
			</tr>
			<tr>
				<td><input type="password" name="pwd_CHECK" value=""></td>
			</tr>
			<tr>
				<td><input type="text" name="name" value="${name }"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" value="${email }"></td>
			</tr>
			<tr>
				<td><input type="text" name="phone" value="${phone }"></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="수정하기"> <input type="reset" value="다시작성"></td>
			</tr>

		</table>
	</form>

</body>
</html>