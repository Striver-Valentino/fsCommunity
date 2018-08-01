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
				
				<div class="layui-form-item layui-form-text">
					<label class="layui-form-label">请填写您对本赛事的期待</label>
					<div class="layui-input-block">
						<textarea style="height: 100px;" name="descr" placeholder="非必填，请填写您对本赛事的期待，如：你要夺冠。" class="layui-textarea"></textarea>
					</div>
				</div>
				
				
				
			</form>
			
			

		</div>








	<script>
		layui.use('form', function() {
			var form = layui.form;

		});
	</script>

	







</body>
</html>