package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.RoleMDao;
import com.jshop.dao.impl.RoleMDaoImpl;
import com.jshop.entity.RoleM;
import com.jshop.service.RoleMService;

@Service("roleMService")
@Scope("prototype")
public class RoleMServiceImpl extends BaseTServiceImpl<RoleM>implements RoleMService {
	
}
