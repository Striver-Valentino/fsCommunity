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
<title>fs社区 - 赛事报名</title>

<jsp:include page="/commons/common.jsp"></jsp:include>


	<style type="text/css">
        
        h1 {
            text-align: center; 
            padding-top:300px; 
            font-size: 50px; 
            color: purple; 
            font-family:STCaiyun  ; 
        }
    </style>
    
    
    



</head>
<body>

<jsp:include page="/commons/header.jsp"></jsp:include>

<jsp:include page="/commons/GamePartMenu.jsp"></jsp:include>



<div class="layui-container">


			
			<c:choose>
		    	<c:when test="${game.status == 2 }">
		    		<h1>
		    		该赛事报名已截止，<span id="second" style="color:red ">5</span>秒后返回
		    		</h1> <br /><br />
		    		<div align="center">
		    		<a href="javascript:goBack();"> <font color="red" size="5">立即返回</font> </a>
		    		</div>
		    	</c:when>
		    	<c:when test="${game.status == 3 }">
		    		<h1>
		    		该赛事已结束，<span id="second" style="color:red ">5</span>秒后返回
		    		</h1> <br /><br />
		    		<div align="center">
		    		<a href="javascript:goBack();"> <font color="red" size="5">立即返回</font> </a>
		    		</div>
		    	</c:when>
		    	<c:when test="${game.status == 4 }">
		    		<h1>
		    		该赛事已取消，<span id="second" style="color:red ">5</span>秒后返回
		    		</h1> <br /><br />
		    		<div align="center">
		    		<a href="javascript:goBack();"> <font color="red" size="5">立即返回</font> </a>
		    		</div>
		    	</c:when>
		    	<c:otherwise>
		    		<div class="layui-card">
						<div class="layui-card-header"> <font size="6" color="#000000">您正在报名的赛事是：${game.name } </font> </div>
						<div class="layui-card-body">
		
		
		
							<div style="padding: 20px; background-color: #F2F2F2;">
								<div class="layui-row layui-col-space15">
									
									<div class="layui-col-md6">
										<div class="layui-card">
											
											<div class="layui-card-body">
												
												<fieldset class="layui-elem-field">
												  <legend>赛事概况</legend>
												  <div class="layui-field-box">
												  	赛事发起者：${game.launchUserName }<br />
												            目前报名人数：${game.applyCount }<br />
												            发起时间：<fmt:formatDate value="${game.launchDate }" pattern="yyyy-MM-dd HH:mm"/><br />
												  </div>
												</fieldset>
												
												<fieldset class="layui-elem-field">
												  <legend>赛事时间</legend>
												  <div class="layui-field-box">
												            报名截止时间：<fmt:formatDate value="${game.signUpLine }" pattern="yyyy-MM-dd HH:mm"/><br />
												            开始时间：<fmt:formatDate value="${game.startDate }" pattern="yyyy-MM-dd HH:mm"/><br />
												            结束时间：<fmt:formatDate value="${game.endDate }" pattern="yyyy-MM-dd HH:mm"/><br />
												  </div>
												</fieldset>
												
												
											</div>
										</div>
									</div>
									
									<div class="layui-col-md6">
										<div class="layui-card">
											<div class="layui-card-body">
												
												<fieldset class="layui-elem-field">
												  <legend>赛事筹办</legend>
												  <div class="layui-field-box">
												  	主  办  者：${game.sponsorName }<br />
												            承  办  者：${game.undertakeName }<br />
												            赞  助  者：${game.supportName }<br />
												            赛事亮点：${game.edge }<br />
												  </div>
												</fieldset>
												
												
											</div>
										</div>
									</div>
									
								</div>
							</div>
		
							
							
							<div style="padding: 20px; background-color: #F2F2F2;">
								<div class="layui-card">
									  <div class="layui-card-body">
										    <fieldset class="layui-elem-field">
												<legend>赛事说明</legend>
												<div class="layui-field-box">
												  	
												  	<div class="layui-card">
													  <div class="layui-card-body">
														    ${game.descr }<br>
													  </div>
													</div>
												  	
												</div>
											</fieldset>
									  </div>
								</div>
							</div>
		
							<div style="padding: 20px; background-color: #F2F2F2;"> 
								<div align="right">
									<button class="layui-btn" lay-filter="" onclick="signUpNow()">我要报名</button>
									<button class="layui-btn" lay-filter="" onclick="contestants()">查看参赛选手</button>
					      			<button class="layui-btn layui-btn-primary" onclick="goBack1()">返回再看</button>
								</div>
							</div>
		
						</div>
					</div>
		    	</c:otherwise>
		    </c:choose>
			
			
			
			
			
			
			<input type="hidden" id="userid" value="${sessionScope.loginUser.id }" />
			
			<input type="hidden" id="gameid" value="${gameId }" />
			
			<input type="hidden" id="signupGameName" value="${game.name }" />
			
			<input type="hidden" id="gameStatus" value="${game.status }" />
			
			
			<input id="basePath" type="hidden" value="<%=basePath %>"/>

		</div>













<jsp:include page="/commons/footer.jsp"></jsp:include>









<script>
	function goBack1(){ 
		
		var basePath = $('#basePath').val();
		window.location.href = basePath + "toSearchGame";
	}

</script>

<script type="text/javascript">

	function signUpNow(){
		
		
		var basePath = $('#basePath').val();
		
		
		layui.use('layer', function(){
		 	var layer = layui.layer;
			layer.open({
	            id: 'LAY_layuipro', 
	            type: 2,
	            title:'填写报名信息',
	            area: ['1000px', '700px'],
	            fixed: false, 
				maxmin: false, 
	            content: basePath + 'initSignUpDetails', 
	            btn: ['确定','取消'],
	            yes: function(index, layero){
	                var signupdetailForm = $(window.frames["layui-layer-iframe" + index].document).contents().find("#signupdetail");
	                
	                var gameId = $('#gameid').val();
	                var userId = $('#userid').val(); 
	                var signupGameName = $('#signupGameName').val(); 
	                
	                
	                signupdetailForm.ajaxSubmit({ 
	                    data:{"gameId":gameId,"userId":userId,"signupGameName":signupGameName},
	                    type:'post',
	                    dataType:'json',
	                    success:function(result){
	                        if(result.data=='EnrollOK'){
	                            layer.closeAll();
	                            window.location.href = basePath + "user/initUserIndex?Enrollok=ok";
	                            
	                        }else{
	                        	
	                        	var jsonobj=eval("("+result.data+")");
	                        	
	                        	layer.alert(jsonobj.msgError);
	                        	
	                        }
	                    }
	                });
	            },btn2: function(){
	                layer.closeAll();
	            }
	        });
			
		});
		
		
		
		
		
		
		
		
		
		
	}

	

	
</script>



	<script>
		layui.use('layer', function(){
		  var layer = layui.layer;
		  	
		  	var basePath = $('#basePath').val();
			var gameStatus = $('#gameStatus').val();
			
			if(gameStatus != null && gameStatus != "" && gameStatus == "1"){
				
				layer.alert("提示：赛事正在进行中，现在报名可能来不及参加");
				var gameStatus = "";
			}
		});  
	
	</script>

	<script type="text/javascript">
	        var gameStatus = $('#gameStatus').val();
	        
	        if(gameStatus != 1 && gameStatus != 1){ 
	        	var basePath = $('#basePath').val();
	            var span = document.getElementById("second");
	            var intervalId = setInterval(function () {
	                var numstr = span.innerHTML;
	                var num = parseInt(numstr);
	                num--;
	 
	                span.innerHTML = num;
	                if (num <= 0) {
	                    clearInterval(intervalId);
	                    location.href = basePath + "toSearchGame";
	                }
	            }, 1000);
	        }
            
            function goBack(){ 
            	 window.history.go(-1);
            } 
 
    </script>


<script type="text/javascript">

	function contestants(){
		
		var basePath = $('#basePath').val();
		
		var gameId = $('#gameid').val();
		
		layui.use('layer', function(){
		 	var layer = layui.layer;
			layer.open({
	            id: 'LAY_layuipro1', 
	            type: 2,
	            title:'查看参赛选手',
	            area: ['1000px', '700px'],
	            fixed: false, 
				maxmin: false, 
	            content: basePath + 'toShowContestant?gameId=' + gameId, 
	            btn: ['关闭'],
	            yes: function(index, layero){
	            	layer.closeAll();
	            }
	        });
			
		});
		
	}

</script>







































</body>
</html>