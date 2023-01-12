<%--
  Created by IntelliJ IDEA.
  User: 49020
  Date: 2020/10/18
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加用户</title>
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

        .files-photo {
            line-height: 32px;
            border: none;
        }
    </style>
</head>
<body>
<jsp:include page="sysheader.jsp"/>
<!-- 主体部分 -->
<div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 60px;">
        <!-- 内容主体区域 -->
        <div class="white">
            <div class="white-insert">
                <!-- 模态框 -->
                <form action="${pageContext.request.contextPath}/sysUser/add" class="layui-form" method="post"
                      enctype="multipart/form-data" onsubmit="return check()">
                    <div class="layui-form-item">
                        <label class="layui-form-label">用户名字：</label>
                        <div class="layui-input-block">
                            <input type="text" name="userName"
                                   placeholder="请输入名字" autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">密码：</label>
                        <div class="layui-input-block">
                            <input type="password" name="password"
                                   placeholder="请输入密码" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">头像：</label>
                        <div class="layui-input-block">
                            <input type="file" name="photo"
                                   placeholder="请选择图片" autocomplete="off" class="layui-input files-photo">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">类型：</label>
                        <div class="layui-input-block">
                            <input type="radio" name="usertype" title="管理员" value="ROLE_ADMIN">
                            <input type="radio" name="usertype" title="普通用户" value="ROLE_USER">
                        </div>
                    </div>

                    <!-- 底部 -->
                    <div>
                        <input type="submit" class="btn btn-primary">
                        <button type="button"
                                onclick="window.location.href='${pageContext.request.contextPath}/sysUser/findall?page=1&pageSize=5'"
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
    //一般直接写在一个js文件中
    layui.use(['layer', 'form'], function () {
        var layer = layui.layer
            , form = layui.form;
    });
    
    function check() {
        var uname = document.all("userName");
        if(uname.value.length==0){
            alert("用户名不能为空");
            return false;
        }
        var upassword = document.all("password");
        if(upassword.value.length==0){
            alert("密码不能为空");
            return false;
        }
        var uphoto = document.all("photo");
        if(uphoto.value.length==0){
            alert("头像不能为空");
            return false;
        }
        var usertype = $('[name="usertype"]:checked').val();
        if (usertype == null){
            alert("请选择用户类型！");
            return false;
        }

        return true;
    }

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
