<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-09-28
  Time: 09:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<!doctype html>
<html lang="zh" class="no-js">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/reset.css"> <!-- CSS reset -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/style.css"> <!-- Gem style -->
    <script src="${pageContext.request.contextPath}/static/public/jquery-3.5.1.js"></script>
    <style>
        #log_registered{
            display: none;
        }
    </style>
</head>
<body>
<div class="bg-back"></div>
<div style="z-index: 10000;
    position: absolute;
    top: 0;
    left:calc(50% - 244px);
		"  class="cd-user-modal is-visible"> <!-- this is the entire modal form, including the background -->
    <div class="cd-user-modal-container">
        <ul class="cd-switcher">
            <li style="cursor: pointer"><a id="a"  onclick="registered1()"  class="selected">账号密码登录</a></li>
            <li style="cursor: pointer"><a id="b" onclick="registered2()" >注册</a></li>
        </ul>
        <div id="cd-login" class="is-visible is-selected"> <!-- log in form -->
            <form class="cd-form " action="${pageContext.request.contextPath}/login" method="post">
                <p class="fieldset">
                    <label class="image-replace cd-username" for="username">账户名</label>
                    <input class="full-width has-padding has-border" id="username" type="text" name="username" placeholder="请输入账户名" value="">
                    <span class="cd-error-message">账户名错误</span>
                </p>
                <p class="fieldset">
                    <label class="image-replace cd-password" for="password">密码</label>
                    <input class="full-width has-padding has-border" id="password" type="password" name="password"  placeholder="请输入密码" value="123456">
                    <span class="cd-error-message">格式错误!</span>
                </p>
                <p class="fieldset">
                    <label class="image-replace cd-password" for="captcha">验证码</label>
                    <input class="has-padding has-border" id="captcha" type="text" name="captcha"  placeholder="请输入验证码">
                    <img src="${pageContext.request.contextPath}/captcha" style="vertical-align: bottom">
                </p>
                <p class="fieldset">
                    <input type="checkbox" id="remember-me" checked name="remember-me" value="true">
                    <label for="remember-me">记住密码</label>
                </p>
                <p class="fieldset">
                    <input class="full-width" type="submit" value="登录">
                </p>
            </form>
        </div>
        <!-- cd-login -->

        <div id="log_registered" class="is-visible is-selected"> <!-- log in form -->
            <form class="cd-form " action="${pageContext.request.contextPath}/user/registered" method="post">
                <p class="fieldset">
                    <label class="image-replace cd-username" for="username">账户名</label>
                    <input class="full-width has-padding has-border"  type="text" name="userName" placeholder="请输入账户名">
                    <span class="cd-error-message">账户名错误</span>
                </p>
                <p class="fieldset">
                    <label class="image-replace cd-password" for="password">密码</label>
                    <input class="full-width has-padding has-border" type="password" name="password"  placeholder="请输入密码">
                    <span class="cd-error-message">格式错误!</span>
                </p>
                <p class="fieldset">
                    <input class="full-width" type="submit" value="注册">
                </p>
            </form>
        </div> <!-- cd-login -->
    </div> <!-- cd-user-modal-container -->
</div> <!-- cd-user-modal -->
<script>
    function registered1() {
        document.getElementById("cd-login").style.display="block";
        document.getElementById("log_registered").style.display="none";
        $("#b").removeClass("selected");
        $("#a").addClass("selected")

    }


    function registered2() {
        document.getElementById("cd-login").style.display="none";
        document.getElementById("log_registered").style.display="block";
        $("#a").removeClass("selected");
        $("#b").addClass("selected")
    }
</script>
</body>
</html>
