<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>注册</title>
<jsp:include page="../inc/header.jsp"></jsp:include>
<link rel="stylesheet" href="css/register.css">
<script type="text/javascript">
	
</script>

</head>
<body>
	<div class="container">
		<form class="form-register">
			<h2 class="form-register-heading">Register</h2>
			<div class="form-group">
				<label for="inputEmail" class="col-lg-2 control-label">Email</label>
				<div class="col-lg-5">
					<input type="text" class="form-control" id="inputEmail" placeholder="Email">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword" class="col-lg-2 control-label">Password</label>
				<div class="col-lg-10">
					<input type="password" class="form-control" id="inputPassword"
						placeholder="Password">
					<div class="checkbox">
						<label> <input type="checkbox"> Checkbox
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-10 col-lg-offset-2">
					<button type="reset" class="btn btn-default">Cancel</button>
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</div>
		</form>
	</div>
	<!-- /container -->
</body>
</html>
