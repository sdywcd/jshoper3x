package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.FunctionMDao;
import com.jshop.entity.FunctionM;
import com.jshop.service.FunctionMService;

@Service("functionMService")
@Scope("prototype")
public class FunctionMServiceImpl extends BaseTServiceImpl<FunctionM>implements FunctionMService {
	@Resource
	private FunctionMDao functionMDao;

	public FunctionMDao getFunctionMDao() {
		return functionMDao;
	}

	public void setFunctionMDao(FunctionMDao functionMDao) {
		this.functionMDao = functionMDao;
	}


	public int delFunctionM(String[] strs) {
		return this.getFunctionMDao().delFunctionM(strs);
	}

	public List<FunctionM> findAllFunctionM() {
		return this.getFunctionMDao().findAllFunctionM();
	}

	public FunctionM findFunctionMById(String id) {
		return this.getFunctionMDao().findFunctionMById(id);
	}

	public void updateFunctionM(FunctionM fm) {
		this.getFunctionMDao().updateFunctionM(fm);
	}

	public List<FunctionM> findAllFunctionMBymoduleid(String moduleid) {
		return this.getFunctionMDao().findAllFunctionMBymoduleid(moduleid);
	}

}
