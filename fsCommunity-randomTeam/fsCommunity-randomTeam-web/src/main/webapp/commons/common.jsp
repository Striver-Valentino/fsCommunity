<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="/res/layui/css/layui.css" />
<link rel="stylesheet" type="text/css" href="/res/css/global.css" />

<style>
	.layui-table-page{
		text-align: center;
	}
</style>


<script type="text/javascript" src="/res/jquery.min.js"></script>
<script type="text/javascript" src="/res/jquery-form.js"></script>
<script type="text/javascript" src="/res/layui/layui.js"></script>

<script>
	function undetermined(){
		layer.alert('暂未开放');
	}
</script>

<script>
	layui.use('element', function(){
	  var element = layui.element;
	  
	});
</script>