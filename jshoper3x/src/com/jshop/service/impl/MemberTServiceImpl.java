package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.MemberTDao;
import com.jshop.entity.MemberT;
import com.jshop.service.MemberTService;

@Service("memberTService")
@Scope("prototype")
public class MemberTServiceImpl implements MemberTService{
	@Resource
	private MemberTDao memberTDao;
	
	public MemberTDao getMemberTDao() {
		return memberTDao;
	}

	public void setMemberTDao(MemberTDao memberTDao) {
		this.memberTDao = memberTDao;
	}

	@Override
	public void saveMemberT(MemberT mt) {
		this.getMemberTDao().saveMemberT(mt);
	}

	@Override
	public List<MemberT> findAllMemberT(int currentPage, int lineSize) {
		return this.getMemberTDao().findAllMemberT(currentPage, lineSize);
	}

	@Override
	public int countfindAllMemberT() {
		return this.getMemberTDao().countfindAllMemberT();
	}

	@Override
	public List<MemberT> findAllMemberT(int currentPage,
			int lineSize, String creatorid) {
		return this.getMemberTDao().findAllMemberT(currentPage, lineSize, creatorid);
	}

	@Override
	public int countfindAllMemberT(String creatorid) {
		return this.getMemberTDao().countfindAllMemberT(creatorid);
	}

	@Override
	public void updateMemberT(MemberT mt) {
		this.getMemberTDao().updateMemberT(mt);
	}

	@Override
	public MemberT findMemberTById(String id) {
		return this.getMemberTDao().findMemberTById(id);
	}

	@Override
	public int delMemberT(String[] strs) {
		return this.getMemberTDao().delMemberT(strs);
	}

	@Override
	public List<MemberT> findMemberTByloginname(String loginname) {
		return this.getMemberTDao().findMemberTByloginname(loginname);
	}

}
