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
        /*h1标签样式*/
        h1 {
            text-align: center; /*居中*/
            padding-top:300px; /*距离顶部300px*/
            font-size: 50px; /*字体大小*/
            color: purple; /*字体颜色*/
            font-family:STCaiyun  ; /*设置字体为华文彩云*/
        }
    </style>
    
    
    



</head>
<body>

<jsp:include page="/commons/header.jsp"></jsp:include>

<jsp:include page="/commons/GamePartMenu.jsp"></jsp:include>



<div class="layui-container">


			<!-- 检查赛事状态 -->
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
											<!-- <div class="layui-card-header">卡片面板</div> -->
											<div class="layui-card-body">
												
												<fieldset class="layui-elem-field">
												  <legend>赛事概况</legend>
												  <div class="layui-field-box">
												  	赛事发起者：${game.launchUserName }<br />
												            目前报名人数：${game.applyCount }<br />
												    <%-- 发起时间：${game.launchDateDisplay }<br /> --%>
												            发起时间：<fmt:formatDate value="${game.launchDate }" pattern="yyyy-MM-dd HH:mm"/><br />
												  </div>
												</fieldset>
												
												<fieldset class="layui-elem-field">
												  <legend>赛事时间</legend>
												  <div class="layui-field-box">
												  <%-- 
												  	报名截止时间：${game.signUpLineDisplay }<br />
												            开始时间：${game.startDateDisplay }<br />
												            结束时间：${game.endDateDisplay }<br />
												       --%>      
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
			
			
			
			
			
			<!-- 隐藏域，保存用户id与赛事id -->
			<input type="hidden" id="userid" value="${sessionScope.loginUser.id }" />
			<!-- <input type="hidden" id="gameid" value="${game.id }" /> -->
			<input type="hidden" id="gameid" value="${gameId }" />
			<!-- 赛事名称 -->
			<input type="hidden" id="signupGameName" value="${game.name }" />
			<!-- 赛事状态 -->
			<input type="hidden" id="gameStatus" value="${game.status }" />
			
			<!-- 绝对路径，项目路径 -->
			<input id="basePath" type="hidden" value="<%=basePath %>"/>

		</div>













<jsp:include page="/commons/footer.jsp"></jsp:include>









<script>
	function goBack1(){ // 如果用 goBack() 命名 方法 ，会与 内置 的 返回方法（也叫goBack()）  冲突
		
		var basePath = $('#basePath').val();
		//alert("goBack1");
		window.location.href = basePath + "toSearchGame";
	}

</script>

<script type="text/javascript">

	function signUpNow(){
		/*layui.use('layer', function(){
		 	var layer = layui.layer;
		  
			//iframe层-父子操作
			layer.open({
			  type: 2,
			  area: ['1000px', '700px'],
			  fixed: false, //不固定
			  maxmin: false, // 可 最大化、最小化
			  content: 'initSignUpDetails'
			  
			  success: function(layero, index){
			    var body = layer.getChildFrame('body', index);
			    var iframeWin = window[layero.find('iframe')[0]['name']]; //得到iframe页的窗口对象，执行iframe页的方法：iframeWin.method();
			    alert(iframeWin);
			    console.log(body.html()); //得到iframe页的body内容
			    body.find('input').val('Hi，我是从父页来的');
			  }
			
			});
		  
		  
		  
		}); */
		
		//alert("我要报名");
		var basePath = $('#basePath').val();
		
		
		layui.use('layer', function(){
		 	var layer = layui.layer;
			layer.open({
	            id: 'LAY_layuipro', //设定一个id，防止重复弹出
	            type: 2,
	            title:'填写报名信息',
	            area: ['1000px', '700px'],
	            fixed: false, //不固定
				maxmin: false, // 可 最大化、最小化
	            content: basePath + 'initSignUpDetails', // 弹出的小窗口的页面内容，从 这个 请求 链接 获得
	            btn: ['确定','取消'],
	            yes: function(index, layero){
	            	//alert("yes1");
	            	// 获得 子页面 的 表单对象
	                var signupdetailForm = $(window.frames["layui-layer-iframe" + index].document).contents().find("#signupdetail");
	                //alert(signupdetailForm);
	                
	                var gameId = $('#gameid').val();
	                var userId = $('#userid').val(); 
	                var signupGameName = $('#signupGameName').val(); 
	                
	                //alert(gameId);
	                //alert(userId);
	                
	                signupdetailForm.ajaxSubmit({ // 子页面 的 表单对象 以 ajax 方式 提交
	                    url:'/submitEnroll',
	                    data:{"gameId":gameId,"userId":userId,"signupGameName":signupGameName},
	                    type:'post',
	                    dataType:'json',
	                    success:function(result){
	                    	//alert("hello");
	                    	//alert(result);
	                        if(result.data=='EnrollOK'){
	                            layer.closeAll();
	                            //layer.alert("报名成功！");
	                            //alert("报名");
	                            //reloadData();   // 重新加载列表
	                            //window.location.href = "/";
	                            window.location.href = basePath + "user/initUserIndex?Enrollok=ok";
	                            
	                        }else{
	                        	//alert("error");
	                        	//alert(result.data);
	                        	
	                        	var jsonobj=eval("("+result.data+")");
	                        	
	                        	layer.alert(jsonobj.msgError);
	                        	
	                        }
	                    }
	                });
	                //alert("yes2");
	            },btn2: function(){
	            	//alert("no");
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
	    // JavaScript 倒计时页面跳转
	        var gameStatus = $('#gameStatus').val();
	        
	        if(gameStatus != 1 && gameStatus != 1){ // 赛事状态不是0，并且也不是1的时候，才执行下面操作
	        	var basePath = $('#basePath').val();
	            var span = document.getElementById("second");
	            // setInterval就是开启一个计时器，里面传入一个方法和一个时间
	            // 表示每隔这个时间间隔调用一次这个方法
	            var intervalId = setInterval(function () {
	                // var num = span.innerHTML - 1;    //等价下面三行
	                //innerHTML：获得或设置一个标签下的内容（内容可以是HTML格式的）：
	                var numstr = span.innerHTML;
	                var num = parseInt(numstr);
	                num--;
	 
	                span.innerHTML = num;
	                //alert("在倒计时");
	                if (num <= 0) {
	                    // 停下计时器
	                    clearInterval(intervalId);
	                    //跳转到赛事搜索页
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
	            id: 'LAY_layuipro1', //设定一个id，防止重复弹出
	            type: 2,
	            title:'查看参赛选手',
	            area: ['1000px', '700px'],
	            fixed: false, //不固定
				maxmin: false, // 可 最大化、最小化
	            content: basePath + 'toShowContestant?gameId=' + gameId, // 弹出的小窗口的页面内容，从 这个 请求 链接 获得
	            //btn: ['关闭','取消'],
	            btn: ['关闭'],
	            yes: function(index, layero){
	            	layer.closeAll();
	            }/*,btn2: function(){
	                layer.closeAll();
	            }*/
	        });
			
		});
		
	}

</script>







































</body>
</html>