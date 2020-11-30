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
<title>會員清單</title>
<link rel="stylesheet" href="header.css">
    <link rel="stylesheet" href="login.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
</head>
<body>

<%@page import="userDAO.UserDao,userBean.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <header>
        <div>
            <ul class="listst1">
                <li>
                    			<p style="font-size: xx-large;font-weight: bold; width: fit-content; margin-left: 10px;margin-bottom: 0px;">
                        <a href="http://10.31.25.26:8080/Project/首頁/首頁.html" style="text-decoration:none;"><big><big><big>享玩 桌遊</big></big>
                        </big></a>
                    </p>
                </li>
                <p style="font-size: larger;font-weight:bold;"><big>讓因桌遊而產生的歡笑&emsp;充滿生命中的每分每秒</big></p>
            </ul>
        </div>
        <hgroup>
            <h2 style="width: fit-content;">放輕心情</h2>
            <h2 style="width: fit-content;">&emsp;&emsp;&emsp;&emsp;享受與親友</h2>
            <h2 style="width: fit-content;">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;共同度過的桌遊時光</h2>
        </hgroup>
        <nav>
            <div>
                <span style="margin-left: 100px ;">網站起源</span>
                <span>最新消息</span>
                <span>分類檢索</span>
                <span>購物車</span>
                <span>討論區</span>
                <span>會員中心</span>
                <span>聯絡我們</span>
            </div>
        </nav>

    </header>
<%
List<User> list=UserDao.getAllRecords();
request.setAttribute("list",list);
%>
<form>
<fieldset>
			<legend class="ti">會員清單</legend>
<table border="1" width="90%">
<tr><th>帳號ID</th><th>密碼Password</th><th>姓名Name</th><th>性別Gender</th><th>生日Birthday</th><th>手機Phone</th><th>信箱E-mail</th><th>會員資料編輯</th><th>會員資料刪除</th></tr>
<c:forEach items="${list}" var="u">
	<tr><td>${u.getAccount()}</td><td>${u.getPassword()}</td><td>${u.getName()}</td><td>${u.getGender()}</td><td>${u.getBirthday()}</td><td>${u.getPhone()}</td><td>${u.getMailaddress()}</td>
	<td><a href="editform.jsp?account=${u.getAccount()}">編輯</a></td>
	<td><a href="deleteuser.jsp?account=${u.getAccount()}">刪除</a></td></tr>
</c:forEach>
</table>
<br/><a class="link" href="adduserform.jsp">註冊新會員</a>
<img class="img1" src="images/5.png">
		</fieldset>
	</form>
</body>
</html>