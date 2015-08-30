<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>兔爷 公告</title>
<script type="text/javascript" src="<%=basePath %>/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
function info(){
	//alert("login click");
	$.ajax({
	    cache: true,
	    type: "POST",
	    url: "<%=basePath%>/home/info",
	    data: {isAjax:true, id:"123456"},
	    error: function(request) {
	    	alert(request.toString());
	        alert("系统出现异常,请稍候再试!");
	    },
	    success: function(data) {
	    	//data=$.parseJSON(data);
	    	alert(data)
	    	//alert(data.code);
	        if(data.code == "1"){ //成功
	        	alert(123);
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
	公告天下啦! 兔爷！！！ ${username}
	<button onclick="info();">获取信息</button>
</body>
</html>
