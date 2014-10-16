package com.jshop.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.entity.GoodsCardsT;
import com.jshop.service.GoodsCardsTService;
@Service("goodsCardsTService")
@Scope("prototype")
public class GoodsCardsTServiceImpl extends BaseTServiceImpl<GoodsCardsT> implements GoodsCardsTService {
	
}
