package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.VouchersTDao;
import com.jshop.dao.impl.VouchersTDaoImpl;
import com.jshop.entity.VouchersT;
import com.jshop.service.VouchersTService;
@Service("vouchersTService")
@Scope("prototype")
public class VouchersTServiceImpl  extends BaseTServiceImpl<VouchersT>implements VouchersTService {
	@Resource
	private VouchersTDao vouchersTDao;

	public VouchersTDao getVouchersTDao() {
		return vouchersTDao;
	}

	public void setVouchersTDao(VouchersTDao vouchersTDao) {
		this.vouchersTDao = vouchersTDao;
	}

	public int delVoucherst(String[] list) {
		return this.getVouchersTDao().delVoucherst(list);
	}

	public int updateVoucherst(VouchersT vt) {
		return this.getVouchersTDao().updateVoucherst(vt);
	}


	public int countfindAllVoucherst() {
		return this.getVouchersTDao().countfindAllVoucherst();
	}

	public List<VouchersT> findAllVoucherst(int currentPage, int lineSize) {
		return this.getVouchersTDao().findAllVoucherst(currentPage, lineSize);
	}

	public List<VouchersT> findVoucherstByName(String vouchersname) {
		return this.getVouchersTDao().findVoucherstByName(vouchersname);
	}

	public VouchersT findVouchersForHonor(String vouchersname) {
		return this.getVouchersTDao().findVouchersForHonor(vouchersname);
	}

	public List<VouchersT> findUserVouchers(String userid, int currentPage, int lineSize) {
		return this.getVouchersTDao().findUserVouchers(userid, currentPage, lineSize);
	}

	public int countfindUserVouchers(String userid) {
		return this.getVouchersTDao().countfindUserVouchers(userid);
	}
}
