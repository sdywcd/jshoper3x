package com.jshop.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.entity.GoodsGroupAttributeRpT;
import com.jshop.service.GoodsGroupAttributeRpTService;

@Service("goodsGroupAttributeRpTService")
@Scope("prototype")
public class GoodsGroupAttributeRpTServiceImpl extends BaseTServiceImpl<GoodsGroupAttributeRpT> implements GoodsGroupAttributeRpTService{

}
