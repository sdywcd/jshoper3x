package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.MemberGradeTDao;
import com.jshop.entity.MemberGradeT;
import com.jshop.service.MemberGradeTService;

@Service("memberGradeTService")
@Scope("prototype")
public class MemberGradeTServiceImpl extends BaseTServiceImpl<MemberGradeT>implements MemberGradeTService {
	@Resource
	private MemberGradeTDao memberGradeTDao;

	public MemberGradeTDao getMemberGradeTDao() {
		return memberGradeTDao;
	}

	public void setMemberGradeTDao(MemberGradeTDao memberGradeTDao) {
		this.memberGradeTDao = memberGradeTDao;
	}


	@Override
	public void delMemberGradeT(String[] strs) {
		this.getMemberGradeTDao().delMemberGradeT(strs);
	}

	@Override
	public List<MemberGradeT> findAllMemberGradeT(int currentPage, int lineSize) {
		return this.getMemberGradeTDao().findAllMemberGradeT(currentPage, lineSize);
	}

	@Override
	public int countfindAllMemberGradeT() {
		return this.getMemberGradeTDao().countfindAllMemberGradeT();
	}

	@Override
	public MemberGradeT findMemberGradeTById(String id) {
		return this.getMemberGradeTDao().findMemberGradeTById(id);
	}

	@Override
	public void updateMemberGradeTById(MemberGradeT mgt) {
		this.getMemberGradeTDao().updateMemberGradeTById(mgt);
	}

	@Override
	public List<MemberGradeT> findAllMemberGradeT() {
		return this.getMemberGradeTDao().findAllMemberGradeT();
	}


}
