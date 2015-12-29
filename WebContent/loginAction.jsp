<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="data.User, db.UserActions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
    String login = request.getParameter("uLogin");
    String password = request.getParameter("uPassword");
    Boolean success = false;
    String appPage = "";
    User user = UserActions.getUserFromDB(login, password);
    if (user.getId() != 0 || user.getLogin() != "") {
    	if (user.getType().equals("Teacher")) {
    		appPage = "teacher/getCourses.jsp";
    	} 
    	if (user.getType().equals("Student")) {
    		appPage = "student/studentPanel.jsp";
    	}
    	session.setAttribute("Current_user", user);
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
					<br><br><br><br><br>Success, you are "<b><%=user.getType() %></b>" and logged in as "<b><%=user.getLogin() %></b>"<br>
		        	<br><a href="/LAB3_new/<%=appPage %>" class="BigButton">Start</a>
				<% } else { %>
					<br><br><br><br>There was an error with logging in,<br>
					please check your data and try again later*<br>
					<h6>(*) Maybe there is no such user, or your password is incorrect.</h6>
				<% } %>
			</div>
        </div>
	</body>
</html>