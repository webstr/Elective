<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ECS v4.2/Register</title>
		<link href="/LAB3_new/css/style.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<div class="AppWindow">
			<form name="register" method="post" action="registerAction.jsp">
				<div style="text-align: center">
				<h2><span class="ListHeader">Sign up</span></h2>
                Login: 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<input type="text" 		name="uLogin" 	value="" 		style="width:100px"/><br>
                Password: 								<input type="password" 	name=uPassword 	value="" 		style="width:100px"/><br>
                Name:	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<input type="text" 		name="uName" 	value="" 		style="width:100px"/><br>
                Type:									<input type="radio" 	name="uType" 	value="Student" checked	>Student
														<input type="radio" 	name="uType" 	value="Teacher"			>Teacher<br><br>
				<a href="/LAB3_new/index.jsp" class="BigButton">Back</a>
				<button type="submit" class="BigButton" value="Sign up">Sign up</button>
				</div>
        	</form>
        </div>
    </body>
</html>