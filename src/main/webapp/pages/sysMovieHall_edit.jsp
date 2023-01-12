<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>编辑放映厅</title>
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/static/image/07.ico"
          media="screen"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layuiadmin/style/admin.css" media="all">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/static/public/bootstrap-4.4.1/dist/css/bootstrap.css">
    <script src="${pageContext.request.contextPath}/static/public/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/public/bootstrap-4.4.1/dist/js/bootstrap.js"></script>
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

        .layui-form-item {
            margin-bottom: 8px;
        }

        .layui-form-label {
            width: 110px;
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
                <!-- 内容主体区域 -->
                <div style="padding: 60px; background-color: white;">
                    <!-- 模态框 -->
                    <form action="${pageContext.request.contextPath}/sysHall/edit" class="layui-form" method="post"
                          enctype="multipart/form-data">
                        <div class="layui-form-item">
                            <label class="layui-form-label">放映厅名称：</label>
                            <div class="layui-input-block">
                                <input type="text" name="moviehallname" placeholder="请输入名称"
                                       autocomplete="off" class="layui-input" value="${tMoviehall.moviehallname}">
                                <input type="hidden" name="moviehallid" value="${tMoviehall.moviehallid}">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">排数：</label>
                            <div class="layui-input-block">
                                <input type="number" name="rows" style="width:300px"
                                       placeholder="请输入排数" value="${tMoviehall.rows}" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">列数：</label>
                            <div class="layui-input-block">
                                <input type="number" name="cols" style="width:300px"
                                       placeholder="请输入列数" value="${tMoviehall.cols}" autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <!-- 底部 -->
                        <div>
                            <input type="submit" class="btn btn-primary">
                            <button data-dismiss="modal" class="btn btn-secondary">取消</button>
                        </div>
                    </form>
                </div>
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
