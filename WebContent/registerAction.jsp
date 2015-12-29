<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="data.User, db.UserActions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	request.setCharacterEncoding("UTF-8");
    String login = request.getParameter("uLogin");
    String pass = request.getParameter("uPassword");
    String name = request.getParameter("uName");
    String type = request.getParameter("uType");
    Boolean success = false;
    if (!UserActions.checkLoginInDB(login)) {
    	UserActions.insertInDB(new User(login, pass, name, type));
    	success = true;
    }
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ECS v4.2</title>
		<link href="/LAB3_new/css/style.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<div class="AppWindow">
			<div style="text-align: center">
				<% if(success == true) {  %>
					<br><br><br><br>Congratulations, <b><%=name%></b>, you have been registered as a <b><%=type%></b><br>
		        	Your login is "<b><%=login%></b>", and password - "<b><%=pass%></b>"<br>
		        	<A HREF="index.jsp">Return</A>
				<% } else { %>
					<br><br><br><br>There was an error with adding you to database,<br>
					please check your data and try again later*<br>
					<h6>(*) Maybe such login already exists.</h6>
				<% } %>
			</div>
        </div>
	</body>
</html>