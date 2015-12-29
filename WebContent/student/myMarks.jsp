<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="db.*, data.*, java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%	
	User usr = (User) session.getAttribute("Current_user");
	ArrayList<Mark> marks = MarkActions.getMarksById(usr);
	int mCount = 0;
	System.out.println("Created: ");
%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ECS v4.2/Student/My Marks</title>
		<link href="/LAB3_new/css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="AppWindow">
			<h2><span class="ListHeader">My Marks:</span></h2>
			<% for(Mark m : marks) { 
				mCount++; %>
				<form name="course_choose" method="post" action="" style="display: inline-block;">				
					<font size="4"><%=mCount%>. <b><%=m.getCourse().getName()%></b><br></font>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<font size="2"><b>Id: <%=m.getId()%></b>, Mark: <%=m.getMark()%><br></font>	
					<font size="2"><b>Reply: <%=m.getReply()%></b><br></font>				
				</form>
				<hr>
			<% } %>
			&nbsp;&nbsp;<a href="/LAB3_new/student/studentPanel.jsp" class="BigButton">Back</a>
		</div>
	</body>
</html>