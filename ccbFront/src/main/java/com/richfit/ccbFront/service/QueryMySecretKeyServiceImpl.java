package com.richfit.ccbFront.service;

import java.util.Map;
import org.springframework.stereotype.Component;
import com.alibaba.dubbo.config.annotation.Reference;
import com.richfit.ccb.facade.IQueryMySecretFacade;
@Component
public class QueryMySecretKeyServiceImpl {
	@Reference
	IQueryMySecretFacade facade;
	public byte[] execute(Map<String, String> param) throws Exception {
		return facade.execute(param);
	}

}
