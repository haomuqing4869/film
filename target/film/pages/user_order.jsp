<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>订单</title>
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/static/image/07.ico"
          media="screen"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/public.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/user-order.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/public/bootstrap-4.4.1/dist/css/bootstrap.css">
    <link href="https://cdn.bootcss.com/font-awesome/5.8.0/css/all.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/static/public/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/public/bootstrap-4.4.1/dist/js/bootstrap.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="content-box">
    <!-- 侧边栏 -->
    <aside>
        <div class="user">
            <img src="${pageContext.request.contextPath}${me.userphoto}" alt="">
            <p class="user-name">${me.userName}</p>
            <p class="user-a"><a href="${pageContext.request.contextPath}/user/find">个人资料</a></p>
        </div>
        <div class="jiange"></div>
        <ul>
            <li><a href="${pageContext.request.contextPath}/user/find">个人中心</a></li>
            <li class="liinfo"><a
                    href="${pageContext.request.contextPath}/userorder/findorder?page=1&pagesize=2">我的订单</a></li>
        </ul>
    </aside>


    <!-- 右边内容部分 -->
    <div class="userinfo">
        <div class="myart">
            <p class="currenthead" id="userinfo_head1">我的订单</p>
        </div>


        <div class="block2">
            <c:forEach items="${orders.list}" var="order">
                <div class="list">
                    <div class="list-header">
                        <p>${order.tSchedule.scheduledate}</p>
                    </div>
                    <div class="list-content">
                        <div class="list-left">
                            <div class="left-img">
                                <img src="${pageContext.request.contextPath}${order.tMovie.moviephoto}" alt="">
                            </div>
                            <div class="left-content">
                                <h4>${order.tMovie.moviename}</h4>
                                <p>${order.tMoviehall.moviehallname}</p>
                                <p>${order.rowsindex}排${order.cols}座</p>
                                <p>${order.tSchedule.scheduledate} ${order.tSchedule.scheduletime}</p>
                            </div>
                        </div>
                        <div class="list-right">
                            <span class="paid">${order.statusStr}</span>
                            <c:if test="${order.status != 0 && order.status !=3}">
                                <form action="${pageContext.request.contextPath}/userorder/cancel">
                                    <input type="hidden" name="orderid" value="${order.orderid}">
                                    <button type="submit" class="cancel-order">取消订单</button>
                                </form>
                            </c:if>
                            <c:if test="${order.status == 0}">
                                <form action="${pageContext.request.contextPath}/pay">

                                    <input type="hidden" name="WIDout_trade_no" value="${order.orderid}">
                                    <input type="hidden" name="WIDsubject" value="${order.tMovie.moviename}">
                                    <input type="hidden" name="WIDtotal_amount" value="${order.price}">
                                    <input type="hidden" name="WIDbody" value="${order.tMovie.moviename}">
                                    <button type="submit" class="cancel-order">支付</button>
                                </form>
                            </c:if>

                        </div>
                    </div>

                </div>
            </c:forEach>
        </div>

        <div class="page">
            <ul class="pagination container">
                <li class="page-item"><a
                        href="${pageContext.request.contextPath}/userorder/findorder?page=0&pagesize=${pages.pageSize}"
                        class="page-link">首页</a></li>
                <li class="page-item"><a
                        href="${pageContext.request.contextPath}/userorder/findorder?page=${pages.page-1}&pagesize=${pages.pageSize}"
                        class="page-link">上一页</a></li>
                <c:forEach begin="1" end="${pages.total}" var="p">
                    <li class="page-item">
                        <a href="${pageContext.request.contextPath}/userorder/findorder?page=${p}&pagesize=${pages.pageSize}"
                           class="page-link">${p}</a>
                    </li>
                </c:forEach>
                <li class="page-item"><a
                        href="${pageContext.request.contextPath}/userorder/findorder?page=${pages.page+1}&pagesize=${pages.pageSize}"
                        class="page-link">下一页</a></li>
                <li class="page-item"><a
                        href="${pageContext.request.contextPath}/userorder/findorder?page=${pages.total}&pagesize=${pages.pageSize}"
                        class="page-link">尾页</a></li>
            </ul>
        </div>

    </div>

</div>


<script>

    $(function () {

        // 设置登录按钮的显示隐藏效果
        $(".login").mouseenter(function () {
            $(this).children(".usrmess").stop();
            $(this).children(".usrmess").show(1000);
        })
        $(".login").mouseleave(function () {
            $(this).children(".usrmess").stop();
            $(this).children(".usrmess").hide(1000);
        })


        // 获取当前的时间
        let time = new Date();
        $(".date").text(time.toLocaleString())

    })


</script>

</body>
</html>
