<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>fs社区 - 发起赛事</title>

<jsp:include page="/commons/common.jsp"></jsp:include>


</head>
<body>

	<jsp:include page="/commons/header.jsp"></jsp:include>
	
	<jsp:include page="/commons/GamePartMenu.jsp"></jsp:include>



	


	

	<div class="layui-container">
		<div class="layui-card">
			  <div class="layui-card-body">
			  		<form id="launchForm" class="layui-form" action="/launchGame" method="post">
						<blockquote class="layui-elem-quote layui-quote-nm"> <font size="6" color="#000000">您正在发起赛事 </font> </blockquote>
						
						
						<div class="layui-form-item">
							<label class="layui-form-label">赛事名称</label>
							<div class="layui-input-block" style="width: 500px;">
								<input type="text" name="name" placeholder="请输入您要发起的赛事名称，如：XXX水友赛" required lay-verify="required" autocomplete="off" class="layui-input" value=""><font size="3" color="red">${launchError }</font>
							</div>
						</div>
						
						<div class="layui-form-item">
							<label class="layui-form-label">开始时间</label>
							<div class="layui-input-block" style="width: 500px;">
								<input type="text" size="1" name="startDate1" class="layui-input" id="startDate" placeholder="请输入您要发起的赛事的开始时间，记得选时分秒" required lay-verify="required" />
							</div>
						</div>
						
						<div class="layui-form-item">
							<label class="layui-form-label">结束时间</label>
							<div class="layui-input-block" style="width: 500px;">
								<input type="text" size="1" name="endDate1" class="layui-input" id="endDate" placeholder="请输入您要发起的赛事的结束时间，记得选时分秒" required lay-verify="required" />
							</div>
						</div>
						
						<div class="layui-form-item">
							<label class="layui-form-label">截止报名</label>
							<div class="layui-input-block" style="width: 500px;">
								<input type="text" size="1" name="signUpLine1" class="layui-input" id="signUpLine" placeholder="请输入您要发起的赛事的截止报名时间，记得选时分秒" required lay-verify="required" />
							</div>
						</div>
						
						<div class="layui-form-item">
							<label class="layui-form-label">主办者</label>
							<div class="layui-input-block" style="width: 500px;">
								<input type="text" name="sponsorName" placeholder="请输入您要发起的赛事的主办者，如：小龙女" required lay-verify="required" autocomplete="off" class="layui-input" value="">
							</div>
						</div>
						
						<div class="layui-form-item">
							<label class="layui-form-label">承办者</label>
							<div class="layui-input-block" style="width: 500px;">
								<input type="text" name="undertakeName" placeholder="请输入您要发起的赛事的承办者，如：qq群。非必填。" autocomplete="off" class="layui-input" value="">
							</div>
						</div>
						
						<div class="layui-form-item">
							<label class="layui-form-label">赞助者</label>
							<div class="layui-input-block" style="width: 500px;">
								<input type="text" name="supportName" placeholder="请输入您要发起的赛事的赞助者，如：XX俱乐部。非必填。" autocomplete="off" class="layui-input" value="">
							</div>
						</div>
						
						<div class="layui-form-item">
							<label class="layui-form-label">赛事亮点</label>
							<div class="layui-input-block" style="width: 500px;">
								<input type="text" name="edge" placeholder="请输入您要发起的赛事的赛事亮点，如：奖励多，妹子多。" required lay-verify="required" autocomplete="off" class="layui-input" value="">
							</div>
						</div>
						
						
						<div class="layui-form-item layui-form-text">
							<label class="layui-form-label">赛事说明</label>
							<div class="layui-input-block">
								<textarea style="height: 200px;" name="descr" placeholder="非必填，您可以填写您要发起的赛事的比赛规则、奖励规则等等。" class="layui-textarea"></textarea>
							</div>
						</div>
						
						<div class="layui-form-item">
							<div class="layui-input-block">
								<button class="layui-btn" lay-submit lay-filter="launch">发起赛事</button>
								<!-- <input class="layui-btn" lay-submit lay-filter="launch" value="发起赛事"> -->
								<button type="reset" class="layui-btn layui-btn-primary">重置</button>
							</div>
						</div>
					</form>
			  </div>
	    </div>
			
	</div>
	
	


	<jsp:include page="/commons/footer.jsp"></jsp:include>






	

     
	<script>
		/******** 日历组件  *********/
		layui.use('laydate', function() {
			var laydate = layui.laydate;

			
			laydate.render({
			  elem: '#startDate'
			  ,type: 'datetime'
			});
			
			laydate.render({
			  elem: '#endDate'
			  ,type: 'datetime'
			});
			
			laydate.render({
			  elem: '#signUpLine'
			  ,type: 'datetime'
			});
		});
	</script>
	

	
	
	
<script>
	layui.use('form', function(){
	  var form = layui.form;
	  
	  //各种基于事件的操作，下面会有进一步介绍
	  
	  form.on('submit(launch)', function(data){
		  console.log(data.elem); //被执行事件的元素DOM对象，一般为button对象
		  console.log(data.form); //被执行提交的form对象，一般在存在form标签时才会返回
		  console.log(data.field);  //当前容器的全部表单字段，名值对形式：{name: value}
		  
		  //alert(data.form.startDate1.value);
		  //alert(data.form.endDate1.value);
		  //alert(data.form.signUpLine1.value);
		  // 报名截止时间 <= 开始时间 <= 结束时间
	      if(data.form.startDate1.value > data.form.endDate1.value){
			  
			  layer.alert('赛事开始时间不能晚于结束时间！', {icon: 2});
			  return false;
		  }
		  if(data.form.signUpLine1.value > data.form.startDate1.value){
			  
			  layer.alert('报名截止时间不能晚于开始时间！！', {icon: 2});
			  return false;
		  }
		  
		  //alert("前面");
			
		   layer.confirm('是否确定发起赛事?', {
			  btn: ['确认','取消'] //按钮
		   }, function(){
			    //alert(1);
			    //layer.msg('发起成功！您可以在“个人中心”->“我发起的赛事”中查看', {icon: 1});
			    $("#launchForm").submit();//重点一！！！模拟提交！！
		   }, function(){
			    //alert(2);
				layer.msg('已取消..');
			    return false;
		   });
		   return false;//重点二！！！！  阻止提交行为！！
		
	  });
	  
	 
	  form.verify({
		  username: function(value, item){ //value：表单的值、item：表单的DOM对象
		    if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
		      return '用户名不能有特殊字符';
		    }
		    if(/(^\_)|(\__)|(\_+$)/.test(value)){
		      return '用户名首尾不能出现下划线\'_\'';
		    }
		    if(/^\d+\d+\d$/.test(value)){
		      return '用户名不能全为数字';
		    }
		  }
	  
		  //我们既支持上述函数式的方式，也支持下述数组的形式
		  //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
		  ,pass: [
		    /^[\S]{10,16}$/
		    ,'密码必须10到16位，且不能出现空格'
		  ] 
		});  
	  
	  
	  
	  
	  
	  
	  
	});
</script>
	











</body>
</html>