$(function() {
	$("#ajaxSubmit").click(function(){
	$.ajax({
           type: "POST",
           url: "/login/login" ,
           dataType: "json",
           data: $('#login-form').serialize(),
           beforeSend: function() {
        	var name = $("input[name='username']").val();
   	        var pwd = $("input[name='password']").val();
   	        if(name==""){
   	    		new show_modal({modalId:'alert_like',titleTxt:'error',modalCon:'<p>用户名不能为空</p>',bootstrapOptionObj:{show:true,backdrop:false},callback:timeClose()});
   	    		return false;
   	    	}
   	     	if(pwd==""){
	    		new show_modal({modalId:'alert_like',titleTxt:'error',modalCon:'<p>密码不能为空</p>',bootstrapOptionObj:{show:true,backdrop:false},callback:timeClose()});
	    		return false;
	    	}
   	    	new show_modal({modalId:'alert_like',titleTxt:'登录',modalCon:'<p>登录中...</p>',bootstrapOptionObj:{show:true,backdrop:false},callback:timeClose()});
           },
           success: function (result) {
               console.log(result);
               if (result.resultCode == 200) {
                   alert("SUCCESS");
               }
               ;
           },
           error : function() {
               alert("异常！");
           }
        });
	});
	
}); 
//显示弹窗函数
var show_modal = function(setting){
    var _self = this;

    //判断为null或者空值
    _self.IsNull = function(value) {
        if (typeof (value) == "function") { return false; }
        if (value == undefined || value == null || value == "" || value.length == 0) {
            return true;
        }
        return false;
    };
    //默认配置
    _self.DefautlSetting = {
        modalId:'',
        titleTxt: '温馨提示',
        modalCon: '这是提示的信息！',
        bootstrapOptionObj: {show : true},
        callback: function() { }
    };
    //读取配置
    _self.Setting = {
        modalId: _self.IsNull(setting.modalId) ? _self.DefautlSetting.modalId : setting.modalId,
        titleTxt: _self.IsNull(setting.titleTxt) ? _self.DefautlSetting.titleTxt : setting.titleTxt,
        modalCon: _self.IsNull(setting.modalCon) ? _self.DefautlSetting.modalCon : setting.modalCon,
        bootstrapOptionObj: _self.IsNull(setting.bootstrapOptionObj) ? _self.DefautlSetting.bootstrapOptionObj : setting.bootstrapOptionObj,
        callback: _self.IsNull(setting.callback) ? _self.DefautlSetting.callback : setting.callback
    };
    //定义函数操作
    _self.int = function(){
        if (_self.Setting.modalId == '') {
            return;
        }
        $("#myModalLabel").text(_self.Setting.titleTxt);//这里设置弹窗的标题
        $("#modal_con").append(_self.Setting.modalCon);//设置弹窗内容
        $("#"+_self.Setting.modalId).modal(_self.Setting.bootstrapOptionObj);//设置弹窗的bootstrap属性方法
        _self.Setting.callback();
    };
    //执行操作
    _self.int();
};

//show_modal回调函数，4s后隐藏弹窗

function timeClose(){
	setTimeout(function(){
		$('#alert_like').modal('hide');},4000
	);
}