<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>fs社区 - 正在报名</title>

<jsp:include page="/commons/common.jsp"></jsp:include>


</head>
<body>




	<div class="layui-container">
			<form class="layui-form" id="signupdetail">
				<blockquote class="layui-elem-quote layui-quote-nm"><font size="6" color="#000000"> 请填写您的报名信息 </font></blockquote>
				
				<!-- 
				<div class="layui-form-item">
					<label class="layui-form-label">请选择您的参赛职业</label>
					<div class="layui-input-block">
						<select name="zhiye" lay-filter="aihao">
							<option value="C">C</option>
							<option value="PF">PF</option>
							<option value="SF">SF</option>
							<option value="SG">SG</option>
							<option value="PG">PG</option>
							<option value="SW">SW</option>
						</select>
					</div>
				</div>
				 -->
				
				<!-- 
				<div class="layui-form-item">
					<label class="layui-form-label">游戏昵称</label>
					<div class="layui-input-block">
						<input type="text" name="gameName" placeholder="请输入您在游戏中的昵称，如：小龙女" autocomplete="off" class="layui-input" value="">
					</div>
				</div>
				 -->
				
				<!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素
				<div class="layui-form-item">
					<label class="layui-form-label">游戏角色名</label>
					<div class="layui-input-block">
						<input type="text" name="" placeholder="请输入您要用来参赛的游戏角色名" autocomplete="off" class="layui-input">
					</div>
				</div> -->
				
				
				
				<div class="layui-form-item">
					<label class="layui-form-label">请选择您的参赛职业</label>
					<div class="layui-input-block" id="position">
						<input type="checkbox" name="position" title="C" value="C" >
						<input type="checkbox" name="position" title="PF" value="PF" >
						<input type="checkbox" name="position" title="SF" value="SF" >
						<input type="checkbox" name="position" title="SG" value="SG" >
						<input type="checkbox" name="position" title="PG" value="PG" >
						<input type="checkbox" name="position" title="SW" value="SW" >
					</div>
				</div>
				
				<!--
				<div class="layui-form-item">
					<label class="layui-form-label">开关关</label>
					<div class="layui-input-block">
						<input type="checkbox" lay-skin="switch">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">开关开</label>
					<div class="layui-input-block">
						<input type="checkbox" checked lay-skin="switch">
					</div>
				</div>
				-->
				
				<div class="layui-form-item">
					<label class="layui-form-label">请选择您的游戏RT</label>
					<div class="layui-input-block">
						<input type="radio" name="rating" value="SSS" title="SSS">
						<input type="radio" name="rating" value="SS" title="SS">
						<input type="radio" name="rating" value="S" title="S">
						<input type="radio" name="rating" value="AAA" title="AAA">
						<input type="radio" name="rating" value="AA" title="AA">
						<input type="radio" name="rating" value="A" title="A">
						<input type="radio" name="rating" value="B" title="B">
						<input type="radio" name="rating" value="C" title="C" checked>
					</div>
				</div>
				<!-- 
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">请填写您对本赛事的期待</label>
					<div class="layui-input-block">
						<textarea placeholder="非必填，请填写您对本赛事的期待，如：你要夺冠" class="layui-textarea"></textarea>
					</div>
				</div> -->
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">请填写您对本赛事的期待</label>
					<div class="layui-input-block">
						<textarea style="height: 100px;" name="descr" placeholder="非必填，请填写您对本赛事的期待，如：你要夺冠。" class="layui-textarea"></textarea>
					</div>
				</div>
				
				<!-- 
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="enroll">确定</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
				 -->
				<!-- 更多表单结构排版请移步文档左侧【页面元素-表单】一项阅览 -->
			</form>
			
			

		</div>








	<script>
		layui.use('form', function() {
			var form = layui.form;

			//各种基于事件的操作，下面会有进一步介绍
		});
	</script>

	







</body>
</html>