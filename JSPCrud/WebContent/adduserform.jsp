<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server
%> 
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>註冊新會員</title>
<link rel="stylesheet" href="header.css">
    <link rel="stylesheet" href="login.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
</head>
<body>

<jsp:include page="userform.html"></jsp:include>

</body>
</html>