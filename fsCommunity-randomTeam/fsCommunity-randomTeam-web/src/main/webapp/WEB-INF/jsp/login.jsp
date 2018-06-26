<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>fs社区 - 登录</title>

<jsp:include page="/commons/common.jsp"></jsp:include>


</head>
<body>

<jsp:include page="/commons/header.jsp"></jsp:include>





<div class="layui-container fly-marginTop">
  <div class="fly-panel fly-panel-user" pad20>
    <div class="layui-tab layui-tab-brief" lay-filter="user">
      <ul class="layui-tab-title">
        <li class="layui-this">登入</li>
        <li><a href="/initreg">注册</a></li>
      </ul>
      <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
        <div class="layui-tab-item layui-show">
          <div class="layui-form layui-form-pane">
            <form method="post" action="/login" name="userlogin">
              <!-- 
            	<div class="layui-form-item">
                <label for="L_email" class="layui-form-label">用户名</label>
                <div class="layui-input-inline">
                  <input type="text" id="L_email" name="email" required lay-verify="required" autocomplete="off" class="layui-input">
                </div>
              </div>
               -->
               
              <div class="layui-form-item">
                <label for="L_email" class="layui-form-label">邮箱<font color="red">*</font></label> <font size="5" color="red">${loginerror }</font>
                <div class="layui-input-inline">
                  <input type="text" id="L_email" name="email" required lay-verify="required" autocomplete="off" class="layui-input">
                </div>
              </div>
              <div class="layui-form-item">
                <label for="L_pass" class="layui-form-label">密码<font color="red">*</font></label>
                <div class="layui-input-inline">
                  <input type="password" id="L_pass" name="password" required lay-verify="required" autocomplete="off" class="layui-input">
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
              <!-- 
              <div class="layui-form-item">
                <label for="L_vercode" class="layui-form-label">人类验证</label>
                <div class="layui-input-inline">
                  <input type="text" id="L_vercode" name="vercode" required lay-verify="required" placeholder="请回答后面的问题" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid">
                  <span style="color: #c00;">{{d.vercode}}</span>
                </div>
              </div>
               -->
              
              <div class="layui-form-item">
                <button class="layui-btn" lay-filter="login" lay-submit>立即登录</button>
                <span style="padding-left:20px;">
                  <a href="forget.html">忘记密码？</a>
                </span>
              </div>
              
              <!--
              <div class="layui-form-item fly-form-app">
                <span>或者使用社交账号登入</span>
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



<script type="text/javascript">
	//换一张验证码
	function changeImage(){
		//不需要直接再发一次请求，只需要改变src的地址
		var code  =document.getElementById("imageCode");
		code.src="${pageContext.request.contextPath }/imageCode"+"?timestamp=" + new Date().getTime();
				
		//$("#imageCode").attr("src","${pageContext.request.contextPath }/imageCode");
	}
</script>

<script>
	layui.use('form', function(){
	  var form = layui.form;
	  
	  //各种基于事件的操作，下面会有进一步介绍
	  
	  form.on('submit(login)', function(data){
		  console.log(data.elem); //被执行事件的元素DOM对象，一般为button对象
		  console.log(data.form); //被执行提交的form对象，一般在存在form标签时才会返回
		  console.log(data.field);  //当前容器的全部表单字段，名值对形式：{name: value}
		  //alert("login");
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