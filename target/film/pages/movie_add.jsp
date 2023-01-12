<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/static/image/07.ico"
          media="screen"/>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
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

        .files-photo {
            line-height: 32px;
            border: none;
        }
    </style>
</head>
<body>
<jsp:include page="sysheader.jsp"/>

<div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 60px;">
        <div class="white">
            <div class="white-insert">
                <!-- 模态框 -->
                <form action="${pageContext.request.contextPath}/sysMovies/add" class="layui-form" method="post"
                      enctype="multipart/form-data">
                    <div class="layui-form-item">
                        <label class="layui-form-label">电影名字：</label>
                        <div class="layui-input-block">
                            <input type="text" name="moviename" id="MovieName"
                                   placeholder="请输入" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">电影图片：</label>
                        <div class="layui-input-block">
                            <input id="dianyingtupian"  type="file" name="photo"
                                   placeholder="请输入" autocomplete="off" class="layui-input files-photo">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">导演：</label>
                        <div class="layui-input-block">
                            <input id="daoyan" type="text" name="director"
                                   placeholder="请输入" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">演员：</label>
                        <div class="layui-input-block">
                            <input id="yanyuan" type="text" name="mainperformer"
                                   placeholder="请输入" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">时长：</label>
                        <div class="layui-input-block">
                            <input id="shichang" type="text" name="duration"
                                   placeholder="请输入" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">区域：</label>
                        <div class="layui-input-block">
                            <input id="quyu" type="text" name="area"
                                   placeholder="请输入" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label id="shangyingriqi" class="layui-form-label">上映日期：</label>
                        <div class="layui-input-block">
                            <input id="test2" type="text" name="releasedate"
                                   placeholder="请输入" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">票价：</label>
                        <div class="layui-input-block">
                            <input id="piaojia"  type="text" name="price"
                                   placeholder="请输入" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">简介：</label>
                        <div class="layui-input-block">
                                    <textarea id="jianjie" name="opera" placeholder="请输入"
                                              class="layui-textarea"></textarea>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">类型：</label>
                        <div class="layui-input-block">
                            <c:forEach items="${sorts}" var="sort">
                                <input id="leixing" type="checkbox" name="sortid" title="${sort.sorts}" value="${sort.id}">
                            </c:forEach>
                        </div>
                    </div>

                    <!-- 模态框底部 -->
                    <div>
                        <button id="tijiao" type="button" class="btn btn-primary" onclick="PanKong()">提交</button>
                        <button type="button"
                                onclick="window.location.href='${pageContext.request.contextPath}/sysMovies/findAll?page=1&pageSize=10'"
                                data-dismiss="modal" class="btn btn-secondary">取消
                        </button>
                    </div>
                </form>
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
    function PanKong() {
       var MovieName= document.getElementById("MovieName");
       var dianyingtupian= document.getElementById("dianyingtupian");
       var daoyan= document.getElementById("daoyan");
       var yanyuan= document.getElementById("yanyuan");
       var shichang= document.getElementById("shichang");
       var quyu= document.getElementById("quyu");
       var test2= document.getElementById("test2");
       var piaojia= document.getElementById("piaojia");
       var jianjie= document.getElementById("jianjie");
       var leixing= document.getElementById("leixing");
       var zhengshu= document.getElementById("piaojia").value;

        var tijiao= document.getElementById("tijiao");
       if (MovieName.value.length==0){
           alert("请填写电影名称");
       }else if (dianyingtupian.value.length==0){
            alert("请上传电影图片");
        }else if (daoyan.value.length==0){
           alert("请填写导演姓名");
       }else if (yanyuan.value.length==0){
           alert("请填写演员信息");
       }else if (shichang.value.length==0){
           alert("时常不能为空");
       }else if (quyu.value.length==0){
           alert("区域未填写");
       }else if (test2.value.length==0){
           alert("请填写上映日期");
       }else if (piaojia.value.length==0){
           alert("请填写票价");
       }else if (jianjie.value.length==0){
           alert("请填写电影简介");
       }else if (leixing.value.length==0){
           alert("请填请勾选类型");
       }else if (!Number(shichang.value) ){
           alert("时长应为数字" );
       }
       else if (!Number(piaojia.value) ){
           alert("票价应为数字" );
       }
       else  {
           tijiao.type="submit";
       }
    }

    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?d214947968792b839fd669a4decaaffc";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>

<script>

    layui.use(['form', 'laydate'], function () {
        var form = layui.form
            , laydate = layui.laydate;

        laydate.render({
            elem: '#test2' //指定元素
            , type: 'datetime'
        });

    });

</script>

</body>
</html>
