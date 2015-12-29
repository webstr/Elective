<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="db.*, data.*, java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%	
	User usr = (User) session.getAttribute("Current_user");
	ArrayList<Course> courses = CoursesActions.getMyCources(usr);
	int cCount = 0;
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ECS v4.2/Student/My Courses</title>
		<link href="/LAB3_new/css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="AppWindow">
			<h2><span class="ListHeader">My Courses:</span></h2>
			<% for(Course c : courses) { 
				cCount++; %>
				<form name="course_choose" method="post" action="getStudents.jsp" style="display: inline-block;">
					<input  type="hidden" name="course_id" value="<%=c.getId()%>">
						&nbsp;&nbsp;						
					<font size="4"><%=cCount%>. <b><%=c.getName() %></b><br></font>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<font size="2"><b>Id: <%=c.getId()%></b>, Teacher: <%=c.getTeacher().getName()%><br></font>					
				</form>
				<form name="course_delete" method="post" action="courseDelete.jsp">
					<input  type="hidden" name="course_id" value="<%=c.getId()%>">
					&nbsp;&nbsp;<button type="submit" class="NormalButton" value="delete">UnJoin</button>
				</form>
				<hr>
			<% } %>
			&nbsp;&nbsp;<a href="/LAB3_new/student/studentPanel.jsp" class="BigButton">Back</a>
		</div>
	</body>
</html>