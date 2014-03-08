package com.jshop.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.MemberRechargeRecordsTDao;
import com.jshop.entity.MemberRechargeRecordsT;
import com.jshop.service.MemberRechargeRecordsTService;

@Service("memberRechargeRecordsTService")
@Scope("prototype")
public class MemberRechargeRecordsTServiceImpl extends BaseTServiceImpl<MemberRechargeRecordsT>implements
		MemberRechargeRecordsTService {
	private MemberRechargeRecordsTDao memberRechargeRecordsTDao;

	public MemberRechargeRecordsTDao getMemberRechargeRecordsTDao() {
		return memberRechargeRecordsTDao;
	}

	public void setMemberRechargeRecordsTDao(
			MemberRechargeRecordsTDao memberRechargeRecordsTDao) {
		this.memberRechargeRecordsTDao = memberRechargeRecordsTDao;
	}


	@Override
	public List<MemberRechargeRecordsT> findAllMemberRechargeRecordsT(
			int currentPage, int lineSize) {
		return this.getMemberRechargeRecordsTDao()
				.findAllMemberRechargeRecordsT(currentPage, lineSize);
	}

	@Override
	public int countfindAllMemberRechargeRecordsT() {
		return this.getMemberRechargeRecordsTDao()
				.countfindAllMemberRechargeRecordsT();
	}

	@Override
	public void delMemberRechargeRecordsT(String[] strs) {
		this.getMemberRechargeRecordsTDao().delMemberRechargeRecordsT(strs);

	}

}
