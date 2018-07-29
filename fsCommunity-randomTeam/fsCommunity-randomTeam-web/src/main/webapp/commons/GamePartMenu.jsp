<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>header.jsp</title>

<jsp:include page="/commons/common.jsp"></jsp:include>


</head>
<body>


<div class="fly-panel fly-column">
		<div class="layui-container">
			<ul class="layui-clear">
				<!-- <li class="layui-hide-xs layui-this"><a href="/">首页</a></li> -->
				<li><a href="/">首页</a></li>
				<li><a href="/initLaunch">发起赛事</a></li>
				<li><a href="/toSearchGame">赛事报名</a></li>
				<li><a href="javascript:void(0);" onclick="undetermined()">排行榜</a></li>
				<li><a href="/initwebsiteIntroduction">fs社区简介</a></li>
				<li><a href="javascript:void(0);" onclick="undetermined()">公告</a></li>
				<li><a href="javascript:void(0);" onclick="undetermined()">动态</a></li>
				<li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block"><span
					class="fly-mid"></span></li>

				<!-- 用户登入后显示
				<li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block">
					<a href="user/index.html">我的报名</a>
				</li>
				<li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block">
					<a href="user/index.html#collection">我收藏的贴</a>
				</li>
				 -->
			</ul>

			<!-- 
			<div class="fly-column-right layui-hide-xs">
				<span class="fly-search"><i class="layui-icon"></i></span> <a
					href="jie/add.html" class="layui-btn">发表新帖</a>
			</div>
			<div class="layui-hide-sm layui-show-xs-block"
				style="margin-top: -10px; padding-bottom: 10px; text-align: center;">
				<a href="jie/add.html" class="layui-btn">发表新帖</a>
			</div>
			 -->
			
		</div>
	</div>













</body>
</html>