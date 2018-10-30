package com.tcc.main.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.main.domain.local.test.MichauxTest;
import com.tcc.main.manager.test.MichauxTestManager;

/**
 * @Description 测试
 * @Author Tu chengcheng
 * @Company Michaux Store Copyright
 * @Date 2018年10月26日 上午11:41:09
 */
@Service
public class MichauxTestServiceImpl implements MichauxTestService {

	@Autowired
	private MichauxTestManager michauxTestManager;

	@Override
	public MichauxTest searchMichaux(Long mtId) {
		return michauxTestManager.selectMichaux(mtId);
	}
	
}
