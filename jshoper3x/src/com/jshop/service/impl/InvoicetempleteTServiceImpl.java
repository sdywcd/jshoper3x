package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.InvoicetempleteTDao;
import com.jshop.dao.impl.InvoicetempleteTDaoImpl;
import com.jshop.entity.InvoicetempleteT;
import com.jshop.service.InvoicetempleteTService;

@Service("invoicetempleteTService")
@Scope("prototype")
public class InvoicetempleteTServiceImpl extends BaseTServiceImpl<InvoicetempleteT>implements InvoicetempleteTService {
	@Resource
	private InvoicetempleteTDao invoicetempleteTDao;

	public InvoicetempleteTDao getInvoicetempleteTDao() {
		return invoicetempleteTDao;
	}

	public void setInvoicetempleteTDao(InvoicetempleteTDao invoicetempleteTDao) {
		this.invoicetempleteTDao = invoicetempleteTDao;
	}

	public int delInvoiceTemplete(String[] list) {
		return this.getInvoicetempleteTDao().delInvoiceTemplete(list);
	}

	public int updateInvoicetempleteT(InvoicetempleteT it) {
		return this.getInvoicetempleteTDao().updateInvoicetempleteT(it);
	}



	public int countfindAllInvoicetempleteT() {
		return this.getInvoicetempleteTDao().countfindAllInvoicetempleteT();
	}

	public List<InvoicetempleteT> findAllInvoicetempleteT(int currentPage, int lineSize) {
		return this.getInvoicetempleteTDao().findAllInvoicetempleteT(currentPage, lineSize);
	}

	public InvoicetempleteT findInvoicetempleteById(String invoicetempleteid) {
		return this.getInvoicetempleteTDao().findInvoicetempleteById(invoicetempleteid);
	}

	public InvoicetempleteT findInvoicetempleteByState(String state) {
		return this.getInvoicetempleteTDao().findInvoicetempleteByState(state);
	}
}
