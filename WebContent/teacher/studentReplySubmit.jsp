<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="db.*, data.*, java.util.ArrayList"%>
<%@ page import="java.io.*,java.util.*" %>

<%
	request.setCharacterEncoding("UTF-8");
	Integer st_id = (Integer) session.getAttribute("student_id_session");
	String reply = request.getParameter("reply");
	String mark = request.getParameter("mark") + request.getParameter("coef");
	int curCourse = (int)session.getAttribute("curCourse_session");
	MarkActions.insertInDB(st_id, curCourse, mark, reply);
	response.sendRedirect("getCourses.jsp"); 
%>