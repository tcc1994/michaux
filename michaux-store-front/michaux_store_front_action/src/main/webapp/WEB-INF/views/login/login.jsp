<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/boot.jsp"%>
<%@ include file="/WEB-INF/views/include/alert.jsp"%>
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>米修登录</title>
<link rel="stylesheet" type="text/css" href="${ctx}/static/css/login.css"/>

</head>
<body>
    <div class="container">
        <div class="form row">
            <div class="form-horizontal col-md-offset-3" id="login_form">
                <h3 class="form-title">LOGIN</h3>
                <div class="col-md-9">
                	<form id="login-form">
	                    <div class="form-group">
	                        <i class="fa fa-user fa-lg"></i>
	                        <input class="form-control required" type="text" placeholder="Username" id="username" name="username" autofocus="autofocus" maxlength="11"/>
	                    </div>
	                    <div class="form-group">
	                            <i class="fa fa-lock fa-lg"></i>
	                            <input class="form-control required" type="password" placeholder="Password" id="password" name="password" maxlength="16"/>
	                    </div>
	                    <div class="form-group">
	                         <input type="text" class="input-small" style="width: 100px;" id="kaptcha" name="kaptcha" placeholder="验证码">
	                         <span class="login-w"><img id="kaptchaImage" src="${ctx}/kaptcha/doGet.do" style="width: 65px;height: 30px;" ></span>
	                    </div>
	                    <div class="form-group col-md-offset-9">
	                    	<a type="button" class="btn btn-warning register" href="${ctx}/reg/page.do" title="注册">注册</a>
	                        <a id="ajaxSubmit" type="button" class="btn btn-success pull-right" title="登录">登录</a>
	                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="${ctx}/static/js/alert/alert.js"></script>
<script type="text/javascript">
$(function() {
	//生成验证码  
	$('#kaptchaImage').click(function () {
	     $(this).hide().attr('src', '${ctx}/kaptcha/doGet.do?' + Math.floor(Math.random()*100) ).fadeIn();  
	     event.cancelBubble=true;  
    });
	//登录
	$("#ajaxSubmit").click(function(){
		ajaxSubmit();
	});
	$(document).keyup(function(event){
	  if(event.keyCode==13){
		  ajaxSubmit();
	  }
	});
}); 

function ajaxSubmit(){
	$.ajax({
        type: "POST",
        url: "${ctx}/login/submit.do" ,
        dataType: "json",
        data: $('#login-form').serialize(),
        beforeSend: function() {
	     	var name = $("input[name='username']").val();
	        var pwd = $("input[name='password']").val();
	        var kaptcha = $("input[name='kaptcha']").val();
	        if(name.trim()==""){
	    		alertLocal("用户名不能为空");
	    		return false;
	    	}
	     	if(pwd.trim()==""){
	    		alertLocal("密码不能为空");
	    		return false;
	    	}
	     	var pattern = /^1[34578]\d{9}$/;
	        if(!pattern.test(name.trim())){
	        	alertLocal("请输入正确手机号");
	    		return false;
	        }
	        if(kaptcha.trim()==""){
	        	alertLocal("请输入验证码");
	    		return false;
	        }
        },
        success: function (data) {
        	if(data=='200'){
        		alertLocal("登录成功");
        		window.location.href("/home/page.do");
        	}
        	if(data=='101'){
        		alertLocal("用户不存在");
        		window.location.href("/reg/page.do");
        	}
        	if(data=='102'){
        		alertLocal("密码错误");
        	}
        	if(data=='103'){
        		alertLocal("验证码错误");
        	}
        	if(data=='500'){
        		alertLocal("系统异常,请重试");
        	}
        },
        error : function(data) {
     	   alertLocal("系统异常,请重试");
        }
     });
}

</script>

</body>
</html>
