<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<body>
	<%@ include file="color.html" %>
	<%!
		int val = 7;
		public String sayWelcome(String name){
			String message=" Hello " + name;
			return message;
		}
	%>
	<%-- Showing HELLO using h1 heading 5 times --%>
	<%-- For loop --%>
	<%
		for(int a=1;a<=5;a++){
	%>
	<h1>Hello World</h1>
	<% 
		}
	%>
	
	<h2>Val=<%=val%></h2>
	<h2>Square of val<%=(val*val)%></h2>	
	<h2>Replay from method is <%=sayWelcome("Chinmay")%></h2>
	<%
		LocalDate today=LocalDate.now();
	%>
	<h2>Today's date is: <%=today %></h2>
</body>
</html>