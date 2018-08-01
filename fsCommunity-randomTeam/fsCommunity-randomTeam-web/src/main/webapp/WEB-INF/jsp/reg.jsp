<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>fs社区 - 注册</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  
  <jsp:include page="/commons/common.jsp"></jsp:include>
  
  
  
</head>
<body>

<jsp:include page="/commons/header.jsp"></jsp:include>



<div class="layui-container fly-marginTop">
  <div class="fly-panel fly-panel-user" pad20>
    <div class="layui-tab layui-tab-brief" lay-filter="user">
      <ul class="layui-tab-title">
        <li><a href="/initlogin">登入</a></li>
        <li class="layui-this">注册</li>
      </ul>
      <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
        <div class="layui-tab-item layui-show">
          <div class="layui-form layui-form-pane">
            <form method="post" action="/reg" name="userreg">
            	
               
              <div class="layui-form-item">
                <label for="L_email" class="layui-form-label">邮箱<font color="red">*</font></label>
                <div class="layui-input-inline" style="width: 260px">
                  <input type="text" id="L_email" name="email" required lay-verify="email" placeholder="注册成功后,请查收邮件激活账号" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">邮箱是您的用户名，也可以帮助您找回密码</div><font size="5" color="red">${regerror }</font>
              </div>
              
              <div class="layui-form-item">
                <label for="L_username" class="layui-form-label">游戏昵称<font color="red">*</font></label>
                <div class="layui-input-inline" style="width: 260px">
                  <input type="text" id="L_username" name="gameName" required lay-verify="required" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">您在游戏中的昵称，如：小龙女</div>
              </div>
              <div class="layui-form-item">
                <label for="L_pass" class="layui-form-label">密码<font color="red">*</font></label>
                <div class="layui-input-inline" style="width: 260px">
                  <input type="password" id="L_pass" name="password" required lay-verify="required|pass" placeholder="建议不要与邮箱本身的密码一样" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">密码可以使用英文、数字，长度必须在10到16位之间</div>
              </div>
              <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">确认密码<font color="red">*</font></label>
                <div class="layui-input-inline" style="width: 260px">
                  <input type="password" id="L_repass" name="repass" required lay-verify="required" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">请再次填写您的密码</div>
              </div>
              
				<div class="layui-form-item">
	                <label for="L_repass" class="layui-form-label">您的头像</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                <button type="button" class="layui-btn" id="headUrlBtn" name="headUrlBtn" autocomplete="off">
					  <i class="layui-icon">&#xe67c;</i>上传头像
					</button>
					
					<input id="headUrl" type="hidden" name="headUrl" />
	              </div>
				
              <div class="layui-form-item">
                <label for="L_vercode" class="layui-form-label">验证码<font color="red">*</font></label>
                <div class="layui-input-inline" style="width: 260px">
                  <input type="text" id="L_vercode" name="vercode" required lay-verify="required" placeholder="请填写验证码" autocomplete="off" class="layui-input">
                </div>
                <div class=""> 
                  
                  <img id="imageCode" src="/imageCode" title="看不清？点击换一张" onclick="changeImage()"></img><font size="5" color="red">${msgvercode }</font>
                </div>
              </div>
              
              <div class="layui-form-item" style="position: relative; left: -10px; height: 32px;"> 
              	  <input id="agree" type="checkbox" name="agreement" lay-skin="primary" lay-verify="" title="" checked="" lay-filter="agree" />
	              <div class="layui-unselect layui-form-checkbox layui-form-checked" lay-skin="primary">
	              	<i class="layui-icon layui-icon-ok"></i>
	              </div> 
	              <a href="/inittermsOfService" target="_blank" style="position: relative; top: 4px; left: 5px; color: #999;">同意用户服务条款</a> 
              </div>
              
              <div class="layui-form-item">
			      <button class="layui-btn" lay-filter="reg" lay-submit>立即注册</button> 
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    
              </div>
              
              
              
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

</div>


<jsp:include page="/commons/footer.jsp"></jsp:include>




<script type="text/javascript">
	function changeImage(){
		var code  =document.getElementById("imageCode");
		code.src="${pageContext.request.contextPath }/imageCode"+"?timestamp=" + new Date().getTime();
				
	}
</script>

<script language="javascript">
     function submitReg () 
     {
         if(CheckPost()) 
         {
             document.userreg.submit();
         }
     }
 
     function CheckPost () 
     {
    	 alert("reg");
          
          return true;
     }
 </script>
 
 
 <script>
	layui.use('form', function(){
	  var form = layui.form;
	  
	  
	  form.on('submit(reg)', function(data){
		  console.log(data.elem); 
		  console.log(data.form); 
		  console.log(data.field); 
		  
		  if(data.form.password.value != data.form.repass.value){
			  layer.alert('两次输入的密码不一样！', {icon: 2});
			  return false;
		  }
		  
		  if(!data.form.agreement.checked){
			  layer.alert('为了方便管理，请您勾选同意用户服务条款', {icon: 7});
			  return false; 
		  }
		  
		  return true;
	  });
	  
	  
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
		    ,'密码必须10到16位，且不能出现空格'
		  ] 
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
	    	  
	    	  layer.alert('上传头像成功');
	    	  
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
layui.cache.page = 'user';
layui.cache.user = {
  username: '游客'
  ,uid: -1
  ,avatar: '../../res/images/avatar/00.jpg'
  ,experience: 83
  ,sex: '男'
};
layui.config({
  version: "3.0.0"
  ,base: '../../res/mods/'
}).extend({
  fly: 'index'
}).use('fly');
</script>

</body>
</html>