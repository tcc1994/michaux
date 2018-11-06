package com.tcc.main.service.profile;

import com.tcc.main.domain.local.profile.RoleProfile;
import com.tcc.main.dto.usr.CurUser;

/**
 * @Description 个人资料
 * @Author Tu chengcheng
 * @Company Michaux Store Copyright
 * @Date 2018年10月31日 下午6:21:17
 */
public interface RoleProfileService {

	/**
	 * @Description 添加
	 * @Return Long
	 * @Author Tu chengcheng
	 * @Date 2018年10月31日 下午6:23:12
	 */
	String addProfile(CurUser usr, RoleProfile profile);
	
	/**
	 * @Description 通过用户id查个人资料
	 * @Return RoleProfile
	 * @Author Tu chengcheng
	 * @Date 2018年11月1日 下午3:23:52
	 */
	RoleProfile searchProfile(Long usId);
	
	/**
	 * @Description 添加/修改头像
	 * @Return String
	 * @Author Tu chengcheng
	 * @Date 2018年11月1日 下午3:46:39
	 */
	String addHeader(String head,CurUser user);
}
