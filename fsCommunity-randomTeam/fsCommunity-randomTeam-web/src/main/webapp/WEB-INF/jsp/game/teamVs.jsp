<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>fs社区 - 赛事对阵</title>

<jsp:include page="/commons/common.jsp"></jsp:include>


</head>
<body>

	<jsp:include page="/commons/header.jsp"></jsp:include>

	<jsp:include page="/commons/GamePartMenu.jsp"></jsp:include>


	<div class="layui-container">
		<div class="layui-card">
		<div class="layui-card-header"> <font size="6" color="#000000">${game.name } - 对阵情况 </font> </div>
			  <div class="layui-card-body">
			    	<br />
			    	<!-- 
			  		<a href="${pageContext.request.contextPath }/initOrganizeGame/${launchGame.id }" class="layui-btn" lay-filter="">开始分组</a>
					<a href="${pageContext.request.contextPath }/cancelGame?gameId=${game.id } " class="layui-btn layui-btn-primary">取消该赛事</a>
			  		 -->	
			  </div>
		</div>
	</div>


	<div class="layui-container">
		<div class="layui-card">
		<div class="layui-card-header"> <font size="5" color="#000000">对阵情况： </font> </div>
			  <div class="layui-card-body">
			    
			  		<table class="layui-hide" id="teamVs"></table>
			  			
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
		<div class="layui-card-header"> <font size="5" color="#000000">所有队伍： </font> </div>
			  <div class="layui-card-body">
			    
			  		<table class="layui-hide" id="teams"></table>
			  			
			  </div>
		</div>
	</div>




	<input id="gameId" type="hidden" value="${game.id }" />

	<input id="startGroupOK" type="hidden" value="${startGroupOK }" />



	<jsp:include page="/commons/footer.jsp"></jsp:include>



	<script>
		layui.use('table', function(){
		  var table = layui.table;
		  
		  var gameId = $('#gameId').val(); 
		  
		  table.render({
		    elem: '#teamVs'
		    ,url:'/teamVs/selectAllTeamVsByGameId/' + gameId
		    ,cellMinWidth: 70 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
		    ,method: 'get'     // get 方式提交
			,skin: 'line' //行边框风格
			,even: true //开启隔行背景
			,size: 'lg' //大尺寸的表格
			,page : true //开启分页
		    ,cols: [[
	          {type:'numbers'}
		      ,{field:'team1Name', title: '队伍', sort: true, align: 'center'}
		      ,{field:'team1Lineup', title: '阵容', sort: true, align: 'center'} //width 支持：数字、百分比和不填写。你还可以通过 minWidth 参数局部定义当前单元格的最小宽度，layui 2.2.1 新增
		      ,{field:'vsSign', title: '   ', align: 'center'}
		      ,{field:'team2Name', title: '队伍', sort: true, align: 'center'}
		      ,{field:'team2Lineup', title: '阵容', sort: true, align: 'center'}
		    ]]
		  });
		});
		
		
		
		/*
			时间格式化
		*/
		
		// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
		// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
		// 例子：   
		//Format("2016-10-04 8:9:4.423","yyyy-MM-dd hh:mm:ss.S") ==> 2016-10-04 08:09:04.423   
		// Format("1507353913000","yyyy-M-d h:m:s.S")      ==> 2017-10-7 13:25:13.0  
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
		  "M+" : datetime.getMonth()+1,                 //月份   
		  "d+" : datetime.getDate(),                    //日   
		  "h+" : datetime.getHours(),                   //小时   
		  "m+" : datetime.getMinutes(),                 //分   
		  "s+" : datetime.getSeconds(),                 //秒   
		  "q+" : Math.floor((datetime.getMonth()+3)/3), //季度   
		  "S"  : datetime.getMilliseconds()             //毫秒   
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
		layui.use('table', function(){
		  var table = layui.table;
		  
		  var gameId = $('#gameId').val(); 
		  
		  table.render({
		    elem: '#teams'
		    ,url:'/team/selectAllTeamByGameId/' + gameId
		    ,cellMinWidth: 70 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
		    ,method: 'get'     // get 方式提交
			,skin: 'line' //行边框风格
			,even: true //开启隔行背景
			,size: 'lg' //大尺寸的表格
			,page : true //开启分页
		    ,cols: [[
              {type:'numbers'}
		      ,{field:'member1GameName', title: '队员1', sort: true, align: 'center'}
		      ,{field:'member2GameName', title: '队员2', sort: true, align: 'center'} //width 支持：数字、百分比和不填写。你还可以通过 minWidth 参数局部定义当前单元格的最小宽度，layui 2.2.1 新增
		      ,{field:'member3GameName', title: '队员3', sort: true, align: 'center'}
		      ,{field:'lineup', title: '队伍阵容', sort: true, align: 'center'}
		    ]]
		  });
		});
		
		
		
		/*
			时间格式化
		*/
		
		// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
		// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
		// 例子：   
		//Format("2016-10-04 8:9:4.423","yyyy-MM-dd hh:mm:ss.S") ==> 2016-10-04 08:09:04.423   
		// Format("1507353913000","yyyy-M-d h:m:s.S")      ==> 2017-10-7 13:25:13.0  
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
		  "M+" : datetime.getMonth()+1,                 //月份   
		  "d+" : datetime.getDate(),                    //日   
		  "h+" : datetime.getHours(),                   //小时   
		  "m+" : datetime.getMinutes(),                 //分   
		  "s+" : datetime.getSeconds(),                 //秒   
		  "q+" : Math.floor((datetime.getMonth()+3)/3), //季度   
		  "S"  : datetime.getMilliseconds()             //毫秒   
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
		  
		  
		    var startGroupOK = $('#startGroupOK').val();
			if(startGroupOK != null && startGroupOK != ""){
				
				layer.alert("赛事分组完成，请查看");
				var startGroupError = "";
			}
			
		});  
	
	</script>


	<script type="text/javascript">
		function startGroup(){
			alert("startGroup");
			
			
			
		}
			
		function cancelGame(){
			alert("cancelGame");
			
			
			
		}
	
	</script>
	
	







</body>
</html>