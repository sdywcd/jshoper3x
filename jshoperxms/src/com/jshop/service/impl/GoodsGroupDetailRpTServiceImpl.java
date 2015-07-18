package com.jshop.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.entity.GoodsGroupDetailRpT;
import com.jshop.service.GoodsGroupDetailRpTService;
@Service("goodsGroupDetailRpTService")
@Scope("prototype")
public class GoodsGroupDetailRpTServiceImpl extends BaseTServiceImpl<GoodsGroupDetailRpT> implements GoodsGroupDetailRpTService{

}
