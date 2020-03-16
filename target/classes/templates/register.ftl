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
    <script type="text/javascript" src="static/js/regist.js"></script>
<meta charset="UTF-8">
<title>注册</title>
</head>
<html>
<body class="text-center">

<br><br><br><br>
<h1>用户注册</h1><br><br>

<#--用户名 ：<input type="text" class="form-control" placeholder="请输入用户名" name="userName" id="userName" required="" autofocus=""><br><br>
密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" class="form-control" placeholder="请输入密码" name="userPwd" id="userPwd" required=""><br><br>

         <div class="btn-group" data-toggle="buttons">
   				<label class="btn  btn-lg">
        		     <input type="radio" name="userRole" value="1"> 品牌商
    			</label>
                <label class="btn  btn-lg">
                     <input type="radio" name="userRole" value="2"> 借卖方
                </label>
		  </div>
<br><br>
<button class="btn  btn-lg" type="submit" onclick="submit()">注册</button><br><br>-->


    <img class="mb-4" src="asserts/img/096-report.svg" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">Please login in</h1>
    <label class="sr-only">Username</label>
<br>
    <input type="text" class="form-control" placeholder="请输入用户名" name="userName" id="userName" required="" autofocus=""><br>
    <label class="sr-only">Password</label>
    <input type="password" class="form-control" placeholder="请输入密码" name="userPwd" id="userPwd" required=""><br>
    <br>
    <div class="checkbox mb-3">

        <!--            <input type="radio" name="user_role" th:value="1">品牌商
						<input type="radio" name="user_role" th:value="2">借卖方 -->

        <div class="btn-group" data-toggle="buttons">
            <label class="btn  btn-lg">
                <input type="radio" name="userRole" value="1"> 品牌商
            </label>
            <label class="btn  btn-lg">
                <input type="radio" name="userRole" value="2"> 借卖方
            </label>
        </div>
    </div>
    <br>
    <br>
    <button class="btn btn-lg btn-primary btn-block" type="submit" onclick="submit()">Login in</button>
    <p class="mt-5 mb-3 text-muted">© 2019-2020</p>


</body>
</html>