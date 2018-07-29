<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>fs社区 - 让我们一起组队</title>

<jsp:include page="/commons/common.jsp"></jsp:include>


</head>
<body>

	<jsp:include page="/commons/header.jsp"></jsp:include>
	
	<jsp:include page="/commons/GamePartMenu.jsp"></jsp:include>



	


	

	<div class="layui-container">
		<div class="layui-card">
			  <div class="layui-card-body">
			  
  				<form class="layui-form">
					<!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
					
					<div class="layui-row">
					    <div class="layui-col-md3">
					        <div class="layui-input-inline"> <!-- layui-form-item -->
								<label class="layui-form-label">赛事名称</label>
								<div class="layui-input-block" style="width: 150px">
									<input id="searchName" type="text" name="searchName" autocomplete="off" class="layui-input">
								</div>
							</div>
					    </div>
					    <div class="layui-col-md3">
					        <div class="layui-input-inline">
								<label class="layui-form-label">主办者</label>
								<div class="layui-input-block" style="width: 150px">
									<input id="searchSponsorName" type="text" name="searchSponsorName" autocomplete="off" class="layui-input">
								</div>
							</div>
					    </div>
					    <div class="layui-col-md3">
					        <div class="layui-input-inline">
								<label class="layui-form-label">赛事亮点</label>
								<div class="layui-input-block" style="width: 150px">
									<input id="searchEdge" type="text" name="searchEdge" autocomplete="off" class="layui-input">
								</div>
							</div>
					    </div>
					    <div class="layui-col-md3">
					        <div class="layui-input-inline">
								<label class="layui-form-label">赛事状态</label>
								<div class="layui-input-block" style="width: 150px">
									<select id="searchStatus" name="searchStatus" lay-filter="">
										<option value="5">所有状态</option>
										<option value="0">未开始</option>
										<option value="1">进行中</option>
										<option value="2">截止报名</option>
										<option value="3">已结束</option>
										<option value="4">已取消</option>
									</select>
								</div>
							</div>
					    </div>  
					    
					</div>  <br />
					
					<div class="layui-row">
						<div class="layui-col-md2">
							<div class="layui-input-inline">
								<label class="layui-form-label">开始时间</label>
								<div class="layui-input-block" style="width: 150px">
									<input type="text" size="1" name="searchStartDate1" class="layui-input" id="searchStartDate1" placeholder="记得选择时分秒" />
								</div>
							</div>
						</div>
						<div class="layui-col-md2">
					        <div class="layui-input-inline">
								<label class="layui-form-label"> <font size="5">~</font> </label>
								<div class="layui-input-block" style="width: 150px">
									<input type="text" size="10" name="searchStartDate2" class="layui-input" id="searchStartDate2" placeholder="记得选择时分秒" />
								</div>
							</div>
						</div>
					</div>
					
					
					 
					
					<!-- 
					<div class="layui-input-inline">
						<label class="layui-form-label">开始时间</label>
						<div class="layui-input-block" style="width: 500px">
							<input type="text" size="1" name="searchStartDate1" class="layui-input" id="searchStartDate1" placeholder="记得选择时分秒" /> - <input type="text" size="10" name="searchStartDate2" class="layui-input" id="searchStartDate2" placeholder="记得选择时分秒" />
						</div>
					</div> -->
					
					
					
					
					
					
					<!-- 
					<div class="layui-input-inline">
						<div class="layui-input-block">
							<button class="layui-btn" lay-submit lay-filter="search">搜索1</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div> -->
				</form>
						<div align="right">
			  				<button class="layui-btn" onclick="search()">搜索</button>
			  			</div>
			  				
			  			
			  </div>
		</div>
	</div>
	

	<div class="layui-container">
		<table id="games" lay-filter="allGames" border="1"></table>
	</div>
	
	
	<!-- 标记是否是 发起赛事 成功后 请求过来的 -->
	<input id="launchSuc" type="hidden" value="${launchSuc }" />


	<jsp:include page="/commons/footer.jsp"></jsp:include>








	

	
	

	<script>
		
		layui.use('table', function() {
			var table = layui.table;

			//第一个实例
			table.render({
				elem : '#games',
				//height : 'full-20',
				url : '/showGamesByCondition' //数据接口
				,cellMinWidth: 70 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
				,method: 'post'     // post 方式提交
				,skin: 'line' //行边框风格
				,even: true //开启隔行背景
				,size: 'lg' //大尺寸的表格
				,page : true //开启分页
				//,id: 'idTest'
				,
				cols : [ [ //表头
				{
					field : 'name',
					title : '赛事名称',
					//width : 200,
					sort : true,
					//fixed : 'left',
					sort : true
				}, {
					field : 'sponsorName',
					title : '主办者',
					//width : 150,
					sort : true
				}, {
					field : 'edge',
					title : '赛事亮点',
					//width : 150,
					sort : true
				}, {
					field : 'startDateDisplay',
					title : '开始时间',
					//width : 150,
					sort : true
				}, {
					field : 'signUpLineDisplay',
					title : '报名截止时间',
					//width : 150,
					sort : true
				}, {
					field : 'applyCount',
					title : '已报名人数',
					//width : 150,
					//align : center,
					sort : true
				}, {
					field : 'statusDisplay',
					title : '状态',
					//width : 100,
					sort : true
				}, {title : '查看', width:115, align:'center', toolbar: '#barDemo'} //这里的toolbar值是模板元素的选择器 
				] ]
			});
			
			/*tableIns.reload({
			  where: { //设定异步数据接口的额外参数，任意设
				 name: searchName
			    ,sponsorName: searchSponsorName
			    ,edge: searchEdge
			    ,statusStr: searchStatus
			    ,startDate1: searchStartDate1
			    ,startDate2: searchStartDate2
			  }
			  ,page: {
			    curr: 1 //重新从第 1 页开始
			  }
			});*/
			
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	</script>
	
	
	<script type="text/javascript">
		function search(){
			//alert("hello");
			
			var searchName = $('#searchName').val();
			var searchSponsorName = $('#searchSponsorName').val();
		    var searchEdge = $('#searchEdge').val();
		    var searchStatus = $('#searchStatus').val();
		    var searchStartDate1 = $('#searchStartDate1').val();
		    var searchStartDate2 = $('#searchStartDate2').val();
		    
		    //alert(searchName);
		    //alert(searchSponsorName);
		    //alert(searchEdge);
		    //alert(searchStatus);
		    //alert(searchStartDate1);
		    //alert(searchStartDate2);
			
			
		    layui.use('table', function() {
				var table = layui.table;
				
				//alert("table");
			
				table.reload('games', { // 指定 重新 加载 的 table 的 id
					where: { //设定异步数据接口的额外参数，任意设
						 name: searchName
					    ,sponsorName: searchSponsorName
					    ,edge: searchEdge
					    ,statusStr: searchStatus
					    ,startDate1: searchStartDate1
					    ,startDate2: searchStartDate2
					  }
					  ,page: {
					    curr: 1 //重新从第 1 页开始
					  }
				});
		    });
			
			  //alert("search");
			
		}
	</script>

	


	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs" lay-event="signUp">查看</a>
	</script>


	<script type="text/html" id="barDemo1">
  <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
  
  <!-- 这里同样支持 laytpl 语法，如： -->
  {{#  if(d.auth > 2){ }}
    <a class="layui-btn layui-btn-xs" lay-event="check">审核</a>
  {{#  } }}
	</script>



	<script>
		/*$(function(){
			$('#undetermined1').click(function(){
    			alert("敬请期待")
    		});
				
		});*/
	
		/*$(document).ready(function(){
			$('#undetermined1').click(function(){
    			alert("敬请期待");
    		});
    		
    		
    	});*/
		
    	//layui.use('layer', callback);
    	
		function undetermined(){
			//alert("敬请期待");
			layer.alert('敬请期待');
		}
	
	</script>


     
	<script>
		/******** 日历组件  *********/
		layui.use('laydate', function() {
			var laydate = layui.laydate;

			
			laydate.render({
			  elem: '#searchStartDate1'
			  ,type: 'datetime'
			});
			
			laydate.render({
			  elem: '#searchStartDate2'
			  ,type: 'datetime'
			});
		});
	</script>
	
	<script>
		layui.use('layer', function(){
		  var layer = layui.layer;
		  
		  //layer.msg('hello');
		  
		    var lau = $('#launchSuc').val();
			//alert(lau);
			//lau = "12";
			if(lau != null && lau != ""){
				//alert("发起赛事成功！您可以在此页面搜索您发起的赛事。");
				//layer.msg('发起赛事成功！您可以在此页面搜索您发起的赛事。');
				
				layer.alert('发起赛事成功！您可以在此页面搜索您发起的赛事。也可以在“我的赛事”->“我发起的赛事”中查看'); 
				var lau = "";
			}
		});  
	
	</script>

	<script>
		layui.use('table', function() {
			var table = layui.table;
			
			table.on('tool(allGames)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
			  var data = obj.data; //获得当前行数据
			  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
			  var tr = obj.tr; //获得当前行 tr 的DOM对象
			  
			  var gameName = data.name;
			  //alert(data.name);
			 
			  if(layEvent === 'signUp'){ // 点击 “报名”
			    //do somehing
			    
			    //alert("hello");
			    
			    
			    //window.location.href="login.jsp?backurl="+window.location.href; 
			    //window.location.href = "${pageContext.request.contextPath}/commons/test.html";
			    window.location.href = "initSignUpGame?gameName="+gameName; // 把 赛事名称 传过去，根据赛事名称查找（赛事名称 有 唯一约束）
			    //${pageContext.request.contextPath}
				 /* $.post(
						"/initSignUpGame",
						{"gameName":gameName},   //这里的data是带去服务器的参数
						function(data){  // 这里的data是返回的数据对象
							window.location.href = "initSignUpGame";
						},
						"json"
				  );*/
			    

			  } else if(layEvent === 'del'){ //删除
			    layer.confirm('真的删除行么', function(index){
			      obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
			      layer.close(index);
			      //向服务端发送删除指令
			    });
			  } else if(layEvent === 'edit'){ //编辑
			    //do something
			    
			    //同步更新缓存对应的值
			    obj.update({
			      username: '123'
			      ,title: 'xxx'
			    });
			  }
			});
	
		});
	</script>









</body>
</html>