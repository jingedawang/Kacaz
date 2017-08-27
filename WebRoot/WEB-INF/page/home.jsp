<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>个人主页</title>

	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/home.css">

  </head>
  
  <body>
    <div id="image">
    	<img src="<%=basePath %>img/faye.jpg">
    </div>
    <h2><s:property value="user.nickname"/>test</h2>
    <table id="table1"><tbody><tr>
    	<td>主页</td>
    	<td style="width: 1px; background-color: #bababc;"></td>
    	<td>时间轴</td>
    	<td style="width: 1px; background-color: #bababc;"></td>
    	<td>作品</td>
    </tr></tbody></table>
    
    <div id="profile">
    	<h3>个人简介</h3>
    	<table id="table2"><tbody><tr>
	    	<td style="width: 1px; background-color: #bababc;"></td>
	    	<td style="padding-left: 10px;">
	    		<p>user.profile..hguioewgjioewgioew给我个hi偶尔我飞机哦额外见覅偶为奇偶将佛额外发窘额外见覅哦</p>
	    		<div id="tag">
	    			<img src="<%=basePath %>img/tag.png">
	    			<em>tag1</em>
	    			<em>tag2</em>
	    			<em>tag3</em>
	    		</div>
	    	</td>
    	</tr></tbody></table>
    </div>
    
    <div id="profile">
    	<h3>好友印象</h3>
    	<table id="table2"><tbody><tr>
	    	<td style="width: 1px; background-color: #bababc;"></td>
	    	<td style="padding-left: 10px;">
	    		<div id="tag">
	    			<img src="<%=basePath %>img/tag.png">
	    			<em>tag1</em>
	    			<em>tag2</em>
	    			<em>tag3</em>
	    		</div>
	    	</td>
    	</tr></tbody></table>
    </div>
  </body>
</html>
