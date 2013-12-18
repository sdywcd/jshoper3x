package com.jshop.service;

import java.io.Serializable;

public interface BaseService<M extends Serializable> {

	public void save(M m);
	
	public void update(M m);
	
	public void delete(M m);
	

	
}
