package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.MemberGroupTDao;
import com.jshop.entity.MemberGroupT;
import com.jshop.service.MemberGroupTService;

@Service("memberGroupTService")
@Scope("prototype")
public class MemberGroupTServiceImpl extends BaseTServiceImpl<MemberGroupT>implements MemberGroupTService{
	@Resource
	private MemberGroupTDao memberGroupTDao;
	
	public MemberGroupTDao getMemberGroupTDao() {
		return memberGroupTDao;
	}

	public void setMemberGroupTDao(MemberGroupTDao memberGroupTDao) {
		this.memberGroupTDao = memberGroupTDao;
	}



	@Override
	public List<MemberGroupT> findAllMemberGroupT(int currentPage, int lineSize) {
		return this.getMemberGroupTDao().findAllMemberGroupT(currentPage, lineSize);
	}

	@Override
	public int countfindAllMemberGroupT() {
		return this.getMemberGroupTDao().countfindAllMemberGroupT();
	}

	@Override
	public List<MemberGroupT> findAllMemberGroupT(int currentPage,
			int lineSize, String creatorid) {
		return this.getMemberGroupTDao().findAllMemberGroupT(currentPage, lineSize, creatorid);
	}

	@Override
	public int countfindAllMemberGroupT(String creatorid) {
		return this.getMemberGroupTDao().countfindAllMemberGroupT(creatorid);
	}

	@Override
	public void updateMemberGroupT(MemberGroupT mgt) {
		this.getMemberGroupTDao().updateMemberGroupT(mgt);
	}

	@Override
	public MemberGroupT findMemberGroupTById(String id) {
		return this.getMemberGroupTDao().findMemberGroupTById(id);
	}

	@Override
	public int delMemberGroupT(String[] strs) {
		return this.getMemberGroupTDao().delMemberGroupT(strs);
	}

	@Override
	public List<MemberGroupT> findMemberGroupTByname(String name) {
		return this.getMemberGroupTDao().findMemberGroupTByname(name);
	}

	@Override
	public List<MemberGroupT> findAllMemberGroup(String status) {
		return this.getMemberGroupTDao().findAllMemberGroup(status);
	}

}
