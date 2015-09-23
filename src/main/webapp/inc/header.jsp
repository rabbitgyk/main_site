<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath()+"/";
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<base href="<%=basePath%>">
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="bootstrap-3.3.5/css/bootstrap.my.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入）
<link rel="stylesheet" href="bootstrap-3.3.5/css/bootstrap-theme.min.css"> -->
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="js/jquery-1.11.3.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="bootstrap-3.3.5/js/bootstrap.min.js"></script>
