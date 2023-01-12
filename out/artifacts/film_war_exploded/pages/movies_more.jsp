<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>更多</title>
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/static/image/07.ico" media="screen" />
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/public/bootstrap-4.4.1/dist/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/public.css">
    <link href="https://cdn.bootcss.com/font-awesome/5.8.0/css/all.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/static/public/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/public/bootstrap-4.4.1/dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/more.css">

</head>

<body>
<jsp:include page="header.jsp"/>

<!-- 内容，电影items -->
<div class="mod_hd" id="mod">

    <div class="mod_hd_list">
        <span class="mod">类型</span>
        <a href="${pageContext.request.contextPath}/movies/findBys?sid=0&page=1&pageSize=18" class="mod_items">全部</a>
        <c:forEach items="${sorts}" var="sort">
            <a href="${pageContext.request.contextPath}/movies/findBys?sid=${sort.id}&page=1&pageSize=18"
               class="mod_items">${sort.sorts}</a>
        </c:forEach>
    </div>
</div>

<div class="more-movies">
    <div class="movies_items">
        <c:forEach items="${movies.list}" var="movie">
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

        <!-- 分页 -->
        <c:if test="${pages !=null}">
            <div class="page">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link"
                                             href="${pageContext.request.contextPath}/movies/findBys?sid=${sortid}&page=${pages.page-1}&pageSize=${pages.pageSize}"><</a>
                    </li>
                    <c:forEach begin="1" end="${pages.total}" var="p">
                        <li class="page-item"><a class="page-link"
                                                 href="${pageContext.request.contextPath}/movies/findBys?sid=${sortid}&page=${p}&pageSize=${pages.pageSize}">${p}</a>
                        </li>
                    </c:forEach>
                    <li class="page-item">
                        <a class="page-link"

                           href="${pageContext.request.contextPath}/movies/findBys?sid=${sortid}&page=${pages.page+1}&pageSize=${pages.pageSize}">></a>
                    </li>
                </ul>
            </div>

        </c:if>


    </div>
</div>


<!-- 空白部分 -->
<div class="kongbai">
    <div class="img_auto">
        <img src="${pageContext.request.contextPath}/static/image/footer1.png" alt="">
    </div>
</div>

<!-- 尾部 footer -->
<footer>
    <div class="footer_main">
        <p><span>组名：</span>321组</p>
        <p><span>组员：</span>谢金生、钟先亮、黄志敏、赖房兴、郭志鹏、华阳</p>
    </div>
</footer>

</body>
</html>
