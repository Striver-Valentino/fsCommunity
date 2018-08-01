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
<title>fs社区 - 管理赛事</title>

<jsp:include page="/commons/common.jsp"></jsp:include>


</head>
<body>

	<jsp:include page="/commons/header.jsp"></jsp:include>

	<jsp:include page="/commons/GamePartMenu.jsp"></jsp:include>


	<div class="layui-container">
		<div class="layui-card">
		<div class="layui-card-header"> <font size="6" color="#000000">您正在管理的赛事是：${game.name } </font> </div>
			  <div class="layui-card-body">
			    	<br />
			  		<a href="javascript:void(0)" class="layui-btn" lay-filter="" onclick="startGroup()">开始分组</a>
					<a href="${pageContext.request.contextPath }/cancelGame?gameId=${game.id } " class="layui-btn layui-btn-primary">取消该赛事</a>
			  			
			  </div>
		</div>
	</div>

	
	<div class="layui-container">
		<div class="layui-card">
			  <div class="layui-card-body">
			    
			  		<hr class="layui-bg-black">
			  			
			  </div>
		</div>
	</div>

	<div class="layui-container">
		<div class="layui-card">
		<div class="layui-card-header"> <font size="5" color="#000000">已报名的选手列表： </font> </div>
			  <div class="layui-card-body">
			    
			  		<table class="layui-hide" id="contestants"></table>
			  			
			  </div>
		</div>
	</div>






	<input id="gameId" type="hidden" value="${game.id }" />
	
	<input id="startGroupError" type="hidden" value="${startGroupError }" />
	
	<input id="gameGroupStatus" type="hidden" value="${game.groupStatus }" />
	
	<input id="basePath" type="hidden" value="<%=basePath %>"/>


	<jsp:include page="/commons/footer.jsp"></jsp:include>



	<script>
		layui.use('table', function(){
		  var table = layui.table;
		  
		  var gameId = $('#gameId').val(); 
		  
		  table.render({
		    elem: '#contestants'
		    ,url:'/showContestant/' + gameId
		    ,cellMinWidth: 70 
		    ,method: 'get'     
			,skin: 'line' 
			,even: true 
			,size: 'lg' 
			,page : true 
		    ,cols: [[
		      {field:'signupGameName', title: '赛事名称', sort: true, align: 'center'}
		      ,{field:'signupUserGameName', title: '选手名', sort: true, align: 'center'} 
		      ,{field:'position', title: '游戏职业', sort: true, align: 'center'}
		      ,{field:'rating', title: 'rating', sort: true, align: 'center'}
		      ,{field:'descr', title: '想说的话', sort: true, align: 'center'} 
		      ,{field:'enrollDate', title: '报名时间', sort: true, align: 'center',templet:'<div>{{ Format(d.enrollDate,"yyyy-MM-dd hh:mm:ss")}}</div>'}
		    ]]
		  });
		});
		
		
		function Format(datetime,fmt) {
		  if (parseInt(datetime)==datetime) {
		    if (datetime.length==10) {
		      datetime=parseInt(datetime)*1000;
		    } else if(datetime.length==13) {
		      datetime=parseInt(datetime);
		    }
		  }
		  datetime=new Date(datetime);
		  var o = {
		  "M+" : datetime.getMonth()+1,                 
		  "d+" : datetime.getDate(),                    
		  "h+" : datetime.getHours(),                   
		  "m+" : datetime.getMinutes(),                 
		  "s+" : datetime.getSeconds(),                 
		  "q+" : Math.floor((datetime.getMonth()+3)/3), 
		  "S"  : datetime.getMilliseconds()             
		  };   
		  if(/(y+)/.test(fmt))   
		  fmt=fmt.replace(RegExp.$1, (datetime.getFullYear()+"").substr(4 - RegExp.$1.length));   
		  for(var k in o)   
		  if(new RegExp("("+ k +")").test(fmt))   
		  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
		  return fmt;
		}
		console.log(Format("1507353913000","yyyy-M-d h:m:s.S"));
		
	</script>
	
	<script>
		layui.use('layer', function(){
		  var layer = layui.layer;
		  
		  
		    var startGroupError = $('#startGroupError').val();
			if(startGroupError != null && startGroupError != ""){
				
				layer.alert(startGroupError);
				var startGroupError = "";
			}
			
		});  
	
	</script>


	<script type="text/javascript">
		function startGroup(){
			
			var basePath = $('#basePath').val();
			var gameId = $('#gameId').val();
			var gameGroupStatus = $('#gameGroupStatus').val(); 
			
			
			if(gameGroupStatus == 1){
				
				layui.use('layer', function(){
				  var layer = layui.layer;
				  
				  layer.alert("该赛事已经分组，请不要重复分组");
				}); 
				
			}else{
				window.location.href = basePath + "team/startGroup?gameId=" + gameId;
			}
			
		}
			
		function cancelGame(){
			alert("cancelGame");
			
			
			
		}
	
	</script>
	
	







</body>
</html>