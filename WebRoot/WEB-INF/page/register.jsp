<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
	
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/register.css">

  </head>
  
  <body>
    <h2>注册</h2>
    <div class="hr"></div>
    <div id="content">
    	<form action="<%=basePath %>action_register.do" method="post">
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
