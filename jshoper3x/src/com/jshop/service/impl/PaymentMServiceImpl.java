package com.jshop.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.entity.PaymentM;
import com.jshop.service.PaymentMService;

@Service("paymentMService")
@Scope("prototype")
public class PaymentMServiceImpl extends BaseTServiceImpl<PaymentM> implements PaymentMService {
	
}
