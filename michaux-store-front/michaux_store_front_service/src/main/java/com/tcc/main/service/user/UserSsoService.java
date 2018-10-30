package com.tcc.main.service.user;

/**
 * @Description 用户
 * @Author Tu chengcheng
 * @Company Michaux Store Copyright
 * @Date 2018年10月29日 下午1:15:55
 */
public interface UserSsoService {
	
	String doLogin(String username, String password,String host, String captcha);

}
