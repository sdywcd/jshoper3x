package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.KeywordTDao;
import com.jshop.dao.impl.KeywordTDaoImpl;
import com.jshop.entity.KeywordT;
import com.jshop.service.KeywordTService;

@Service("keywordTService")
@Scope("prototype")
public class KeywordTServiceImpl extends BaseTServiceImpl<KeywordT> implements KeywordTService {
	@Resource
	private KeywordTDao keywordTDao;

	public KeywordTDao getKeywordTDao() {
		return keywordTDao;
	}

	public void setKeywordTDao(KeywordTDao keywordTDao) {
		this.keywordTDao = keywordTDao;
	}

	public int delKeywordT(String[] list) {
		return this.getKeywordTDao().delKeywordT(list);
	}

	public int updateKeywordT(KeywordT kt) {
		return this.getKeywordTDao().updateKeywordT(kt);
	}

	public int updatekeywordsearchcount(String keywordname) {
		return this.getKeywordTDao().updatekeywordsearchcount(keywordname);
	}

	
	public int countAllKeywordT() {
		return this.getKeywordTDao().countAllKeywordT();
	}

	public List<KeywordT> findAllKeywordT(int currentPage, int lineSize) {
		return this.getKeywordTDao().findAllKeywordT(currentPage, lineSize);
	}

	public KeywordT findKeywordById(String keywordid) {
		return this.getKeywordTDao().findKeywordById(keywordid);
	}

	public List<KeywordT> findAllKeywordTjson() {
		return this.getKeywordTDao().findAllKeywordTjson();
	}

	public List<KeywordT> findKeywordLimit(int limit) {
		return this.getKeywordTDao().findKeywordLimit(limit);
	}
}
