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


<div class="fly-header layui-bg-black">
		<div class="layui-container">

			<!--
				<a class="fly-logo" href="/">
					<img src="../res/images/logo.png" alt="layui">
				</a>
				-->
			<ul class="layui-nav fly-nav layui-hide-xs">
				<li class="layui-nav-item layui-this"><a href="/">
						<i class="layui-icon">&#xe613;</i>赛事组队</a></li>
				<li class="layui-nav-item"><a href="javascript:void(0);" onclick="undetermined()">
											<i class="layui-icon">&#xe631;</i>活动工具</a></li>
				<li class="layui-nav-item"><a href="javascript:void(0);" onclick="undetermined()"
					target="_blank"><i class="layui-icon">&#xe63a;</i>讨论区</a></li>
			</ul>

			<ul class="layui-nav fly-nav-user">

				<!-- 未登入的状态 -->
				<li class="layui-nav-item"><a
					class="iconfont icon-touxiang layui-hide-xs" href="user/login.html"></a>
				</li>
				<li class="layui-nav-item"><a href="user/login.html">登入</a></li>
				<li class="layui-nav-item"><a href="user/reg.html">注册</a></li>

				<!--
					<li class="layui-nav-item layui-hide-xs">
						<a href="/app/qq/" onclick="layer.msg('正在通过QQ登入', {icon:16, shade: 0.1, time:0})" title="QQ登入" class="iconfont icon-qq"></a>
					</li>
					<li class="layui-nav-item layui-hide-xs">
						<a href="/app/weibo/" onclick="layer.msg('正在通过微博登入', {icon:16, shade: 0.1, time:0})" title="微博登入" class="iconfont icon-weibo"></a>
					</li>
					-->

				<!-- 登入后的状态 -->
				<!--
      <li class="layui-nav-item">
        <a class="fly-nav-avatar" href="javascript:;">
          <cite class="layui-hide-xs">贤心</cite>
          <i class="iconfont icon-renzheng layui-hide-xs" title="认证信息：layui 作者"></i>
          <i class="layui-badge fly-badge-vip layui-hide-xs">VIP3</i>
          <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg">
        </a>
        <dl class="layui-nav-child">
          <dd><a href="user/set.html"><i class="layui-icon">&#xe620;</i>基本设置</a></dd>
          <dd><a href="user/message.html"><i class="iconfont icon-tongzhi" style="top: 4px;"></i>我的消息</a></dd>
          <dd><a href="user/home.html"><i class="layui-icon" style="margin-left: 2px; font-size: 22px;">&#xe68e;</i>我的主页</a></dd>
          <hr style="margin: 5px 0;">
          <dd><a href="/user/logout/" style="text-align: center;">退出</a></dd>
        </dl>
      </li>
      -->
			</ul>
		</div>
	</div>













</body>
</html>