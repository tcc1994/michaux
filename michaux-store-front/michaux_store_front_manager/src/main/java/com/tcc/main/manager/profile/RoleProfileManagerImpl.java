package com.tcc.main.manager.profile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tcc.main.dao.local.profile.RoleProfileMapper;
import com.tcc.main.domain.local.profile.RoleProfile;
import com.tcc.main.domain.local.profile.RoleProfileExample;

/**
 * @Description 
 * @Author Tu chengcheng
 * @Company Michaux Store Copyright
 * @Date 2018年10月31日 下午6:14:48
 */
@Component
@Transactional
public class RoleProfileManagerImpl implements RoleProfileManager {

	@Autowired
	private RoleProfileMapper roleProfileMapper;

	@Override
	public RoleProfile searchByPrimaryKey(Long id) {
		return roleProfileMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<RoleProfile> searchByExample(RoleProfileExample example) {
		return roleProfileMapper.selectByExample(example);
	}

	@Override
	public List<RoleProfile> searchByExampleWithBLOBs(RoleProfileExample example) {
		return roleProfileMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public Integer countByExample(RoleProfileExample example) {
		return roleProfileMapper.countByExample(example);
	}

	@Override
	public int insert(RoleProfile record) {
		return roleProfileMapper.insert(record);
	}

	@Override
	public int insertSelective(RoleProfile record) {
		return roleProfileMapper.insertSelective(record);
	}

	@Override
	public int updateByExampleSelective(RoleProfile record,RoleProfileExample example) {
		return roleProfileMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(RoleProfile record, RoleProfileExample example) {
		return roleProfileMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(RoleProfile record) {
		return roleProfileMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(RoleProfile record) {
		return roleProfileMapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByExample(RoleProfileExample example) {
		return roleProfileMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long pk) {
		return roleProfileMapper.deleteByPrimaryKey(pk);
	}
	

}
