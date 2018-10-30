package com.tcc.main.action.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tcc.main.domain.local.test.MichauxTest;
import com.tcc.main.service.test.MichauxTestService;

/**
 * @Description test
 * @Author Tu chengcheng
 * @Company Michaux Store Copyright
 * @Date 2018年10月26日 上午11:44:19
 */
@Controller
@RequestMapping("test")
public class MichauxTestAction {

	@Autowired
	private MichauxTestService michauxTestService;
	
	@RequestMapping("a")
	public String test(Model model){
		try {
			MichauxTest searchMichaux = michauxTestService.searchMichaux(1l);
			System.out.println(searchMichaux.getMtId());
			System.out.println(searchMichaux.getMtInfo());
			System.out.println(searchMichaux.getCreateDatetime());
			model.addAttribute("message", searchMichaux.getMtInfo());
			return "message/message";
		} catch (Exception e) {
			return "error/500";
		}
	}
}
