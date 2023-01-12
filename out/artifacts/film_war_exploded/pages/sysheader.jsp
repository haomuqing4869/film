<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<header>
    <div id="LAY_app">
        <div class="layui-layout layui-layout-admin">
            <!-- 头部区域 -->
            <div class="layui-header">
                <ul class="layui-nav layui-layout-left">
                    <li class="layui-nav-item layadmin-flexible" lay-unselect>
                        <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
                            <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
                        </a>
                    </li>
                    <li class="layui-nav-item" lay-unselect>
                        <a href="javascript:;" layadmin-event="refresh" title="刷新">
                            <i class="layui-icon layui-icon-refresh-3"></i>
                        </a>
                    </li>

                </ul>
                <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">

                    <li class="layui-nav-item" lay-unselect>
                        <a href="javascript:;">
                            <cite><security:authentication property="principal.username"/></cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a href="${pageContext.request.contextPath}/movies/home">返回前台</a>
                                <a href="${pageContext.request.contextPath}/logout">注销</a>
                            </dd>
                        </dl>
                    </li>
                </ul>
            </div>
            <!-- 侧边菜单 -->
            <div class="layui-side layui-side-menu">
                <div class="layui-side-scroll">
                    <div class="layui-logo" lay-href="home/console.html">
                        <span>后台管理</span>
                    </div>
                    <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
                        <li data-name="component" class="layui-nav-item">
                            <a href="javascript:;" lay-tips="用户管理" lay-direction="2">
                                <i class="layui-icon layui-icon-component"></i>
                                <cite>用户管理</cite>
                            </a>
                            <dl class="layui-nav-child">
                                <dd>
                                    <a href="${pageContext.request.contextPath}/sysUser/findall?page=1&pageSize=5">用户管理</a>
                                </dd>
                            </dl>
                        </li>
                        <li data-name="template" class="layui-nav-item">
                            <a href="javascript:;" lay-tips="电影" lay-direction="2">
                                <i class="layui-icon layui-icon-template"></i>
                                <cite>电影</cite>
                            </a>
                            <dl class="layui-nav-child">
                                <dd><a href="${pageContext.request.contextPath}/sysMovies/findAll?page=1&pageSize=10">电影管理</a></dd>
                                <dd><a href="${pageContext.request.contextPath}/sysOrder/findAll?page=1&pageSize=8">订单管理</a></dd>
                                <dd><a href="${pageContext.request.contextPath}/sysComment/findAll?page=1&pageSize=8">评论管理</a></dd>
                                <dd><a href="${pageContext.request.contextPath}/sysSort/findAll?page=1&pageSize=5">标签管理</a></dd>
                            </dl>
                        </li>
                        <li data-name="app" class="layui-nav-item">
                            <a href="javascript:;" lay-tips="影院" lay-direction="2">
                                <i class="layui-icon layui-icon-app"></i>
                                <cite>影院</cite>
                            </a>
                            <dl class="layui-nav-child">
                                <dd data-name="forum">
                                    <a href="${pageContext.request.contextPath}/sysHall/findAll">放映厅管理</a>
                                </dd>
                                <dd data-name="content">
                                    <a href="${pageContext.request.contextPath}/sysSchedule/findAll?page=1&pageSize=8">场次安排</a>
                                </dd>
                            </dl>
                        </li>
                    </ul>
                </div>
            </div>

        </div>
    </div>


</header>
