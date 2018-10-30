package com.tcc.main.action.usr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tcc.main.domain.local.user.UserSso;
import com.tcc.main.service.user.UserSsoService;

/**
 * @Description 注册
 * @Author Tu chengcheng
 * @Company Michaux Store Copyright
 * @Date 2018年10月26日 下午4:59:01
 */
@Controller
@RequestMapping(value = "reg")
public class RegisterUserAction {

	@Autowired
	private UserSsoService userSsoService;
	
	@RequestMapping(value = "page",method = RequestMethod.GET)
	public String regPage(UserSso usr){
		return "register/reg";
	}
	
}
