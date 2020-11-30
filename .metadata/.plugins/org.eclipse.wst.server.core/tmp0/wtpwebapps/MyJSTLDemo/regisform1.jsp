
<!DOCTYPE html>
<% 
response.setContentType("text/html;charset=UTF-8");
response.setHeader("Cache-Control","no-cache"); // HTTP 1.1
response.setHeader("Pragma","no-cache"); // HTTP 1.0
response.setDateHeader ("Expires", -1); // Prevents caching at the proxy server
%>
<html>
<head>
<meta http-equiv="content-Type" content="text/html;charset=UTF-8">
<title>���W���U��</title>
</head>
<body>
<h2>
���W��Ƶn�J
</h2>
<form action="regisServlet" method="post">
<table  cellspacing="2" cellpadding="1" border="1" width="100%">
<tr>
<td>���W����</td>
	<td> <label for="" class="t1">�a��:</label>
            <select name="location">
            <option value="TPE" selected>�x�_</option>
            <option value="TYU">���</option>
            <OPtion value="HSU">�s��</OPtion>
            <OPtion value="TCH">�x��</OPtion>
            <OPtion value="CHY">�Ÿq</OPtion>
            <OPtion value="TNA">�x�n</OPtion>
            <OPtion value="KHC">����</OPtion>
            </select></td>
</tr>
<tr>
    <td>�m�W:</td>
    <td><input type="text" name="name" autocomplete="off" autofocus placeholder="�m�W" size="10" maxlength="10"></td>
</tr>
<tr>
    <td>�ͤ�:</td>
    <td>
    �褸
    <input type="text" name="birthyear" size="4" maxlength="4">�~
    <input type="text" name="birthmonth" size="2" maxlength="2">��
    <input type="text" name="birthday" size="2" maxlength="2">��    
    </td>
</tr>
<tr>
    <td>�����Ҧr��:</td>
    <td><input type="text" name="id" maxlength="10"maxlength="10" pattern="[a-zA-Z]{1}[1-2,4,7]{1}\d{8}"></td>
</tr>
<tr>
    <td width="150">�p���a�}:</td>
    <td><input type="text" name="address" size="50" maxlength="50"></td>
</tr>
<tr>
    <td>�p���q��:</td>
    <td><input type="text" name="phone" size="20" maxlength="20"></td>
</tr>
<tr>
    <td>E-mail:</td>
    <td><input type="text" name="mailaddress" size="20" maxlength="20"></td>
</tr>
</table>
<center>
<input type="submit" name="submit" value="�e�X">
</center>
</form>
</body>
</html>