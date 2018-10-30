package com.tcc.main.service.user;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.main.common.encrypt.MD5Encrypt;
import com.tcc.main.common.utils.UsernamePasswordCaptchaToken;
import com.tcc.main.domain.local.user.UserSso;
import com.tcc.main.domain.local.user.UserSsoExample;
import com.tcc.main.manager.user.UserSsoManager;

/**
 * @Description 用户
 * @Author Tu chengcheng
 * @Company Michaux Store Copyright
 * @Date 2018年10月29日 下午1:16:05
 */
@Service
public class UserSsoServiceImpl  implements UserSsoService {

	@Autowired
    private UserSsoManager userSsoManager;

	@Override
	public String doLogin(String username,String password,String host,String captcha) {
		UserSsoExample example = new UserSsoExample();
		example.createCriteria().andUsPhoneEqualTo(Long.parseLong(username));
		List<UserSso> list = userSsoManager.searchByExample(example);
		if(list == null || list.size() < 1){
			return "101";
		}
		UserSso usr = list.get(0);
		String encryptData = MD5Encrypt.encryptData(password, usr.getUsSecret());
		if(encryptData != usr.getUsSecret()){
			return "102";
		}
		UsernamePasswordCaptchaToken token = new UsernamePasswordCaptchaToken(username, password.toCharArray(), false, host, captcha);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
		return "200";
	}


}
