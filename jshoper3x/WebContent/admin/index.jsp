<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="magi">
<title>首页 &middot; jshoper</title>

</head>
<body>
	<!-- header 包含头部导航-->
	<%@include file="header.jsp"%>

	<div class="navbar">
		<div class="navbar-innert">
			<a class="brand" href="#"><img
				src="<%=basePath%>admin/ui/assets/img/logo.png" width="175"
				height="30" alt=""> </a> <a class="brand" href="#">欢迎登录后台管理系统</a>
		</div>
	</div>
	<div class="container-fluid containerb">

		<div class="row-fluid">

			<div class="span2">
				<a href="#" class="thumbnail"><img
					src="<s:property value="#session.admin.headpath"/>" alt=""
					class="caption"> </a>
				<div class="well well-small smallt">
					<h4><s:property value="#session.admin.realname"/> ，你好！</h4>
					<p>
						欢迎您再次来到<br />Jshoper3x
					</p>
					<button class="btn btn-block btn-primary" type="button">我的工作</button>
				</div>


				<div class="line-dotted"></div>
				<!-- 引入左侧导航 -->
				<%@include file="left.jsp"%>

			</div>

			<div class="span7">
				<div class="row-fluid">
					<ul class="thumbnails">
						<li class="span2"><a
							href="<%=basePath%>admin/goods/goods.jsp?operate=add"
							class="thumbnail"><img
								src="<%=basePath%>admin/ui/assets/img/header/icon-48-article-add.png"
								alt="" class="caption">
								<h4>添加产品</h4> </a></li>
						<li class="span2"><a
							href="<%=basePath%>admin/pagecontent/articlement.jsp?operate=find"
							class="thumbnail"><img
								src="<%=basePath%>admin/ui/assets/img/header/icon-48-article.png"
								alt="" class="caption">
								<h4>文章管理</h4> </a></li>
						<li class="span2"><a
							href="<%=basePath%>admin/goods/goodscategoryment.jsp?operate=find"
							" class="thumbnail"><img
								src="<%=basePath%>admin/ui/assets/img/header/icon-48-category.png"
								alt="" class="caption">
								<h4>分类管理</h4> </a></li>
						<li class="span2"><a href="<%=basePath%>admin/order/normalordersment.jsp?operate=find" class="thumbnail"><img
								src="<%=basePath%>admin/ui/assets/img/header/icon-48-menumgr.png"
								alt="" class="caption">
								<h4>订单管理</h4> </a></li>
						<li class="span2"><a href="<%=basePath%>admin/member/membergroupment.jsp?operate=find" class="thumbnail"><img
								src="<%=basePath%>admin/ui/assets/img/header/icon-48-user.png"
								alt="" class="caption">
								<h4>分组管理</h4> </a></li>
						<li class="span2"><a href="<%=basePath%>admin/setting/basicinfoment.jsp?operate=find" class="thumbnail"><img
								src="<%=basePath%>admin/ui/assets/img/header/icon-48-config.png"
								alt="" class="caption">
								<h4>基本设置</h4> </a></li>
					</ul>
				</div>


				<h4>jshoper3x介绍</h4>
				<p>
				这是ostocyjshop计划下的一个新版本，主要是重构并增强App部分的功能。希望可以制作成一个可以稳定在线上运行的系统。<br>
				ostocyjshop更名为jshoper3x简称jshoper。取义行走在java上的人。3x标示版本号
				</p>
				<h5>2014年的计划</h5>
<p>
1,我们将投入更多的精力书写文档，包括需求说明，详细设计
</p>
<p>
2,我们将邀请专人对jshoper3x进行测试，提高代码的质量</p>
<p>
3,我们将推出基于jshoper3x的移动端产品，为所有的关注着们展示一个更全面的系统</p>
				<h5>项目目标</h5>
				<p>我们要做一个支持android，ios和web的电商类移动应用解决方案</p>

				<h5>什么是通用电商类移动应用解决方案？</h5>
				<p>电商类移动应用解决方案的意思是说，我们可以在系统中容易的增加数据表和功能模块并开放服务给android及ios使用以达到O2O的模式或者提供更好的移动化服务，方便大家在既定的开发模式下顺利的增加你想要的功能。
				<br>
				应用领域可以很多，例如汽车维修，订餐，教育，远程学习等等</p>

				<h5>如何参与？</h5>
				<p>你必须有一个github账号会使用git<br>
				你必须会用eclipse的git插件来提交更新和合并别人的代码<br>
				你必须能够遵守我们的一些开发规范，例如注释要多写，完善你的代码文档
				</p>
				<h5>协议许可是？</h5>
				<p>我们目前使用GPLv3协议<br>
				同时我们为商业用途提供了授权协议</p>
				
				<h5>组织和理念？</h5>
				<p>我们希望大家都是热于奉献的代码人
				<br>
				我们希望大家可以通过共同参与这个项目来提高自己或者帮助别人
				<br>
				我们希望大家可以互相成为好朋友，互相学习
				<br>
				我们希望把大家最擅长的一面表现出来，无论是设计或者是细节上的代码编写
				<br>
				我们希望大家可以用于分享自己的经验和总结
				<br>
				我们更加希望这里是我们代码人，程序员在这个行业的一个证明（可能有些人以后去卖水果）
				<br>
				</p>
				
				<h5>开发的态度？</h5>
				<p>认真<br>
				负责<br>
				热情<br>
				</p>
				
				<h5>我们已经做了？</h5>
				<p>jshoperv2是一个初级版本，你可以在这里下载https://github.com/sdywcd/jshoperv2  但我们已不再维护仅供参考和学习
				<br>
				该版本完成了基础服务端和一个基于android的平板系统，并以电子菜单形式的产品进行过小范围生成测试和运营
				<br>
				由于历时原因我们在https://code.google.com/p/ostocy-jshop/ 也保留了一份源码
				<br>
				平板的app由于那时我主要写设计，基础架构是我写的，更新是其他人做的，我就暂时不公开源码了
				<br>
				</p>
				<h5>我们将来做什么？</h5>
				<p>简化jshoperv2的功能把过去不合理的设计进行重构并优化和规范代码
				<br>
				继续编写和优化android平板上的app
				<br>
				增加android手机上的app
				<br>
				新增内容管理类功能，满足新闻类app需求
				<br>
				新增客户关系管理类功能，满足客户分析类app需求
				<br>
				新增库存管理类功能，完善jshoper的整体流程
				<br>
				新增采购管理类功能，完成jshoper的整体流程
				<br>
				最终我们希望jshoper3x是一个jshoperv2的流程完善版本，并增强移动平台上的客户端，通过抽离和重组模块可以帮助企业或者个人完成中小型应用或者电商开发。更多功能可能是你给我的想法，或者你fork后自己的创新
				</p>
				
				<h5>我们的自由团队</h5>
				<p>
				我们有一位专业的UI设计师
				<br>
				我们有一位IOS开发者，开发过的应用上过app store 英语教育类前10名
				<br>
				我们有一位j2ee开发者，没错就是现在写这段文字，并把ui和功能组织起来的我
				<br>
				我们有一位j2ee开发者，他远在北京，也是通过这个开源项目认识并和谐的交流到现在并加入了我们
				</p>
				<h5>我们的一些解释</h5>
				<p>jshoper并不是一个完美的东西，我们力求做到更好
				<br>
				无论是手机还是平板上的app都需要不断改进
				<br>
				我们并不是什么大牛，只是喜欢写代码而已,也想通过代码来实现理想
				<br>
				无论是安全性，性能，功能上我们希望可以慢慢的兼顾
				<br>
				</p>
				
				<h5>关于技术选型</h5>
				<p>struts2,spring3.0,hibernate4,freemarker,jsp,jquery,dwr,js,html5,css,mysql5,android4,Redis 这些事我们目前用到的
				<br>我们乐于使用新技术，我们也在系统中使用了很多国内的开源组件</p>
				
				<h5>关于未来想加入的技术</h5>
				<p>搜索技术 lucene
				
				<br>缓存 Redis（已加入）
				
				nosql
				<p>
				------------------------------------------------------
				<h2>欢迎使用jshoper3x版本，欢迎技术咨询，欢迎业务合作</h2>
				-------------------------------------------------------
				<h5>你可以在如下几个地方找到我</h5>
				<p>1，上海
				<br>
				2，我的博客：http://sdywcd.iteye.com/
				<br>
				3，我的微博：http://weibo.com/sdywcd
				<br>
				4，我的邮箱：sdywcd@gmail.com
				<br>
				5，我的qq：281198200 （请某些行业的某先生/女士自重不要乱加，加时请注明github字样，让我知道你是好人就行）
				</p>				
				<h2>感谢</h2>
				<p>
				感谢重庆蓝盒子科技有限公司<br>
				感谢北京某公司<br>
				感谢上海某公司<br>
				感谢64位加过我qq的jshoper3关注者<br>
				感谢所有下载过jshoper3或者jv2的朋友们<br>
				</p>
			</div>

			<div class="span3">
				<h4>最新需发货订单</h4>
				<ul class="nav nav-list bs-docs-sidenavh">
					<s:iterator id="bean" value="#session.newestorders" status="newestorders">
						<li><a href="InitOrdersDetail.action?orderid=<s:property value="orderid"/>"><s:property value="ordername"/></a></li>
					</s:iterator>
					
				
				</ul>
				<div class="line-dotted"></div>
				<!-- <h4>销量 Top 5</h4>
				<ul class="nav nav-list bs-docs-sidenavh">
					<li><a href="#dropdowns"><span class="badge badge-success">1</span>
							西牧狼商务英伦复古牛皮</a></li>
					<li><a href="#buttonGroups"><span
							class="badge badge-warning">2</span> 限量300台送UV镜！特价尼康 D3200！</a></li>
					<li><a href="#buttonDropdowns"><span
							class="badge badge-important">3</span> 电子书刊畅读卡（季度卡）赠《攻心话术》！</a></li>
					<li><a href="#navs"><span class="badge badge-info">4</span>
							ayhke磨砂牛皮保暖棉鞋</a></li>
					<li><a href="#navbar"><span class="badge badge-inverse">5</span>
							E人E本T4 WIFI版</a></li>
				</ul>

 -->
			</div>

		</div>

	</div>



	<!-- footer -->
	<%@include file="footer.jsp"%>
</body>
</html>