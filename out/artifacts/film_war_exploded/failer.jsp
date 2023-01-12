<%--
  Created by IntelliJ IDEA.
  User: 49020
  Date: 2020/8/9
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="refresh" content="3;url=${pageContext.request.contextPath}/login.html">
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css">
    <title>登录失败</title>
    <script type="text/javascript">
        function info() {
            //循环执行,1秒执行一次
            window.setInterval("daojishi()", 1000);
        }

        function daojishi() {
            if (document.getElementById("msg").innerHTML != 1) {
                document.getElementById("msg").innerHTML = document.getElementById("msg").innerHTML - 1;
            }
        }
    </script>
</head>
<body>
    <div class="alert alert-success" role="alert" οnlοad="info()">
        <p style="text-align: center;">用户名或密码错误,<span id="msg">3</span>秒返回登录页面...</p>
    </div>
</body>
</html>
