<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>fs社区 - 查看参赛选手</title>

<jsp:include page="/commons/common.jsp"></jsp:include>


</head>
<body>




	<div class="layui-container">
		<table class="layui-hide" id="contestants"></table>
	</div>






	<input id="gameId" type="hidden" value="${gameId }" />



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

	
	







</body>
</html>