<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="db.*, data.*, java.util.ArrayList"%>
<%@ page import="java.io.*,java.util.*"%>

<%
	String str_id = request.getParameter("course_id");
	System.out.println("lol");
	System.out.println(str_id + "lol");

	Integer id = Integer.parseInt(str_id);
	CoursesActions.unJoinCource(id);
	
	response.sendRedirect("myCources.jsp"); 
%>