<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Core Tag Example</title>
</head>
<body>
 <c:set var = "salary" scope = "session" value = "${2000*2}"/>
      <c:if test = "${salary > 2000}">
         <p>My salary is:  <c:out value = "${salary}"/><p>
      </c:if>
</body>
</html>