package com.jshop.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.entity.OrderGroupT;
import com.jshop.service.OrderGroupTService;

@Service("orderGroupTService")
@Scope("prototype")
public class OrderGroupTServiceImpl extends BaseTServiceImpl<OrderGroupT>implements OrderGroupTService {

}
