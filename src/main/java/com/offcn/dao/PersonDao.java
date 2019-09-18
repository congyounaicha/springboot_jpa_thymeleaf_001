package com.offcn.dao;

import com.offcn.po.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * dao继承JPA仓库,自动生成增删改查.<,>须写 表对应的实体类 和 主键类型tui'dao
 * 什么注解都不用加,自动推导出 sql语句
 */
public interface PersonDao extends JpaRepository<Person,Long> {
    //根据用户名 模糊查询
    public Person findByNameIs(String name);
    //根据名字和年龄 查询用户
    public Person findByNameAndAge(String name,Integer age);
}
