<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="db.*, data.*, java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%	
	String st_id_str = request.getParameter("student_id");
	String c_id_str = request.getParameter("course_id");
	Integer st_id = Integer.parseInt(st_id_str);
	Integer c_id = Integer.parseInt(st_id_str);
	User choosedStudent = UserActions.getUserByID(st_id);
	session.setAttribute("student_id_session", st_id);
	int curCourse = (int)session.getAttribute("curCourse_session");
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ECS v4.2/Students</title>
		<link href="/LAB3_new/css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="AppWindow">
			<h2><span class="ListHeader"><%=choosedStudent.getName()%>:</span></h2>
			<form name="student_reply" method="post" action="studentReplySubmit.jsp">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				Leave a reply:
				<div style="text-align: center">	
					<textarea rows="4" cols="50" name="reply" style="resize: none;"></textarea><br><br>
				</div>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				Mark: 
				<select name="mark">
			  		<option value="A">A</option>
			 		<option value="B">B</option>
			  		<option value="C">C</option>
			  		<option value="D">D</option>
			  		<option value="F">F</option>
				</select>
				<select name="coef">
			  		<option value="+">+</option>
			 		<option value="-">-</option>
				</select><br><br>
					&nbsp;&nbsp;
				<a href="/LAB3_new/teacher/getStudents.jsp?course_id=<%=curCourse%>" class="NormalButton" style="display: inline-block;">Back</a>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" class="NormalButton" value="submit" style="display: inline-block;">Submit</button>
			</form>
		</div>
	</body>
</html>