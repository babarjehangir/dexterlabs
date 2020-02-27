<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%

	String[] cities = {"Mumbai", "Singapore", "Philadelphia"};

	pageContext.setAttribute("myCities", cities);
	
	pageContext.setAttribute("tmpVar", 5);

	int tmpVar = 5;
%>
<html>
<body>
<h2>Hello World!</h2>

<c:out value = "Hello world"/>

<c:out value = "${tmpVar}"/>

<c:out value="${'Welcome to javaTpoint'}"/> 

</body>
</html>
