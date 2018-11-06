function alertLocal(message){
	new show_modal({
		modalId:'alert_like',
		titleTxt:'提示',
		modalCon:'<p class="alert_content">' + message + '</p>',
		bootstrapOptionObj:{show:true,backdrop:false}
	});
}
//显示弹窗函数
var show_modal = function(setting){
    var _self = this;
    $(".alert_content").html("");
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
