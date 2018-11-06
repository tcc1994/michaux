package com.tcc.main.action.usr;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
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
	
	/**
	 * @Description 注册页面
	 * @Return String
	 * @Author Tu chengcheng
	 * @Date 2018年10月30日 上午11:46:02
	 */
	@RequestMapping(value = "page",method = RequestMethod.GET)
	public String regPage(){
		return "register/reg";
	}
	
	/**
	 * @Description 提交注册
	 * @Return String
	 * @Author Tu chengcheng
	 * @Date 2018年10月30日 上午11:46:36
	 */
	@ResponseBody
	@RequestMapping(value = "submit",method = RequestMethod.POST)
	public String doRegister(HttpServletRequest request){
		try {
			String captcha = request.getParameter("kaptcha");
			if (!captcha.equals(request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY))) {
				return "202";
			}
			String account = request.getParameter("account").trim();
			String nickname = request.getParameter("nickname").trim();
			String password = request.getParameter("password").trim();
			return userSsoService.doRegister(account, nickname, password);
		} catch (Exception e) {
			return "500";
		}
	}
	
}
