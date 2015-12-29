<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="db.*, data.*, java.util.ArrayList"%>
<%@ page import="java.io.*,java.util.*" %>

<%
	String course_id = request.getParameter("course_id");
	Integer c_id = Integer.parseInt(course_id);
	User curUser = (User) session.getAttribute("Current_user");
	UserActions.joinCourse(curUser, c_id);
	
	response.sendRedirect("allCources.jsp"); 
%>