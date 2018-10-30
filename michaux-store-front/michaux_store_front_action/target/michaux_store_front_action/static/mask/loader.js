/**
 *  页面加载等待页面
 *
 * @author gxjiang
 * @date 2010/7/24
 *
 */
 var height = window.screen.height-250;
 var width = window.screen.width;
var leftW = 300;
 if(width>1200){
 	leftW = 850;
 }else if(width>1000){
 	leftW = 450;
 }else {
 	leftW = 350;
 }
 
 var _html = "<div id='loading' style='position:absolute;z-index:99999;left:0;width:100%;height:"+height+"px;top:0;background:#E0ECFF;opacity:0.8;filter:alpha(opacity=80);'>\
 <div style='position:absolute;	cursor1:wait;left:"+leftW+"px;top:400px;width:auto;height:16px;padding:8px 9px 12px 25px;\
 background:#fff url(../../static/plugins/easyui/jquery-easyui-theme/default/images/loading.gif) no-repeat scroll 5px 10px;border:2px solid #ccc;color:#000;'>\
 正在处理，请等待...\
 </div></div>";
 
function removeMask(){
 	var _mask = document.getElementById('loading');
 	_mask.parentNode.removeChild(_mask);
 };
	
function addMask(){
	$('body').append(_html);
};

 