<%@page import="java.util.ArrayList"%>
<%@page import="com.dexter.labs.tagdemo.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<!--  isELIgnored="false" -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%

List<Student> data = new ArrayList<Student>();

data.add(new Student("John", "Doe", false));
data.add(new Student("Maxwell", "Johnson", false));
data.add(new Student("Mary", "Public", true));

pageContext.setAttribute("myStudents", data);

%>

<html>
<head>
<meta charset="UTF-8">
<title>Student Table Demo</title>
</head>
<body>
<table border="1">
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th> Gold Customer</th>
	</tr>

	<c:forEach var="tempStudent" items="${myStudents}">
		<tr>
			<td>${tempStudent.firstName}</td>
			<td> ${tempStudent.lastName}</td>
			<td> 
				<c:if test="${tempStudent.goldCustomer}">
					Special Discount
				</c:if>
				
				<c:if test="${not tempStudent.goldCustomer}">
					-
				</c:if>
			</td>
		</tr>
	</c:forEach>
	
	</table>
</body>
</html>