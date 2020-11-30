<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">
    
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>享玩 桌遊</title>
    <link rel=stylesheet type="text/css" href="shopCar.css">
    <style>
	.ast{
    text-decoration:none; 
	width: 100px;
	text-align: center;
	font-size: larger;
	margin-right: 100px;
	font-weight: bold;
	padding: 5px;
	background-image: none;
	border:none;
	}
    </style>
</head>
<body>
    <header>
        <div>
            <ul class="listst1">
                <li>
                    	<p style="font-size: xx-large;font-weight: bold; width: fit-content; margin-left: 10px;margin-bottom: 0px;">
                        <a href="http://10.31.25.26:8080/Project/首頁/首頁.html" class="ast"><big><big>享玩 桌遊</big></big>
                        </a>
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
            <div class="container">
                <span style="margin-left: 100px ;">網站起源</span>
                <span>最新消息</span>
                <a href="http://localhost:8080/Project/Standard/Main_page.html">分類檢索</a>
                <a href="http://localhost:8080/MD2/shopCarJsp.jsp">購物車</a>
                <a href="http://localhost:8080/boardgames/F1.jsp">討論區</a>
                <a href="http://localhost:8080/JSPCrud/loginPage.jsp">會員中心</a>
                <span>聯絡我們</span>
            </div>
        </nav>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    </header>
    <article>
    <script src="shopCar.js"></script>
        <button type="button" id='myWantBuy' style="margin-left: 500px; background-color:gray;">我的購物清單</button><button type="button" id='myLike'>我的追蹤清單</button><button type="button" id='myBuy'>出貨進度查詢</button><br>
        <div style="height:600px;">
	        <div id="WhichBuy" style="width: 900px; margin-left: 500px; background-color: white; overflow:auto; height:">
	            <table id="buyList">
	            </table>
	        </div>
	        <div style="text-align: right;  width: 900px;  margin-left: 500px; background-color: #e2dfdd;">
	            <span style="border: none; margin: 0;"><big><big>目前金額共</big></big></span><span style="border: none; margin: 0; " id="totalMoney"><big><big>0</big></big></span><span style="border: none; margin: 0;"><big><big>元</big></big></span>
	        </div>
	    </div>
	    <div style="text-align: center;">
         <button id="showAnother" style="height: 30px;">刷新看其他商品</button>
        </div>
        <div id="myDiv" style="item-align:center;background-color:white;width:900px; margin-left: 500px;">
        	<div style="float:left; margin-left: 50px; width: 95px; text-align:center;"><img style="width:95px"/><button style="width:95px">加入購物車</button></div>
        	<div style="float:left; margin-left: 50px; width: 95px; text-align:center;"><img style="width:95px"/><button style="width:95px">加入購物車</button></div>
        	<div style="float:left; margin-left: 50px; width: 95px; text-align:center;"><img style="width:95px"/><button style="width:95px">加入購物車</button></div>
        	<div style="float:left; margin-left: 50px; width: 95px; text-align:center;"><img style="width:95px"/><button style="width:95px">加入購物車</button></div>
        	<div style="float:left; margin-left: 50px; width: 95px; text-align:center;"><img style="width:95px"/><button style="width:95px">加入購物車</button></div>
        	<div style="float:left; margin-left: 50px; width: 95px; text-align:center;"><img style="width:95px"/><button style="width:95px">加入購物車</button></div>
        </div>
    </article>
    <footer style="clear: both;">
        <section>
            <p>本網站僅供中壢資策會 EEIT125-第三組練習使用 圖片僅供教學使用，無侵權疑慮</p>

        </section>
    </footer>

</body>

</html>