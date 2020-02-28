<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>functions jsp test</title>
</head>
<body>
	<c:set var="data" value="dexterlabs"/>
	
	Length of the string <b>${data}</b>: ${fn:length(data)}
	
	<br/><br/>
	
	Does the string <b> ${data}</b> start with <b>dexter</b> ?: ${fn:startsWith(data, "dexter")}
</body>
</html>