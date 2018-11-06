package com.tcc.main.action.usr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.tcc.main.action.base.BaseAction;
import com.tcc.main.domain.local.profile.RoleProfile;
import com.tcc.main.dto.result.SimpleResult;
import com.tcc.main.dto.usr.CurUser;
import com.tcc.main.service.profile.RoleProfileService;
import com.tcc.main.service.user.UserSsoService;

/**
 * @Description 登录
 * @Author Tu chengcheng
 * @Company Michaux Store Copyright
 * @Date 2018年10月26日 下午4:59:30
 */
@Controller
@RequestMapping("login")
public class LoginUserAction extends BaseAction {

	@Autowired
	private UserSsoService userSsoService;
	
	@Autowired
	private RoleProfileService roleProfileService;

	/**
	 * @Description 登录页面
	 * @Return String
	 * @Author Tu chengcheng
	 * @Date 2018年10月31日 上午10:06:07
	 */
	@RequestMapping(value = "page", method = RequestMethod.GET)
	public String loginPage(String account, Model model,HttpServletRequest request) {
		//IP限制访问
		String host = request.getRemoteHost();
		if(!host.equals("0:0:0:0:0:0:0:1")){
			model.addAttribute("message", "Sorry, your IP is not allowed to access this site ~");
			return "message/message";
		}
		CurUser usr = (CurUser)request.getSession().getAttribute("account");
		if(usr != null){
			RoleProfile profile = roleProfileService.searchProfile(usr.getUsId());
			model.addAttribute("profile", profile);
			return "home/index";
		}else{
			model.addAttribute("account", account);
			return "login/login";
		}
		
	}

	/**
	 * @Description 提交登录
	 * @Return String
	 * @Author Tu chengcheng
	 * @Date 2018年10月29日 下午6:07:20
	 */
	@ResponseBody
	@RequestMapping(value = "submit", method = RequestMethod.POST)
	public String doLogin(HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			session.removeAttribute("account");//初始化session
			String captcha = request.getParameter("kaptcha");
			if (!captcha.equals(request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY))) {
				return "103";
			}
			String account = request.getParameter("account").trim();
			String password = request.getParameter("password").trim();
			SimpleResult result = userSsoService.doLogin(account, password);
			if(result.isSuccess()){
				CurUser value = (CurUser)result.getValue();
				session.setAttribute("account", value);
			}
			return String.valueOf(result.getCode());
		} catch (Exception e) {
			e.printStackTrace();
			return "500";
		}
	}
	
	/**
	 * @Description 退出登录
	 * @Return String
	 * @Author Tu chengcheng
	 * @Date 2018年10月31日 上午10:04:25
	 */
	@RequestMapping(value = "exit", method = RequestMethod.GET)
	public String exitLogin(HttpServletRequest request){
		request.getSession().removeAttribute("account");
		return "redirect:page.do";
	}
	
	
	
	
	
	
	

}
