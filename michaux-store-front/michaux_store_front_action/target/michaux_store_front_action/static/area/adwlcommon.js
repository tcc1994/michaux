
var lbs_distance=0;
function initLbsTransit(startplace,endplace,callback){
	
	// 百度地图API功能
	var myGeo = new BMap.Geocoder();
	// 将地址解析结果显示在地图上,并调整地图视野
	myGeo.getPoint(startplace, function(point){
		
		if (point) {
			var searchComplete = function (results){
			if (transit.getStatus() != BMAP_STATUS_SUCCESS){
				return;
			}
				var plan = results.getPlan(0);
				lbs_distance += plan.getDistance(true) + "\n";             //获取距离
				if(lbs_distance!=null&&lbs_distance.length>2){
					lbs_distance=lbs_distance.substring(0,lbs_distance.length-3);
				}
				callback();
			}
			var transit = new BMap.DrivingRoute(point, {renderOptions: {},
				onSearchComplete: searchComplete,
				onPolylinesSet: function(){  
				
					setTimeout(function(){},"1000");
				}});
				myGeo.getPoint(endplace, function(point1){
				transit.search(point, point1);
			})
			
		}else{
			alert("您选择地址没有解析到结果!");
		}
	}, "北京市");

}
function drawTransitMap(id,startplace,endplace){
	// 百度地图API功能
	var myGeo = new BMap.Geocoder();
	myGeo.getPoint(startplace, function(point){
		// 百度地图API功能
		var map = new BMap.Map(id);
		map.centerAndZoom(point, 12);
		var searchComplete = function (results){	
		}
		var transit = new BMap.DrivingRoute(map, {renderOptions: {map: map},
			onSearchComplete: searchComplete,
			onPolylinesSet: function(){        
			setTimeout(function(){},"1000");
			}});
		myGeo.getPoint(endplace, function(point1){
		transit.search(point, point1);
		})
	})
}
/**
 * 去掉出发地或者目的地的“-”
 * @param areaformat
 * @returns {String}
 */
function areaFormat(areaformat) {

	var areaArr = areaformat.split("-");
	var  place_to ="";
	if(areaArr.length==3){
		if((areaArr[0]+"市")==areaArr[1]){
			place_to = areaArr[1] + areaArr[2];
		}else{
			place_to = areaArr[0]+areaArr[1]+areaArr[2];
		}
	}else if(areaArr.length==2){
		if((areaArr[0]+"市")==areaArr[1]){
			place_to = areaArr[1];
		}else{
			place_to = areaArr[0]+areaArr[1];
		}
	}else if(areaArr.length==1){
		place_to = areaArr[0];
	}else {
		place_to = areaformat;
	}
	return place_to;
}
/**
 * js添加cookie
 * 登录成功之后存储用户名
 */
function addCookie(c_name,value){
	document.cookie=c_name+ "=" +value+";path=/;";
}
/**
 * js添加cookie
 * 登录成功之后存储用户名
 */
function addCookieLong(c_name,value){
	var date=new Date();
	date.setTime(date.getTime()+30*24*60*1000); //设置date为当前时间+30分
	document.cookie=c_name+ "=" +value+";path=/;expires="+date.toGMTString();
}
/**
 * js删除cooke
 * 需要在用户退出时 删除用户名cookie
 */
//清除cookie  
function clearCookie(name) {  
    setCookie(name, "", -1);
}  
function getCookie(name)
{
    var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
 
    if(arr=document.cookie.match(reg))
 
        return (arr[2]);
    else
        return null;
}
function guid() {
    return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = Math.random()*16|0, v = c == 'x' ? r : (r&0x3|0x8);
        return v.toString(16);
    });
}
//校验手机号是否合法
function isPhoneNum(phonenum){
    var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(16[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
    if(!myreg.test(phonenum)){ 
        alert('请输入有效的手机号码！'); 
        return false; 
    }else{
        return true;
    }
}

