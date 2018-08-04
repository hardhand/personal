<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="deleteStudent.do">
<input type="text" name="id">
<input type="submit" value="확인">
</form>
<c:forEach var="Student" items="${studentList }">
아이디: ${Student.id },
이   름: ${Student.name },
학   년: ${Student.grade }<br>
</c:forEach>
<input type="button" value="확인" onclick="location.href='main.do'">
</body>
</html>