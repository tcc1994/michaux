package com.tcc.main.action.usr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.tcc.main.service.user.UserSsoService;

/**
 * @Description
 * @Author Tu chengcheng
 * @Company Michaux Store Copyright
 * @Date 2018年10月26日 下午4:59:30
 */
@Controller
@RequestMapping("login")
public class LoginUserAction {

	@Autowired
	private UserSsoService userSsoService;

	@RequestMapping("page")
	public String loginPage() {
		return "login/login";
	}

	/**
	 * @Description 提交登录
	 * @Return String
	 * @Author Tu chengcheng
	 * @Date 2018年10月29日 下午6:07:20
	 */
	@ResponseBody
	@RequestMapping(value = "submit", method = RequestMethod.POST)
	public String doLogin(HttpServletRequest request,HttpServletResponse response) {
		try {
			String captcha = request.getParameter("kaptcha");
			if (!captcha.equals(request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY))) {
				return "103";
			}
			String host = request.getRemoteHost();
			String username = request.getParameter("username").trim();
			String password = request.getParameter("password").trim();
			return userSsoService.doLogin(username, password, host, captcha);
		} catch (Exception e) {
			e.printStackTrace();
			return "500";
		}
	}

}
