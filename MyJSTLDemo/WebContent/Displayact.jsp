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
<title>新增資料確認</title>
</head>
<body>
<jsp:useBean id="reg_act" class="mvc.bean.activityBean" scope="session" />
<h2>
新增資料如下請確認
</h2>
<form action="activityServlet" method="get">
<table  cellspacing="2" cellpadding="1" border="1" width="100%">
<tr bgcolor="#F2F4FB">
    <td>活動區域:</td>
    <td><jsp:getProperty name="add_act" property="area" /></td>
</tr>
<tr bgcolor="#FFFFE1">
    <td>活動類型:</td>
    <td><jsp:getProperty name="add_act" property="activity" /></td>
</tr>
<tr bgcolor="#F2F4FB">
    <td>活動形式:</td>
    <td><jsp:getProperty name="add_act" property="type" /></td>
</tr>
<tr bgcolor="#FFFFE1">
    <td>活動時間(1):</td>
    <td><jsp:getProperty name="add_act" property="date_time_1" /></td>
</tr>
<tr bgcolor="#F2F4FB">
	<td>活動時間(2):</td>
    <td><jsp:getProperty name="add_act" property="date_time_2" /></td>
</tr>
<tr bgcolor="#FFFFE1">
    <td>活動天數:</td>
    <td><jsp:getProperty name="add_act" property="day" /></td>
</tr>
<tr bgcolor="#F2F4FB">
    <td>活動地點:</td>
    <td><jsp:getProperty name="add_act" property="location" /></td>
</tr>
<tr bgcolor="#FFFFE1">
    <td >活動地址:</td>
    <td> <jsp:getProperty name="add_act" property="address" /></td>
</tr>
<tr bgcolor="#F2F4FB">
    <td>人數限制:</td>
    <td><jsp:getProperty name="add_act" property="limit_per" /></td>
</tr>
<tr bgcolor="#FFFFE1">
    <td>活動費用:</td>
    <td><jsp:getProperty name="add_act" property="cost" /></td>
</tr>
</table>
<center>
<input type="submit" name="confirm" value="確認" >
<input type="reset" name="reset" value="重設">
</center>
</form>
</body>
</html>