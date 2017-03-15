<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>扫描二维码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="js/jquery.min.js"></script>
	<script>
    	$(function(){
   			$("#qrcode").empty().append("<img id='qrImg' />");
   			$("#qrImg").attr("src", "qrcode?website="+$("input[type=text][name=website]").val());
    	});
    </script>

  </head>
  
  <body>
   	<div id="qrcode"></div>
  </body>
</html>
