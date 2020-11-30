<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="content-Type" content="text/html;charset=UTF-8">
    <title>報名表單</title>
    <link rel="stylesheet" href="Header/regisform_style.css">
</head>
<body>
    <form action="regisServlet" method="post">
        <div class="form">
            <div class="st1">
            <legend>
                <h3>報名場次</h3>
                        <label for="" class="t1">地區:</label>
                        <select name="location">
                            <option value="台北" selected>台北</option>
                            <option value="桃園">桃園</option>
                            <OPtion value="新竹">新竹</OPtion>
                            <OPtion value="台中">台中</OPtion>
                            <OPtion value="嘉義">嘉義</OPtion>
                            <OPtion value="台南">台南</OPtion>
                            <OPtion value="高雄">高雄</OPtion>
                        </select><br>                
                    </legend>           
            </div>
            <br>
            <div class="st2">
                <label class="t1" for="account1">姓名:</label><br>
                <input type="text" id="name" name="name" autocomplete="off" autofocus placeholder="姓名" size="10"
                    maxlength="10">
            <br>
                <label class="t1">生日:</label><br>
                西元
                <input type="text" name="birthyear" size="4" maxlength="4" autofocus placeholder="yyyy">年
                <input type="text" name="birthmonth" size="2" maxlength="2" autofocus placeholder="mm">月
                <input type="text" name="birthday" size="2" maxlength="2"autofocus placeholder="dd">日
            <br>
                <label class="t1">身分證字號:</label><br>
                <input type="text" name="id" maxlength="10" pattern="[a-zA-Z]{1}[1-2,4,7]{1}\d{8}">
            <br>

                <label for="" class="t1">聯絡地址:</label><br>
                <input type="text" name="address" size="50" maxlength="50" autofocus placeholder="居住地址">
            <br>
                <label for="" class="t1">聯絡電話:</label><br>
                <input type="text" name="phone" size="20" maxlength="20">
            <br>
                <label for="" class="t1">E-mail:</label><br>
                <input type="text" name="mailaddress" size="20" maxlength="20">
            </div>
            </fieldset>
                <div class="sub">
                <input type="submit" name="submit" value="送出">
                <input type="reset" name="reset" value="取消">
            </div>
        </div>
    </form>
</body>

</html>