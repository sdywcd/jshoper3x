package com.jshop.mongo.dao.impl;

import org.springframework.stereotype.Repository;

import com.jshop.mongo.dao.PersonAbstractRepository;
import com.jshop.vo.Person;

@Repository("personAbstractRepository")
public class PersonAbstractRepositoryImpl extends AbstractRepositoryImpl<Person> implements PersonAbstractRepository{

}
