<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 49020
  Date: 2020/10/16
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>评论管理</title>
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/static/image/07.ico" media="screen" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layuiadmin/style/admin.css" media="all">

    <style>
        .white {
            padding: 10px;
        }

        .white .white-insert {
            padding: 15px;
            background-color: white;
            overflow: hidden;
        }

        .btn {
            float: right;
        }

        table {
            text-align: center;
        }
    </style>

</head>

<body>
<div class="white">
    <jsp:include page="sysheader.jsp"/>
    <!-- 主体部分 -->
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 60px;">
            <div class="white-insert">
                <table class="layui-table">
                    <colgroup>
                        <col width="150">
                        <col width="200">
                        <col>
                    </colgroup>
                    <thead>
                    <tr>
                        <th style="text-align: center;">ID</th>
                        <th style="text-align: center;">电影</th>
                        <th style="text-align: center;">评论内容</th>
                        <th style="text-align: center;">用户</th>
                        <th style="text-align: center;">评论时间</th>
                        <th style="text-align: center;">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${comments.list}" var="comment">
                        <tr>
                            <td>${comment.commentid}</td>
                            <td>${comment.tMovie.moviename}</td>
                            <td>${comment.content}</td>
                            <td>${comment.userobj}</td>
                            <td>${comment.commenttime}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/sysComment/delete?id=${comment.commentid}" class="layui-btn  layui-btn-danger layui-btn-sm">删除</a>
                                <%--<a href="#" class="layui-btn layui-btn-warm layui-btn-sm">编辑</a>--%>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <c:if test="${pages !=null}">
                    <div class="btn">
                        <a class="layui-btn layui-btn-sm layui-btn-normal"
                           href="${pageContext.request.contextPath}/sysComment/findAll?page=${pages.page-1}&pageSize=${pages.pageSize}">上一页</a>
                        <c:forEach begin="1" end="${pages.total}"  var="p">
                            <a class="layui-btn layui-btn-sm layui-btn-normal"
                               href="${pageContext.request.contextPath}/sysComment/findAll?page=${p}&pageSize=${pages.pageSize}">${p}</a>
                        </c:forEach>
                        <a class="layui-btn layui-btn-sm layui-btn-normal"
                           href="${pageContext.request.contextPath}/sysComment/findAll?page=${pages.page+1}&pageSize=${pages.pageSize}">下一页</a>
                    </div>
                </c:if>
            </div>
        </div>

    </div>
</div>


<script src="${pageContext.request.contextPath}/static/layuiadmin/layui/layui.js"></script>
<script>
    //一般直接写在一个js文件中
    layui.use(['layer', 'form'], function () {
        var layer = layui.layer
            , form = layui.form;

    });
</script>
<script>
    layui.config({
        base: '${pageContext.request.contextPath}/static/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use('index');
</script>
<!-- 百度统计 -->
<script>
    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?d214947968792b839fd669a4decaaffc";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
</body>
</html>
