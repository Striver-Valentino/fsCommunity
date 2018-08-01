<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>header.jsp</title>

<jsp:include page="/commons/common.jsp"></jsp:include>


</head>
<body>


<div class="fly-header layui-bg-black">
		<div class="layui-container">

			
				<a class="fly-logo" href="/">
					<img src="http://pbjixg82v.bkt.clouddn.com/fs%E7%A4%BE%E5%8C%BAlogo.jpg" alt="layui">
				</a>
				
			<ul class="layui-nav fly-nav layui-hide-xs">
				<li class="layui-nav-item layui-this"><a href="/">
						<i class="layui-icon">&#xe613;</i>赛事组队</a></li>
				<li class="layui-nav-item"><a href="javascript:void(0);" onclick="undetermined()">
											<i class="layui-icon">&#xe631;</i>活动工具</a></li>
				<li class="layui-nav-item"><a href="javascript:void(0);" onclick="undetermined()"
					target="_blank"><i class="layui-icon">&#xe63a;</i>讨论区</a></li>
			</ul>

			<ul class="layui-nav fly-nav-user">
			
				<c:choose>
			    	<c:when test="${!empty requestScope.userHost }"> 
			    	  
				      <li class="layui-nav-item">
				        <a class="fly-nav-avatar" href="javascript:;">
				          <cite class="layui-hide-xs">${requestScope.userHost.gameName }</cite>
				          
				          
				          
				          <img src="${requestScope.userHost.headUrl }?imageView2/1/w/100/h/100/">
				        </a>
				        
				        <li class="layui-nav-item">
					      	<a href="javascript:void(0)" style="text-align: right;"><i class="layui-icon">&#xe61a;</i></a>
					    	
					    	<dl class="layui-nav-child">
					    	 
					    	  <dd><a href="${pageContext.request.contextPath }/user/initUserIndex"><i class="layui-icon" style="margin-left: 2px; font-size: 22px;">&#xe62d;</i>我的赛事</a></dd>
					          <dd><a href="${pageContext.request.contextPath }/user/initUserSet"><i class="layui-icon">&#xe620;</i>基本设置</a></dd>
					          
					          <dd><a href="${pageContext.request.contextPath }/initMessagePage"><i class="iconfont icon-tongzhi" style="top: 4px;"></i>我的消息</a></dd>
					          
					          
					          
					          <hr style="margin: 5px 0;">
					          <dd><a href="/logout" style="text-align: center;">退出</a></dd>
					        </dl>
					    </li>
				        
				        
				      </li>
				      
				      
			    		
			    	</c:when>
			    	<c:otherwise>
			    		
						<li class="layui-nav-item"><a
							class="iconfont icon-touxiang layui-hide-xs" href="/initlogin"></a>
						</li>
						<li class="layui-nav-item"><a href="/initlogin">登入</a></li>
						<li class="layui-nav-item"><a href="/initreg">注册</a></li>
		
						
			    	</c:otherwise>
			    </c:choose>
			
			
			

				

				
			</ul>
		</div>
	</div>




	
	<c:choose>
    	<c:when test="${empty requestScope.userHost }">
    		<input id="loginis" type="hidden" value="no" />
    	</c:when>
    	<c:otherwise>
    		
    	</c:otherwise>
    </c:choose>



	<script>
		layui.use('layer', function(){
		  var layer = layui.layer;
		  
			var loginis = $('#loginis').val();
			if(loginis != null && loginis != "" && loginis == "no"){
				
				layer.alert("请先登陆或注册");
				var loginis = "";
			}
		});  
	
	</script>





</body>
</html>