<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>测试</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.11.1.min.js"></script>

    <script type="text/javascript">

    </script>
</head>

<body>
<h1>这是一个页面缓存的练习</h1>
<font style="color:green;font-weight:bold;font-size: 18px">${date}</font>
</body>
</html>