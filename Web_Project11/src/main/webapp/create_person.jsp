<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--Instantiating a java bean: Person --%>
	
	<jsp:useBean id="personObj" class="example.bean.Person" scope="session"/>
	<jsp:setProperty property="*" name="personObj"/>
	<h1>Person Created Successfully</h1>
	<h1>To view Please
		<a href="showperson.jsp">
			click here
		</a>
	
	</h1>
</body>
</html>