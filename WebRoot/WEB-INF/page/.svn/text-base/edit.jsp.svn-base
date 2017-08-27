<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>编辑个人信息</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/edit.css">
  </head>
  
  <body>
    <h2>编辑个人信息</h2>
    <div class="hr"></div>
    <div id="content">
    	<form action="<%=basePath %>action_edit.do" method="post">
    		<label>昵称</label>
    		<input name="user.nickname" type="text"><br />
    		<input type="hidden" name="username.weixin" value="<s:property value="#session.weixin"/>">
    		<a href="">上传头像</a><br />
    		<input type="submit" value="提交">
    	</form>
    </div>
    <div class="hr"></div>
  </body>
</html>
