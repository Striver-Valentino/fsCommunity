<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>fs社区 - 让我们一起组队</title>

<jsp:include page="/commons/common.jsp"></jsp:include>


</head>
<body>

	<jsp:include page="/commons/header.jsp"></jsp:include>

	<jsp:include page="/commons/GamePartMenu.jsp"></jsp:include>

	<!-- 如果是未激活用户，显示重新发送邮件链接 -->
	<c:choose>
		<%-- 先判断是否已经登陆 --%>
    	<c:when test="${empty requestScope.userHost }">
    		<%-- 如果没有登陆，不显示  “重新发送激活邮件” --%>
    		
    	</c:when>
    	<c:when test="${requestScope.userHost.status == 0 }">
    		<%-- 如果登陆了，并且 用户状态是0，就说明是 已 激活 用户，不显示  “重新发送激活邮件” --%>
		    
		</c:when>
    	<c:otherwise>
    		<%-- 如果前面两个 when 都不成立，即 登陆了，并且 状态 不是 0，那就是 未激活 用户 --%>
    		<div align="center">
    		<font color="red" size="5">
    		<a class="layui-form-a" style="color:#4f99cf;" id="LAY-activate" href="${pageContext.request.contextPath }/sendActEmailAgain?userId=${requestScope.userHost.id }">重新发送激活邮件</a>
    		</font>
    		<hr />
    		</div>
    	</c:otherwise>
    </c:choose>
	

	
	
	
	
	
<div class="layui-container">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md12">
      <div class="fly-panel">
        <div class="fly-panel-title fly-filter">
          <a><font size="4">欢迎来到fs社区</font></a>
        </div>
       
       <div class="layui-carousel" id="test1">
		  <div carousel-item>
		    <div><a href="${pageContext.request.contextPath }/initwebsiteIntroduction"><img src="http://pbjixg82v.bkt.clouddn.com/fs%E7%A4%BE%E5%8C%BA%E6%AC%A2%E8%BF%8E%E4%BD%A0.jpg"></a></div>
		    <div><a href="${pageContext.request.contextPath }/initLaunch"><img src="http://pbjixg82v.bkt.clouddn.com/%E4%BD%A0%E6%9D%A5%E5%8F%91%E8%B5%B7%E4%B8%80%E5%9C%BA%E6%AF%94%E8%B5%9B.jpg"></a></div>
		    <div><a href="${pageContext.request.contextPath }/toSearchGame"><img src="http://pbjixg82v.bkt.clouddn.com/%E6%9D%A5%E4%B8%80%E8%B5%B7%E6%89%93%E7%90%83%E5%90%A7.jpg"></a></div>
		  </div>
		</div>
       
      </div>









      <div class="fly-panel" style="margin-bottom: 0;">
      
      	<div class="fly-panel-title fly-filter">
      	  <a><font size="4">最新赛事</font></a>
        </div>
        
        <div class="layui-container">
			<ul class="layui-timeline">
				
				<c:forEach items="${gameList }" var="game" varStatus="varSta">
					<li class="layui-timeline-item">
					    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
					    <div class="layui-timeline-content layui-text">
					      <h3 class="layui-timeline-title"><fmt:formatDate value="${game.startDate }" pattern="yyyy-MM-dd HH:mm"/></h3>
					      <p>
					        <a href="${pageContext.request.contextPath }signUpGame/{game.id }"><font size="3">${game.name }</font> </a> 
					        <br>主办者：${game.sponsorName }
					        <br>发起者：${game.launchUserName }
					      </p>
					    </div>
					</li>
				
			    </c:forEach>
			  
			</ul>
		</div>


      </div>
    </div>
    
  </div>
</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	<input id="regSuc" type="hidden" value="${regsuc }" />
	<input id="loginSuc" type="hidden" value="${loginsuc }" />
	<input id="regActSuc" type="hidden" value="${regActSuc }" />
	
	<!-- 如果是未激活用户，弹框 提示 激活 -->
	<c:choose>
		<%-- 先判断是否已经登陆 --%>
    	<c:when test="${empty requestScope.userHost }">
    		<%-- 如果没有登陆，就什么都不做 --%>
    		
    	</c:when>
    	<c:when test="${requestScope.userHost.status == 0 }">
    		<%-- 如果登陆了，并且 用户状态是0，就说明是 已 激活 用户 --%>
		    <input id="actTip" type="hidden" value="0" />
		</c:when>
    	<c:otherwise>
    		<%-- 如果前面两个 when 都不成立，即 登陆了，并且 状态 不是 0，那就是 未激活 用户 --%>
    		<input id="actTip" type="hidden" value="1" />
    	</c:otherwise>
    </c:choose>
    
    

	<jsp:include page="/commons/footer.jsp"></jsp:include>










	<script>
		layui.use('carousel', function(){
		  var carousel = layui.carousel;
		  //建造实例
		  carousel.render({
		    elem: '#test1'
		    ,width: '100%' //设置容器宽度
		    ,arrow: 'always' //始终显示箭头
		    //,anim: 'updown' //切换动画方式
		  });
		});
	</script>


	<script>
		layui.use('layer', function(){
		  var layer = layui.layer;
		  
		  //layer.msg('hello');
		  
		    var regs = $('#regSuc').val();
		    //alert(regs);
			if(regs != null && regs != ""){
				//layer.msg('注册成功！fs社区欢迎您！', {icon: 6});
				layer.alert('您已注册成功，请到注册邮箱点击链接激活用户', {icon: 6}); 
				var regs = "";
			}
			
			var logins = $('#loginSuc').val();
			//alert(logins);
			if(logins != null && logins != ""){
				layer.msg('登录成功！fs社区欢迎您！', {icon: 6});
				var logins = "";
			}
			
			var rASuc = $('#regActSuc').val();
			//alert(rASuc);
			if(rASuc != null && rASuc != "" && rASuc == "激活成功"){
				layer.msg('您已激活成功！fs社区欢迎您！', {icon: 6});
				var rASuc = "";
			}
			
		});  
	
	</script>


	<script>
		layui.use('layer', function(){
		  var layer = layui.layer;
		  
			var aT = $('#actTip').val();
			if(aT != null && aT != "" && aT == "1"){
				
				layer.alert("请先到邮箱激活用户");
				var aT = "";
			}
		});  
	
	</script>







</body>
</html>