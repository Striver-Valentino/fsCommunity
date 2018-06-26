<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>index.jsp</title>

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
				<li class="layui-nav-item"><a href="/jsp/login.jsp">登入</a></li>
				<li class="layui-nav-item"><a href="/initreg">注册</a></li>

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

	<div class="fly-panel fly-column">
		<div class="layui-container">
			<ul class="layui-clear">
				<li class="layui-hide-xs layui-this"><a href="/">首页</a></li>
				<li><a href="jie/index.html">发起赛事</a></li>
				<li><a href="jie/index.html">赛事报名</a></li>
				<li><a href="jie/index.html">查看我的报名</a></li>
				<li><a href="jie/index.html">fs社区使用说明</a></li>
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



	<div class="layui-container">
		<table id="demo" lay-filter="test" border="1"></table>
	</div>
















	<script>
		layui.use('table', function() {
			var table = layui.table;

			//第一个实例
			table.render({
				elem : '#demo',
				//height : 'full-20',
				url : '/showAllGames' //数据接口
				,skin: 'line' //行边框风格
				,even: true //开启隔行背景
				,size: 'lg' //小尺寸的表格
				,page : true //开启分页
				,
				cols : [ [ //表头
				{
					field : 'name',
					title : '赛事名称',
					width : 200,
					sort : true,
					//fixed : 'left',
					sort : true
				}, {
					field : 'sponsorName',
					title : '发起者',
					width : 150,
					sort : true
				}, {
					field : 'organizerId',
					title : '组织者',
					width : 150,
					sort : true
				}, {
					field : 'startDate',
					title : '开始时间',
					width : 150,
					sort : true
				}, {
					field : 'endDate',
					title : '结束时间',
					width : 150,
					sort : true
				}, {
					field : 'applyCount',
					title : '已报名人数',
					width : 150,
					sort : true
				}, {
					field : 'status',
					title : '状态',
					width : 100,
					sort : true
				}, {title : '报名', width:115, align:'center', toolbar: '#barDemo'} //这里的toolbar值是模板元素的选择器 
				] ]
			});

		});
	</script>


	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs" lay-event="detail">报名</a>
	</script>


	<script type="text/html" id="barDemo1">
  <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
  
  <!-- 这里同样支持 laytpl 语法，如： -->
  {{#  if(d.auth > 2){ }}
    <a class="layui-btn layui-btn-xs" lay-event="check">审核</a>
  {{#  } }}
	</script>



	<script>
		/*$(function(){
			$('#undetermined1').click(function(){
    			alert("敬请期待")
    		});
				
		});*/
	
		/*$(document).ready(function(){
			$('#undetermined1').click(function(){
    			alert("敬请期待");
    		});
    		
    		
    	});*/
		
    	//layui.use('layer', callback);
    	
		function undetermined(){
			//alert("敬请期待");
			layer.alert('敬请期待');
		}
	
	</script>







</body>
</html>