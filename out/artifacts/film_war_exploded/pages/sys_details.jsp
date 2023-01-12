<%--
  Created by IntelliJ IDEA.
  User: 49020
  Date: 2020/10/19
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>详情</title>
    <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/static/image/07.ico" media="screen" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layuiadmin/style/admin.css" media="all">

    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .white {
            padding: 10px;
            background-color: #eceff4;
        }

        .white .white-insert {
            background-color: white;
            overflow: hidden;
        }

        .white .white-insert h2 {
            padding: 5px;
            padding-left: 15px;
            height: 40px;
            line-height: 40px;
            background-color: #f5f5f5;
        }

        .white .white-insert .info-content {
            padding: 15px;
        }

        .info-content .info-box {
            border: 1px solid #d3d3d3;
        }

        .info-content .info-box .s_p {
            border-top: 1px solid #d9d9d9;
            font-size: 20px;
            height: 46px;
        }

        .s_p {
            width: 100%;
        }

        .s_p .s_p_a {
            width: 49%;
            display: inline-block;
        }

        .s_p .s_p_a span {
            display: inline-block;
            width: 150px;
            background-color: #ececec;
            text-align: center;
            line-height: 46px;
        }

        .s_p .s_p_a .p {
            display: inline-block;
            padding: 5px;
            padding-left: 10px;
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
                <h2>订单详情</h2>
                <div class="info-content">
                    <div class="info-box">
                        <div class="s_p">
                            <div class="s_p_a">
                                <span>购票人</span>
                                <div class="p">
                                    <p>${details.tUserinfo.userName}</p>
                                </div>
                            </div>
                            <div class="s_p_a">
                                <span>电影名</span>
                                <div class="p">
                                    <p>${details.tMovie.moviename}</p>
                                </div>
                            </div>
                        </div>
                        <div class="s_p">
                            <div class="s_p_a">
                                <span>放映厅</span>
                                <div class="p">
                                    <p>${details.tMoviehall.moviehallname}</p>
                                </div>
                            </div>
                            <div class="s_p_a">
                                <span>座位号</span>
                                <div class="p">
                                    <p>${details.rowsindex}排${details.cols}座</p>
                                </div>
                            </div>
                        </div>
                        <div class="s_p">
                            <div class="s_p_a">
                                <span>放映时间</span>
                                <div class="p">
                                    <p>${details.tSchedule.scheduledate} ${details.tSchedule.scheduletime}</p>
                                </div>
                            </div>
                            <div class="s_p_a">
                                <span>下单时间</span>
                                <div class="p">
                                    <p>${details.ordertime}</p>
                                </div>
                            </div>
                        </div>
                        <div class="s_p">
                            <div class="s_p_a">
                                <span>票价</span>
                                <div class="p">
                                    <p>${details.price}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
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
</body>
</html>
