<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- bootstrap -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">

<title>회원가입</title>

<script type="text/javascript">

	window.onload = function() {
	
	var id= document.getElementById("id");
	var idok = document.getElementById("idok");
	idInput.addEventListener("blur", function(e) {
		
		var pattern = /^[a-z0-9_]{5,12}$/; //5~12자 영문소문자, 숫자, 언더바(_) 사용가능

		if(pattern.test(id.value)==true){
			idok.innerHTML = "5~12자 영문소문자, 숫자, 언더바(_) 사용가능"
			id.focus();
		} else {
			var http = new XMLHttpRequest();
			http.open("get", "idCheck.do?id=" + id.value);
			http.onreadystatechange == function() {
				if (http.readyState == 4 && http.status == 200) {
					idok.innerHTML('사용가능한 아이디입니다.')
				} else {
					idok.innerHTML('중복된 아이디가 있어 사용이 불가합니다.')
					idInput.focus();
				}
			}
		}

		http.send();
	});
}	
	
	var pwd = document.getElementById("pwd");
	var pwdok = document.getElementById("pwdok");
	pwdInput.addEventListener('blur', function(e) {
		
		var pattern = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-]|.*[0-9]).{4,24}$/;
		
		if(pattern.test(pwd.value)==true) {
			pwdok.innerHTML('4~16자 영문대소문자, 숫자, 특수문자 혼합하여 사용가능')
			pwd.focus();
		} else {
			var http = new XMLHttpRequest();
			http.open("get", "pwdCheck.do?pwd=" + pwd.value);
			http.onreadystatechange == function() {
				if (http.readyState == 4 && http.status == 200) {
					pwdok.innerHTML('사용가능합니다.')
				} else {
					pwdok.innerHTML('비밀번호를 다시 확인하세요.')
					pwdInput.focus();
				}
			}
			
		}
		http.send();

	});
	
	var pwd_CHECK = document.getElementById("pwd_CHECK");
	var pwd_CHECKok = document.getElementById("pwd_CHECKok");
	pwd_CHECKInput.addEventListener('blur', function(e) {
		if (pwd.value != pwd_CHECK.value) {
			pwd_CHECKok.innerHTML = "비밀번호가 일치하지 않습니다. 다시 입력하세요.";
			pwd_CHECKInput.focus();
		}
		else {
			pwd_CHECKok.innerHTML = "비밀번호가 일치합니다.";
		}
		
	});
	
	var name = document.getElementById("name");
	var nameok = document.getElementById("nameok");
	name.addEventListener('blur', function(e) {
		var pattern = /^[0-9a-zA-Z가-힣]{4,20}$/;
		if(pattern.test(name.value)==true) {
			nameok.innerHTML = "닉네임은 한글10자, 영문20자, 한글,영문,숫자 사용가능"
			name.focus();
		}
		else {
			var http = new XMLHttpRequest();
			http.open('get', 'nameCheck.do?name=' + name.value);
			http.onreadystatechange = function() {
				if (http.readyState == 4 && http.status == 200) {
					
					var resultJson = JSON.parse(http.responseText);
					if (resultJson.result) {
						nameok.innerHTML = "사용가능한 닉네임입니다."
					} else {
						nameok.innerHTML = "중복된 닉네임이므로 사용이 불가합니다."
						name.focus();
					}
					
				}
			}
			http.send();
		}
		
	});
	
	
</script>

</head>
<body>
	<center>
		<div class="container">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<div class="jumbotron" style="padding-top: 20px">
					<form method="post" action="join.do">
						<h3 style="text-align: center:">회원가입 화면</h3>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="아이디를 입력하세요."
								name="id" id="id" maxlength="20"><br>
							<span id ="idok"></span>
								
						</div>
						<div class="form-group">
							<input type="password" class="form-control"
								placeholder="비밀번호를 입력하세요." name="pwd" id="pwd" maxlength="20"><br>
							<span id ="pwdok"></span>
						</div>
						<div class="form-group">
							<input type="password" class="form-control"
								placeholder="비밀번호를 한번 더 입력하세요." name="pwd_CHECK" id="pwd_CHECK" maxlength="20"><br>
							<span id ="pwd_CHECKok"></span>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="닉네임을 입력하세요."
								name="name" maxlength="20"><br>
							<span id = "nameok"></span>
						</div>
						
						<input type="reset" class="btn btn-warning form-control"
							value="다시입력"> 
						<input type="submit" class="btn btn-primary form-control" 
							value="회원가입">

					</form>
				</div>
			</div>
		</div>

		<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
		<script src="js/bootstrap.min.js"></script>


	</center>

</body>
</html>