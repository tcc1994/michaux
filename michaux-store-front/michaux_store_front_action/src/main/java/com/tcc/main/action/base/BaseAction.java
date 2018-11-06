package com.tcc.main.action.base;

import javax.servlet.http.HttpServletRequest;

import com.tcc.main.dto.usr.CurUser;

/**
 * @Description 
 * @Author Tu chengcheng
 * @Company Michaux Store Copyright
 * @Date 2018年10月26日 下午5:02:47
 */
public class BaseAction {

	/**
	 * @Description 获取当前登录用户
	 * @Return UserSso
	 * @Author Tu chengcheng
	 * @Date 2018年10月31日 下午6:37:49
	 */
	public CurUser getUser(HttpServletRequest request){
		Object attribute = request.getSession().getAttribute("account");
		if(attribute != null){
			return (CurUser) attribute;
		}
		return null;
	}
}
