<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="Header/header_style.css">
<link rel="stylesheet" href="Header/newinfo.html">
<script src="http://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
<Script text="text/javascript">
	$(document).ready(function() {
		$("#optionmenu>dd>dl>dd").hide();
		$.each($("#optionmenu>dd>dl>dt"), function() {
			$(this).click(function() {
				$("#optionmenu>dd>dl>dd ").not($(this).next()).slideUp();
				$(this).next().slideToggle(500);
				//$(this).next().toggle();
			});
		});
	});
</script>
</Script>
</head>
<style>
.menu {
	background-image: url(Header/墨綠色背景.jpg);
	width: 150px;
	height: 700px;
	float: left;
	font-size: x-large;
	color: white;
	text-align: center;
	border-radius: 20px;
}

#optionmenu {
	width: 150px;
	text-align: center;
	font-size: 12px;
}

#optionmenu dd dl dt {
	border-top: 2px solid #dedede;
	height: 25px;
	line-height: 25px;
	font-weight: bold;
	background-image: url(墨綠色背景.jpg);
	font-size: x-large;
	color: white;
}

#optionmenu ul {
	background: #f9f9f9;
}

#optionmenu li {
	border-top: 1px 0px 1px 0px solid #efefef;
	line-height: 25px;
}

.box1, .box2, .box3 {
	float: left;
	width: 400px;
}
</style>
<body>

	<article>
		<header>
			<div>
				<ul class="listst1">
					<li>
						<p
							style="font-size: xx-large; font-weight: bold; width: fit-content; margin-left: 10px; margin-bottom: 0px;">
							<a href="http://10.31.25.26:8080/Project/首頁/首頁.html"
								style="text-decoration: none;"><big><big><big>享玩
											桌遊</big></big> </big></a>
						</p>
					</li>
					<p style="font-size: larger; font-weight: bold;">
						<big>讓因桌遊而產生的歡笑&emsp;充滿生命中的每分每秒</big>
					</p>
				</ul>
			</div>
			<hgroup>
				<h2 style="width: fit-content;">放輕心情</h2>
				<h2 style="width: fit-content;">&emsp;&emsp;&emsp;&emsp;享受與親友</h2>
				<h2 style="width: fit-content;">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;共同度過的桌遊時光</h2>
			</hgroup>
			<nav>
				<div>
					<span style="margin-left: 100px;">網站起源</span> <span>最新消息</span> <span>分類檢索</span>
					<span>購物車</span> <span>討論區</span> <span>會員中心</span> <span>聯絡我們</span>
				</div>
			</nav>
		</header>

		<div class="menu">
			<h3>最新消息</h3>
			<dl id="optionmenu">
				<dd>
					<dl>
						<dt>新品上架</dt>
						<dd>
							<ul>
								<li><a href=#>語文</a></li>
								<li><a href=#>數學</a></li>
								<li><a href=#>自然</a></li>
								<li><a href=#>社會</a></li>
								<li><a href=#>科技</a></li>
								<li><a href=#>藝術</a></li>
								<li><a href=#>綜合</a></li>
							</ul>
						</dd>
					</dl>
				</dd>
				<dd>
					<dl>
						<dt>
							<a href="regisact.html">課程資訊</a>
						</dt>
					</dl>
				</dd>
				<dd>
					<dl>
						<dt>活動消息</dt>
						<dd>
							<ul>
								<li><a href=#>新竹</a></li>
								<li><a href=#>嘉義</a></li>
								<li><a href=#>彰化</a></li>
								<li><a href=#>高雄</a></li>
								<li><a href=#>台南</a></li>
								<li><a href=#>桃園</a></li>
								<li><a href=#>台北</a></li>
								<li><a href=#>台中</a></li>
							</ul>
						</dd>
					</dl>
				<dd>
					<dl>
						<dt>開箱試玩</dt>
						<dd>
							<ul>
								<li>最新開箱</li>
								<li>玩法介紹</li>
								<li>比賽直播</li>
							</ul>
						</dd>
					</dl>
				<dd>
					<dl>
						<dt>
							<a href=Controler.jsp>管理者系統</a>
						</dt>
					</dl>
		</div>
		<div class="box1">
			<form action="activityServlet" method="get">
				<div class="st1">
					<div class="form">
						<legend>
							<table cellspacing="2" cellpadding="1" width="100%">
								活動查詢
								<input class="sch" type="text" placeholder="請輸入關鍵字"
									name="search" value="" aria-label="Search">
								<button class="schbut" type="submit">Search</button>

							</table>
						</legend>
			</form>
		</div>
		<div = class=box2>
			<figure class="f1">
				<form action="activityServlet" method="get">
					<div class="update form">
						<legend>
							<h3>新增活動</h3>
							<table cellspacing="2" cellpadding="1" border="1" width="100%">
								<tr>
									<td><label class="u1">活動區域:</label></td>
									<td><input type="text" name="area"></td>
								</tr>
								<tr>
									<td><label class="u1">類型:</label></td>
									<td><input type="text" name="activity"></td>
								</tr>
								<tr>
									<td><label class="u1">活動形式:</label></td>
									<td><input type="text" name="type"></td>
								</tr>
								<tr>
									<td><label class="u1">活動時間(1):</label></td>
									<td><input type="text" name="date_time_1"></td>
								</tr>
								<tr>
									<td><label class="u1">活動時間(2):</label></td>
									<td><input type="text" name="date_time_2"></td>
								</tr>
								<tr>
									<td><label class="u1">活動天數:</label></td>
									<td><input type="text" name="day"></td>
								</tr>
								<tr>
									<td><label class="u1">活動地點:</label></td>
									<td><input type="text" name="location"></td>
								</tr>
								<tr>
									<td><label class="u1">活動地址:</label></td>
									<td><input type="text" name="address"></td>
								</tr>
								<tr>
									<td><label class="u1">人數限制:</label></td>
									<td><input type="text" name="limit_per"></td>
								</tr>
								<tr>
									<td><label class="u1">活動費用:</label></td>
									<td><input type="text" name="cost"></td>
									</figcaption>
									</div>
									<div class="sub">
										<input type="submit" name="submit" value="新增"> <input
											type="reset" name="reset" value="重設">
									</div>
								</tr>
							</table>
						</legend>
					</div>
				</form>
			</figure>
		</div>

		<div class="box3">
			<figure class="f1">
				<form action="activityServlet" method="get">
					<h3>
						刪除活動
						<h3>
							<table cellspacing="2" cellpadding="1" border="1" width="100%">
								<tr>
									<td><label class="u1">活動區域:</label></td>
									<td><input type="text" name="area"></td>
								</tr>
								<tr>
									<td><label class="u1">類型:</label></td>
									<td><input type="text" name="activity"></td>
								</tr>
								<tr>
									<td><label class="u1">活動形式:</label></td>
									<td><input type="text" name="type"></td>
								</tr>
								<tr>
									<td><label class="u1">活動時間:</label></td>
									<td><input type="text" name="date_time_1"></td>
								</tr>
								<input type="submit" name="delete" value="刪除">
								<input type="reset" name="reset" value="重設">
							</table>
				</form>
			</figure>
		</div>
</body>

</html>