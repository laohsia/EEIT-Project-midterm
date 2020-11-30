<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="e_name" value="${param.e_name}"></c:set>

<sql:setDataSource var="ds" dataSource="jdbc/TableGameDB" />
<sql:query sql="select * from product where E_name like N'%${e_name}%'" var="rs" dataSource="${ds}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>遊戲資料編輯</title>
<link rel="stylesheet" href="Standard.css">
    <!--  <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">-->
<style>
.edit_form{
	background-image: url(image/墨綠色背景.jpg);
    float: left;
    margin-left: 20px;
    font-size:x-large;
    border-radius:15px;
    padding:15px;
}
</style>
</head>
<body>

<head>
        <div>
            <ul class="standard_listst1">
                <li>
                    <p style="font-size: xx-large;font-weight: bold; width: fit-content; margin-left: 10px;margin-bottom: 0px;">
                        <a href="http://10.31.25.26:8080/Project/首頁/首頁.html" style="text-decoration:none;"><big><big><big>享玩 桌遊</big></big>
                        </big></a>
                    </p>
                </li>
                <p style="font-size: larger;font-weight:bold;"><big>讓因桌遊而產生的歡笑&emsp;充滿生命中的每分每秒</big></p>
            </ul>
        </div>
        <hgroup class="standard_hgroup">
            <h2 style="width: fit-content;">放輕心情</h2>
            <h2 style="width: fit-content;">&emsp;&emsp;&emsp;&emsp;享受與親友</h2>
            <h2 style="width: fit-content;">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;共同度過的桌遊時光</h2>
        </hgroup>
    </head>
    <nav class="standard_nav">
        <div>
            <span class="standard_span" style="margin-left: 80px ;margin-right: 80px;">網站起源</span>
            <span class="standard_span" style="margin-right: 80px;">最新消息</span>
            <span class="standard_span" style="margin-right: 80px;">分類檢索</span>
            <span class="standard_span" style="margin-right: 80px;">購物車</span>
            <span class="standard_span" style="margin-right: 80px;">討論區</span>
            <span class="standard_span" style="margin-right: 80px;">會員中心</span>
            <span class="standard_span" style="margin-right: 80px;">聯絡我們</span>
        </div>

    </nav>

    <div class="standard_nav" style="width:200px;height: fit-content;float: left;">
        <p style="margin-left: 10px; font-size: 35px;font-weight: bold;color: rgb(234, 241, 171);">分類檢索表</p>
        <ul class="standard_ul">
            <li>英文名稱
                <img src="image/箭頭.png" class="standard_imgst" onclick="Ename()">
                <div id="ename" class="standard_divst1">
                </div>
            </li>
            <li>中文名稱
                <img src="image/箭頭.png" class="standard_imgst" onclick="Cname()">
                <div id="cname" class="standard_divst1">
                </div>
            </li>
            <li>遊戲作者
                <img src="image/箭頭.png" class="standard_imgst" onclick="Gmaker()">
                <div id="gmaker" class="standard_divst1">
                </div>
            </li>
            <li>插畫家
                <img src="image/箭頭.png" class="standard_imgst" onclick="Iss()">
                <div id="iss" class="standard_divst1">
                </div>
            </li>
            <li>年齡
                <img src="image/箭頭.png" class="standard_imgst" onclick="Age()">
                <div id="age" class="standard_divst1"></div>
            </li>
            <li>類型
                <img src="image/箭頭.png" class="standard_imgst" onclick="Type()">
                <div id="type" class="standard_divst1"></div>
            </li>
            <li>遊戲人數
                <img src="/image/箭頭.png" class="standard_imgst" onclick="People()">
                <div id="people" class="standard_divst1"></div>
            </li>
            <li>遊戲時間
                <img src="image/箭頭.png" class="standard_imgst" onclick="Time()">
                <div id="time" class="standard_divst1"></div>
            </li>
            <li>遊戲價格
                <img src="image/箭頭.png" class="standard_imgst" onclick="Price()">
                <div id="price" class="standard_divst1"></div>
            </li>

<a href="http://10.31.25.26:8080/Project/Standard/Advanced_Search2.html">
			<li>進階查詢</li>
		</a>
            <a href="">
                <li>管理員介面 </li>
            </a>

        </ul>
    </div>
    <div>

    </div>

<div class="edit_form">
<form action="../Controller" method="post">
<h2 style="color:beige">欲修改之遊戲內容</h2>
  <table border="1" style="background-color:beige;font-size:x-large;text-align:center">
  	<th>英文名稱</th>
    <th>中文名稱</th>
    <th>圖片</th> 
    <th>作者</th>
    <th>插畫家</th>
    <th>遊戲資訊</th>
    <th>價錢</th>
    <c:forEach var="row" items="${rs.rows}">
    <tr>
    <td style="width:100px;height:50px"><input type="text" name="e_name" value="${row.e_name}"></td>
    <td style="width:100px;height:50px"><input type="text" name="c_name" value="${row.c_name}"></td>
    <td style="width:100px;height:50px"><input type="text" name="img_url" value="${row.img_url}"></td>
    <td style="width:100px;height:50px"><input type="text" name="g_maker" value="${row.G_maker}"></td>
    <td style="width:100px;height:50px"><input type="text" name="iss" value="${row.iss}"></td>
    <td style="width:fit-content;height:fit-content"><input style="width:400px" type="textarea" name="info" value="${row.info}"></td>
    <td style="width:50px;height:50px"><input type="text" name="price" value="${row.Price}"></td>
    </tr>
    </c:forEach>
  </table>
    <input type="submit" value="確認修改" onclick="warnning()" name="update">
    <input type="reset" value="清除全部">
    </form>
    </div>
    <script>
		function warnning() {
			window.alert('資料即將產生異動!')
		}
	</script>
	<script src="Standard.js"></script>
</body>
</html>