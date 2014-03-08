package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.ModuleMDao;
import com.jshop.dao.impl.ModuleMDaoImpl;
import com.jshop.entity.ModuleM;
import com.jshop.service.ModuleMService;

@Service("moduleMService")
@Scope("prototype")
public class ModuleMServiceImpl extends BaseTServiceImpl<ModuleM> implements ModuleMService {
	@Resource
	private ModuleMDao moduleMDao;

	public ModuleMDao getModuleMDao() {
		return moduleMDao;
	}

	public void setModuleMDao(ModuleMDao moduleMDao) {
		this.moduleMDao = moduleMDao;
	}

	public int delModuleM(String[] strs) {
		return this.getModuleMDao().delModuleM(strs);
	}

	public ModuleM findModuleMById(String id) {
		return this.getModuleMDao().findModuleMById(id);
	}

	public void updateModuleM(ModuleM mm) {
		this.getModuleMDao().updateModuleM(mm);
	}

	public List<ModuleM> findAllModuleM() {
		return this.getModuleMDao().findAllModuleM();
	}

}
