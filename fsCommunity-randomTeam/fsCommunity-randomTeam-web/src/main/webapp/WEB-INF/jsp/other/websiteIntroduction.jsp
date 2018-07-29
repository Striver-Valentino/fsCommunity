<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>fs社区 - 社区简介</title>

<jsp:include page="/commons/common.jsp"></jsp:include>



</head>
<body>

	<jsp:include page="/commons/header.jsp"></jsp:include>

	<jsp:include page="/commons/GamePartMenu.jsp"></jsp:include>


	
	<div class="layui-container">
		<div class="fs-docs-container">
		
		
		
		<div class="layui-container">
			<div class="layui-card">
				  <div class="layui-card-header"><h1 class="fs-docs-title">fs社区简介</h1></div> <hr>
				  <div class="layui-card-body">
				  		<div class="layui-text fs-md-text" id="fs-docs-preview">
							<p>欢迎您来到fs社区。</p>
							<blockquote class="layui-elem-quote">
								<p>下面将为您介绍fs社区（以下简称“本站”）。</p>
							</blockquote>
							 
							 <br />
							 
							<h2>登陆社区</h2>
							<p>1、只有注册，并登陆了本站，才可以使用本站的所有功能。</p>
							<p>2、本站暂时只支持邮箱注册，注册后会收到激活邮件，激活邮件24小时有效，请及时激活。</p>
							<br />
							
							<h2>社区能做什么</h2>
							<p>本站是一个提供自组织fs娱乐赛发起赛事、分组组队以及交流fs游戏的平台。</p>
							<p>1、自组织fs娱乐赛，即非官方的、由玩家自己组织的俱乐部内战、水友赛等。</p>
							<p>2、已在本站注册并且激活的用户，都可以发起赛事；已在本站注册并且激活的用户，可以报名已经发起的赛事。</p>
							<p>3、当一个赛事的报名人数足够了，或者报名时间截止了，该赛事的发起者可以在个人中心里，“我发起的赛事”->“管理此赛事”中，对赛事进行分组（只需点击“开始分组”按钮即可）；也可以取消该赛事。</p>
							<p>4、分组完成后，会生成对阵表，所有报名了该赛事的用户都能看到。</p>
							<p>5、本站目前的赛事分组，暂时只支持3vs3赛制。</p>
							<p>6、由于报名人数的原因，可能会出现某些报名了的用户没有被分组，因为报名人数不会总是3的倍数。</p>
							<p>7、生成的对阵表可能会有队伍轮空。</p>
							
							<br />
							
							<h2>更多功能</h2>
							<p>1、目前本站的功能有：</p>
							<p>（1）发起赛事；</p>
							<p>（2）赛事报名；</p>
							<p>（3）赛事分组与对阵；</p>
							<p>（4）管理赛事。</p>
							<p>2、后续会陆续上线的功能：</p>
							<p>（1）发帖讨论；</p>
							<p>（2）各角色各等级的能力值查询；</p>
							<p>（3）与一些活动有关的工具，如：枚举法猜数字工具。</p>
							<p>（4）还有更多，敬请期待。</p>
							
							<br />
							
							<h2>关于侵权</h2>
							<p>本站完全由个人团队开发，有部分素材来自于互联网，如有侵权，请联系qq：3540846483。</p>
							
							<br />
							
							<h2>免责申明</h2>
							<p>1、本团队不代表官方，本站也不代表官方网站，本站仅仅是一种fs情怀。</p>
							<p>2、本站与本团队不参与任何赛事的纠纷，如果在比赛过程中发生冲突，请自行解决。</p>
							<p>3、本站是非营利网站，如有收到涉及转账等内容的站内信，请勿轻信。</p>
							
							<br />
							
							<h2>联系我们</h2>
							<p>本团队成员主要在三个qq群出现，可以在以下三个qq群中找到本团队成员。</p>
							<p>QQ群：260743048</p>
							<p>QQ群：682622431</p>
							<p>QQ群：234597793</p>
							<p>对于这三个qq群，只想说：蕾拉的视角，鱼蛋的三分，娜娜的阵容，佳燕的篮板，都一样是让人捉摸不透的。 &nbsp; <i class="layui-icon"></i> </p> 
							
							<br />
							
							<h3>各位FSer可以在本站快捷组队，轻松打比赛。</h3>
							<br />
							
						</div>
						
						
				  </div>
		    </div>
				
		</div>
		
		
			
			
		</div>
	</div>






























	<input id="delMessageOK" type="hidden" value="" />
	<input id="delMessageError" type="hidden" value="" />

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