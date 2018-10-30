var cookie = {
	
	set_cookie_without_time : function (key, value) {
		// 设置cookie,不设置过期时间,cookie保存在内存中,浏览器关闭则失效
		document.cookie = key + "=" + value;
	},
	set_cookie_with_time : function (key, value, time) {
		// 设置cookie,设置过期时间,cookie存在硬盘中
		var date = new Date(); //获取当前时间
        var expiresDays = time;  //将date设置为n天以后的时间
        date.setTime(date.getTime() + expiresDays*24*3600*1000); //格式化为cookie识别的时间
        document.cookie = key + "=" + value + ";expires=" + date.toGMTString();  //设置cookie
	},
	get_cookie : function (key) {
		// 获取设置进cookie中的值
        var get_cookie = document.cookie.replace(/[ ]/g,"");  //获取cookie，并且将获得的cookie格式化，去掉空格字符
        var arr_cookie = get_cookie.split(";")  //将获得的cookie以"分号"为标识 将cookie保存到arrCookie的数组中
        var tips;  //声明变量tips
        for(var i=0;i<arr_cookie.length;i++){   //使用for循环查找cookie中的tips变量
            var arr = arr_cookie[i].split("=");   //将单条cookie用"等号"为标识，将单条cookie保存为arr数组
            if(key == arr[0]){  //匹配变量名称，其中arr[0]是指的cookie名称，如果该条变量为tips则执行判断语句中的赋值操作
                tips = arr[1];   //将cookie的值赋给变量tips
                break;   //终止for循环遍历
            }
        }
        return tips;
	},
	delete_cookie : function (key) {
		// 删除cookie中设置的值
		var date = new Date(); //获取当前时间
        date.setTime(date.getTime() - 1); //格式化为cookie识别的时间
        document.cookie = key + "=" + null + ";expires=" + date.toGMTString();
	}
}