<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="db.*, data.*, java.util.ArrayList"%>
<%@ page import="java.io.*,java.util.*"%>

<%
	request.setCharacterEncoding("UTF-8");
	String course_name = request.getParameter("course_name");
	User curUser = (User) session.getAttribute("Current_user");
	Course tCourse = new Course(course_name, curUser);
	CoursesActions.insertInDB(tCourse);
	
	response.sendRedirect("getCourses.jsp"); 
%>