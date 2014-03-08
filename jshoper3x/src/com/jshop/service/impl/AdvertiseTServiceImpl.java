package com.jshop.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.entity.AdvertiseT;
import com.jshop.service.AdvertiseTService;

@Service("advertiseTService")
@Scope("prototype")
public class AdvertiseTServiceImpl extends BaseTServiceImpl<AdvertiseT> implements
		AdvertiseTService {

	

}
