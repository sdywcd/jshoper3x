package com.jshop.dao;

import java.io.Serializable;

public interface BaseDao<M extends Serializable> {

	public void save(M m);
	
	public void update(M m);
	
	public void delete(M m);
	

	
}
