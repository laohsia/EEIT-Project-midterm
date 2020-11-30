<%@page import="java.io.Console"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>享玩 桌遊</title>
    <style>
        @import url("https://fonts.googleapis.com/earlyaccess/cwtexyen.css");

        .delmar{
            margin: 0;
            padding: 0;
        }
        td{
            vertical-align: inherit;
            line-height: 30px;
            border:1px solid black;
            padding: 0 20px;
            word-break: break-all;
            text-align: center;
        }
        table{
            border:1px solid black;
            border-collapse:collapse;
        }
        body {
            font-family: 'cwTeXYen' !important;
            background-image: url(image/木質背景3.jpg);
            /* background-repeat: no-repeat; */
            background-size: cover;
        }

        .divst1 {
            float: left;
            border: 2px solid gray;
            border-radius: 15px;
            height: fit-content;
            background-image: url(image/墨綠色背景.jpg); 
            background-repeat: no-repeat;
            background-size: cover;
            text-align: center;
            padding: 15px;
            margin-left: 20px;
        }

        .divst2 {
            width: 150px;
            height: 750px;
            border: 2px solid gray;
            float: left;
            border-radius: 15px;
            margin-right: 10px;
            background-image: url(image/墨綠色背景.jpg);
            background-repeat: no-repeat;
            background-size: cover;
            opacity: 0.7;
        }

        nav {
            margin-bottom: 20px;
            padding: 10px;
            border: 2px solid gray;
            border-radius: 10px;
            
            background-image: url(image/墨綠色背景.jpg);

        }

        hgroup {
            /* border: 3px solid gray; */
            width: fit-content;
            position: absolute;
            right: 20px;
            top: 20px;
            font-weight: bold
        }

        img {
            width: 70px;
            height: 70px;       
            
        }

        /* figure {
            border: 2px solid gray;
            border-radius: 15px;
            background-image: url(image/木質背景1.jpg);
            background-repeat: no-repeat;
            background-size: cover;
            text-align: center;
        }

        figcaption {
            width: 500px;
            text-align: justify;
            font-weight: bold;
        } */

        span {
            width: 100px;
            text-align: center;
            border: 2px solid gray;
            border-radius: 15px;
            font-size: larger;
            margin-right: 100px;
            font-weight: bold;
            padding: 5px;
            background-image: url(image/木質背景1.jpg);

        }
        .listst1 {
            list-style: none;
            list-style-image: url(image/骰子1.png);
            margin-left: 20px;
        }
        a {
            width: 100px;
            text-align: center;
            border: 2px solid gray;
            border-radius: 15px;
            font-size: larger;
            margin-right: 100px;
            font-weight: bold;
            padding: 5px;
            background-image: url(image/木質背景1.jpg);

        }
    </style>
    
</head>

<body>
    <header>
        <div>
            <ul class="listst1">
                <li>
                    <p style="font-size: xx-large;font-weight: bold; width: fit-content; margin-left: 10px;margin-bottom: 0px;">
                        <big><big><big>享玩 桌遊</big></big></big></p>
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
                <a href="分類檢索表.html">分類檢索</a>
                <span>購物車</span>
                <span>桌遊店地圖</span>
                <span>聯絡我們</span>
            </div>
        </nav>
	
    </header>
    <article>
        <button type="button" id='myWantBuy' style="margin-left: 500px;">我的購物清單</button><button type="button" id='myLike'>我的追蹤清單</button><button type="button" id='myBuy'>出貨進度查詢</button><br>
        <div style="height:600px;">
	        <div id="WhichBuy" style="width: 900px; margin-left: 500px; background-color: white; overflow:auto; height:">
	            <table id="buyList">
	            </table>
	        </div>
	        <div style="text-align: right;  width: 900px;  margin-left: 500px; background-color: #e2dfdd;">
	            <span style="border: none; margin: 0;"><big><big>目前金額共</big></big></span><span style="border: none; margin: 0; " id="totalMoney"><big><big>0</big></big></span><span style="border: none; margin: 0;"><big><big>元</big></big></span>
	        </div>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script> 
	   	let AllBuy = [];
	   	let WaitToDo = [];
	   	var user;
	    var re = /^[0-9]+$/;
	    var doWhich = "";
	    var CName="";
	    var EName="";
	    var buyHowmuch = 1;
		
	   	function checkData() {
	   		let j=0;
	   		for(;j<AllBuy.length;j++){	
    			if(AllBuy[j][4] == EName){
    				alert("該商品已存在");
    				break;
    			}
    		}
	   		if(j==AllBuy.length){
				doWhich = "insert";
		   		backToFace();
			}
		}
	   	function backToFace(){ //新增後端傳來的元素
	   		$.ajax({
	   			withCredentials:true,
   	  			url:"test",
   	  			data: {
   	  				'C_Name':CName,
   	  				'doWhich':doWhich,
   	  				'user':user,
   	  				'buyHowmuch':buyHowmuch,
   	  				'EName':EName,
   	  				},
   	  			dataType: 'json',
   	  			async:false,
   	  			type:'POST',
   	  			success : function(htmlobj){
   	  				switch(doWhich){
   	  					case "":
   	  						console.log(htmlobj[0].Visitors)
   	  						user = "Visitors" + htmlobj[0].Visitors;
   	  						console.log(user)
   	  					case "insert":
			   	  			for(let a=0;a< htmlobj.length; a++){
				   				let s = htmlobj[a]
				   				AllBuy.push([s.imgUrl.toString(),s.message.toString(),s.price.toString(),s.buyHowmuch.toString(),s.E_Name.toString()])	   	  					
			   				}
	   	  					break;
   	  					case "delete":
   	  						break;
   	  					case "update":
   	  						break;
   	  					default:
   	  						break;
   	  				}
	   	  			if(doWhich != ""){
	   	  				createTable();
	   	  			}
   	  			},
   	  			error:function(){console.log("bbb")}
   	  		});
	   	}
	   	$(document).ready(function(){
			   	backToFace();
		   		for(let i=0,j=0;WaitToDo.length<6;i++){
		   			j = Math.floor(Math.random()*AllBuy.length);
	   				WaitToDo.push(AllBuy[j]);
	   				AllBuy.splice(j,1);
		   		}
	   			let i=0;
	   			$("#myDiv").children().each(function(){
   			    	$(this).children("img").attr("src",WaitToDo[i][0])
   			    	$(this).children("button").attr("id",WaitToDo[i][4]).click(function(){
   			    		EName = $(this).attr("id");
   			    		checkData();
   			    	})
   			    	i++;
  			    	})
				AllBuy.length = 0;
			    WaitToDo.length = 0;
	   	})
        function delTitle(){    //隱藏表格標題(如果沒有AllBuy資料的畫執行)
            for(let i=0; i<document.querySelectorAll("#menuBuy").length;i++){
                document.querySelectorAll("#menuBuy")[i].style.display="none";
            }
        }
        function showTitle(){   //顯示表格標題
            for(let i=0; i<document.querySelectorAll("#menuBuy").length;i++){
                document.querySelectorAll("#menuBuy")[i].style.display="";
            }
        }
        function delList(c){    //刪除特定元素
        	EName = AllBuy[c][4];
        	doWhich = "delete";
        	backToFace();
            AllBuy.splice(c,1);
            createTable();
        }
        function SetTotalMoney(){   //顯示於下方的總金額
            document.getElementById('totalMoney').innerHTML = '<big><big>' + totalMoney + '</big></big>';
        }
		function BuyUp(c){
			document.getElementById('countSelect' + c).value++;
			BuySelect(c);
		}
		function BuyDown(c){
			document.getElementById('countSelect' + c).value--;
			BuySelect(c);
		}
		function BuySelect(c){
			if(re.test(document.getElementById('countSelect' + c).value)){
				AllBuy[c][3] = document.getElementById('countSelect' + c).value;
			}
			if(AllBuy[c][3] == 0){
				delList(c);
			}
			else{
				EName = AllBuy[c][4];
	        	doWhich = "updata";
	        	buyHowmuch = AllBuy[c][3];
	        	backToFace();
	        	buyHowmuch = 1;
				createTable();		
			}
		}
        function createTable(){ //建立完整的Table
            document.getElementById('buyList').innerHTML = "";
            totalMoney = 0;
            if(AllBuy.length != 0){
            	if(AllBuy.length > 6){
            		$("#WhichBuy").css("height","500px")
            	}
            	else{
            		$("#WhichBuy").css("height","auto")
            	}
                let s = '<caption><td style="width: 44px;" id="menuBuy">序號</td><td style="width: 101px;" id="menuBuy">商品圖</td><td style="width: 443px;" id="menuBuy">商品名稱</td><td style="width: 90px;" id="menuBuy">單價</td><td style="width: 98px;" id="menuBuy">數量</td><td style="width: 90px;" id="menuBuy">小計</td><td style="width: 76px;" id="menuBuy">變更</td></caption>';
                for(let i = 0; i < AllBuy.length; i++){
                    s += '<tr id="data>' + i + '">';
                    s += '<td>' + (i+1) + '</td>';
                    s += '<td><img src="' + AllBuy[i][0] + '"></td>';
                    s += '<td>' + AllBuy[i][1] + '</td>';
                    s += '<td>' + AllBuy[i][2] + '</td>';
                    s += '<td><button id=countDel' + i + ' style="width:3px;">-</button><input type="text" value="' + AllBuy[i][3] + '" style="width:20px; text-align:center;" id="countSelect' + i + '"><button id=countAdd' + i + ' style="width:3px;">+</button></td>';
                    s += '<td>' + AllBuy[i][2]*AllBuy[i][3] + '</td>';
                    s += '<td><button type="button" id="add' + i + '">追蹤</button><br><button type="button" id="del' + i + '">刪除</button></td>';
                    s += '</tr>';
                    totalMoney += AllBuy[i][2]*AllBuy[i][3];
                }
                document.getElementById('buyList').innerHTML += s;
                createListen();
            }
            SetTotalMoney();
        }

        if(AllBuy.length != 0){
            createTable();
        }

        function createListen(){
            for(let i=0; i<AllBuy.length; i++){
                //document.getElementById('add' + i).addEventListener('click',); //加入追蹤清單
                document.getElementById('del' + i).addEventListener('click',function(){
                    delList(i);
                });
                document.getElementById('countAdd' + i).addEventListener('click',function(){
                	BuyUp(i);
                });
                document.getElementById('countDel' + i).addEventListener('click',function(){
                	BuyDown(i);
                });
                document.getElementById('countSelect' + i).addEventListener('change',function(){
                	BuySelect(i);
                });
            }
        }
    </script>
</body>

</html>