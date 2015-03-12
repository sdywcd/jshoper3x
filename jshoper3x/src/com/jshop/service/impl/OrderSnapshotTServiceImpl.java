package com.jshop.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.entity.OrderSnapshotT;
import com.jshop.service.OrderSnapshotTService;
@Service("orderSnapshotTService")
@Scope("prototype")
public class OrderSnapshotTServiceImpl extends BaseTServiceImpl<OrderSnapshotT> implements OrderSnapshotTService{

}
