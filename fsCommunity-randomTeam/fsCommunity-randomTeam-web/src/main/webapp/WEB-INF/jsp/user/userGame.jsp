<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
			
			<li class="layui-nav-item layui-this"><a href="${pageContext.request.contextPath }/user/initUserIndex">
					<i class="layui-icon">&#xe62d;</i> 我的赛事
			</a></li>
			<li class="layui-nav-item"><a href="${pageContext.request.contextPath }/user/initUserSet"> 
				    <i class="layui-icon">&#xe620;</i> 基本设置
			</a>
			</li>
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
		
    		<c:choose>
		    	<c:when test="${requestScope.userHost.status == 0 }">
		    		<div class="layui-tab layui-tab-brief" lay-filter="user">
						<ul class="layui-tab-title" id="LAY_mine">
							<li data-type="mine-jie" lay-id="index" class="layui-this">我报名的赛事 
							</li>
							<li data-type="collection" data-url="/collection/find/"
								lay-id="collection">我发起的赛事 
							</li>
						</ul>
						<div class="layui-tab-content" style="padding: 20px 0;">
					    
							<div class="layui-tab-item layui-show">
								<ul class="mine-view jie-row">
								
									
									<c:forEach items="${requestScope.enrollList }" var="enroll" varStatus="varSta">
										<li><a class="jie-title" href="${pageContext.request.contextPath }/signUpGame/${enroll.gameId }"
											target="_blank">${enroll.signupGameName }</a> 
											<i><fmt:formatDate value="${enroll.enrollDate }" pattern="yyyy-MM-dd HH:mm"/></i> 
											
											
											<em>
											<a class="mine-edit" href="${pageContext.request.contextPath }/teamVs/toteamVs?gameId=${enroll.gameId }" target="_blank">查看对阵</a>
											</em>
											
										</li>
									</c:forEach>
									
									
								</ul>
								<div id="LAY_page"></div>
							</div>
							
							<div class="layui-tab-item">
								<ul class="mine-view jie-row">
									
									<c:forEach items="${requestScope.launchGameList }" var="launchGame" varStatus="varSta">
										<li><a class="jie-title" href="${pageContext.request.contextPath }/signUpGame/${launchGame.id }"
											target="_blank">${launchGame.name }</a> 
											<i><fmt:formatDate value="${launchGame.launchDate }" pattern="yyyy-MM-dd HH:mm"/></i>
											
											<em>
											<a class="mine-edit" href="${pageContext.request.contextPath }/initOrganizeGame/${launchGame.id }" target="_blank">管理此赛事</a>
											</em>
											
										</li>
									</c:forEach>
								</ul>
								<div id="LAY_page1"></div>
							</div>
							
						</div>
					</div>
		    	</c:when>
		    	<c:otherwise>
		    		
		    		
		    		<div class="fly-panel fly-panel-user" pad20>
					    <div class="layui-tab layui-tab-brief" lay-filter="user">
					      <ul class="layui-tab-title">
					        <li class="layui-this">
					          激活邮箱
					        </li>
					      </ul>
					      <div class="layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
					        <ul class="layui-form">
					          <li class="layui-form-li">
					            <label for="activate">您的邮箱：</label>
					            <span class="layui-form-text">${requestScope.userHost.email }
					              
					              <em style="color:#c00;">（尚未激活）</em>
					            </span>
					          </li>
					          <li class="layui-form-li" style="margin-top: 20px; line-height: 26px;">
					            <div>
					              1. 如果您未收到邮件，或激活链接失效，您可以
					              <a class="layui-form-a" style="color:#4f99cf;" id="LAY-activate" href="${pageContext.request.contextPath }/sendActEmailAgain?userId=${requestScope.userHost.id }" email="{{user.email}}">重新发送邮件</a>
					              	
					            </div>
					            <div>
					              2. 如果您始终没有收到 fs社区 发送的邮件，请注意查看您邮箱中的垃圾邮件；
					            </div>
					            <div>
					              3. 如果你实在无法激活邮件，您还可以联系社区管理员：3540846483@qq.com
					            </div>
					          </li>
					        </ul>
					      </div>
					    </div>
					  </div>
					  
		    	</c:otherwise>
		    </c:choose>
    
    
			
			
			
			
			
			
			
			
		</div>
	</div>





























	
	<input id="Enrollok" type="hidden" value="${Enrollok }" />
	
	
	<input id="cancelGameOK" type="hidden" value="${cancelGameOK }" />
	<input id="cancelGameError" type="hidden" value="${cancelGameError }" />
	
	
	
	<c:choose>
    	<c:when test="${requestScope.userHost.status == 0 }">
    		<input id="actTip" type="hidden" value="0" />
    	</c:when>
    	<c:otherwise>
    		<input id="actTip" type="hidden" value="1" />
    	</c:otherwise>
    </c:choose>
	


	<jsp:include page="/commons/footer.jsp"></jsp:include>




	<script>
		layui.use('layer', function(){
		  var layer = layui.layer;
		  
		  
		    var Enr = $('#Enrollok').val();
			if(Enr != null && Enr != ""){
				
				layer.alert("报名成功！您可以在“我的赛事”里查看。");
				var Enr = "";
			}
			
			var aT = $('#actTip').val();
			if(aT != null && aT != "" && aT == "1"){
				
				layer.alert("请先到邮箱激活用户");
				var aT = "";
			}
			
			
			var cancelGameOK = $('#cancelGameOK').val();
			if(cancelGameOK != null && cancelGameOK != "" && cancelGameOK == "赛事已取消"){
				
				layer.alert(cancelGameOK);
				var cancelGameOK = "";
			}
			
			var cancelGameError = $('#cancelGameError').val();
			if(cancelGameError != null && cancelGameError != ""){
				
				layer.alert(cancelGameError);
				var cancelGameError = "";
			}
			
			
		});  
	
	</script>






</body>
</html>