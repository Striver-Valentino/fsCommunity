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
			
			 
			<li class="layui-nav-item"><a href="${pageContext.request.contextPath }/user/initUserIndex"> <i
					class="layui-icon">&#xe62d;</i> 我的赛事
			</a></li>
			<li class="layui-nav-item"><a href="${pageContext.request.contextPath }/user/initUserSet"> <i
					class="layui-icon">&#xe620;</i> 基本设置
			</a></li>
			<li class="layui-nav-item layui-this"><a href="${pageContext.request.contextPath }/initMessagePage">
					<i class="layui-icon">&#xe611;</i> 我的消息
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
			<div class="layui-tab layui-tab-brief" lay-filter="user" id="LAY_msg"
				style="margin-top: 15px;">
				
				<div id="LAY_minemsg" style="margin-top: 10px;">
					
					<c:choose>
				    	<c:when test="${empty requestScope.viewMapList }">
				    		<div class="fly-none">您暂时没有最新消息</div>
				    	</c:when>
				    	<c:otherwise>
				    		<ul class="mine-msg">
								
								
								<c:forEach items="${viewMapList }" var="viewMap" varStatus="varSta">
									<li data-id="123">
										<blockquote class="layui-elem-quote">
											${viewMap['fromUserName']}  发给    ${viewMap['toUserName']} ：${viewMap['message'].content}
										</blockquote>
										<p>
											<span><fmt:formatDate value="${viewMap['message'].createdDate}" pattern="yyyy-MM-dd HH:mm"/></span>
											<a href="${pageContext.request.contextPath }/deleteMessage?messageId=${viewMap['message'].id}" class="layui-btn layui-btn-small layui-btn-danger fly-delete">删除</a>
										</p>
									</li>
								</c:forEach>
								
							</ul>
				    	</c:otherwise>
				    </c:choose>
					
				</div>
			</div>
		</div>

	</div>






























	<input id="delMessageOK" type="hidden" value="${delMessageOK }" />
	<input id="delMessageError" type="hidden" value="${delMessageError }" />

	<jsp:include page="/commons/footer.jsp"></jsp:include>




	<script>
		layui.use('layer', function() {
			var layer = layui.layer;

			var delok = $('#delMessageOK').val();
			var deler = $('#delMessageError').val();
			
			if (delok != null && delok != "" && delok == "delMessageOK") {

				layer.alert("删除成功");
				var delok = "";
			}
			
			if (deler != null && deler != "" && deler == "删除出错") {

				layer.alert("删除出错");
				var deler = "";
			}
			
		});
	</script>






</body>
</html>