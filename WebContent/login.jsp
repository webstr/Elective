<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ECS v4.2/Login</title>
		<link href="/LAB3_new/css/style.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<div class="AppWindow">
			<form name="login" method="post" action="loginAction.jsp">
				<div style="text-align: center">
					<h2><span class="ListHeader">Sign up</span></h2><br>
	                Login: 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<input type="text" 		name="uLogin" 	value="" 		style="width:100px"/><br>
	                Password: 								<input type="password" 	name=uPassword 	value="" 		style="width:100px"/><br>
					<br><a href="/LAB3_new/index.jsp" class="BigButton">Back</a>
					<button type="submit" class="BigButton" value="Sign in">Sign in</button>
				</div>
        	</form>
        </div>
    </body>
</html>