<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>報名資料確認</title>
</head>
<body>
<jsp:useBean id="reg_regis" class="mvc.bean.regisBean" scope="session" />
<h2>
報名資料如下請確認
</h2>
<form action="regisServlet" method="post">
<table  cellspacing="2" cellpadding="1" border="1" width="100%">
<tr bgcolor="#F2F4FB">
    <td>報名場次:</td>
    <td><jsp:getProperty name="reg_regis" property="location" /></td>
</tr>
<tr bgcolor="#FFFFE1">
    <td>姓名:</td>
    <td><jsp:getProperty name="reg_regis" property="name" /></td>
</tr>
<tr bgcolor="#F2F4FB">
    <td>生日:</td>
    <td>
    西元
    <jsp:getProperty name="reg_regis" property="birthyear" /> 年
    <jsp:getProperty name="reg_regis" property="birthmonth" />月
    <jsp:getProperty name="reg_regis" property="birthday" />日    
    </td>
</tr>
<tr bgcolor="#FFFFE1">
    <td>身份證字號:</td>
    <td><jsp:getProperty name="reg_regis" property="id" /></td>
</tr>
<tr bgcolor="#F2F4FB">
    <td width="150">聯絡地址:</td>
    <td> <jsp:getProperty name="reg_regis" property="address" /></td>
</tr>
<tr bgcolor="#FFFFE1">
    <td>聯絡電話</td>
    <td><jsp:getProperty name="reg_regis" property="phone" /></td>
</tr>
<tr bgcolor="#F2F4FB">
    <td>E-mail:</td>
    <td><jsp:getProperty name="reg_regis" property="mailaddress" /></td>
</tr>
</table>
<center>
<input type="submit" name="confirm" value="確認" >
</center>
</form>
</body>
</html>