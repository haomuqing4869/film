<%--
  Created by IntelliJ IDEA.
  User: 49020
  Date: 2020/10/17
  Time: 8:08
  To change this template use File | Settings | File Templates.
--%>
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
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/echarts.min.js"></script>
</head>
<body>
<jsp:include page="sysheader.jsp"/>
<!-- 主体部分 -->
<div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 60px;">


        <a href="${pageContext.request.contextPath}/sysMovies/findAll?page=1&pageSize=10" class="layui-btn layui-btn-normal">电影</a>
        <a href="${pageContext.request.contextPath}/pages/sysSortHit.jsp" class="layui-btn layui-btn-normal">类型点击率</a>
        <div id="main" style="height:600px;width: 1100px; margin-left: 30px ;margin: 20px auto;"></div>




    </div>
</div>
<script type="text/javascript">
    // 利用AjAx来获取后台传入的数据（@Responsebody注解传入的）
    var movieName=[];
    var hit=[];
    $.ajax({
        type: "get",
        async: false, //是否异步
        url: "${pageContext.request.contextPath}/sysMovies/show",
        contentType: "application/json;charset=UTF-8",
        dataType: "json", //跨域json请求一定是json
        success: function (response) {
            console.log('response :>> ', response);
            for (var index = 0; index < response.length; index += 1) {
                movieName.push(response[index].moviename);
                hit.push(response[index].hit);
                console.log(index)
            }

        },
        error: function (response) {
            console.log("请求失败")
        }
    });
    //Echarts展示数据
    $(function () {
        {
            // 基于准备好的dom，初始化echarts图表
            var myChart = echarts.init(document.getElementById('main'));

            option = {
                title: {
                    text: '点击量',
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross'
                    }
                },
                toolbox: {
                    show: true,
                    feature: {
                        saveAsImage: {}
                    }
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: movieName,
                    axisLabel: {
                        interval:0
                    }
                },
                yAxis: {
                    type: 'value',
                    axisLabel: {
                        formatter: '{value}',
                    },
                    axisPointer: {
                        snap: true
                    }
                },
                visualMap: {
                    show: false,
                    dimension: 0,

                },
                series: [
                    {
                        name: '点击量',
                        type: 'line',
                        smooth: true,
                        data: hit,
                        markArea: {

                        }
                    }
                ]
            };


            // 为echarts对象加载数据
            myChart.setOption(option);
        }
    })
</script>



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
</body>
</html>
