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
    
    <title>失败</title>

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		h2{text-align: center; font-family: "Microsoft Yahei"; margin-top: 100px;}
	</style>

  </head>
  
  <body>
    <h2>失败:<s:property value="#session.fail"/></h2>
  </body>
</html>
