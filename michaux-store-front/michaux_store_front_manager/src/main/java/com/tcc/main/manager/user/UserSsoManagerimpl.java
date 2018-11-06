package com.tcc.main.manager.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tcc.main.dao.local.user.UserSsoMapper;
import com.tcc.main.domain.local.user.UserSso;
import com.tcc.main.domain.local.user.UserSsoExample;

/**
 * @Description 用户
 * @Author Tu chengcheng
 * @Company Michaux Store Copyright
 * @Date 2018年10月29日 上午11:54:45
 */
@Component
@Transactional
public class UserSsoManagerimpl implements UserSsoManager {

	@Autowired
	private UserSsoMapper userSsoMapper;

	@Override
	public UserSso searchByPrimaryKey(Long id) {
		return userSsoMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<UserSso> searchByExample(UserSsoExample example) {
		return userSsoMapper.selectByExample(example);
	}

	@Override
	public List<UserSso> searchByExampleWithBLOBs(UserSsoExample example) {
		return userSsoMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public Integer countByExample(UserSsoExample example) {
		return userSsoMapper.countByExample(example);
	}

	@Override
	public int insert(UserSso record) {
		return userSsoMapper.insert(record);
	}

	@Override
	public int insertSelective(UserSso record) {
		return userSsoMapper.insertSelective(record);
	}

	@Override
	public int updateByExampleSelective(UserSso record, UserSsoExample example) {
		return userSsoMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(UserSso record, UserSsoExample example) {
		return userSsoMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(UserSso record) {
		return userSsoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(UserSso record) {
		return userSsoMapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByExample(UserSsoExample example) {
		return userSsoMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long pk) {
		return deleteByPrimaryKey(pk);
	}

	
	
}
