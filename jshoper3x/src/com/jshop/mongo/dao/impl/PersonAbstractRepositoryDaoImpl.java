package com.jshop.mongo.dao.impl;

import org.springframework.stereotype.Repository;

import com.jshop.mongo.dao.PersonAbstractRepositoryDao;
import com.jshop.mongo.documents.Person;

@Repository("personAbstractRepositoryDao")
public class PersonAbstractRepositoryDaoImpl extends AbstractRepositoryDaoImpl<Person> implements PersonAbstractRepositoryDao{

}
