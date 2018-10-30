package com.tcc.main.manager.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.tcc.main.dao.local.test.MichauxTestMapper;
import com.tcc.main.domain.local.test.MichauxTest;

/**
 * @Description 测试
 * @Author Tu chengcheng
 * @Company Michaux Store Copyright
 * @Date 2018年10月26日 上午11:33:48
 */
@Component
@Transactional
public class MichauxTestManagerImpl implements MichauxTestManager {

	@Autowired
	private MichauxTestMapper michauxTestMapper;
	
	@Override
	public MichauxTest selectMichaux(Long mtId) {
		return michauxTestMapper.selectByPrimaryKey(mtId);
	}

}
