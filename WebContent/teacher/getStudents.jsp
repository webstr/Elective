<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="db.*, data.*, java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%	
	String c_id_str = "-1";
	if (request.getParameter("course_id") != null) {
		c_id_str = request.getParameter("course_id");
	}
	int c_id = Integer.parseInt(c_id_str);
	ArrayList<User> students = UserActions.getStudentsByCourseID(c_id);
	session.setAttribute("curCourse_session", c_id);

%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ECS v4.2/Students</title>
		<link href="/LAB3_new/css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="AppWindow">
			<h2><span class="ListHeader">Students (<%=students.size()%>):</span></h2>
			<% if (c_id == -1) {%>
				<span class="ListHeader">No students in this course</span>
			<% } else { %>
				<% for(User u : students) { %>
					<form name="student_choose" method="post" action="getStudentInfo.jsp">
						<input  type="hidden" name="student_id" value="<%=u.getId()%>">
							&nbsp;&nbsp;
						<font size="4"><%=students.indexOf(u)+1%>. <b><%=u.getName() %></b><br></font>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<font size="2"><b>Id: <%=u.getId() %></b><br></font>
							&nbsp;&nbsp; 
						<button type="submit" class="NormalButton" value="open">Open</button>
						<hr>
					</form>
				<% } %>
			<%} %>
			&nbsp;&nbsp;<a href="/LAB3_new/teacher/getCourses.jsp" class="BigButton">Back</a>
		</div>
	</body>
</html>