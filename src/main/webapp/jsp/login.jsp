<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登录</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="<%=basePath %>/bootstrap-3.3.5/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="<%=basePath %>/bootstrap-3.3.5/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="<%=basePath %>/js/jquery-1.11.3.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=basePath %>/bootstrap-3.3.5/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="<%=basePath %>/css/signin.css">

<script type="text/javascript">

function login(){
	//alert("login click");
	var loginIndivForm = $('#loginIndivForm');
	loginIndivForm
	$.ajax({
	    cache: true,
	    type: "POST",
	    url: "<%=basePath%>/login/post",
	    data: loginIndivForm.serialize(),
	    error: function(request) {
	        alert("系统出现异常,请稍候再试!");
	    },
	    success: function(data) {
	    	//data=$.parseJSON(data);
	    	//alert(data.code);
	        if(data.code == "1"){ //成功
	        	//alert(123);
	        	loginIndivForm.submit();
	        }else { //验证码,密码,用户名等错误
	        	alert(data.msg);
	        }
	    }
	});
}

</script>

</head>
<body>
	<div class="container">
	
      <form class="form-signin" id="loginIndivForm" action="${refer}" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" name="userName" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="button" onclick="login()">Sign in</button>
      </form>

    </div> <!-- /container -->
</body>
</html>
