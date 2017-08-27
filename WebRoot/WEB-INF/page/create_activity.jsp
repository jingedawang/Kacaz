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
    
    <title>创建活动</title>

	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/create_activity.css">

  </head>
  
  <body>
    <div id="header"><h2>创建活动</h2></div>
    <div class="hr"></div>
    <div id="content">
    	<form action="<%=basePath %>action_createActivity.do" method="post">
    		<input id="theme" name="user.id" type="hidden" value="<s:property value="user.id"/>">
    		<input id="theme" name="user.nickname" type="hidden" value="<s:property value="user.nickname"/>">
	    	<table>
	    		<tbody>
	    			<tr>
	    				<td><label for="theme">主题</label></td>
	    				<td><input id="theme" name="activity.theme" type="text" required="required"></td>
	    			</tr>
	    			<tr>
	    				<td><label for="picture">活动配图</label></td>
	    				<td><a id="picture" href="">点击上传</a><br /></td>
	    			</tr>
	    			<tr>
	    				<td><label for="date">活动日期</label></td>
	    				<!-- <td><input id="date" name="activity.date" type="datetime-local"></td> -->
	    				<td><input id="date" name="date" required="required" type="datetime-local"></td>
	    			</tr>
	    			<tr>
	    				<td><label for="place">地点</label></td>
	    				<td><input id="place" name="activity.place" required="required" type="text"></td>
	    			</tr>
	    			<tr>
	    				<td><label for="totalNumber">人数上限</label></td>
	    				<td><input id="totalNumber" name="activity.totalNumber" required="required" type="text"></td>
	    			</tr>
	    			<tr>
	    				<td><label for="detail">详细信息</label></td>
	    				<td><input id="detail" name="activity.detail" required="required" type="text"></td>
	    			</tr>
	    			<tr><td colspan="2"><input id="submit" type="submit" value="提交"></td></tr>
	    		</tbody>
	    	</table>
    	</form>
    </div>
    <div class="hr"></div>
  </body>
</html>
