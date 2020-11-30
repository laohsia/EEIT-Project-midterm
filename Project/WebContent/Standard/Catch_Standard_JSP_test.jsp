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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Standard.css">
</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %>

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
    <div class="standard_nav"
	style="width: 200px; height: fit-content; float: left;">
	<p
		style="margin-left: 10px; font-size: 35px; font-weight: bold; color: rgb(234, 241, 171);">分類檢索表</p>
	<ul class="standard_ul">
		<li>英文名稱 <img src="image/箭頭.png" class="standard_imgst"
			onclick="Ename_test()">
			<form id="fid1" action="Catch_Standard_JSP_test.jsp" method="get"
				style="display: none">
				<input type='text' style='width: 100px' name="e_name"> <input
					type='submit' value='送出'>
			</form>
		</li>
		<li>中文名稱 <img src="image/箭頭.png" class="standard_imgst"
			onclick="Cname_test()">
			<form id="fid2" action="Catch_Standard_JSP_test2.jsp" method="get"
				style="display: none">
				<input type='text' style='width: 100px' name="c_name"> <input
					type='submit' value='送出'>
			</form>
		</li>
		<li>遊戲作者 <img src="image/箭頭.png" class="standard_imgst"
			onclick="Gmaker_test()">
			<form id="fid3" action="Catch_Standard_JSP_test3.jsp" method="get"
				style="display: none">
				<input type='text' style='width: 100px' name="gmaker"> <input
					type='submit' value='送出'>
			</form>

		</li>
		<li>插畫家 <img src="image/箭頭.png" class="standard_imgst"
			onclick="Iss_test()">
			<form id="fid4" action="Catch_Standard_JSP_test4.jsp" method="get"
				style="display: none">
				<input type='text' style='width: 100px' name="iss"> <input
					type='submit' value='送出'>
			</form>
		</li>
		<li>類型 <img src="image/箭頭.png" class="standard_imgst" onclick="Type_test()">
                <form id="fid6" action=Catch_Standard_JSP_test6.jsp method="get" style="display:none;font-size:smaller";>
				<input type="radio" name="type" value="大腦">大腦
				<input type="radio" name="type" value="樂齡">樂齡
				<br>
				<input type="radio" name="type" value="言語">言語
				<input type="radio" name="type" value="紙牌">紙牌
				<br>
				<input type="radio" name="type" value="讀物">讀物
				<input type="radio" name="type" value="競速">競速
				<br>
				<input type="radio" name="type" value="猜心">猜心
				<input type="radio" name="type" value="巧手">巧手
				<br>
				<input type="radio" name="type" value="派對">派對
				<input type="radio" name="type" value="陣營">陣營
				<br>
				<input type="radio" name="type" value="合作">合作
				<input type="radio" name="type" value="重策略">重策略
				<br>
				<input type="radio" name="type" value="中策略">中策略
				<input type="radio" name="type" value="輕策略">輕策略
				<br>
				<input type='submit' value='送出'>
				<input type='reset' value='清除'>
				</form>
            </li>
		<li>遊戲人數 <img src="image/箭頭.png" class="standard_imgst"
			onclick="People_test()">
			<form id="fid7" action=Catch_Standard_JSP_test6.jsp method="get"
				style="display: none;font-size:smaller";>
				<input type="radio" name="type" value="1-2人">1-2人 <input
					type="radio" name="type" value="6人">6人+ <input
					type='submit' value='送出'> <input type='reset' value='清除'>
			</form>
		</li>
		<li>遊戲價格 <img src="image/箭頭.png" class="standard_imgst"
			onclick="Price_test()">
			<form id="fid8" action=Catch_Standard_JSP_test7.jsp method="get"
				style="display: none;font-size:smaller";>
				<input type="radio" name="price" value="between 0 and 500">$
				0-500 <br> <input type="radio" name="price"
					value="between 500 and 1000">$ 500-1000 <br> <input
					type="radio" name="price" value="between 1000 and 1500">$
				1000-1500 <br> <input type="radio" name="price"
					value="between 1000 and 1500">$ 1500-2000 <br> <input
					type="radio" name="price" value=">2000">$ 2000+ <br> <input
					type='submit' value='送出'> <input type='reset' value='清除'>
			</form>
		</li>
<a href="http://10.31.25.26:8080/Project/Standard/Advanced_Search2.html">
			<li>進階查詢</li>
		</a>
		<a href="manager_page.html">
			<li>管理員介面</li>
		</a>
	</ul>
</div>

<h2>搜尋結果 :  <c:out value="${rs.rowCount}"></c:out> 筆資料</h2>
  <table border="1" style="background-color:beige;font-size:x-large;text-align:center">
  	<th>英文名稱</th>
    <th>中文名稱</th>
    <th>圖片</th> 
    <th>作者</th>
    <th>插畫家</th>
    <th>遊戲資訊</th>
    <th>價錢</th>
    <th>   </th>
    <c:forEach var="row" items="${rs.rows}">
    <tr>
    <td style="width:100px">${row.e_name}</td>
    <td style="width:100px">${row.c_name}</td>
    <td><img src="${row.img_url}" style="height:200px;width:200px"/></td>
    <td style="width:100px">${row.G_maker}</td>
    <td style="width:100px">${row.iss}</td>
    <td style="width:500px">${row.info}</td>
    <td style="width:100px">${row.Price}</td>
    <td style="width:100px"><input type="button" value="購買"></td>
    </tr>
    </c:forEach>
  </table>
<script src="Standard.js"></script>
</body>
</html>