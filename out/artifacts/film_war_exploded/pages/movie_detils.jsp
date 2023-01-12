<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/static/image/07.ico" media="screen" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/public.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/message.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/public/bootstrap-4.4.1/dist/css/bootstrap.css">
    <link href="https://cdn.bootcss.com/font-awesome/5.8.0/css/all.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/static/public/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/public/bootstrap-4.4.1/dist/js/bootstrap.js"></script>
    <title>详情</title>

    <style>
        .module{
            position: relative;
        }
        .commen-entry{
            cursor: pointer;
            position: absolute;
            top: -10px;
            right: 0;
            display: inline-block;
            height: 30px;
            padding: 0 10px;
            border-radius: 15px;
            border: 1px solid #ef4238;
            text-align: center;
            font-size: 14px;
            line-height: 30px;
            color: #ef4238;
        }
        .commen-entry:hover{
            color: #ef4238;
            text-decoration-line: none;
        }

    </style>
</head>
<body>

<!-- 输入框 -->
<jsp:include page="header.jsp"/>

<div class="bar">
    <div class="bar-container">
        <div class="bar-img-a">
            <div class="bar-img">
                <img src="${pageContext.request.contextPath}${movie.moviephoto}" alt="">
            </div>
        </div>
        <div class="bar-message">
            <div class="bar-messae-text">
                <h3>${movie.moviename}</h3>
                <c:forEach items="${movie.sorts}" var="sort">
                    <p>${sort.sorts}</p>
                </c:forEach>
                <p>时长:${movie.duration}分钟</p>
                <p>上映日期:${movie.releasedate}</p>
            </div>
        </div>
        <div class="bar-bottom-left">
            <div class="bar-input">

                <a href="#" class="a-bottom">${movie.price}￥</a>
                <%--<a href="#" class="a-top">评分</a>--%>
                <br>
                <a href="${pageContext.request.contextPath}/userorder/add?id=${movie.movieid}" class="a-bottom">购票</a>
            </div>
        </div>
        <div class="bar-bottom-right">
            <div class="right-score">
                <span>口碑</span>
                <h2>9.2</h2>
            </div>
            <div class="right-office">
                <span>票房</span>
                <h2>14.00亿</h2>
            </div>
        </div>
    </div>
</div>

<div class="white"></div>

<div class="message">
    <div class="banner">
        <div class="module">
            <div class="module-title">
                <h2>剧情简介</h2>
            </div>
            <div class="module-conte">
                <span>${movie.opera}</span>
            </div>
        </div>

        <div class="module">
            <div class="module-title">
                <h2>演职人员</h2>
            </div>
            <div class="module-conte">
                <span>导演：${movie.director}</span><br>
                <span>演员：${movie.mainperformer}</span>
            </div>
        </div>

        <div class="module">
            <div class="module-title">
                <h2>热门短评</h2>
            </div>
            <c:forEach var="coment" items="${comments}">

                <div class="module-conte">
                    <div class="common-list">
                        <ul>
                            <li>
                                <div class="usr-img">
                                    <div class="img">
                                        <img src="${pageContext.request.contextPath}/static/image/user.jpg" alt="">
                                    </div>
                                </div>

                                <div class="main-message">
                                    <div class="user-name">
                                        <span class="name">${coment.userobj}</span>
                                    </div>
                                    <div class="main-content">
                                        ${coment.content}
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </c:forEach>
            <a type="button" class="commen-entry" data-toggle="modal" data-target="#myModal">写评论</a>

            <!-- 模态框 -->
            <form action="${pageContext.request.contextPath}/comment/save">
                <div class="modal fade" id="myModal">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">

                            <!-- 模态框头部 -->
                            <div class="modal-header">
                                <h4 class="modal-title">评论</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>

                            <!-- 模态框主体 -->
                            <div class="modal-body">
                                <textarea cols="90" rows="3" name="content"></textarea>
                            </div>
                            <input type="hidden" name="movieobj" value="${movie.movieid}">
                            <!-- 模态框底部 -->
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-primary">
                                <button  data-dismiss="modal" class="btn btn-secondary">取消</button>
                            </div>

                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>


<script>

    $(function(){

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
