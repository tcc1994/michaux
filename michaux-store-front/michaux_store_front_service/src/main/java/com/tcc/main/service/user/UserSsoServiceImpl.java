package com.tcc.main.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.main.common.dict.Frozen;
import com.tcc.main.common.dict.RegClient;
import com.tcc.main.common.dict.Usable;
import com.tcc.main.common.encrypt.MD5Encrypt;
import com.tcc.main.common.random.RandomUtil;
import com.tcc.main.common.utils.DateUtil;
import com.tcc.main.domain.local.profile.RoleProfile;
import com.tcc.main.domain.local.profile.RoleProfileExample;
import com.tcc.main.domain.local.user.UserSso;
import com.tcc.main.domain.local.user.UserSsoExample;
import com.tcc.main.dto.result.SimpleResult;
import com.tcc.main.dto.usr.CurUser;
import com.tcc.main.manager.profile.RoleProfileManager;
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
	
	@Autowired
	private RoleProfileManager roleProfileManager;

	@Override
	public SimpleResult doLogin(String account,String password) {
		UserSsoExample example = new UserSsoExample();
		example.createCriteria().andUsPhoneEqualTo(Long.parseLong(account)).andUsFrozenEqualTo(Frozen.USABLE).andUsYnEqualTo(Usable.USABLE);
		List<UserSso> list = userSsoManager.searchByExample(example);
		if(list == null || list.size() < 1){
			return new SimpleResult("用户不存在", 101, null, false);
		}
		UserSso usr = list.get(0);
		String pwd = MD5Encrypt.encryptData(password, usr.getUsSecret());
		if(!pwd.equals(usr.getUsPasswd())){
			return new SimpleResult("密码错误", 102, null, false);
		}
		RoleProfileExample profileExample = new RoleProfileExample();
		profileExample.createCriteria().andUsIdEqualTo(usr.getUsId()).andRpYnEqualTo(Usable.USABLE);
		List<RoleProfile> roles = roleProfileManager.searchByExample(profileExample);
		RoleProfile profile = roles.get(0);
		CurUser curUser = new CurUser();
		curUser.setUsNickname(profile.getRpNickName());
		curUser.setUsFrozen(usr.getUsFrozen());
		curUser.setUsId(usr.getUsId());
		curUser.setUsPhone(usr.getUsPhone());
		curUser.setUsRegClient(usr.getUsRegClient());
		return new SimpleResult("登录成功", 200, curUser, true);
	}

	@Override
	public String doRegister(String account, String nickname, String password) {
		UserSsoExample example = new UserSsoExample();
		example.createCriteria().andUsPhoneEqualTo(Long.parseLong(account)).andUsFrozenEqualTo(Frozen.USABLE).andUsYnEqualTo(Usable.USABLE);
		List<UserSso> list = userSsoManager.searchByExample(example);
		if(list != null && list.size() > 0){
			return "201";
		}
		String dateTime = DateUtil.getDateTime();
		String secret = RandomUtil.generateStr(128);
		UserSso userSso = new UserSso();
		userSso.setUsFrozen(Frozen.USABLE);
		userSso.setUsPasswd(MD5Encrypt.encryptData(password, secret));
		userSso.setUsPhone(Long.parseLong(account));
		userSso.setUsRegClient(RegClient.PC);
		userSso.setUsSecret(secret);
		userSso.setUsTimeCreate(dateTime);
		userSso.setUsYn(Usable.USABLE);
		userSsoManager.insert(userSso);
		RoleProfile profile = new RoleProfile();
		profile.setUsId(userSso.getUsId());
		profile.setRpNickName(nickname);
		profile.setRpTimeCreate(dateTime);
		profile.setRpYn(Usable.USABLE);
		roleProfileManager.insertSelective(profile);
		return "200";
	}









}
