<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>登录界面</title>
  </head>
  <body>
    <div align="center">
    	<form action="User_login" method="post">
    		<h1>用户登录</h1>
    		用户名:<input type="text" name="username"></br>
    		密&nbsp;码:<input type="text" name="password"></br>
    		<input type="submit" value="提交">
    		<input type="reset" value="重置">
    	</form>
    </div>
  </body>
</html>
