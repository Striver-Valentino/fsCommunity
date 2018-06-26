<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>fs社区 - 让我们一起组队</title>

<jsp:include page="/commons/common.jsp"></jsp:include>


</head>
<body>

	<jsp:include page="/commons/header.jsp"></jsp:include>


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


	<jsp:include page="/commons/footer.jsp"></jsp:include>













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