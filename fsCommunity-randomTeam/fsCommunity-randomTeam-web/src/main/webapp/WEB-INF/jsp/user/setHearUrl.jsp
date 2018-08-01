<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>fs社区 - 个人中心</title>

<jsp:include page="/commons/common.jsp"></jsp:include>


</head>
<body>

	<jsp:include page="/commons/header.jsp"></jsp:include>

	<jsp:include page="/commons/GamePartMenu.jsp"></jsp:include>



	<div class="layui-container fly-marginTop fly-user-main">
		<ul class="layui-nav layui-nav-tree layui-inline" lay-filter="user">
			
			<li class="layui-nav-item"><a href="${pageContext.request.contextPath }/user/initUserIndex"> <i
					class="layui-icon">&#xe62d;</i> 我的赛事
			</a></li>
			<li class="layui-nav-item layui-this"><a href="${pageContext.request.contextPath }/user/initUserSet"> <i
					class="layui-icon">&#xe620;</i> 基本设置
			</a></li>
			<li class="layui-nav-item"><a href="${pageContext.request.contextPath }/initMessagePage"> <i
					class="layui-icon">&#xe611;</i> 我的消息
			</a></li>
		</ul>

		<div class="site-tree-mobile layui-hide">
			<i class="layui-icon">&#xe602;</i>
		</div>
		<div class="site-mobile-shade"></div>

		<div class="site-tree-mobile layui-hide">
			<i class="layui-icon">&#xe602;</i>
		</div>
		<div class="site-mobile-shade"></div>


		<div class="fly-panel fly-panel-user" pad20>
			<div class="layui-tab layui-tab-brief" lay-filter="user">
				<ul class="layui-tab-title" id="LAY_mine">
					<li class="layui-this" lay-id="info">我的资料</li>
					<li lay-id="avatar">头像</li>
					<li lay-id="pass">密码</li>
					
				</ul>
				<div class="layui-tab-content" style="padding: 20px 0;">
					<div class="layui-form layui-form-pane layui-tab-item">
						<form method="post" action="/user/updateUserGameName">
							
							
							<p>温馨提示：暂时不支持修改邮箱</p><br />
							
							<div class="layui-form-item">
								<label for="gameName" class="layui-form-label">游戏昵称</label>
								<div class="layui-input-inline">
								
									<input type="text" id="gameName" name="gameName" required
										lay-verify="required" autocomplete="off" value=""
										class="layui-input">
										
									
								    <input id="userId" type="hidden" name="userId" value="${requestScope.userHost.id }"/>
								    
								    <input id="email" type="hidden" name="email" value="${requestScope.userHost.email }"/>
								    
								</div> <font size="5" color="red">${updateGameNameError }</font>
								
							</div>
							
							
							
							<div class="layui-form-item">
								<button class="layui-btn" lay-filter="set-gameName" lay-filter="*"
									lay-submit>确认修改</button>
							</div>
							
							</form>
					</div>

					<div class="layui-form layui-form-pane layui-tab-item layui-show">
						<form action="/user/updateUserHeadUrl" method="post">
						<div class="layui-form-item">
							<div class="avatar-add">
								<p>建议尺寸200*200，支持jpg、png，最大不能超过1000KB</p>
										
								
								<input id="userId" type="hidden" name="userId" value="${requestScope.userHost.id }"/>
								
								<input id="email" type="hidden" name="email" value="${requestScope.userHost.email }"/>
								
								<input id="headUrl" type="hidden" name="headUrl" />
								
								<button type="button" class="layui-btn upload-img" id="headUrlBtn" name="headUrlBtn">
									<i class="layui-icon">&#xe67c;</i>上传头像
								</button>
								<img
									src="${sessionScope.loginUser.headUrl }?imageView2/1/w/200/h/200/">
								<span class="loading"></span>
							</div>
						</div>
						<div class="layui-form-item">
								<button class="layui-btn" lay-filter="set-headUrl" lay-filter="*"
									lay-submit>确认修改</button> <font size="5" color="red">${updateHeadUrlError }</font>
						</div>
						</form>
					</div>

					<div class="layui-form layui-form-pane layui-tab-item">
						<form action="/user/updateUserPassword" method="post">
							
						    <input id="userId" type="hidden" name="userId" value="${requestScope.userHost.id }"/>
						    
							<div class="layui-form-item">
								<label for="L_nowpass" class="layui-form-label">当前密码</label>
								<div class="layui-input-inline">
									<input type="password" id="oldPwd" name="oldPwd" required
										lay-verify="required|pass" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item">
								<label for="L_pass" class="layui-form-label">新密码</label>
								<div class="layui-input-inline">
									<input type="password" id="newPwd" name="newPwd" required
										lay-verify="required|pass" autocomplete="off" class="layui-input">
								</div>
								<div class="layui-form-mid layui-word-aux">密码必须10到16位，且不能出现空格</div>
							</div>
							<div class="layui-form-item">
								<label for="L_repass" class="layui-form-label">确认密码</label>
								<div class="layui-input-inline">
									<input type="password" id="confirmPwd" name="confirmPwd" required
										lay-verify="required|pass" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item">
								<button class="layui-btn" lay-filter="set-repass" lay-filter="*"
									lay-submit>确认修改</button> <font size="5" color="red">${updatePasswordError }</font>
							</div>
						</form>
					</div>

					 </li>
					        

					
					
					
				</div>

			</div>
		</div>
	</div>





























	<input id="updateOK" type="hidden" value="${updateOK }" />
	<input id="updateOK2" type="hidden" value="${updateOK2 }" />
	
	
	<input id="basePath" type="hidden" value="<%=basePath %>"/>


	<jsp:include page="/commons/footer.jsp"></jsp:include>




	<script>
		layui.use('layer', function(){
		  var layer = layui.layer;
		  
		    var upd = $('#updateOK').val();
		    var basePath = $('#basePath').val();
		    
			if(upd != null && upd != ""){
				
				var upd = "";
				
				
				layer.confirm("修改成功，要现在刷新页面吗", { title: "刷新页面" }, function (index) {
	                layer.close(index);
	                window.location.href = basePath + "user/initUserSet?updateOK2=ok2";
	                $.post("user/initUserSet", { updateOK: "ok2" }, function (data) {
	                    layer.alert(data, {
	                        title: "刷新页面",
	                        btn: ['确定']
	                    },
	                        function (index, item) {
	                        });
	                });
	            });
				
			}
			
		});  
	
	</script>
	
	<script>
		layui.use('layer', function(){
		  var layer = layui.layer;
		  
		  
		    var upd2 = $('#updateOK2').val();
			if(upd2 != null && upd2 != ""){
				
				layer.alert("刷新成功！");
				var upd2 = "";
				
			}
		});  
	
	</script>
	
	
	<script type="text/javascript">
		layui.use('form', function(){
			  var form = layui.form;
			  
			  form.on('submit(set-gameName)', function(data){
				  return true;
			  });
			  
		});
	</script>
	
	<script type="text/javascript">
		layui.use('form', function(){
			  var form = layui.form;
			  
			  form.on('submit(set-headUrl)', function(data){
				  return true;
			  });
			  
		});
	</script>
	
	<script>
		layui.use('form', function(){
			  var form = layui.form;
			  
			  form.on('submit(set-repass)', function(data){
				  
				  console.log(data.elem); 
				  console.log(data.form);
				  console.log(data.field);  
				  
				  
				  if(data.form.newPwd.value != data.form.confirmPwd.value){
					  layer.alert('两次输入的密码不一样！', {icon: 2});
					  return false;
				  }
				  
				  return true;
			  });
			  
		});
	</script>
	
	
	

<script>
	layui.use('upload', function(){
	  var upload = layui.upload;
	   
	  var uploadInst = upload.render({
	    elem: '#headUrlBtn'  
	    ,url: '/uploadImage' 
	    
    	, before: function(obj){ 
    	    layer.load(); 
    	}
	  
	    ,done: function(res, index, upload){
	    	layer.closeAll('loading'); 
	    	
	      
	      if(res.code == 0){
	    	  $('#headUrl').val(res.imageUrl);
	    	  
	    	  layer.alert('上传头像成功，请点击“确认修改”使修改生效');
	    	  
	      }
	      if(res.code == 1){
	    	layer.alert('上传出错了，请刷新页面后再重新上传');
	      }
	      
	     
	    }
	    ,error: function(){
	      layer.alert('上传异常了');
	    }
	    
	    ,accept: 'images' 
	    ,size: 3000 
	    
	  });
	});
</script>



<script>
	layui.use('form', function(){
	  var form = layui.form;
	  
	  form.verify({
		  username: function(value, item){ 
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
	  
		  ,pass: [
		    /^[\S]{10,16}$/
		    ,'所有的密码都必须是10到16位，且不能出现空格'
		  ] 
		});  
	  
	});
</script>




</body>
</html>