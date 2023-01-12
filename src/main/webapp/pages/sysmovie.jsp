<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>电影</title>
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/static/image/07.ico" media="screen" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layuiadmin/style/admin.css" media="all">
    <style>
        .div-right {
            float: right;
        }

        .div-right :nth-of-type(even) {
            border: 1px solid white;
        }
    </style>

</head>
<body>
<jsp:include page="sysheader.jsp"/>
<!-- 主体部分 -->
<div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 60px;">
        <div class="white">
            <div class="white-insert">
                <div style="margin-bottom: 5px">
                    <a href="${pageContext.request.contextPath}/sysMovies/toAdd"
                       class="layui-btn layui-btn-normal">添加</a>
                    <a href="${pageContext.request.contextPath}/pages/sysmoviesHit.jsp"
                       class="layui-btn layui-btn-normal">电影点击量</a>
                    <a href="${pageContext.request.contextPath}/pages/sysSortHit.jsp"
                       class="layui-btn layui-btn-normal">类型点击率</a>
                </div>
                <form action="${pageContext.request.contextPath}/sysMovies/findSome" method="post">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <input type="text" name="moviename" placeholder="电影" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-inline">
                            <input type="text" name="director" placeholder="导演" autocomplete="off"
                                   class="layui-input"></div>
                        <div class="layui-inline">
                            <input type="text" name="mainperformer" placeholder="演员" autocomplete="off"
                                   class="layui-input">
                        </div>
                        <input type="hidden" name="page" value="1">
                        <input type="hidden" name="pageSize" value="50">
                        <button type="submit" class="layui-btn layui-btn-normal">查询</button>
                    </div>
                </form>

                <table class="layui-table">
                    <thead>
                    <tr>
                        <th style="width: 20px">ID</th>
                        <th>电影名字</th>
                        <th style="width: 70px">导演</th>
                        <th style="width: 150px">主演</th>
                        <th>时长</th>
                        <th>上映时间</th>
                        <th style="width: 150px">地区</th>
                        <th>点击量</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${movies.list}" var="movie">
                        <tr>
                            <td>${movie.movieid}</td>
                            <td>${movie.moviename}</td>
                            <td>${movie.director}</td>
                            <td>${movie.mainperformer}</td>
                            <td>${movie.duration}</td>
                            <td>${movie.releasedate}</td>
                            <td>${movie.area}</td>
                            <td>${movie.hit}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/sysMovies/delete?id=${movie.movieid}"
                                   onclick="return(confirm('是否确认删除')) " class="layui-btn  layui-btn-danger layui-btn-sm">删除</a>
                                <a href="${pageContext.request.contextPath}/sysMovies/toEdit?id=${movie.movieid}"
                                   class="layui-btn layui-btn-warm layui-btn-sm">编辑</a>
                                <c:if test="${movie.tSchedule == null}">
                                    <a id="${movie.moviename}_${movie.movieid}"
                                       class="layui-btn layui-btn-warm layui-btn-sm sj">上架</a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <c:if test="${pages !=null}">
                    <div class="btn">
                        <a class="layui-btn layui-btn-sm layui-btn-normal"
                           href="${pageContext.request.contextPath}/sysMovies/findAll?page=${pages.page-1}&pageSize=${pages.pageSize}">上一页</a>
                        <c:forEach begin="1" end="${pages.total}" var="p">
                            <a class="layui-btn layui-btn-sm layui-btn-normal"
                               href="${pageContext.request.contextPath}/sysMovies/findAll?page=${p}&pageSize=${pages.pageSize}">${p}</a>
                        </c:forEach>
                        <a class="layui-btn layui-btn-sm layui-btn-normal"
                           href="${pageContext.request.contextPath}/sysMovies/findAll?page=${pages.page+1}&pageSize=${pages.pageSize}">下一页</a>
                    </div>
                </c:if>

            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/layuiadmin/layui/layui.js"></script>
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
<script>

    //一般直接写在一个js文件中
    layui.use(['layer', 'form', 'laydate'], function () {
        var layer = layui.layer
            , form = layui.form
            , $ = layui.$
            , admin = layui.admin
            , element = layui.element
            , laydate = layui.laydate;

        $(".sj").on('click', function () {
            layer.open({
                title: '选择分类'
                , type: 1
                , shadeClose: true
                , area: ['35%', '50%']
                , content: `<form action="${pageContext.request.contextPath}/sysMovies/putShelf">
                                    <div class="layui-form-item" style="margin:40px auto; margin-bottom:0">
                                        <label class="layui-form-label">电影名字：</label>
                                        <div class="layui-input-block" style="padding:8px">
                                            <input type="text"  id="movievalue" value="" style="border:1px solid white;background-color:white" disabled>
                                            <input type="hidden" name="movieobj" id="movieid" value="">

                                        </div>
                                    </div>
                                    <div class="layui-form-item">
                                        <label class="layui-form-label" style="text-align: center;">影院：</label>
                                        <div class="layui-input-block" style="padding:8px">
                                        <c:forEach items="${halls}" var="hall">
                                            <input id="shangyingting" type="radio"  name="hallobj" value="${hall.moviehallid}">${hall.moviehallname}
                                        </c:forEach>
                                        </div>
                                    </div>
                                    <div class="layui-form-item">
                                        <label class="layui-form-label">上映时间：</label>
                                        <div  class="layui-input-block" style="padding:8px">
                                            <input type="text" class="layui-input" id="test1" name="scheduledate">
                                        </div>
                                    </div>
                                    <div>
                                        <div style="width:100px" class="div-right">
                                            <button id="shangyingtijiao" onclick="shangying()"  class="layui-btn layui-btn-sm layui-btn-normal" type="button">提交<button/>
                                        <div/>
                                    <div/>
                                <form/>`

            })
            laydate.render({
                elem: '#test1' //指定元素
                , type: 'datetime'
            });
            var movievalue = $(this).attr("id")
            var moviename = '';
            var movieid = '';
            moviename = movievalue.split('_')[0];
            movieid = movievalue.split('_')[1];

            $("#movievalue").val(moviename);
            $("#movieid").val(movieid)
        })

    });

</script>
<script>
    function shangying() {
        var shangyingtijiao= document.getElementById("shangyingtijiao");
        var shangyingting= document.getElementById("shangyingting");
        var test1= document.getElementById("test1");
        if (!shangyingting.checked){
            alert("请选择上映厅")
        }else if(test1.value.length==0){
            alert("请选择上映时间")
        }else{
            shangyingtijiao.type="submit";
        }

    }
    function myFunction(){
        var r=confirm("确认删除？");
        if (r==true){

        }
        else{

        }

    }
</script>
</body>
</html>
