package com.tcc.main.service.user;

import com.tcc.main.dto.result.SimpleResult;

/**
 * @Description 用户
 * @Author Tu chengcheng
 * @Company Michaux Store Copyright
 * @Date 2018年10月29日 下午1:15:55
 */
public interface UserSsoService {
	
	/**
	 * @Description 登录
	 * @Return String
	 * @Author Tu chengcheng
	 * @Date 2018年10月30日 上午11:49:10
	 */
	SimpleResult doLogin(String account, String password);

	/**
	 * @Description 注册
	 * @Return String
	 * @Author Tu chengcheng
	 * @Date 2018年10月30日 上午11:49:12
	 */
	String doRegister(String phone, String nickname, String password);
}
