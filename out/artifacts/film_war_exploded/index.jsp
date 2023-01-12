<%--
  Created by IntelliJ IDEA.
  User: 49020
  Date: 2020/9/24
  Time: 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>首页</title>
</head>
<body>

    <%
        int stayTime=0;
        String URL=request.getContextPath()+"/movies/home";
        String content=stayTime+";URL="+URL;
        response.setHeader("REFRESH",content);
    %>
</body>
</html>
