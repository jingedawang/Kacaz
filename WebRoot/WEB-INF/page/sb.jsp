<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>致黄浅的一封信</title>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<style>
		h1{margin-top: 100px;}
	</style>
	
	<script>
		function alerting() {
			alert("点你妹啊！");
		}
	</script>

  </head>
  
  <body onclick="alerting()">
    <h1><center>浅浅SB</center></h1> <br>
  </body>
</html>
