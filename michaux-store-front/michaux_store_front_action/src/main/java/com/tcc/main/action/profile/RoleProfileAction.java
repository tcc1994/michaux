package com.tcc.main.action.profile;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tcc.main.action.base.BaseAction;
import com.tcc.main.domain.local.profile.RoleProfile;
import com.tcc.main.dto.usr.CurUser;
import com.tcc.main.service.profile.RoleProfileService;

/**
 * @Description 个人资料
 * @Author Tu chengcheng
 * @Company Michaux Store Copyright
 * @Date 2018年10月31日 下午6:35:12
 */
@Controller
@RequestMapping("profile")
public class RoleProfileAction extends BaseAction {
	
	@Autowired
	private RoleProfileService roleProfileService;

	/**
	 * @Description 添加/修改个人资料
	 * @Return String
	 * @Author Tu chengcheng
	 * @Date 2018年10月31日 下午6:42:51
	 */
	@ResponseBody
	@RequestMapping(value = "submit", method = RequestMethod.POST)
	public String addProfile(RoleProfile profile, HttpServletRequest request){
		try {
			CurUser user = getUser(request);
			if(user == null){
				return "301";//未登录
			}
			if(!StringUtils.isEmpty(profile.getRpNickName())){
				user.setUsNickname(profile.getRpNickName());
				request.getSession().setAttribute("account", user);
			}else{
				if(profile.getRpAge() == null  && StringUtils.isEmpty(profile.getRpCompany()) && StringUtils.isEmpty(profile.getRpEmail()) && StringUtils.isEmpty(profile.getRpHeader()) 
						&& StringUtils.isEmpty(profile.getRpIndustry()) && StringUtils.isEmpty(profile.getRpOccupation())){
					return "302";
				}
			}
			return roleProfileService.addProfile(user, profile);
		} catch (Exception e) {
			e.printStackTrace();
			return "500";
		}
	}
	/**
	 * @Description 添加/修改头像
	 * @Return String
	 * @Author Tu chengcheng
	 * @Date 2018年11月1日 下午3:44:58
	 */
	@ResponseBody
	@RequestMapping(value = "head", method = RequestMethod.POST)
	public String addHead(String head, HttpServletRequest request){
		try {
			CurUser user = getUser(request);
			if(user == null){
				return "301";//未登录
			}
			return roleProfileService.addHeader(head, user);
		} catch (Exception e) {
			e.printStackTrace();
			return "500";
		}
	}
	
	
	
	
	
	
	
	
	
	
}
