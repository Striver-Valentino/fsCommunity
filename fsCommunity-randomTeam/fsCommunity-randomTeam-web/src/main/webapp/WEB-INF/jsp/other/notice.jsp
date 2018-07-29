<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>fs社区 - 提示页面</title>

<jsp:include page="/commons/common.jsp"></jsp:include>


<style>
  .notice{width: 600px; margin: 30px auto; padding: 30px 15px; border-top: 5px solid #009688; line-height: 30px;  text-align: center; font-size: 16px; font-weight: 300; background-color: #f2f2f2;}
  
  @media screen and (max-width: 750px) {
    html body{margin-top: 0;}
    .notice{width: auto; margin: 20px 15px; padding: 30px 0;}
  }
  </style>

</head>
<body>

	<jsp:include page="/commons/header.jsp"></jsp:include>

	<jsp:include page="/commons/GamePartMenu.jsp"></jsp:include>


	<!-- 
	<div class="fly-none" style="min-height: 0; padding: 0;">
	  <i class="iconfont icon-tishilian"></i>
	</div> -->
	
	<div class="notice layui-text"> 
		<font size="5" color="red">${requestScope.sendActAgain }</font> <br> <br>
		<font size="5" color="red">${requestScope.regSucPleaseAct }</font> <br> <br>
		
		<a href="${pageContext.request.contextPath }/" target="_blank">fs社区首页</a> <span style="padding:0 5px;"></span> 
		<a href="${pageContext.request.contextPath }/initwebsiteIntroduction" target="_blank">fs社区简介</a> <span style="padding:0 5px;"></span>
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