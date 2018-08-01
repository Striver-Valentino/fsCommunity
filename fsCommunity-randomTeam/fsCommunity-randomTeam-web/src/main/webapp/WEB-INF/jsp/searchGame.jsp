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
					
					
					<div class="layui-row">
					    <div class="layui-col-md3">
					        <div class="layui-input-inline"> 
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
	
	
	
	<input id="launchSuc" type="hidden" value="${launchSuc }" />


	<jsp:include page="/commons/footer.jsp"></jsp:include>








	

	
	

	<script>
		
		layui.use('table', function() {
			var table = layui.table;

			table.render({
				elem : '#games',
				url : '/showGamesByCondition' 
				,cellMinWidth: 70 
				,method: 'post'     
				,skin: 'line' 
				,even: true 
				,size: 'lg' 
				,page : true 
				,
				cols : [ [ 
				{
					field : 'name',
					title : '赛事名称',
					sort : true,
					sort : true
				}, {
					field : 'sponsorName',
					title : '主办者',
					sort : true
				}, {
					field : 'edge',
					title : '赛事亮点',
					sort : true
				}, {
					field : 'startDateDisplay',
					title : '开始时间',
					sort : true
				}, {
					field : 'signUpLineDisplay',
					title : '报名截止时间',
					sort : true
				}, {
					field : 'applyCount',
					title : '已报名人数',
					sort : true
				}, {
					field : 'statusDisplay',
					title : '状态',
					sort : true
				}, {title : '查看', width:115, align:'center', toolbar: '#barDemo'} 
				] ]
			});
			
			
			
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	</script>
	
	
	<script type="text/javascript">
		function search(){
			
			var searchName = $('#searchName').val();
			var searchSponsorName = $('#searchSponsorName').val();
		    var searchEdge = $('#searchEdge').val();
		    var searchStatus = $('#searchStatus').val();
		    var searchStartDate1 = $('#searchStartDate1').val();
		    var searchStartDate2 = $('#searchStartDate2').val();
		    
			
			
		    layui.use('table', function() {
				var table = layui.table;
				
				
			
				table.reload('games', { 
					where: { 
						 name: searchName
					    ,sponsorName: searchSponsorName
					    ,edge: searchEdge
					    ,statusStr: searchStatus
					    ,startDate1: searchStartDate1
					    ,startDate2: searchStartDate2
					  }
					  ,page: {
					    curr: 1 
					  }
				});
		    });
			
			
		}
	</script>

	


	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs" lay-event="signUp">查看</a>
	</script>


	<script type="text/html" id="barDemo1">
  <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
  
  
  {{#  if(d.auth > 2){ }}
    <a class="layui-btn layui-btn-xs" lay-event="check">审核</a>
  {{#  } }}
	</script>



	<script>
		
	
		
		
    	
		function undetermined(){
			layer.alert('敬请期待');
		}
	
	</script>


     
	<script>
		
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
		  
		  
		    var lau = $('#launchSuc').val();
			if(lau != null && lau != ""){
				
				layer.alert('发起赛事成功！您可以在此页面搜索您发起的赛事。也可以在“我的赛事”->“我发起的赛事”中查看'); 
				var lau = "";
			}
		});  
	
	</script>

	<script>
		layui.use('table', function() {
			var table = layui.table;
			
			table.on('tool(allGames)', function(obj){ 
			  var data = obj.data;
			  var layEvent = obj.event; 
			  var tr = obj.tr; 
			  
			  var gameName = data.name;
			 
			  if(layEvent === 'signUp'){ 
			    
			    
			    window.location.href = "initSignUpGame?gameName="+gameName;
				 
			    

			  } else if(layEvent === 'del'){ 
			    layer.confirm('真的删除行么', function(index){
			      obj.del(); 
			      layer.close(index);
			    });
			  } else if(layEvent === 'edit'){ 
			    
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