package com.offcn.service;

import com.offcn.po.Person;

import java.util.List;

public interface PersonService {
    public void add(Person person);
    public void update(Person person);
    public void delete(Long id);
    public List<Person> findAll();
    public Person findOne(Long id);
}
