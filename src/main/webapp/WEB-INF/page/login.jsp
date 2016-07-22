<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	function changeImg(){
	    document.getElementById("randomcode_img").src="http://localhost:8080/stumarket-web/validatecode.jsp?t="+Math.random();

	}
	

</SCRIPT>

</head>
<body>
<form action="/stumarket-web/SecurityVerification/login.do" method="post" onsubmit="return check()" >
<font color="red">${msg }</font><br>
username<input type="text" name="username"><br/>
password<input type="text" name="password"><br/>
<input type="radio" value="1" name="role" />员工
<input type="radio" value="2" name="role"/>店长
<input type="radio" value="3" name="role"/>超级管理员<br/>
验证码：<input id="randomcode" name="randomcode" size="8" />
<img id="randomcode_img" alt="absMiddle" src="http://localhost:8080/stumarket-web/validatecode.jsp" onclick="changeImg()">
<input type="submit" value="login">

</form>

</body>
</html>