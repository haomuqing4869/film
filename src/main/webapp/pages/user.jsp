
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户信息</title>
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/static/image/07.ico" media="screen" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/public.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/user.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/public/bootstrap-4.4.1/dist/css/bootstrap.css">
    <link href="https://cdn.bootcss.com/font-awesome/5.8.0/css/all.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/static/public/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/public/bootstrap-4.4.1/dist/js/bootstrap.js"></script>
</head>
<body>
<!-- 输入框 -->
<jsp:include page="header.jsp"/>

<div class="content-box">

    <aside>
        <div class="user">
            <img src="${pageContext.request.contextPath}${me.userphoto}" alt="">
            <p class="user-name">${me.userName}</p>
            <p class="user-a"><a href="${pageContext.request.contextPath}/user/find">个人资料</a></p>
        </div>
        <div class="jiange"></div>
        <ul>
            <li class="liinfo"><a href="${pageContext.request.contextPath}/user/find">个人中心</a></li>
            <li><a href="${pageContext.request.contextPath}/userorder/findorder?page=1&pagesize=2">我的订单</a></li>
        </ul>
    </aside>

    <div class="userinfo">
        <div class="myart">
            <p class="currenthead" id="userinfo_head1"></p>

        </div>


        <!-- block1 -->
        <div class="block1">
            <div class="thumb">
                <img src="${pageContext.request.contextPath}${me.userphoto}" alt="">
            </div>
            <div class="thumbinfo">
<%--                <p>点击头像编辑</p>--%>
            </div>

            <p class="infohead"><span>基本信息</span></p>

            <form action="${pageContext.request.contextPath}/user/update" method="post">
                <div class="from-group">
                    <label>用户名</label>
                    <input type="text" name="userName" value="${me.userName}">
                </div>

<%--                <div class="from-group">--%>
<%--                    <label>密码</label>--%>
<%--                    <input type="password" name="password" value="${me.password}">--%>
<%--                </div>--%>
<%--                <button class="btn btn-primary form-btn" type="submit"><span>保存</span></button>--%>
            </form>
        </div>

        <!-- block2 -->
        <div class="block2">

        </div>

    </div>

</div>

<script>

    $(function(){
        // 设置登录按钮的显示隐藏效果
        $(".login").mouseenter(function(){
            $(this).children(".usrmess").stop();
            $(this).children(".usrmess").show(1000);
        })
        $(".login").mouseleave(function(){
            $(this).children(".usrmess").stop();
            $(this).children(".usrmess").hide(1000);
        })
    })
</script>

</body>
</html>

