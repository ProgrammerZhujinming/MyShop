<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
	 <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
	 <link href="asserts/css/signin.css" rel="stylesheet">
	 <link href="asserts/css/bootstrap.min.css" rel="stylesheet">
   <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script  src="${pageContext.request.contextPath}/static/js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="static/js/login.js"></script>

<meta charset="UTF-8">
<title>登录</title>
</head>
<html>

<body class="text-center">

<#--<h1>用户登录</h1><br><br>
用户名 ：<input type="text" class="form-control" placeholder="请输入用户名" name="userName" id="userName" required="" autofocus=""><br><br>
密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" class="form-control" placeholder="请输入密码" name="userPwd" id="userPwd" required=""><br><br>
<button class="btn  btn-lg" type="submit" onclick="login()">登录</button><br><br>-->


    <img class="mb-4" src="asserts/img/069-startup.svg" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>

    <label class="sr-only">Username</label>

<input type="text" class="form-control" placeholder="请输入用户名" name="userName" id="userName" required="" autofocus=""><br><br>

    <label class="sr-only">Password</label>
<input type="password" class="form-control" placeholder="请输入密码" name="userPwd" id="userPwd" required=""><br><br>

    <button class="btn btn-lg btn-primary btn-block" onclick="login()" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted">© 2019-2020</p>

</body>

</html>