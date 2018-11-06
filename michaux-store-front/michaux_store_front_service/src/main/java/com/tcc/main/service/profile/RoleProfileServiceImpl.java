package com.tcc.main.service.profile;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.main.common.dict.Usable;
import com.tcc.main.common.utils.DateUtil;
import com.tcc.main.domain.local.profile.RoleProfile;
import com.tcc.main.domain.local.profile.RoleProfileExample;
import com.tcc.main.dto.usr.CurUser;
import com.tcc.main.manager.profile.RoleProfileManager;
import com.tcc.main.manager.user.UserSsoManager;

/**
 * @Description 个人资料
 * @Author Tu chengcheng
 * @Company Michaux Store Copyright
 * @Date 2018年10月31日 下午6:21:27
 */
@Service
public class RoleProfileServiceImpl implements RoleProfileService {

	@Autowired
	private UserSsoManager userSsoManager;
	
	@Autowired
	private RoleProfileManager roleProfileManager;
	
	@Override
	public String addProfile(CurUser usr, RoleProfile profile) {
		Long usId = usr.getUsId();
		String dateTime = DateUtil.getDateTime();
		RoleProfileExample example = new RoleProfileExample();
		example.createCriteria().andUsIdEqualTo(usId).andRpYnEqualTo(Usable.USABLE);
		List<RoleProfile> list = roleProfileManager.searchByExample(example);
		if(list != null && list.size() > 0){ //修改
			RoleProfile roleProfile = list.get(0);
			Long rpId = roleProfile.getRpId();
			roleProfile = assembleProfile(profile);
			roleProfile.setRpId(rpId);
			roleProfile.setRpTimeModify(dateTime);
			roleProfileManager.updateByPrimaryKeySelective(roleProfile);
		}else{ //添加
			profile = assembleProfile(profile);
			profile.setUsId(usId);
			profile.setRpTimeCreate(dateTime);
			profile.setRpYn(Usable.USABLE);
			roleProfileManager.insertSelective(profile);
		}
		return "200";
	}
	
	/**
	 * @Description 组装参数
	 * @Return RoleProfile
	 * @Author Tu chengcheng
	 * @Date 2018年11月1日 上午11:39:46
	 */
	private RoleProfile assembleProfile(RoleProfile profile){
		RoleProfile roleProfile = new RoleProfile();
		if(!StringUtils.isEmpty(profile.getRpCompany())){
			roleProfile.setRpCompany(profile.getRpCompany());
		}
		if(!StringUtils.isEmpty(profile.getRpEmail())){
			roleProfile.setRpEmail(profile.getRpEmail());
		}
		if(!StringUtils.isEmpty(profile.getRpHeader())){
			roleProfile.setRpHeader(profile.getRpHeader());
		}
		if(!StringUtils.isEmpty(profile.getRpIndustry())){
			roleProfile.setRpIndustry(profile.getRpIndustry());
		}
		if(!StringUtils.isEmpty(profile.getRpOccupation())){
			roleProfile.setRpOccupation(profile.getRpOccupation());
		}
		if(!StringUtils.isEmpty(profile.getRpNickName())){
			roleProfile.setRpNickName(profile.getRpNickName());
		}
		if(profile.getRpAge() != null){
			roleProfile.setRpAge(profile.getRpAge());
		}
		roleProfile.setRpSex(profile.getRpSex());
		return roleProfile;
	}

	@Override
	public RoleProfile searchProfile(Long usId) {
		RoleProfileExample example = new RoleProfileExample();
		example.createCriteria().andUsIdEqualTo(usId).andRpYnEqualTo(Usable.USABLE);
		List<RoleProfile> list = roleProfileManager.searchByExample(example);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public String addHeader(String head,CurUser usr) {
		Long usId = usr.getUsId();
		String dateTime = DateUtil.getDateTime();
		RoleProfileExample example = new RoleProfileExample();
		example.createCriteria().andUsIdEqualTo(usId).andRpYnEqualTo(Usable.USABLE);
		List<RoleProfile> list = roleProfileManager.searchByExample(example);
		RoleProfile profile = list.get(0);
		if(!head.equals(profile.getRpHeader())){
			profile.setRpHeader(head);
			profile.setRpTimeModify(dateTime);
			roleProfileManager.updateByPrimaryKeySelective(profile);
		}
		return "200";
	}
}
