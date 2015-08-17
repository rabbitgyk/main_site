<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">

function login(){
	//alert("login click");
	var loginIndivForm = $('#loginIndivForm');
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
	<h3>${label}</h3>
	<form id="loginIndivForm" action="${refer}" method="post">
	<label>用户名：</label><input name="userName"></input>
	<label>密 码：</label><input name="password"></input>
	<input type="button" value="登录" id="btn" onclick="login()" />
	</form>
</body>
</html>
