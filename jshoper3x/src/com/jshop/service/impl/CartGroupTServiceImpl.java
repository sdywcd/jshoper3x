package com.jshop.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.entity.CartGroupT;
import com.jshop.service.CartGroupTService;

@Service("cartGroupTService")
@Scope("prototype")
public class CartGroupTServiceImpl extends BaseTServiceImpl<CartGroupT> implements CartGroupTService {

}
