package com.jshop.mongo.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.mongo.documents.Person;
import com.jshop.mongo.service.PersonAbstractRepositoryService;
@Service("personAbstractRepositoryService")
@Scope("prototype")
public class PersonAbstractRepositoryServiceImpl  extends AbstractRepositoryServiceImpl<Person> implements PersonAbstractRepositoryService{
	

}
