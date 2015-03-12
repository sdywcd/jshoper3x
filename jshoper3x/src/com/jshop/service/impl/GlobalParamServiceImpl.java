package com.jshop.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.entity.GlobalParamM;
import com.jshop.service.GlobalParamService;

@Service("globalParamService")
@Scope("prototype")
public class GlobalParamServiceImpl extends BaseTServiceImpl<GlobalParamM>
		implements GlobalParamService {
	
}
