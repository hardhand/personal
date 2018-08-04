<%@page import="model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학생관리-수정</title>
</head>
<body>

<%Student student = new Student(); %>
<form action="modifyStudent.do">
아이디: <input type="text" value=<%=student.getId() %> name="id">
이   름: <input type="text" value=<%=student.getName() %> name="name">
학   년: <input type="text" value=<%=student.getGrade() %> name="grade">

<input type="submit" value="확인">

</form>

</body>
</html>