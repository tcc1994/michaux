// 代理区域地址存储key add:agent 省-市-区/县
// 代理区域地址名称存储key add:agent:name 省-市-区/县
// 管辖区域地址存储key add:administer:city 市-市-市-市。。。。。。。
// 管辖区域地址存储key add:administer:area:市： 区-区-区-区。。。。。。。
////////////////////////////////////////////////管辖区域/////////////////////////////////////////////////////////////////////////
// 两种情况:一、省级运营中心;二、市级运营中心或者服务站
function get_jurisdiction_address(){
	var level = get_level();
	var agentName = $("#eiAreaName").val();
	// 获取代理级别,根据代理级别显示不同的控件
	if(level == 1){
		// 运营中心
		if(agentName.indexOf("-") < 0){
			// 省级运营中心
			get_jurisdiction_city();
		} else {
			// 市级运营中心
			get_jurisdiction_area(1);
		}
	} else if (level == 2) {
		// 服务站
		get_jurisdiction_area(2);
	} else {
		// 工作站
		$("#agentRegionName").val(agentName);
		$("#agentRegionName").attr("disabled", true);
		return;
	}
}
// 省级运营中心获取市级数据
function get_jurisdiction_city () {
	// 设置title
	var title = cookie.get_cookie("add:agent:name");
	var aiCode = cookie.get_cookie("add:agent");
	if("北京" == title || "上海" == title || "天津" == title || "重庆" == title){
		title = title + "市运营中心";
	} else {
		title = title + "省运营中心";
	}
	$(".province_jurisdiction_div_title").text(title);
	// 获取数据
	getData("/agent/qualification/aa", {"aiCode": aiCode});
	var html = "";
	var flag = true;
	for(var i=0;i<address_arr.length;i++){
		var memory = whether_memory(address_arr[i].aiCode, 1);
		if(memory){
			if(flag){
				html += "<div class='city b_current' code='"+address_arr[i].aiCode+"' onclick='click_city(this)'>"+
				"<input type='checkbox' checked=true disabled=true index='"+i+"'/>"+address_arr[i].aiName+"</div>";
				// 再次展示,显示记忆中的第一个市的区/县
				get_jurisdiction_city_area (address_arr[i].aiCode);
				flag = false;
			} else {
				html += "<div class='city' code='"+address_arr[i].aiCode+"' onclick='click_city(this)'>"+
				"<input type='checkbox' checked=true disabled=true index='"+i+"'/>"+address_arr[i].aiName+"</div>";
			}
		} else {
			html += "<div class='city' code='"+address_arr[i].aiCode+"' onclick='click_city(this)'>"+
			"<input type='checkbox' disabled=true index='"+i+"'/>"+address_arr[i].aiName+"</div>";
		}
	}
	$(".province_jurisdiction_div_context_left").html(html);
	display_div("province_jurisdiction_div");
}
// 市级运营中心和服务站点击确定
function area_ensure () {
	var memorycode = cookie.get_cookie("add:agent");
	var name = cookie.get_cookie("add:agent:name");
	var divs = $(".city_jurisdiction_div_context_center").find("div");
	var areaStr = "";
	for(var i=0;i<divs.length;i++){
		var check = $($(divs[i]).find("input")).prop("checked");
		var code = $(divs[i]).attr("code");
		if(check && code != undefined && code != ""){
			areaStr += code + "-";
		}
	}
	areaStr = areaStr.substring(0, areaStr.length - 1);
	cookie.set_cookie_without_time("add:administer:area:" + memorycode.split("-")[1], areaStr);
	var area = cookie.get_cookie("add:administer:area:" + memorycode.split("-")[1]);
	if(area == undefined || area == ""){
		$.messager.alert('提示','请重新选择管辖区域','info');
	}
	$("#see").show();
	close_div();
}
// 市级运营中心和服务站
function get_jurisdiction_area (type) {
	// 设置title
	var level = get_level();
	var agentNameStr = cookie.get_cookie("add:agent:name");
	var agentCodeStr = cookie.get_cookie("add:agent");
	var agentNameArr = agentNameStr.split("-");
	var title = (type == 1) ? (agentNameArr[1] + "市运营中心") : (agentNameArr[1] + "市服务站");
	$(".city_jurisdiction_div_title").text(title);
	// 请求数据
	getData("/agent/qualification/aa", {"aiCode": agentCodeStr.split("-")[1]});
	var html = "<div class='area' onclick='select_all_2(this)'><input type='checkbox' checked=true/>全选</div>";
	for(var i=0;i<address_arr.length;i++){
		var memory = whether_memory(agentCodeStr.split("-")[1], 2, address_arr[i].aiCode);
		var available = 0;
		if(level == 1){
			available = address_arr[i].aiProvinceAvailable;
		} else if (level == 2) {
			available = address_arr[i].aiCityAvailable;
		} else {
			available = address_arr[i].aiAreaAvailable;
		}
		if(available == 1){
			if(memory == undefined){
				html += "<div class='area' code='"+address_arr[i].aiCode+"' onclick='click_area_2(this)'><input type='checkbox' checked=true/>"+address_arr[i].aiName+"</div>";
			} else {
				if(memory){
					html += "<div class='area' code='"+address_arr[i].aiCode+"' onclick='click_area_2(this)'><input type='checkbox' checked=true/>"+address_arr[i].aiName+"</div>";
				}else{
					html += "<div class='area' code='"+address_arr[i].aiCode+"' onclick='click_area_2(this)'><input type='checkbox'/>"+address_arr[i].aiName+"</div>";
				}
			}
		}
	}
	$(".city_jurisdiction_div_context_center").html(html);
	display_div("city_jurisdiction_div");
}
// 市级运营中心或者服务站点击区/县
function select_all_2 (obj) {
	// 将所有数据改变为全部勾选或者全部非勾选,增加或者删除数据 
	var code = cookie.get_cookie("add:agent");
	var check = $($(obj).find("input")).prop("checked");
	var divs = $(".city_jurisdiction_div_context_center").find("div");
	if(check){
		// 如果当前为勾选,将所有改变为非勾选,删除cookie
		var total = 0;
		for(var i=0;i<divs.length;i++){
			var checks = $($(divs[i]).find("input")).prop("checked");
			var texts = $(divs[i]).text();
			if(checks && (texts != "全选")){
				total += 1;
			}
		}
		// 计数勾选的个数
		if(total == (divs.length - 1)){
			for(var i=0;i<divs.length;i++){
				$($(divs[i]).find("input")).prop("checked", false);
			}
		} else {
			for(var i=0;i<divs.length;i++){
				$($(divs[i]).find("input")).prop("checked", true);
			}
		}
		cookie.delete_cookie("add:administer:area:" + code.split("-")[1]);
	} else {
		// 如果当前为非勾选,将所有改变为勾选,重新获取字符串,存储
		var areaStr = "";
		for(var i=0;i<divs.length;i++){
			$($(divs[i]).find("input")).prop("checked", true);
			var code = $(divs[i]).attr("code");
			if(code != undefined && code != ""){
				areaStr += code + "-";
			}
		}
		areaStr = areaStr.substring(0, areaStr.length - 1);
		cookie.set_cookie_without_time("add:administer:area:" + code.split("-")[1], areaStr);
	}
}
// 市级运营中心或者服务站点击区/县
function click_area_2 (obj) {
	// 改变勾选状态,修改记忆的数据 
	var code = cookie.get_cookie("add:agent");
	var area = cookie.get_cookie("add:administer:area:" + code.split("-")[1]);
	var check = $($(obj).find("input")).prop("checked");
	// 获取所有勾选的区/县
	var divs = $(".city_jurisdiction_div_context_center").find("div");
	if(check){
		// 当前状态为勾选,改变为非勾选
		$($(obj).find("input")).prop("checked", false);
		var total = 0;
		for(var i=0;i<divs.length;i++){
			var check = $($(divs[i]).find("input")).prop("checked");
			var text = $(divs[i]).text();
			if(!check && (text != "全选")){
				total += 1;
			}
		}
		if(total == (divs.length - 1)){
			// 去掉全选的勾选状态
			$($(divs[0]).find("input")).prop("checked", false);
		}
	} else {
		// 当前状态为非勾选,改变为勾选
		$($(obj).find("input")).prop("checked", true);
		var total = 0;
		for(var i=0;i<divs.length;i++){
			var check = $($(divs[i]).find("input")).prop("checked");
			var text = $(divs[i]).text();
			if(check && (text != "全选")){
				total += 1;
			}
		}
		if(total == (divs.length - 1)){
			// 去掉全选的勾选状态
			$($(divs[0]).find("input")).prop("checked", true);
		}
	}
	// 获取所有已勾选的区/县的字符串
	var areaStr = "";
	for(var i=0;i<divs.length;i++){
		var check = $($(divs[i]).find("input")).prop("checked");
		var code = $(divs[i]).attr("code");
		if(check && code != undefined && code != ""){
			areaStr += code + "-";
		}
	}
	if(areaStr != ""){
		areaStr = areaStr.substring(0, areaStr.length - 1);
		cookie.set_cookie_without_time("add:administer:area:" + code.split("-")[1], areaStr);
	}
}
// 清除cookie中记忆的数据,清除eiAreaName输入框中的值
function clear_memory_address () {
	// 代理区域 add:agent 和 add:agent:name
	cookie.delete_cookie("add:agent");
	cookie.delete_cookie("add:agent:name");
	// 管辖区域  add:administer:city 和 add:administer:area:市code
	var memoryCityStr = cookie.get_cookie("add:administer:city");
	if(memoryCityStr != undefined && memoryCityStr != ""){
		var memoryCityArr = memoryCityStr.split("-");
		for(var i=0;i<memoryCityArr.length;i++){
			cookie.delete_cookie("add:administer:area:" + memoryCityArr[i]);
		}
		cookie.delete_cookie("add:administer:city");
	}
	var name = cookie.get_cookie("add:agent:name");
	$("#eiAreaName").val("");
	$("#see").hide();
}
// eiAreaName输入框中值改变,清除管辖区域的记忆
function clear_memory_jurisdiction () {
	// 管辖区域  add:administer:city 和 add:administer:area:市code
	var memoryCityStr = cookie.get_cookie("add:administer:city");
	if(memoryCityStr != undefined && memoryCityStr != ""){
		var memoryCityArr = memoryCityStr.split("-");
		for(var i=0;i<memoryCityArr.length;i++){
			cookie.delete_cookie("add:administer:area:" + memoryCityArr[i]);
		}
		cookie.delete_cookie("add:administer:city");
	}
	$("#see").hide();
	$("#agentRegionName").attr("disabled", false);
}
// 省级运营中心获取区/县级数据
function get_jurisdiction_city_area (cityCode) {
	var level = get_level();
	getAreaData("/agent/qualification/aa", {"aiCode": cityCode});
	var html = "";
	html += "<div class='area' onclick='select_all("+cityCode+")'><input type='checkbox' checked=true/>全选</div>";
	for(var i=0;i<address_area_arr.length;i++){
		var memory = whether_memory (cityCode, 2, address_area_arr[i].aiCode);
		var available = 0;
		if(level == 1){
			available = address_area_arr[i].aiProvinceAvailable;
		} else if (level == 2) {
			available = address_area_arr[i].aiCityAvailable;
		} else {
			available = address_area_arr[i].aiAreaAvailable;
		}
		if(available == 1){
			if(memory == undefined){
				html += "<div class='area' code='"+cityCode+"' onclick='click_area(this)'>"+
				"<input type='checkbox' checked=true code='"+address_area_arr[i].aiCode+"'/>"+address_area_arr[i].aiName+"</div>";
			} else {
				if(memory){
					html += "<div class='area' code='"+cityCode+"' onclick='click_area(this)'>"+
					"<input type='checkbox' checked=true code='"+address_area_arr[i].aiCode+"'/>"+address_area_arr[i].aiName+"</div>";
				} else {
					html += "<div class='area' code='"+cityCode+"' onclick='click_area(this)'>"+
					"<input type='checkbox' code='"+address_area_arr[i].aiCode+"'/>"+address_area_arr[i].aiName+"</div>";
				}
			}
		}
	}
	$(".province_jurisdiction_div_context_right").html(html);
}
// 是否记忆
function whether_memory (cityCode, type, areaCode) {
	// 管辖区域地址存储key add:administer:city 市-市-市-市。。。。。。。
	// 管辖区域地址存储key add:administer:area:市： 区-区-区-区。。。。。。。
	if(type == 1){
		// 判断该市是否已选择
		var memoryCityStr = cookie.get_cookie("add:administer:city");
		if(memoryCityStr == undefined || memoryCityStr == ""){
			return undefined;
		}
		var memoryCityArr = memoryCityStr.split("-");
		for(var i=0;i<memoryCityArr.length;i++){
			if(cityCode == memoryCityArr[i]){
				return true;
			}
		}
	} else {
		// 判断该区/县是否已选择
		var memoryAreaStr = cookie.get_cookie("add:administer:area:" + cityCode);
		if(memoryAreaStr == undefined || memoryAreaStr == ""){
			return undefined;
		}
		var memoryAreaArr = memoryAreaStr.split("-");
		for(var i=0;i<memoryAreaArr.length;i++){
			if(areaCode == memoryAreaArr[i]){
				return true;
			}
		}
	}
	return false;
}

// 省级运营中心点击全选
function select_all (cityCode) {
	var flag = false;
	var divs = $(".province_jurisdiction_div_context_right").find("div");
	for(var i=0;i<divs.length;i++){
		var input = $(divs[i]).find("input");
		var check = $(input).prop("checked");
		if(!check){
			flag = true;
			break;
		}
	}
	// 当flag为ture时,说明非全部勾选
	var memberCityStr = (cookie.get_cookie("add:administer:city") == undefined) ? "" : cookie.get_cookie("add:administer:city");
	if(flag){
		// 判断,如果部分勾选,将所有变为勾选,对应的市也要改变
		var divs1 = $(".province_jurisdiction_div_context_right").find("div");
		for(var i=0;i<divs1.length;i++){
			var input = $(divs1[i]).find("input");
			$(input).prop("checked", true);
		}
		var divs2 = $(".province_jurisdiction_div_context_left").find("div");
		for(var i=0;i<divs2.length;i++){
			var code = $(divs2[i]).attr("code");
			if(cityCode == code){
				$($(divs2[i]).find("input")).prop("checked", true);
			}
		}
		// 记忆数据
		var checks = whether_memory (cityCode, 1);
		if(checks == undefined || checks == false){
			// 增加
			cookie.set_cookie_without_time("add:administer:city", memberCityStr + "-" + cityCode);
			// 获取所有的区和县
			var areaStr = "";
			var divs = $(".province_jurisdiction_div_context_right").find("div");
			for(var i=0;i<divs.length;i++){
				var div = $(divs[i]);
				if(div.text() != "全选"){
					areaStr += $($(divs[i]).find("input")).attr("code") + "-";
				}
			}
			areaStr = areaStr.substring(0, areaStr.length - 1);
			cookie.set_cookie_without_time("add:administer:area:" + cityCode, areaStr);
		} else {
			// 修改对应市的区/县数据
			var areaStr = "";
			for(var i=0;i<divs1.length;i++){
				var div = $(divs1[i]);
				if(div.text() != "全选" && ($($(divs1[i]).find("input")).prop("checked") == true)){
					areaStr += $($(divs1[i]).find("input")).attr("code") + "-";
				}
			}
			areaStr = areaStr.substring(0, areaStr.length - 1);
			cookie.set_cookie_without_time("add:administer:area:" + cityCode, areaStr);
		}
	}else{
		// 点击全选,判断,如果已全部勾选,将所有变为非勾选,对应的市也要改变
		var divs1 = $(".province_jurisdiction_div_context_right").find("div");
		for(var i=0;i<divs1.length;i++){
			var input = $(divs1[i]).find("input");
			$(input).prop("checked", false);
		}
		var divs2 = $(".province_jurisdiction_div_context_left").find("div");
		for(var i=0;i<divs2.length;i++){
			var code = $(divs2[i]).attr("code");
			if(cityCode == code){
				$($(divs2[i]).find("input")).prop("checked", false);
			}
		}
		// 记忆数据,删除数据
		var newMemberCityStrs = "";
		var memberCityArr = memberCityStr.split("-");
		for(var i=0;i<memberCityArr.length;i++){
			if(cityCode != memberCityArr[i]){
				newMemberCityStrs += memberCityArr[i] + "-";
			}
		}
		newMemberCityStrs = newMemberCityStrs.substring(0, newMemberCityStrs.length - 1);
		cookie.set_cookie_without_time("add:administer:city", newMemberCityStrs);
		cookie.delete_cookie("add:administer:area:"+ cityCode);
	}
}
function click_city (obj) {
	var input = $(obj).find("input");
	var cityCode = $(obj).attr("code");
	var check = $(input).prop("checked");
	var cls = $(obj).attr("class");
	if(check){
		if(cls == "city"){
			// 判断,如果自己为勾选且没有背景色,请求数据
			get_jurisdiction_city_area(cityCode);
		}else{
			// 判断,如果自己为勾选且有背景色,那么将自己和所辖区都改变为非勾选
			$(input).prop("checked", false);
			var divs = $(".province_jurisdiction_div_context_right").find("div");
			for(var i=0;i<divs.length;i++){
				var input = $(divs[i]).find("input");
				$(input).prop("checked", false);
			}
			// 删除对应的数据
			member_administer_data(obj, 1);
		}
	} else {
		// 判断,如果自己为非勾选,勾选自己,请求数据
		$(input).prop("checked", true);
		get_jurisdiction_city_area(cityCode);
		// 记录数据
		member_administer_data(obj, 1);
	}
	// 清除所有背景色,给自己增加背景色
	var divs = $(".province_jurisdiction_div_context_left").find("div");
	for(var i=0;i<divs.length;i++){
		$(divs[i]).removeClass("b_current");
	}
	$(obj).addClass("b_current");
}
function click_area (obj) {
	var input = $(obj).find("input");
	var cityCode = $(obj).attr("code");
	var check = $(input).prop("checked");
	// 点击区/县,判断,如果为勾选修改为非勾选
	if(check){
		// 如果修改为非勾选,判断是否所有的都已为非勾选,如果所有都已改变为非勾选,修改对应市和全选
		$(input).prop("checked", false);
		var divs = $(".province_jurisdiction_div_context_right").find("div");
		var total = 0;
		for(var i=0;i<divs.length;i++){
			var div = $(divs[i]);
			if(div.text() != "全选"){
				var input = div.find("input");
				var isCheck = $(input).prop("checked");
				if(!isCheck){
					total += 1;
				}
			}
		}
		if((divs.length - 1) == total){
			// 此时所有都已为非勾选,修改全选和对应的市为非勾选
			var input = $(divs[0]).find("input");
			$(input).prop("checked", false);
			// 修改对应的市为非勾选
			var divs = $(".province_jurisdiction_div_context_left").find("div");
			for(var i=0;i<divs.length;i++){
				var code = $(divs[i]).attr("code");
				if(cityCode == code){
					$($(divs[i]).find("input")).prop("checked", false);
					break;
				}
			}
		}
	} else {
		// 点击区/县,判断,如果为非勾选修改为勾选,如果所有都已改变为勾选,修改对应的市和全选
		$(input).prop("checked", true);
		var divs = $(".province_jurisdiction_div_context_right").find("div");
		var total = 0;
		for(var i=0;i<divs.length;i++){
			var div = $(divs[i]);
			if(div.text() != "全选"){
				var input = div.find("input");
				var isCheck = $(input).prop("checked");
				if(isCheck){
					total += 1;
				}
			}
		}
		if((divs.length - 1) == total){
			// 此时所有都已为勾选,修改全选和对应的市为勾选
			var input = $(divs[0]).find("input");
			$(input).prop("checked", true);
			// 修改对应的市为非勾选
			var divs = $(".province_jurisdiction_div_context_left").find("div");
			for(var i=0;i<divs.length;i++){
				var code = $(divs[i]).attr("code");
				if(cityCode == code){
					$($(divs[i]).find("input")).prop("checked", true);
					break;
				}
			}
		}
		// 勾选对应的市
		var divss = $(".province_jurisdiction_div_context_left").find("div");
		for(var i=0;i<divss.length;i++){
			var code = $(divss[i]).attr("code");
			if(cityCode == code){
				$($(divss[i]).find("input")).prop("checked", true);
				break;
			}
		}
		if(total == 1){
			// 增加记忆数据
			var codesss = cookie.get_cookie("add:administer:city");
			if(codesss == undefined || codesss == ""){
				cookie.set_cookie_without_time("add:administer:city", cityCode);
			} else {
				cookie.set_cookie_without_time("add:administer:city", codesss + "-" + cityCode);
			}
			var areaCode = $($(obj).find("input")).attr("code");
			cookie.set_cookie_without_time("add:administer:area:" + cityCode, areaCode);
		}
	}
	// 记录数据
	member_administer_data(obj, 2);
}
function member_administer_data (obj, type) {
	// 管辖区域地址存储key add:administer:city 市-市-市-市。。。。。。。
	// 管辖区域地址存储key add:administer:area:市： 区-区-区-区。。。。。。。
	var cityCode = $(obj).attr("code");
	var check = $($(obj).find("input")).prop("checked");
	var memberCityStr = (cookie.get_cookie("add:administer:city") == undefined || cookie.get_cookie("add:administer:city") == "") ? "" : cookie.get_cookie("add:administer:city") + "-";
	var memberAreaStr = (cookie.get_cookie("add:administer:area:" + cityCode) == undefined) ? "" : cookie.get_cookie("add:administer:area:" + cityCode);
	if(type == 1){
		// 点击市,增加或者删除数据
		if(check){
			// 勾选,增加
			cookie.set_cookie_without_time("add:administer:city", memberCityStr + cityCode);
			// 获取所有的区和县
			var areaStr = "";
			var divs = $(".province_jurisdiction_div_context_right").find("div");
			for(var i=0;i<divs.length;i++){
				var div = $(divs[i]);
				if(div.text() != "全选"){
					areaStr += $($(divs[i]).find("input")).attr("code") + "-";
				}
			}
			areaStr = areaStr.substring(0, areaStr.length - 1);
			cookie.set_cookie_without_time("add:administer:area:" + cityCode, areaStr);
		} else {
			// 非勾选,删除
			memberCityStrs = memberCityStr.substring(0, memberCityStr.length - 1);
			var memberCityArr = memberCityStrs.split("-");
			var newMemberCityStr = "";
			for(var i=0;i<memberCityArr.length;i++){
				if(cityCode != memberCityArr[i]){
					newMemberCityStr += memberCityArr[i] + "-";
				}
			}
			newMemberCityStr = newMemberCityStr.substring(0, newMemberCityStr.length - 1);
			cookie.set_cookie_without_time("add:administer:city", newMemberCityStr);
			cookie.delete_cookie("add:administer:area:" + cityCode);
		}
	} else {
		// 点击区/县,修改对应市的数据,判断如果为全部勾选正常修改,如果为全部非勾选,删除数据
		var divs = $(".province_jurisdiction_div_context_right").find("div");
		if(check){
			// 勾选,修改对应市下的区/县
			var areaStr = "";
			for(var i=0;i<divs.length;i++){
				var div = $(divs[i]);
				if(div.text() != "全选" && ($($(divs[i]).find("input")).prop("checked") == true)){
					areaStr += $($(divs[i]).find("input")).attr("code") + "-";
				}
			}
			areaStr = areaStr.substring(0, areaStr.length - 1);
			cookie.set_cookie_without_time("add:administer:area:" + cityCode, areaStr);
		} else {
			// 非勾选,判断是否全部为非勾选,如果全部为非勾选,删除,如果不是全部为非勾选,修改
			var total = 0;
			for(var i=0;i<divs.length;i++){
				var div = $(divs[i]);
				if(div.text() != "全选"){
					var input = div.find("input");
					var isCheck = $(input).prop("checked");
					if(!isCheck){
						total += 1;
					}
				}
			}
			if(total == divs.length){
				// 此时全部为非勾选,删除
				var newMemberCityStr = "";
				var memberCityArr = memberCityStr.split("-");
				for(var i=0;i<memberCityArr.length;i++){
					if(cityCode != memberCityArr[i]){
						newMemberCityStr += memberCityArr[i] + "-";
					}
				}
				newMemberCityStr = newMemberCityStr.substring(0, newMemberCityStr.length - 1);
				cookie.set_cookie_without_time("add:administer:city", newMemberCityStr);
				cookie.delete_cookie("add:administer:area:"+ cityCode);
			} else {
				// 修改
				var areaStr = "";
				for(var i=0;i<divs.length;i++){
					var div = $(divs[i]);
					if(div.text() != "全选" && ($($(divs[i]).find("input")).prop("checked") == true)){
						areaStr += $($(divs[i]).find("input")).attr("code") + "-";
					}
				}
				areaStr = areaStr.substring(0, areaStr.length - 1);
				cookie.set_cookie_without_time("add:administer:area:" + cityCode, areaStr);
			}
		}
		
	}
}
// 判断数组中是否存在指定字符串
function check_contains (str, arrStr) {
	if(arr != undefined){
		var arr = arrStr.split("-");
		for(var i=0;i<arr.length;i++){
			if(str == arr[i]){
				return true;
			}
		}
	}
	return false;
}
// 省级运营中心点击确定
function jurisdiction_ensure () {
	// 将记忆的数据转为发送请求的数据
	// 管辖区域地址存储key add:administer:city 市-市-市-市。。。。。。。
	// 管辖区域地址存储key add:administer:area:市： 区-区-区-区。。。。。。。
	var memoryCityStr = cookie.get_cookie("add:administer:city");
	//console.log("记忆的市：" + memoryCityStr);
	if(memoryCityStr != undefined && memoryCityStr != ""){
		var memoryCityArr = memoryCityStr.split("-");
		for(var i=0;i<memoryCityArr.length;i++){
			var memoryAreaStr = cookie.get_cookie("add:administer:area:" + memoryCityArr[i]);
			if(memoryAreaStr == undefined || memoryAreaStr == ""){
				// 提示每个市都必须有管辖区域
				$.messager.alert('提示','请重新选择管辖区域','info');
				return;
			}
			//console.log("记忆的区/县" + memoryCityArr[i] + ":" + memoryAreaStr);
		}
	} else {
		// 提示选择市
		if(memoryCityStr == undefined || memoryCityStr == ""){
			$.messager.alert('提示','请选择管辖区域','info');
		}
		return;
	}
	// 显示查看
	$("#see").show();
	// 关闭控件
	close_div();
}

////////////////////////////////////////////////选择代理区域///////////////////////////////////////////////////////////////////////
function get_agent_address (title, aiCode, aiLevel, aiName) {
	if(!title && aiCode != 1){
		// aiCode为1时为请求全省,不做记录
		member_select(aiCode, aiLevel, aiName);
	}
	var member = get_member(aiLevel);
	if(aiLevel == 3){
		// aiLevel为3,此时为点击第三级地址,不请求数据
		var divs = $(".agent_div_center").find("div");
		for(var i=0;i<divs.length;i++){
			$(divs[i]).removeClass("current");
		}
		for(var i=0;i<divs.length;i++){
			var code = $(divs[i]).attr("code");
			if(aiCode == code){
				$(divs[i]).addClass("current");
				break;
			}
		}
		return;
	}
	// 改变title的选中
	change_title_select(aiLevel + 1);
	getData("/agent/qualification/aa", {"aiCode": aiCode});
	var flag = true;
	var str = "";
	if(aiLevel == 1 && aiCode != "110000" && aiCode != "120000" && aiCode != "190000" && aiCode != "320000"){
		if(member == undefined){
			str += "<div class='areaInfoElement current' onclick='select_myself(this)'>全省</div>";
			flag = false;
		} else {
			str += "<div class='areaInfoElement' onclick='select_myself(this)'>全省</div>";
		}
	} else if (aiLevel == 2) {
		if(member == undefined){
			str += "<div class='areaInfoElement current' onclick='select_myself(this)'>全境</div>";
			flag = false;
		} else {
			str += "<div class='areaInfoElement' onclick='select_myself(this)'>全境</div>";
		}
	}
	var levels = get_level();
	for(var i=0;i<address_arr.length;i++){
		var ele = address_arr[i];
		var click = 'get_agent_address(false, '+ele.aiCode+','+ele.aiLevel+',"'+ele.aiName+'")';
		var available = 0;
		if(levels == 1){
			available = address_arr[i].aiProvinceAvailable;
		} else if (levels == 2) {
			available = address_arr[i].aiCityAvailable;
		} else {
			available = address_arr[i].aiAreaAvailable;
		}
		if(available == 1){
			if(ele.aiLevel == 2){
				if(member == undefined){
					if(i == 0 && flag){
						str += "<div class='areaInfoElement current' code='"+ele.aiCode+"' onclick='"+click+"'>" + ele.aiName + "</div>";
					} else {
						str += "<div class='areaInfoElement' code='"+ele.aiCode+"' onclick='"+click+"'>" + ele.aiName + "</div>";
					}
				} else {
					if(member == ele.aiCode && flag){
						str += "<div class='areaInfoElement current' code='"+ele.aiCode+"' onclick='"+click+"'>" + ele.aiName + "</div>";
					} else {
						str += "<div class='areaInfoElement' code='"+ele.aiCode+"' onclick='"+click+"'>" + ele.aiName + "</div>";
					}
				}
			} else {
				if(member == undefined){
					if(i == 0 && flag){
						str += "<div class='areaInfoElement current' code='"+ele.aiCode+"' onclick='"+click+"'>" + ele.aiName + "</div>";
					} else {
						str += "<div class='areaInfoElement' code='"+ele.aiCode+"' onclick='"+click+"'>" + ele.aiName + "</div>";
					}
				} else {
					if(member == ele.aiCode && flag){
						str += "<div class='areaInfoElement current' code='"+ele.aiCode+"' onclick='"+click+"'>" + ele.aiName + "</div>";
					} else {
						str += "<div class='areaInfoElement' code='"+ele.aiCode+"' onclick='"+click+"'>" + ele.aiName + "</div>";
					}
				}
			}
		}
	}
	$(".agent_div_center").html(str);
	display_div("agent_div");
}
// 记录选择的数据
function member_select (aiCode, aiLevel, aiName) {
	var value = cookie.get_cookie("add:agent"); // 获取已记录的数据
	var name = $("#agent_member").val();
	if(value != undefined){
		var agentArr = value.split("-");
		if(aiLevel == 1){ // 点击省
			value = aiCode;
			name = aiName;
		}else if(aiLevel == 2){ // 点击市
			value = agentArr[0] + "-" + aiCode;
			name = name.split("-")[0] + "-" + aiName;
		}else{ // 点击区
			value = agentArr[0] + "-" + agentArr[1] + "-" + aiCode;
			name = name.split("-")[0] + "-" + name.split("-")[1] + "-" + aiName;
		}
	} else {
		value = aiCode;
		name = aiName;
	}
	if(aiCode == "110000" || aiCode == "120000" || aiCode == "190000" || aiCode == "320000"){
		value = aiCode + "-" + (aiCode + "").substring(0, 3) + "100";
		name = aiName + "-" + aiName;
	}
	$("#agent_member").val(name);
	cookie.set_cookie_without_time("add:agent:name", name);
	cookie.set_cookie_without_time("add:agent", value);
}
function select_myself(obj){
	var text = $(obj).text();
	var value = cookie.get_cookie("add:agent"); // 获取已记录的数据
	var valArr = value.split("-");
	if(text == "全境"){
		value = value = valArr[0] + "-" + valArr[1];
		var name = cookie.get_cookie("add:agent:name");
		name = name.split("-")[0] + "-" + name.split("-")[1];
		cookie.set_cookie_without_time("add:agent:name", name);
	} else {
		value = value = valArr[0] + "-" + valArr[1] + "-" + valArr[2];
	}
	if(text == "全省"){
		value = valArr[0];
	} else {
		value = valArr[0] + "-" + valArr[1];
	}
	cookie.set_cookie_without_time("add:agent", value);
	var divs = $(".agent_div_center").find("div");
	for(var i=0;i<divs.length;i++){
		$(divs[i]).removeClass("current");  
	}
	$(obj).addClass("current");
}
// 获取选择的数据
function get_member(aiLevel){
	var value = cookie.get_cookie("add:agent"); // 获取已记录的数据
	var code;
	if(value == undefined){
		return code;
	}
	var valArr = value.split("-");
	if(aiLevel == 0){ // 获取记忆的省
		code = valArr[0];
	} else if (aiLevel == 1) { // 获取记忆的市
		code = valArr[1];
	} else if (aiLevel == 2) { // 获取记忆的区
		code = valArr[2];
	}
	return code;
}
// 点击代理区域的标题
function click_title (index) {
	var value = cookie.get_cookie("add:agent"); // 获取已记录的数据
	var valArr = value.split("-");
	if(index == 1){
		// 点击省
		get_agent_address(true, 1, 0);
	} else if (index == 2) {
		// 点击市
		get_agent_address(true, valArr[0], 1);
	} else {
		// 点击区/县
		if(valArr.length < 3 && valArr[1] == undefined){
			return;
		}
		get_agent_address(true, valArr[1], 2);
	}
	// 改变title的选中状态
	change_title_select(index);
}
// 更改title的选中状态
function change_title_select (index) {
	var divs = $(".agent_div_title").find("div");
	for(var i=0;i<divs.length;i++){
		$(divs[i]).removeClass("current");
	}
	for(var i=0;i<divs.length;i++){
		if((i+1) == index){
			$(divs[i]).addClass("current");
		}
	}
}
// 代理区域控件点击确定
function agent_ensure () {
	var address = cookie.get_cookie("add:agent"); // 获取已记录的数据
	if(address == undefined){
		$.messager.alert('提示','请选择代理区域','info');
		return;
	}
	// 获取代理级别
	var level = get_level();
	var flag = agentIsAllow(level, address);
	if(!flag){
		$.messager.alert('提示','代理级别和代理区域不匹配,请选择正确的代理区域','info');
		return;
	}
	// 给地址赋值
	var name = cookie.get_cookie("add:agent:name");
//	if(name.indexOf("北京") > -1 || name.indexOf("天津") > -1 || name.indexOf("上海") > -1 ||name.indexOf("重庆") > -1){
//		name = name.split("-")[0];
//	}
	var oldName = $("#eiAreaName").val();
	$("#eiAreaName").val(name);
	close_div();
	var newName = $("#eiAreaName").val();
	if(oldName != newName){
		$("#eiAreaName").change();
	}
	//console.log(cookie.get_cookie("add:agent"));
	//console.log(cookie.get_cookie("add:agent:name"));
}
function agentIsAllow (level, address) {
	var addressArr = address.split("-");
	if(level == 1 && (addressArr.length > 2)){
		return false;
	}
	if(level == 2 && (addressArr.length != 2)){
		return false;
	}
	if(level == 3 && (addressArr.length != 3)){
		return false;
	}
	return true;
}

//////////////////////////////////////////////公共部分//////////////////////////////////////////////////////////////////////////
var address_arr = new Array(); // 请求地址数据返回数组
var address_area_arr = new Array(); // 请求地址数据返回数组
var temp_cookie = "";
function Address (aiId, aqId, aiCode, aiLevel, aiName, aiParentCode, aiProvinceAvailable, aiCityAvailable, aiAreaAvailable, aiYn) {
	this.aiId = aiId;
	this.aqId = aqId;
	this.aiCode = aiCode;
	this.aiLevel = aiLevel;
	this.aiName = aiName;
	this.aiParentCode = aiParentCode;
	this.aiProvinceAvailable = aiProvinceAvailable;
	this.aiCityAvailable = aiCityAvailable;
	this.aiAreaAvailable = aiAreaAvailable;
	this.aiYn = aiYn;
}
// 获取地址数据
function getData (url, params) {
	address_arr.splice(0, address_arr.length);
	$.ajax({
        type: 'POST',
        data: params,
        url: url,
        async: false,
        success: function (data) {
        	for(var i=0;i<data.length;i++){
				address_arr[i] = new Address(data[i].aiId, data[i].aqId, data[i].aiCode, data[i].aiLevel, 
						data[i].aiName, data[i].aiParentCode, data[i].aiProvinceAvailable, 
						data[i].aiCityAvailable, data[i].aiAreaAvailable, data[i].aiYn);
      		}
        },
        error: function (err) {
        	successTip("获取地址失败");
        }
	});
}
// 只有省级运营中心获取区/县时使用,因为省级运营中心需要记忆市和县,所以不能清除address_arr
function getAreaData (url, params) {
	address_area_arr.splice(0, address_area_arr.length);
	$.ajax({
        type: 'POST',
        data: params,
        url: url,
        async: false,
        success: function (data) {
        	for(var i=0;i<data.length;i++){
        		address_area_arr[i] = new Address(data[i].aiId, data[i].aqId, data[i].aiCode, data[i].aiLevel, 
						data[i].aiName, data[i].aiParentCode, data[i].aiProvinceAvailable, 
						data[i].aiCityAvailable, data[i].aiAreaAvailable, data[i].aiYn);
      		}
        },
        error: function (err) {
        	successTip("获取地址失败");
        }
	});
}
// 获取代理级别
function get_level () {
	return $("input[id='eiLevel']:checked").val();
}
// 隐藏DIV
function close_div () {
	$(".fade").hide();
	$(".fade_div").hide();
}
// 显示DIV
function display_div (id) {
	$(".fade").show();
	$("#" + id).show();
}
function change_title_select (index) {
	if(index == 4){
		index = 1;
	}
	var divs = $(".agent_div_title").find("div");
	for(var i=0;i<divs.length;i++){
		$(divs[i]).removeClass("current");
	}
	for(var i=0;i<divs.length;i++){
		if((i+1) == index){
			$(divs[i]).addClass("current");
		}
	}
}
//////////////////////////////////////////////// 查看////////////////////////////////////////////////////////////////
function chakan () {
	// 代理区域地址存储key add:agent 省-市-区/县
	// 代理区域地址名称存储key add:agent:name 省-市-区/县
	// 管辖区域地址存储key add:administer:city 市-市-市-市。。。。。。。
	// 管辖区域地址存储key add:administer:area:市： 区-区-区-区。。。。。。。
	var level = get_level();
	var cityCodeStr = "";
	var areaCodeStr = "";
	var name = cookie.get_cookie("add:agent:name");
	var code = cookie.get_cookie("add:agent");
	if(level == 1){
		// 运营中心,省级和市级
		if(code.indexOf("-") > 0){
			// 市级运营中心
			cityCodeStr = code.split("-")[1];
			areaCodeStr = cookie.get_cookie("add:administer:area:" + cityCodeStr);
			$(".show_select_div_title").text(name.split("-")[1] + "市运营中心");
		} else {
			// 省级运营中心
			cityCodeStr = cookie.get_cookie("add:administer:city");
			var cityCodeArr = cityCodeStr.split("-");
			for(var i=0;i<cityCodeArr.length;i++){
				areaCodeStr += cookie.get_cookie("add:administer:area:" + cityCodeArr[i]) + ":";
			}
			areaCodeStr = areaCodeStr.substring(0, areaCodeStr.length - 1);
			$(".show_select_div_title").text(name.split("-")[0] + "省运营中心");
		}
	} else {
		// 服务站
		cityCodeStr = code.split("-")[1];
		areaCodeStr = cookie.get_cookie("add:administer:area:" + cityCodeStr);
		$(".show_select_div_title").text(name.split("-")[1] + "市服务站");
	}
	// cityCodeStr 市-市-市-市
	// areaCodeStr 区-区-区-区：区-区-区-区：区-区-区-区：区-区-区-区
	// 返回数据   市-市-市-市+区-区-区-区：区-区-区-区：区-区-区-区：区-区-区-区
	$.ajax({
        type: 'POST',
        data: {"cityCode": cityCodeStr, "areaCode": areaCodeStr},
        url: "/agent/qualification/name",
        async: false,
        success: function (data) {
        	var cityNameStr = data.split("+")[0];
        	var areaNameStr = data.split("+")[1];
        	var cityNameArr = cityNameStr.split("-");
        	var areaNameArr = areaNameStr.split(":");
        	var html = "";
        	for(var i=0;i<cityNameArr.length;i++){
        		html += "<div style='color:#0099ff;margin-left:10px;font-size: 18px;clear:both;'>" + cityNameArr[i] + "</div>";
        		var areaNameEachArr = areaNameArr[i].split("-");
        		for(var j=0;j<areaNameEachArr.length;j++){
        			html += "<div style='float:left;margin-left:10px;font-size: 18px;'>" + areaNameEachArr[j] + "</div>";
        		}
        	}
        	$(".show_select_div_context").html(html);
        	display_div("show_select_div");
        },
        error: function (err) {
        	successTip("获取地址失败");
        }
	});
}
function re_selection () {
	close_div();
	get_jurisdiction_address();
}