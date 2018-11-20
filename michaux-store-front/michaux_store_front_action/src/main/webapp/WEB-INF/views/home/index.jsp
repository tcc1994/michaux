<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>首页</title>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
		
<!-- //for-mobile-apps -->
<link href="${ctx}/static/css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
<link href="${ctx}/static/css/style.css" rel="stylesheet" type="text/css" media="all"/>
<!-- js -->
<%-- <script type="text/javascript" src="${ctx}/static/js/model/jquery-2.1.4.min.js"></script> --%>
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<!-- //js -->
<!-- pop-up-box -->
<link href="${ctx}/static/css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
<!-- //pop-up-box -->
<!-- font-awesome icons -->
<link href="${ctx}/static/css/font-awesome.css" rel="stylesheet" type="text/css" media="all"/>
<!-- //font-awesome icons -->
<link href="http://fonts.googleapis.com/css?family=Work+Sans:100,200,300,400,500,600,700,800,900&amp;subset=latin-ext" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
</head>
<body>
<!-- header -->
	<div class="header">
		<div class="container">
			<div class="agile_header_grid">
				<div class="w3_agile_logo">
					<h1><a href="${ctx}/home/index.do"><span>MX</span>michaux</a></h1>
				</div>
				<div class="agileits_w3layouts_sign_in">
					<ul>
					<input id="head_input" value="${profile.rpHeader }" hidden/>
						<c:if test="${not empty profile.rpHeader}">
							<li><a href="#small-dialog1"  class="popup-with-zoom-anim"><img class="img-circle img-thumbnail" style="height: 60px;width: 60px;margin-right: 5px;" src="${ctx}/static/images/portrait/${profile.rpHeader}.jpg" alt="头像" /></a></li>
						</c:if>
						<c:if test="${empty profile.rpHeader}">
							<li><a href="#small-dialog1"  class="play-icon popup-with-zoom-anim"><img class="img-circle img-thumbnail" style="height: 60px;width: 60px;margin-right: 5px;" src="${ctx}/static/images/portrait/1.jpg" alt="头像" /></a></li>
						</c:if>
						<c:if test="${not empty account}">
							<li><a href="#small-dialog" class="play-icon popup-with-zoom-anim">${account.usNickname}</a></li>
							<span><a type="button" style="margin-left: 20px;" href="${ctx}/login/exit.do" title="退出登录">退出</a></span>
						</c:if>
						<c:if test="${empty account}">
							<li><a href="${ctx}/login/page.do">登录</a></li>
						</c:if>
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="w3_agileits_nav">
				<nav class="navbar navbar-default">
					<div class="navbar-header navbar-left">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
					</div>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse navbar-right" id="bs-example-navbar-collapse-1">
						<nav>
							<ul class="nav navbar-nav">
								<li class="active"><a href="index.html">Home</a></li>
								<li><a href="${ctx}/service/info.do" class="hvr-sweep-to-bottom">Services</a></li>
								<li><a href="${ctx}/about/info.do" class="hvr-sweep-to-bottom">About</a></li>
								<li class="dropdown">
									<a href="#" class="dropdown-toggle hvr-sweep-to-bottom" data-toggle="dropdown">Short Codes <b class="caret"></b></a>
									<ul class="dropdown-menu agile_short_dropdown">
										<li><a href="${ctx}/icons/list.do">Web Icons</a></li>
										<li><a href="${ctx}/typography/info.do">Typography</a></li>
									</ul>
								</li>
								<li><a href="${ctx}/portfolio/info.do" class="hvr-sweep-to-bottom">Portfolio</a></li>
								<li><a href="${ctx}/contact/info.do" class="hvr-sweep-to-bottom">Contact</a></li>
							</ul>
							<div class="agileinfo_search">
								<form action="#" method="post">
									<input type="text" name="Search" placeholder="Type text here..." required="">
									<input type="submit" value=" ">
								</form>
							</div>
						</nav>
					</div>
				</nav>	
			</div>
		</div>
	</div>
<!-- //header -->
<!-- pop-up-box -->
	<div id="small-dialog" class="mfp-hide w3ls_small_dialog wthree_pop">
		<h3 class="agileinfo_sign">个人资料</h3>	
		<div class="agileits_signin_form">
			<form id="profile-form">
			 <div class="form-group">
			 	<input id="sex" value="${profile.rpSex}" hidden/>
			  性别 : <label class="radio-inline"><input id="radio1" type="radio"  value="1" name="rpSex" checked title="男"/>男性 </label>
			        <label class="radio-inline"><input id="radio2" type="radio"  value="2" name="rpSex" title="女" />女性</label>
			  </div>
			  <!-- 头像 : <input type="file" class="file" name="rpHeader" placeholder="Header"/> -->
			    <input type="text" name="rpAge" placeholder="Age" value="${profile.rpAge}" maxlength="3" title="年龄"/>
			    <input type="text" name="rpNickName" placeholder="Nickname" value="${profile.rpNickName}"maxlength="10" title="昵称"/>
				<input type="email" name="rpEmail" placeholder="Email" value="${profile.rpEmail}" maxlength="30" title="邮箱"/>
				<input type="text" name="rpCompany" placeholder="Company" value="${profile.rpCompany}" maxlength="30" title="公司"/>
				<input type="text" name="rpOccupation" placeholder="Occupation" value="${profile.rpOccupation}" maxlength="30" title="职业"/>
				<input type="text" name="rpIndustry" placeholder="Industry" value="${profile.rpIndustry}" maxlength="30" title="行业"/>
				<input type="button" class="btn btn-success btn-lg btn-block" id="ajaxSubmit" value="确定" title="提交"/>
			</form>
		</div>
	</div>
<style>
    .selected{border:3px solid black !important;}
</style>

	<div id="small-dialog1" class="mfp-hide w3ls_small_dialog wthree_pop">
		<h3 class="agileinfo_sign">个人头像</h3>	
		<div class="agileits_signin_form">
			 <table class="table">
			 	<tr>
			 		<c:forEach var="i" begin="1" end="6">
				 		<td><img id="head${i}" class="headImage" style="cursor:pointer;width: 40px;height: 40px;" src="${stx}/static/images/portrait/${i}.jpg" value="${i}"/></td>
			 		</c:forEach>
			 	</tr>
			 	<tr>
			 		<c:forEach var="i" begin="7" end="12">
				 		<td><img id="head${i}" class="headImage" style="cursor:pointer;width: 40px;height: 40px;" src="${stx}/static/images/portrait/${i}.jpg" value="${i}"/></td>
			 		</c:forEach>
			 	</tr>
			 	<tr>
			 		<c:forEach var="i" begin="13" end="18">
				 		<td><img id="head${i}" class="headImage" style="cursor:pointer;width: 40px;height: 40px;" src="${stx}/static/images/portrait/${i}.jpg" value="${i}"/></td>
			 		</c:forEach>
			 	</tr>
			 	<tr>
			 		<c:forEach var="i" begin="19" end="24">
				 		<td><img id="head${i}" class="headImage" style="cursor:pointer;width: 40px;height: 40px;" src="${stx}/static/images/portrait/${i}.jpg" value="${i}"/></td>
			 		</c:forEach>
			 	</tr>
			 	<tr>
			 		<c:forEach var="i" begin="25" end="30">
				 		<td><img id="head${i}" class="headImage" style="cursor:pointer;width: 40px;height: 40px;" src="${stx}/static/images/portrait/${i}.jpg" value="${i}"/></td>
			 		</c:forEach>
			 	</tr>
			 </table>
			 <input type="button" class="btn btn-success btn-lg btn-block" id="headSubmit" value="确定">
		</div>
	</div>
<!-- //pop-up-box -->	
<script type="text/javascript" src="${ctx}/static/js/model/jquery.magnific-popup.js"></script>
<script>
$(function() {
	var sex=$("#sex").val();
	var head_input=$("#head_input").val();
	if(sex=="2"){
		$("#radio2").prop("checked",true);
		$("#radio1").prop("checked",false);
	}
	if(head_input==""){
		$("#head1").css("border","4px solid #f62b2b");
		$("#head_input").val("1");
	}else{
		var id_img="#head"+head_input;
		$(id_img).css("border","4px solid #f62b2b");
		$("#head_input").val(head_input);
	}
	$(".headImage").click(function(){
		$(".headImage:not(this)").css("border","1px solid #fff");
        $(this).css("border","4px solid #f62b2b"); 
        var val=$(this).attr("id");
        var valus =val.split("d");
        $("#head_input").val(valus[1]);
	});
	$("#headSubmit").click(function(){
		var val=$('#head_input').val();
		headSubmit(val);
	});
	$("#ajaxSubmit").click(function(){
		ajaxSubmit();
	});
	$(document).keyup(function(event){
	  if(event.keyCode==13){
		  ajaxSubmit();
	  }
	});
}); 
function headSubmit(data){
	$.ajax({
        type: "POST",
        url: "${ctx}/profile/head.do" ,
        dataType: "json",
        data: {"head":data},
        beforeSend: function() { },
        success: function (data) {
        	if(data=='200'){
        		alert("更改成功");
        		window.location.reload();
        	}
        	if(data=='301'){
        		alert("未登录");
        		window.location.reload();
        	}
        	if(data=='302'){
        		alert("请填写资料");
        	}
        	if(data=='500'){
        		alert("系统异常,请重试");
        	}
        },
        error : function(data) {
     	   alert("系统异常,请重试");
        }
     });
}

function ajaxSubmit(){
	$.ajax({
        type: "POST",
        url: "${ctx}/profile/submit.do" ,
        dataType: "json",
        data: $('#profile-form').serialize(),
        beforeSend: function() {
	     	var age = $("input[name='rpAge']").val();
	        var email = $("input[name='rpEmail']").val();
	        var reg=/^((1[0-5])|[1-9])?\d$/;
	        if(age.trim() !="" && !reg.test(age.trim())){
	    		alert("请输入正确的年龄");
	    		return false;
	    	}
	        var re = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
	        if(email.trim() != "" && !re.test(email.trim())){
	        	alert("请输入正确的邮箱地址");
	    		return false;
	        }
        },
        success: function (data) {
        	if(data=='200'){
        		alert("保存成功");
        		window.location.reload();
        	}
        	if(data=='301'){
        		alert("未登录");
        		window.location.reload();
        	}
        	if(data=='302'){
        		alert("请填写资料");
        	}
        	if(data=='500'){
        		alert("系统异常,请重试");
        	}
        },
        error : function(data) {
     	   alert("系统异常,请重试");
        }
     });
}

	$(document).ready(function() {
	$('.popup-with-zoom-anim').magnificPopup({
		type: 'inline',
		fixedContentPos: false,
		fixedBgPos: true,
		overflowY: 'auto',
		closeBtnInside: true,
		preloader: false,
		midClick: true,
		removalDelay: 300,
		mainClass: 'my-mfp-zoom-in'
	});
																	
	});
</script>
<!-- banner -->	
	<div class="banner">
		<div class="container">
			<h2>we generate most valuable <span>idea</span></h2>
			<p>Creative agency for your design needs</p>
			<div class="wthree_banner_grids">
				<div class="col-md-3 wthree_banner_grid">
					<i class="fa fa-desktop" aria-hidden="true"></i>
					<h4>customized solution</h4>
				</div>
				<div class="col-md-3 wthree_banner_grid">
					<i class="fa fa-money" aria-hidden="true"></i>
					<h4>Minimal Cost</h4>
				</div>
				<div class="col-md-3 wthree_banner_grid">
					<i class="fa fa-users" aria-hidden="true"></i>
					<h4>professional team</h4>
				</div>
				<div class="col-md-3 wthree_banner_grid">
					<i class="fa fa-clock-o" aria-hidden="true"></i>
					<h4>Quick Results</h4>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="agileits_more">
				<ul>
					<li><a href="#" class="w3ls_banner_more hvr-icon-hang">Use it for free</a></li>
					<li><a href="#" class="hvr-icon-hang" data-toggle="modal" data-target="#myModal">Learn More</a></li>
				</ul>
			</div>
		</div>
	</div>
<!-- //banner -->
<!-- bootstrap-pop-up -->
	<div class="modal video-modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					Michaux
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
				</div>
				<section>
					<div class="modal-body">
						<img src="${ctx}/static/images/banner.jpg" alt=" " class="img-responsive" />
						<p>Ut enim ad minima veniam, quis nostrum 
							exercitationem ullam corporis suscipit laboriosam, 
							nisi ut aliquid ex ea commodi consequatur? Quis autem 
							vel eum iure reprehenderit qui in ea voluptate velit 
							esse quam nihil molestiae consequatur, vel illum qui 
							dolorem eum fugiat quo voluptas nulla pariatur.
							<i>" Quis autem vel eum iure reprehenderit qui in ea voluptate velit 
								esse quam nihil molestiae consequatur.</i></p>
					</div>
				</section>
			</div>
		</div>
	</div>
<!-- //bootstrap-pop-up -->
<!-- banner-bottom -->
	<div class="banner-bottom">
		<div class="container">
			<div class="col-md-8 w3l_banner_bottom_left">
				<h3>Our Design and development</h3>
				<p>Integer et feugiat elit. Nullam at turpis vel sapien aliquam feugiat vitae vitae mi. 
					Donec scelerisque, justo vel blandit tempor, quam tellus blandit lectus, ut viverra leo 
					velit et quam. Michaux viverra et quam efficitur rhoncus sollicitudin.
					Etiam ultricies mauris et dapibus molestie. Suspendisse bibendum ex sit amet 
					tellus finibus ultrices. Sed velit urna, faucibus at gravida ut, aliquam ut purus.
					<span>Donec porttitor neque sed mauris sagittis, a auctor enim porta. 
						Sed tristique sollicitudin orci. Vivamus vulputate nunc id nulla elementum,nec vehicula ipsum ullamcorper.</span></p>
			</div>
			<div class="col-md-4 w3l_banner_bottom_right">
				<img src="${ctx}/static/images/1.jpg" alt=" " class="img-responsive" />
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
<!-- //banner-bottom -->
<div class="tlinks">Collect from <a href="#" >米修-store</a></div>
<!-- two-grids -->
	<div class="two-grids">
		<div class="col-md-6 w3_two_grid_left">
			<img src="${ctx}/static/images/2.jpg" alt=" " class="img-responsive" />
		</div>
		<div class="col-md-6 w3_two_grid_right">
			<h3>make your business success with us</h3>
			<p class="w3layouts_dummy_para">Michaux viverra et quam efficitur rhoncus sollicitudin.
				Etiam ultricies mauris et dapibus molestie.</p>
			<div class="w3_two_grid_right1">
				<div class="col-xs-3 w3_two_grid_right_grid">
					<div class="w3_two_grid_right_grid1">
						<i class="fa fa-thumbs-up" aria-hidden="true"></i>
					</div>
				</div>
				<div class="col-xs-9 w3_two_grid_right_gridr">
					<h4>Project Management</h4>
					<p>Suspendisse bibendum ex sit amet tellus finibus ultrices.</p>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="w3_two_grid_right1">
				<div class="col-xs-3 w3_two_grid_right_grid">
					<div class="w3_two_grid_right_grid1">
						<i class="fa fa-building" aria-hidden="true"></i>
					</div>
				</div>
				<div class="col-xs-9 w3_two_grid_right_gridr">
					<h4>Design & Development</h4>
					<p>Suspendisse bibendum ex sit amet tellus finibus ultrices.</p>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="w3_two_grid_right1">
				<div class="col-xs-3 w3_two_grid_right_grid">
					<div class="w3_two_grid_right_grid1">
						<i class="fa fa-wrench" aria-hidden="true"></i>
					</div>
				</div>
				<div class="col-xs-9 w3_two_grid_right_gridr">
					<h4>Business Management</h4>
					<p>Suspendisse bibendum ex sit amet tellus finibus ultrices.</p>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="w3_two_grid_right1">
				<div class="col-xs-3 w3_two_grid_right_grid">
					<div class="w3_two_grid_right_grid1">
						<i class="fa fa-trophy" aria-hidden="true"></i>
					</div>
				</div>
				<div class="col-xs-9 w3_two_grid_right_gridr">
					<h4>Awesome Results</h4>
					<p>Suspendisse bibendum ex sit amet tellus finibus ultrices.</p>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
		<div class="clearfix"> </div>
	</div>
<!-- //two-grids -->
<!-- news -->
	<div class="news">
		<div class="container">
			<h3 class="agile_head">Latest News</h3>
			<p class="w3_agile_para">Suspendisse bibendum ex sit amet tellus finibus</p>
			<div class="agileits_w3layouts_news_grids">
				<ul id="flexiselDemo1">	
					<li>
						<div class="agileits_w3layouts_news_grid">
							<div class="w3_agileits_news_grid">
								<img src="${ctx}/static/images/3.jpg" alt=" " class="img-responsive" />
								<div class="w3_agileits_news_grid_pos">
									<h4>Date : 15 November 2017</h4>
								</div>
							</div>
							<h5><a href="#" data-toggle="modal" data-target="#myModal">bibendum ex sit amet</a></h5>
							<p>Nunc sodales augue in felis facilisis consectetur.</p>
						</div>
					</li>
					<li>
						<div class="agileits_w3layouts_news_grid">
							<div class="w3_agileits_news_grid">
								<img src="${ctx}/static/images/4.jpg" alt=" " class="img-responsive" />
								<div class="w3_agileits_news_grid_pos">
									<h4>Date : 18 November 2017</h4>
								</div>
							</div>
							<h5><a href="#" data-toggle="modal" data-target="#myModal">augue in felis facili</a></h5>
							<p>Nunc sodales augue in felis facilisis consectetur.</p>
						</div>
					</li>
					<li>
						<div class="agileits_w3layouts_news_grid">
							<div class="w3_agileits_news_grid">
								<img src="${ctx}/static/images/5.jpg" alt=" " class="img-responsive" />
								<div class="w3_agileits_news_grid_pos">
									<h4>Date : 23 November 2016</h4>
								</div>
							</div>
							<h5><a href="#" data-toggle="modal" data-target="#myModal">facilisis consecte</a></h5>
							<p>Nunc sodales augue in felis facilisis consectetur.</p>
						</div>
					</li>
					<li>
						<div class="agileits_w3layouts_news_grid">
							<div class="w3_agileits_news_grid">
								<img src="${ctx}/static/images/6.jpg" alt=" " class="img-responsive" />
								<div class="w3_agileits_news_grid_pos">
									<h4>Date : 28 November 2016</h4>
								</div>
							</div>
							<h5><a href="#" data-toggle="modal" data-target="#myModal">sodales augue felis</a></h5>
							<p>Nunc sodales augue in felis facilisis consectetur.</p>
						</div>
					</li>
					<li>
						<div class="agileits_w3layouts_news_grid">
							<div class="w3_agileits_news_grid">
								<img src="${ctx}/static/images/1.jpg" alt=" " class="img-responsive" />
								<div class="w3_agileits_news_grid_pos">
									<h4>Date : 30 November 2016</h4>
								</div>
							</div>
							<h5><a href="#" data-toggle="modal" data-target="#myModal">augue in felis felis</a></h5>
							<p>Nunc sodales augue in felis facilisis consectetur.</p>
						</div>
					</li>
				</ul>
				<script type="text/javascript">
						$(window).load(function() {
							$("#flexiselDemo1").flexisel({
								visibleItems: 4,
								animationSpeed: 1000,
								autoPlay: true,
								autoPlaySpeed: 3000,    		
								pauseOnHover: true,
								enableResponsiveBreakpoints: true,
								responsiveBreakpoints: { 
									portrait: { 
										changePoint:480,
										visibleItems: 1
									}, 
									landscape: { 
										changePoint:640,
										visibleItems:2
									},
									tablet: { 
										changePoint:768,
										visibleItems: 3
									}
								}
							});
							
						});
				</script>
				<script type="text/javascript" src="${ctx}/static/js/model/jquery.flexisel.js"></script>
			</div>
		</div>
	</div>
<!-- //news -->
<!-- stats -->
	<div class="stats">
		<div class="wthree_stat">
			<div class="container">
				<div class="col-md-5 wthree_stat_left">
					<h3>Our Stats</h3>
					<p>Nullam blandit condimentum tellus, eu sagittis leo pellentesque nec. 
						Integer semper risus commodo neque semper.</p>
				</div>
				<div class="col-md-7 wthree_stat_right">
					<ul>
						<li>
							<div class="wthree_stat_right1">
								<i class="fa fa-heart" aria-hidden="true"></i>
								<h4>People Loved</h4>
								<p class="counter">324</p> 
							</div>
						</li>
						<li>
							<div class="wthree_stat_right1">
								<i class="glyphicon glyphicon-piggy-bank" aria-hidden="true"></i>
								<h4>Save Income</h4>
								<p class="counter">412</p> 
							</div>
						</li>
						<li>
							<div class="wthree_stat_right1">
								<i class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></i>
								<h4>Creative Design</h4>
								<p class="counter">231</p> 
							</div>
						</li>
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
		<div class="w3layouts_newsletter">
			<div class="container">
				<div class="w3layouts_newsletter_left">
					<h3>Subscribe to our newsletter</h3>
				</div>
				<div class="w3layouts_newsletter_right">
					<form action="#" method="post">
						<input type="email" name="Email" placeholder="Email..." required="">
						<input type="submit" value="Subscribe">
					</form>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
<!-- //stats -->
<!-- stats -->
	<script src="${ctx}/static/js/model/waypoints.min.js"></script>
	<script src="${ctx}/static/js/model/counterup.min.js"></script>
	<script>
		jQuery(document).ready(function( $ ) {
			$('.counter').counterUp({
				delay: 20,
				time: 1000
			});
		});
	</script>
<!-- stats -->
<!-- footer -->
	<div class="footer">
		<div class="container">
			<div class="w3_footer_grids">
				<div class="col-md-4 w3_footer_grid">
					<h2><a href="index.html"><span>MX</span>michaux</a></h2>
					<p>Aliquam lacus tur <a href="#">http://michaux.com</a> lobortis quis dolor sed, 
						nec convallis velit vestibulum ac dignissim rhoncus neque.</p>
				</div>
				<div class="col-md-3 w3_footer_grid">
					<div class="w3l_footer_grid">
						<i class="fa fa-home" aria-hidden="true"></i>
					</div>
					<h4>Address</h4>
					<p>234 main street west Building, BeiJing City,F34 834.</p>
				</div>
				<div class="col-md-2 w3_footer_grid">
					<div class="w3l_footer_grid">
						<i class="fa fa-phone" aria-hidden="true"></i>
					</div>
					<h4>Call Us</h4>
					<p>(010) 456 789 344 <span>(010) 456 780 344</span></p>
				</div>
				<div class="col-md-3 w3_footer_grid">
					<div class="w3l_footer_grid">
						<i class="fa fa-envelope" aria-hidden="true"></i>
					</div>
					<h4>Mail Us</h4>
					<p><a href="www.tcc0503@163.com">tcc0503@163.com</a>
						<span><a href="www.tcc0503@163.com">michaux@mx.com</a></span></p>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<div class="copyright">
		<div class="container">
			<div class="w3ls_copyright_left">
				<ul>
					<li><a href="services.html">Services</a></li>
					<li><a href="about.html">About</a></li>
					<li><a href="portfolio.html">Portfolio</a></li>
					<li><a href="contact.html">Contact</a></li>
				</ul>
				<p>Copyright &copy; 2017.Company name All rights reserved.More Templates <a href="http://www.michaux.com/" target="_blank" title="michaux-store">michaux-store</a> - Collect from <a href="http://www.michaux.com/" title="michaux-store" target="_blank">michaux-store</a></p>
			</div>
			<div class="w3ls_copyright_right">
				<ul>
					<li><a href="#" class="w3_agile_facebook"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
					<li><a href="#" class="agile_twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
					<li><a href="#" class="w3_agile_dribble"><i class="fa fa-dribbble" aria-hidden="true"></i></a></li>
					<li><a href="#" class="w3_agile_vimeo"><i class="fa fa-vimeo" aria-hidden="true"></i></a></li>
				</ul>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //footer -->
<!-- start-smoth-scrolling -->
<script src="${ctx}/static/js/model/move-top.js"></script>
<script src="${ctx}/static/js/model/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
<!-- for bootstrap working -->
	<script src="${ctx}/static/js/model/bootstrap.js"></script>
<!-- //for bootstrap working -->
<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
<!-- //here ends scrolling icon -->
</body>
</html>