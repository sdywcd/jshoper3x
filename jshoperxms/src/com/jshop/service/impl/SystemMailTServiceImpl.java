package com.jshop.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.entity.SystemMailT;
import com.jshop.service.SystemMailTService;

@Service("systemMailTService")
@Scope("prototype")
public class SystemMailTServiceImpl extends BaseTServiceImpl<SystemMailT>implements SystemMailTService {



}
