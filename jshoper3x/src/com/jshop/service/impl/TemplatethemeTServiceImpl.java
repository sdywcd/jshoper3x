package com.jshop.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.entity.TemplatethemeT;
import com.jshop.service.TemplatethemeTService;
@Service("templatethemeTService")
@Scope("prototype")
public class TemplatethemeTServiceImpl extends BaseTServiceImpl<TemplatethemeT> implements TemplatethemeTService {
	
}
