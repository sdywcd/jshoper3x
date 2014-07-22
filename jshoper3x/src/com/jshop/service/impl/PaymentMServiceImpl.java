package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.PaymentMDao;
import com.jshop.entity.PaymentM;
import com.jshop.service.PaymentMService;

@Service("paymentMService")
@Scope("prototype")
public class PaymentMServiceImpl extends BaseTServiceImpl<PaymentM> implements PaymentMService {
	@Resource
	private PaymentMDao paymentMDao;

	public PaymentMDao getPaymentMDao() {
		return paymentMDao;
	}

	public void setPaymentMDao(PaymentMDao paymentMDao) {
		this.paymentMDao = paymentMDao;
	}

	public int openPayment(String[] list) {
		return this.getPaymentMDao().openPayment(list);
	}

	public int updatePayment(PaymentM pm) {
		return this.getPaymentMDao().updatePayment(pm);
	}

	
	public int countfindAllPayment() {
		return this.getPaymentMDao().countfindAllPayment();
	}

	public List<PaymentM> findAllPayment(int currentPage, int lineSize) {
		return this.getPaymentMDao().findAllPayment(currentPage, lineSize);
	}

	public PaymentM findPaymentbyId(String paymentid) {
		return this.getPaymentMDao().findPaymentbyId(paymentid);
	}

	public int closePayment(String[] list) {
		return this.getPaymentMDao().closePayment(list);
	}

	public List<PaymentM> findAllPayment(String state) {
		return this.getPaymentMDao().findAllPayment(state);
	}

	@Override
	public int delPaymentByid(String[] str) {
		return this.getPaymentMDao().delPaymentByid(str);
	}

}
