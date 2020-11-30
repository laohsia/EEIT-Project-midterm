<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.0.js"></script>  
       
<script>  
	var i=0;
    function jsonAjaxPost(){
    	i=i+1;
        $.ajax({  
            type:"post", 
            url:"GsonServlet",   
            dataType:"json",//设置返回数据的格式 ，请求成功后的回调函数 data为json格式  
            success:
                function(data){  
                    $("#resultJsonText").text("name："+data[0].success);  
                },  
            error:
                function(xhr, ajaxOptions, thrownError){
                    console.log(xhr.status+"\n"+thrownError);
                }
        });
        $("#resultJsonText").html(i)
    }  
</script>  
</head>
<body>


<input type="button" id="btn" name="btn" value="點我" onclick="jsonAjaxPost()">
<div id="resultJsonText"></div>
</body>
</html>