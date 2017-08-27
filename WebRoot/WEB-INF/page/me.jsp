<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>    
    <title>My JSP 'index.jsp' starting page is <%=basePath %></title>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/index.css">

  </head>
  
  <body>
    <section id="profile">
    	<div id="imageContainer">
			<img id="image" src="<%=basePath %>img/faye.jpg" />
		</div>
		<div id="nickname">
			<div>
				<h2><s:property value="user.nickname"/></h2>
				<s:debug/>
			</div>
			
		</div>
	</section>
	<section id="content">
		<div id="blank"></div>
		<div class="hr"></div>
		<div class="activity">
		我参与的活动
		</div>
		<div class="hr"></div>
		<div class="activity">
		我发起的活动（1个正在进行中）
		</div>
		<div class="hr"></div>
	</section>
  </body>
</html>
