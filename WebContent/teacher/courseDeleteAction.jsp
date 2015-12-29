<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="db.*, data.*, java.util.ArrayList"%>
<%@ page import="java.io.*,java.util.*" %>

<%
	String str_id = request.getParameter("course_id");
	Integer id = Integer.parseInt(str_id);
	CoursesActions.deleteFromDB(id);
	
	response.sendRedirect("getCourses.jsp"); 
%>