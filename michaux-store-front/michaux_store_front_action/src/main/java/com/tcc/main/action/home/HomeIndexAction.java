package com.tcc.main.action.home;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tcc.main.action.base.BaseAction;
import com.tcc.main.domain.local.profile.RoleProfile;
import com.tcc.main.dto.usr.CurUser;
import com.tcc.main.service.profile.RoleProfileService;

/**
 * @Description 首页
 * @Author Tu chengcheng
 * @Company Michaux Store Copyright
 * @Date 2018年10月31日 下午1:09:43
 */
@Controller
@RequestMapping("home")
public class HomeIndexAction extends BaseAction {

	@Autowired
	private RoleProfileService roleProfileService;
	/**
	 * @Description 首页页面
	 * @Return String
	 * @Author Tu chengcheng
	 * @Date 2018年10月31日 下午3:57:28
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model){
		CurUser user = getUser(request);
		if(user != null){
			RoleProfile profile = roleProfileService.searchProfile(user.getUsId());
			model.addAttribute("profile", profile);
			return "home/index";
		}else{
			return "login/login";
		}
		
	}
}
