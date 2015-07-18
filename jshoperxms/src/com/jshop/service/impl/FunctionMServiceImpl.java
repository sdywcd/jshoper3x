package com.jshop.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.entity.FunctionM;
import com.jshop.service.FunctionMService;

@Service("functionMService")
@Scope("prototype")
public class FunctionMServiceImpl extends BaseTServiceImpl<FunctionM> implements
		FunctionMService {

	
}
