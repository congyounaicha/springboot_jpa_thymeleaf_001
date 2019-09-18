package com.offcn.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity//表示该类对应数据库上的一张表,若不定义表名=类名
@Table(name="tb_person")//表的相关属性,表名
public class Person {
    @Id//声明主键
    @GeneratedValue//声明自增
    private Long id;
    @Column(name="name",nullable = false,length = 100)//表字段(列)的相关属性
    private String name;
    //不写字段注解,会自动根据 类型和属性名生成
    private Integer age;
}
