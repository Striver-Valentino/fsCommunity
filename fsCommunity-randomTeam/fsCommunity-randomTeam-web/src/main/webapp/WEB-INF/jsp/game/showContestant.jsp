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
		    ,cellMinWidth: 70 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
		    ,method: 'get'     // get 方式提交
			,skin: 'line' //行边框风格
			,even: true //开启隔行背景
			,size: 'lg' //大尺寸的表格
			,page : true //开启分页
		    ,cols: [[
		      {field:'signupGameName', title: '赛事名称', sort: true, align: 'center'}
		      ,{field:'signupUserGameName', title: '选手名', sort: true, align: 'center'} //width 支持：数字、百分比和不填写。你还可以通过 minWidth 参数局部定义当前单元格的最小宽度，layui 2.2.1 新增
		      ,{field:'position', title: '游戏职业', sort: true, align: 'center'}
		      ,{field:'rating', title: 'rating', sort: true, align: 'center'}
		      ,{field:'descr', title: '想说的话', sort: true, align: 'center'} //单元格内容水平居中
		      ,{field:'enrollDate', title: '报名时间', sort: true, align: 'center',templet:'<div>{{ Format(d.enrollDate,"yyyy-MM-dd hh:mm:ss")}}</div>'}
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

	
	







</body>
</html>