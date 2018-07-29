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
			<!-- 
			<li class="layui-nav-item"><a href="home.html"> <i
					class="layui-icon">&#xe609;</i> 我的主页
			</a></li>
			 -->
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
					<!-- <li lay-id="bind">帐号绑定</li> -->
				</ul>
				<div class="layui-tab-content" style="padding: 20px 0;">
					<div class="layui-form layui-form-pane layui-tab-item layui-show">
						<form method="post" action="/user/updateUserGameName">
							<!-- 
							<div class="layui-form-item">
								<label for="L_email" class="layui-form-label">邮箱</label>
								<div class="layui-input-inline">
									<input type="text" id="L_email" name="email" required
										lay-verify="email" autocomplete="off" value=""
										class="layui-input">
								</div>
								<div class="layui-form-mid layui-word-aux">
									如果您在邮箱已激活的情况下，变更了邮箱，需<a href="activate.html"
										style="font-size: 12px; color: #4f99cf;">重新验证邮箱</a>。
								</div>
							</div>
							 -->
							
							<p>温馨提示：暂时不支持修改邮箱</p><br />
							
							<div class="layui-form-item">
								<label for="gameName" class="layui-form-label">游戏昵称</label>
								<div class="layui-input-inline">
								
									<input type="text" id="gameName" name="gameName" required
										lay-verify="required" autocomplete="off" value=""
										class="layui-input">
										
									<!-- 用户id -->
								    <input id="userId" type="hidden" name="userId" value="${requestScope.userHost.id }"/>
								    <!-- 用户邮箱（邮箱在数据库是非空约束，必须要有） -->
								    <input id="email" type="hidden" name="email" value="${requestScope.userHost.email }"/>
								    
								</div> <font size="5" color="red">${updateGameNameError }</font>
								<!-- 
								<div class="layui-inline">
									<div class="layui-input-inline">
										<input type="radio" name="sex" value="0" checked title="男">
										<input type="radio" name="sex" value="1" title="女">
									</div>
								</div>
								 -->
							</div>
							
							<!-- 
							<div class="layui-form-item">
								<label for="L_city" class="layui-form-label">城市</label>
								<div class="layui-input-inline">
									<input type="text" id="L_city" name="city" autocomplete="off"
										value="" class="layui-input">
								</div>
							</div>
							 -->
							<!-- 
							<div class="layui-form-item layui-form-text">
								<label for="L_sign" class="layui-form-label">签名</label>
								<div class="layui-input-block">
									<textarea placeholder="随便写些什么刷下存在感" id="L_sign" name="sign"
										autocomplete="off" class="layui-textarea"
										style="height: 80px;"></textarea>
								</div>
							</div>
							 -->
							<div class="layui-form-item">
								<button class="layui-btn" lay-filter="set-gameName" lay-filter="*"
									lay-submit>确认修改</button>
							</div>
							
							</form>
					</div>

					<div class="layui-form layui-form-pane layui-tab-item">
						<form action="/user/updateUserHeadUrl" method="post">
						<div class="layui-form-item">
							<div class="avatar-add">
								<p>建议尺寸200*200，支持jpg、png，最大不能超过1000KB</p>
										
								<!-- 用户id -->
								<input id="userId" type="hidden" name="userId" value="${requestScope.userHost.id }"/>
								<!-- 用户邮箱（邮箱在数据库是非空约束，必须要有） -->
								<input id="email" type="hidden" name="email" value="${requestScope.userHost.email }"/>
								<!-- 保存用户头像的链接 -->
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
							<!-- 用户id -->
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

					<!-- 
					<div class="layui-form layui-form-pane layui-tab-item">
						<ul class="app-bind">
							<li class="fly-msg app-havebind"><i class="iconfont icon-qq"></i>
								<span>已成功绑定，您可以使用QQ帐号直接登录Fly社区，当然，您也可以</span> <a
								href="javascript:;" class="acc-unbind" type="qq_id">解除绑定</a>  --> <!-- <a href="" onclick="layer.msg('正在绑定微博QQ', {icon:16, shade: 0.1, time:0})" class="acc-bind" type="qq_id">立即绑定</a>
                <span>，即可使用QQ帐号登录Fly社区</span> --></li>
					      <!-- <li class="fly-msg"><i class="iconfont icon-weibo"></i> -->  <!-- <span>已成功绑定，您可以使用微博直接登录Fly社区，当然，您也可以</span>
                <a href="javascript:;" class="acc-unbind" type="weibo_id">解除绑定</a> -->

					<!-- 
								<a href="" class="acc-weibo" type="weibo_id"
								onclick="layer.msg('正在绑定微博', {icon:16, shade: 0.1, time:0})">立即绑定</a>
								<span>，即可使用微博帐号登录Fly社区</span></li>
						</ul>
					</div>
					 -->
					
					
				</div>

			</div>
		</div>
	</div>





























	<input id="updateOK" type="hidden" value="${updateOK }" />
	<input id="updateOK2" type="hidden" value="${updateOK2 }" />
	
	<!-- 绝对路径，项目路径 -->
	<input id="basePath" type="hidden" value="<%=basePath %>"/>


	<jsp:include page="/commons/footer.jsp"></jsp:include>




	<script>
		layui.use('layer', function(){
		  var layer = layui.layer;
		  
		    var upd = $('#updateOK').val();
		    var basePath = $('#basePath').val();
		    
			if(upd != null && upd != ""){
				
				var upd = "";
				
				//window.location.href = ${pageContext.request.contextPath } + "user/initUserSet?updateOK2=ok2";
				//window.location.reload();
				//layer.alert("修改成功！");
				
				
				layer.confirm("修改成功，要现在刷新页面吗", { title: "刷新页面" }, function (index) {
	                layer.close(index);
	                //alert("刷新前");
	                window.location.href = basePath + "user/initUserSet?updateOK2=ok2";
	                //alert("刷新后");
	                $.post("user/initUserSet", { updateOK: "ok2" }, function (data) {
	                    layer.alert(data, {
	                        title: "刷新页面",
	                        btn: ['确定']
	                    },
	                        function (index, item) {
	                            //layer.close(index);
	                            //alert("刷新前");
	                            //window.location.reload();
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
		    //alert("Enr");
		    //alert(Enr);
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
				  
				  console.log(data.elem); //被执行事件的元素DOM对象，一般为button对象
				  console.log(data.form); //被执行提交的form对象，一般在存在form标签时才会返回
				  console.log(data.field);  //当前容器的全部表单字段，名值对形式：{name: value}
				  
				  //alert(data.form.newPwd.value);
				  //alert(data.form.confirmPwd.value);
				  
				  if(data.form.newPwd.value != data.form.confirmPwd.value){
					  //alert(data.form.newPwd.value);
					  //alert(data.form.confirmPwd.value);
					  layer.alert('两次输入的密码不一样！', {icon: 2});
					  return false;
				  }
				  
				  return true;
			  });
			  
		});
	</script>
	
	
	

<script>
    // 图片上传 js
	layui.use('upload', function(){
	  var upload = layui.upload;
	   
	  //执行实例
	  var uploadInst = upload.render({
	    elem: '#headUrlBtn'  // 绑定元素
	    ,url: '/uploadImage' //上传接口
	    
    	, before: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
    	    layer.load(); //上传loading
    	}
	  
	    ,done: function(res, index, upload){
	    	layer.closeAll('loading'); //关闭loading
	    	
	      //上传完毕回调
	      //alert("上传完毕回调");
	      
	    	//alert(res);
	    	//alert(res.code);
	    	
	      //var jsonobj=eval("("+res+")");
	      
	      //alert(jsonobj);
	      
	      if(res.code == 0){
	          //do something （比如将res返回的图片链接保存到表单的隐藏域）
	          //alert("上传成功");
	    	  //alert("图片链接" + res.imageUrl);
	    	  $('#headUrl').val(res.imageUrl);
	    	  
	    	  layer.alert('上传头像成功，请点击“确认修改”使修改生效');
	    	  
	      }
	      if(res.code == 1){
	    	layer.alert('上传出错了，请刷新页面后再重新上传');
	      	//alert("上传出错");
	      }
	      
	      //alert($('#headUrl').val());
	     
	    }
	    ,error: function(){
	      //请求异常回调
	      //alert("请求异常回调");
	      layer.alert('上传异常了');
	    }
	    
	    ,accept: 'images' //允许上传的文件类型
	    ,size: 3000 //最大允许上传的文件大小,单位 KB
	    
	  });
	});
</script>



<script>
	layui.use('form', function(){
	  var form = layui.form;
	  
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
		    ,'所有的密码都必须是10到16位，且不能出现空格'
		  ] 
		});  
	  
	});
</script>




</body>
</html>