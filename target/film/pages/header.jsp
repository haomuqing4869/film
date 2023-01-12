
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<header>
    <div class="input" id="navbar">
        <div class="logo">
            <a href="${pageContext.request.contextPath}/movies/home">
                <img src="${pageContext.request.contextPath}/static/image/09.png" alt="">
            </a>
        </div>
        <div class="input-container">
            <form action="${pageContext.request.contextPath}/movies/findByname">
                <div class="search-box">
                    <input class="search-txt" type="text" placeholder="请输入..." name="name" />
                    <button type="submit" class="search-btn">
                        <i class="fas fa-search"></i>
                    </button>
                </div>
                <input type="hidden" name="page" value="1">
                <input type="hidden" name="pagesize" value="12">
            </form>
        </div>
        <security:authorize access="hasAnyAuthority('ROLE_ADMIN')">
            <a class="btn btn-default" href="${pageContext.request.contextPath}/pages/sysmain.jsp" role="button">管理员</a>
        </security:authorize>
        <div class="login">
            <a href="${pageContext.request.contextPath}/user/find" class="login-btn">我</a>

            <div class="usrmess">
                <a href="${pageContext.request.contextPath}/user/find">我的</a>
                <a href="${pageContext.request.contextPath}/logout">退出</a>
            </div>
        </div>

    </div>
</header>
