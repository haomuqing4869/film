<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/static/image/07.ico" media="screen" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/public/bootstrap-4.4.1/dist/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/public.css">
    <link href="https://cdn.bootcss.com/font-awesome/5.8.0/css/all.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/static/public/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/public/bootstrap-4.4.1/dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/index.css">
    <title>Document</title>
</head>
<body>
<!-- ****************输入框**************** -->

<jsp:include page="header.jsp"/>

<!-- 轮播图 -->
<div id="demo" class="carousel slide" data-ride="carousel" style="width: 100%; height: 520px;">

    <!-- 指示符 -->
    <ul class="carousel-indicators">
        <li data-target="#demo" data-slide-to="0" class="active"></li>
        <li data-target="#demo" data-slide-to="1"></li>
        <li data-target="#demo" data-slide-to="2"></li>
    </ul>

    <!-- 轮播图片 -->
    <div class="carousel-inner" style="width: 100%; height: 100%;">
        <div class="carousel-item active" style="width: 100%; height: 100%;">
            <img src="${pageContext.request.contextPath}/static/image/四海%20(2).jpg" style="width: 100%; height: 100%;">
        </div>
        <div class="carousel-item">
            <img src="${pageContext.request.contextPath}/static/image/笨小孩.jpg">
        </div>
        <div class="carousel-item">
            <img src="${pageContext.request.contextPath}/static/image/水门桥.jpg">
        </div>
    </div>



    <div class="top">
        <ul>
            <h3 class="ul_h3">热播</h3>
            <c:forEach items="${movies}" var="movie">
                <li>
                    <a href="${pageContext.request.contextPath}/movies/findById?id=${movie.movieid}">${movie.moviename}</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>


<!-- 内容，电影items -->
<!-- <div class="mod_hd" id="mod">
    <div class="mod_hd_list">
        <span class="mod">类型</span>
        <a href="#" class="mod_items">全部</a>
        <a href="#" class="mod_items">喜剧</a>
        <a href="#" class="mod_items">动作</a>
        <a href="#" class="mod_items">科幻</a>
    </div>
</div> -->


<div class="movies_main">
    <div class="section clear">
        <!-- 左侧电影 -->
        <div class="movies_items">
            <div class="items_header clear">
                <h2>喜剧电影</h2>
                <p><a href="${pageContext.request.contextPath}/movies/findBys?sid=1&page=1&pageSize=18">查看更多</a></p>
            </div>
            <c:forEach var="comedys" items="${comedy}">
                <div class="message">
                    <a href="${pageContext.request.contextPath}/movies/findById?id=${comedys.movieid}">
                        <div class="message_img">
                            <img src="${pageContext.request.contextPath}${comedys.moviephoto}" alt="">
                        </div>
                        <div class="name_price clear">
                            <h3>${comedys.moviename}</h3>
                            <span class="price">${comedys.price}￥</span>
                        </div>
                        <span class="data">${comedys.releasedate}</span>
                        <p>${comedys.opera}</p>
                    </a>
                </div>
            </c:forEach>
        </div>
        <!-- 右边侧边栏 -->
        <div class="right_aside">
            <div class="right_header clear">
                <h2>喜剧排行</h2>
                <p><a href="${pageContext.request.contextPath}/movies/findBys?sid=1&page=1&pageSize=18">查看更多</a>
                </p>
            </div>
            <div class="right-content clear">
                <ul class="ul_left">
                    <c:forEach var="lef" items="${l}" varStatus="status">
                        <li>
                            <a href="${pageContext.request.contextPath}/movies/findById?id=${lef.movieid}"><span>${status.index+1}</span>${lef.moviename}
                            </a></li>
                    </c:forEach>
                </ul>
                <ul class="ul_right">
                    <c:forEach var="ri" items="${r}" varStatus="status">
                        <li>
                            <a href="${pageContext.request.contextPath}/movies/findById?id=${ri.movieid}"><span>${status.index+6}</span>${ri.moviename}
                            </a></li>
                    </c:forEach>
                </ul>

                <div class="advertise">
                    <img src="${pageContext.request.contextPath}/static/image/guanggao1.jpg" alt="">
                </div>
            </div>
        </div>
    </div>
    <div class="section clear">
        <!-- 左侧电影 -->
        <div class="movies_items">
            <div class="items_header clear">
                <h2>动作电影</h2>
                <p><a href="${pageContext.request.contextPath}/movies/findBys?sid=2&page=1&pageSize=18">查看更多</a></p>
            </div>
            <c:forEach items="${actions}" var="action">


                <div class="message">
                    <a href="${pageContext.request.contextPath}/movies/findById?id=${action.movieid}">
                        <div class="message_img">
                            <img src="${pageContext.request.contextPath}${action.moviephoto}" alt="">
                        </div>
                        <div class="name_price clear">
                            <h3>${action.moviename}</h3>
                            <span class="price">${action.price}￥</span>
                        </div>
                        <span class="data">${action.releasedate}</span>
                        <p>${action.opera}</p>
                    </a>
                </div>
            </c:forEach>
        </div>
        <!-- 右边侧边栏 -->
        <div class="right_aside">
            <div class="right_header clear">
                <h2>动作排行</h2>
                <p><a href="${pageContext.request.contextPath}/movies/findBys?sid=2&page=1&pageSize=18">查看更多</a>
                </p>
            </div>
            <div class="right-content clear">
                <ul class="ul_left">
                    <c:forEach var="ri" items="${l1}" varStatus="status">
                        <li>
                            <a href="${pageContext.request.contextPath}/movies/findById?id=${ri.movieid}"><span>${status.index+1}</span>${ri.moviename}
                            </a>
                        </li>
                    </c:forEach>
                </ul>
                <ul class="ul_right">
                    <c:forEach var="ri" items="${r1}" varStatus="status">
                        <li>
                            <a href="${pageContext.request.contextPath}/movies/findById?id=${ri.movieid}"><span>${status.index+6}</span>${ri.moviename}
                            </a>
                        </li>
                    </c:forEach>
                </ul>

                <div class="advertise">
                    <img src="${pageContext.request.contextPath}/static/image/guanggao4.jpg" alt="">
                    <img src="${pageContext.request.contextPath}/static/image/guanggao3.png" class="ad_2" alt="">
                </div>
            </div>
        </div>
    </div>
    <div class="section clear">
        <!-- 左侧电影 -->
        <div class="movies_items movies_items2">
            <div class="items_header clear">
                <h2>全部电影</h2>
                <p><a href="${pageContext.request.contextPath}/movies/findBys?sid=0&page=1&pageSize=18">查看更多</a></p>
            </div>
            <c:forEach items="${all}" var="movie">


                <div class="message">
                    <a href="${pageContext.request.contextPath}/movies/findById?id=${movie.movieid}">
                        <div class="message_img">
                            <img src="${pageContext.request.contextPath}${movie.moviephoto}" alt="">
                        </div>
                        <div class="name_price clear">
                            <h3>${movie.moviename}</h3>
                            <span class="price">${movie.price}￥</span>
                        </div>
                        <span class="data">${movie.releasedate}</span>
                        <p>${movie.opera}</p>
                    </a>
                </div>
            </c:forEach>
        </div>

    </div>
</div>

<!-- 空白部分 -->
<div class="kongbai">
    <div class="img_auto">
        <img src="${pageContext.request.contextPath}/static/image/footer1.png" alt="">
    </div>
</div>


<script>

    $(function () {
        $(".ul_h3").css({
            color: "#ff5c38"
        });

        // 设置登录按钮的显示隐藏效果
        $(".login").mouseenter(function () {
            $(this).children(".usrmess").stop();
            $(this).children(".usrmess").show(500);
        });
        $(".login").mouseleave(function () {
            $(this).children(".usrmess").stop();
            $(this).children(".usrmess").hide(500);
        });


        // // 顶部导航栏到达某个点时改变样式
        // $(window).scroll(function () {
        //     x = $(".movies_main").offset().top - $(window).scrollTop()
        //     if (x < 67) {
        //         $("#navbar").css({
        //             background: "rgba(255, 255, 255, 0.98)"
        //         })
        //     } else {
        //         $("#navbar").css({
        //             background: " rgba(255, 255, 255, 0.3)"
        //         })
        //     }
        // });

        $("li").mouseleave(function () {
            $(".ul_h3").css({
                color: "#ff5c38"
            })
        });
        $("li").mouseenter(function () {
            $(".ul_h3").css({
                color: "white"
            })
        })


    })

</script>

</body>
</html>