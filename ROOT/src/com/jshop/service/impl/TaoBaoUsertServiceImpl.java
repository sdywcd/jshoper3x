package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.TaoBaoUsertDao;
import com.jshop.dao.impl.TaoBaoUserTDaoImpl;
import com.jshop.entity.TaobaoUserT;
import com.jshop.service.TaoBaoUsertService;

@Service("taoBaoUsertService")
@Scope("prototype")
public class TaoBaoUsertServiceImpl implements TaoBaoUsertService {
	@Resource
	private TaoBaoUsertDao taoBaoUserTDao;

	public TaoBaoUsertDao getTaoBaoUserTDao() {
		return taoBaoUserTDao;
	}

	public void setTaoBaoUserTDao(TaoBaoUsertDao taoBaoUserTDao) {
		this.taoBaoUserTDao = taoBaoUserTDao;
	}

	public int addTaoBaoUserT(TaobaoUserT taobao) {
		return this.getTaoBaoUserTDao().addTaoBaoUserT(taobao);
	}

	public List<TaobaoUserT> findAllTaobaoUserT(int currentPage, int lineSize) {
		return this.getTaoBaoUserTDao().findAllTaobaoUserT(currentPage, lineSize);
	}
}
