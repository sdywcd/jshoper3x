package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.MsgtextTDao;
import com.jshop.dao.impl.MsgtextTDaoImpl;
import com.jshop.entity.MsgtextT;
import com.jshop.service.MsgtextTService;

@Service("msgtextTService")
@Scope("prototype")
public class MsgtextTServiceImpl extends BaseTServiceImpl<MsgtextT>implements MsgtextTService {
	@Resource
	public MsgtextTDao msgtextTDao;

	public MsgtextTDao getMsgtextTDao() {
		return msgtextTDao;
	}

	public void setMsgtextTDao(MsgtextTDao msgtextTDao) {
		this.msgtextTDao = msgtextTDao;
	}

	public int delMsgtext(String[] list) {
		return this.getMsgtextTDao().delMsgtext(list);
	}

	public int updateMsgtext(MsgtextT mt) {
		return this.getMsgtextTDao().updateMsgtext(mt);
	}

	public int countfindAllMsgtext() {
		return this.getMsgtextTDao().countfindAllMsgtext();
	}

	public List<MsgtextT> findAllMsgtext(int currentPage, int lineSize) {
		return this.getMsgtextTDao().findAllMsgtext(currentPage, lineSize);
	}

	public MsgtextT findMsgtextById(String id) {
		return this.getMsgtextTDao().findMsgtextById(id);
	}
}
