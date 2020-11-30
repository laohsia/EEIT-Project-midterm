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
<html>
<head>
<meta charset="UTF-8">
<title>會員資料編輯</title>
 <link rel="stylesheet" href="header.css">
    <link rel="stylesheet" href="login.css">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
</head>
<body>
<%@page import="userDAO.UserDao,userBean.User"%>
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
String account=request.getParameter("account");
User u =UserDao.getRecordById(account);
%>
<form action="edituser.jsp" method="post">
  <fieldset>
        <legend class="ti">會員資料編輯</legend>
        <table cellspacing="2" cellpadding="1" width="100%"> 
<tr><td>帳號Account:</td><td><input type="hidden" name="account" value="<%=u.getAccount()%>"/><%=u.getAccount()%></td></tr>
<tr><td>密碼Password:</td><td><input type="text" name="password" value="<%= u.getPassword()%>"/></td></tr>
<tr><td>姓名Name:</td><td><input type="text" name="name" value="<%= u.getName()%>"/></td></tr>
<tr><td>性別Gender:</td><td><input type="radio" name="gender" value="male" checked="checked"/>男<input type="radio" name="gender" value="female"/>女</td></tr>
<tr><td>生日birthday:</td><td><input type="date" name="birthday" value="<%= u.getBirthday()%>"/></td></tr>
<tr><td>手機Phone:</td><td><input type="text" name="phone" value="<%= u.getPhone()%>"/></td></tr>
<tr><td>信箱E-Mail:</td><td><input type="email" name="mailaddress" value="<%= u.getMailaddress() %>"/></td></tr>
</td></tr>
<tr><td colspan="2"><input class="login" type="submit" value="送出修改"/></td></tr>
</table>
        <br>
        <img class="img1" src="images/5.png">
    </fieldset>
    </form>
</body>
</html>