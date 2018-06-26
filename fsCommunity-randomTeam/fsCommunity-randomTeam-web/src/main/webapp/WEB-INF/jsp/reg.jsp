<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>fs社区 - 注册</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="keywords" content="fly,layui,前端社区">
  <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
  
  <jsp:include page="/commons/common.jsp"></jsp:include>
  
  
  
</head>
<body>

<jsp:include page="/commons/header.jsp"></jsp:include>



<div class="layui-container fly-marginTop">
  <div class="fly-panel fly-panel-user" pad20>
    <div class="layui-tab layui-tab-brief" lay-filter="user">
      <ul class="layui-tab-title">
        <li><a href="login.html">登入</a></li>
        <li class="layui-this">注册</li>
      </ul>
      <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
        <div class="layui-tab-item layui-show">
          <div class="layui-form layui-form-pane">
            <form method="post" action="/reg" name="userreg">
            	<!-- 
            	<div class="layui-form-item">
                <label for="L_email" class="layui-form-label">用户名</label>
                <div class="layui-input-inline">
                  <input type="text" id="L_email" name="email" required lay-verify="email" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">4~20个字符，请以字母开头</div>
              </div>
               -->
               
              <div class="layui-form-item">
                <label for="L_email" class="layui-form-label">邮箱<font color="red">*</font></label>
                <div class="layui-input-inline">
                  <input type="text" id="L_email" name="email" required lay-verify="email" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">邮箱是您的用户名，也可以帮助您找回密码</div><font size="5" color="red">${regerror }</font>
              </div>
              <div class="layui-form-item">
                <label for="L_username" class="layui-form-label">游戏昵称<font color="red">*</font></label>
                <div class="layui-input-inline">
                  <input type="text" id="L_username" name="gameName" required lay-verify="required" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">您在游戏中的昵称，如：小龙女</div>
              </div>
              <div class="layui-form-item">
                <label for="L_pass" class="layui-form-label">密码<font color="red">*</font></label>
                <div class="layui-input-inline">
                  <input type="password" id="L_pass" name="password" required lay-verify="required|pass" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">密码可以使用英文、数字，长度必须在10到16位之间</div>
              </div>
              <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">确认密码<font color="red">*</font></label>
                <div class="layui-input-inline">
                  <input type="password" id="L_repass" name="repass" required lay-verify="required" autocomplete="off" class="layui-input">
                </div>
              </div>
              <div class="layui-form-item">
                <label for="L_vercode" class="layui-form-label">验证码<font color="red">*</font></label>
                <div class="layui-input-inline">
                  <input type="text" id="L_vercode" name="vercode" required lay-verify="required" placeholder="请填写验证码" autocomplete="off" class="layui-input">
                </div>
                <div class=""> <!-- layui-form-mid -->
                  <!-- <span style="color: #c00;">{{d.vercode}}</span> -->
                  <img id="imageCode" src="/imageCode" title="看不清？点击换一张" onclick="changeImage()"></img><font size="5" color="red">${msgvercode }</font>
                </div>
              </div>
              
              <div class="layui-form-item" style="position: relative; left: -10px; height: 32px;"> 
              	  <input id="agree" type="checkbox" name="agreement" lay-skin="primary" lay-verify="" title="" checked="" lay-filter="agree" />
	              <div class="layui-unselect layui-form-checkbox layui-form-checked" lay-skin="primary">
	              	<i class="layui-icon layui-icon-ok"></i>
	              </div> 
	              <a href="/instructions/terms.html" target="_blank" style="position: relative; top: 4px; left: 5px; color: #999;">同意用户服务条款</a> 
              </div>
              
              <div class="layui-form-item">
			      <button class="layui-btn" lay-filter="reg" lay-submit>立即注册</button> <!-- onclick="submitReg();" -->
			      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			    
              </div>
              
              <!--
              <div class="layui-form-item fly-form-app">
                <span>或者直接使用社交账号快捷注册</span>
                <a href="" onclick="layer.msg('正在通过QQ登入', {icon:16, shade: 0.1, time:0})" class="iconfont icon-qq" title="QQ登入"></a>
                <a href="" onclick="layer.msg('正在通过微博登入', {icon:16, shade: 0.1, time:0})" class="iconfont icon-weibo" title="微博登入"></a>
              </div>
              -->
              
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>

</div>


<jsp:include page="/commons/footer.jsp"></jsp:include>

<!-- 
<div class="fly-footer">
  <p><a href="http://fly.layui.com/" target="_blank">Fly社区</a> 2017 &copy; <a href="http://www.layui.com/" target="_blank">layui.com 出品</a></p>
  <p>
    <a href="http://fly.layui.com/jie/3147/" target="_blank">付费计划</a>
    <a href="http://www.layui.com/template/fly/" target="_blank">获取Fly社区模版</a>
    <a href="http://fly.layui.com/jie/2461/" target="_blank">微信公众号</a>
  </p>
</div>
 -->


<script type="text/javascript">
	//换一张验证码
	function changeImage(){
		//不需要直接再发一次请求，只需要改变src的地址
		var code  =document.getElementById("imageCode");
		code.src="${pageContext.request.contextPath }/imageCode"+"?timestamp=" + new Date().getTime();
				
		//$("#imageCode").attr("src","${pageContext.request.contextPath }/imageCode");
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
          /*if (userreg.user.value == "") 
          {
                alert("请填写用户名！");
                addForm.username.focus();
                return false;
          }
          if (addForm.title.value.length < 5) 
          {
                alert("标题不能少于5个字符！");
                addForm.title.focus();
                return false;
          }*/
          return true;
     }
 </script>
 
 
 <script>
	layui.use('form', function(){
	  var form = layui.form;
	  
	  //各种基于事件的操作，下面会有进一步介绍
	  
	  form.on('submit(reg)', function(data){
		  console.log(data.elem); //被执行事件的元素DOM对象，一般为button对象
		  console.log(data.form); //被执行提交的form对象，一般在存在form标签时才会返回
		  console.log(data.field);  //当前容器的全部表单字段，名值对形式：{name: value}
		  
		  if(data.form.password.value != data.form.repass.value){
			  //alert(data.form.pass.value);
			  //alert(data.form.repass.value);
			  layer.alert('两次输入的密码不一样！');
			  return false;
		  }
		  
		  if(!data.form.agreement.checked){
			  layer.alert('为了方便管理，请您勾选同意用户服务条款');
			  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
		  }
		  
		  //layer.alert('两次的密码一样！');
		  //alert("hello");
		  return true;
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