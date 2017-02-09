<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../common/taglibs.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <h1>请登录</h1>
        <form action="${ctx}/sso/login" method="post">
            <span>用户名：</span><input name="username" type="text">
            <span>密码:</span><input name="password" type="password">
            <!-- 实际想要访问的网址 -->
            <input type="hidden" name="gotoUrl" value="${gotoUrl}">
            <input type="submit">
        </form>
    </center>
</body>
</html>
