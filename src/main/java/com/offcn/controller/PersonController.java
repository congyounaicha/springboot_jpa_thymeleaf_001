package com.offcn.controller;

import com.offcn.po.Person;
import com.offcn.service.PersonService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    //查询全部用户数据,显示列表
    @GetMapping("/")
    public String findAll(Model model){
        List<Person> all = personService.findAll();
        model.addAttribute("page",all);
        return "user/list";
    }

    //跳转到新增用户页面
    @GetMapping("/toAdd")
    public String toAdd(){
        return "user/userAdd";
    }

    //保存新增用户
    @PostMapping("/")
    public String add(Person person){
        try {
            personService.add(person);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
    
    //根据用户id读取用户信息
    @GetMapping("/{id}")
    public String toEdit(Model model, @PathVariable Long id){
        Person one = personService.findOne(id);
        model.addAttribute("person",one);
        return "user/userEdit";

    }

    //更新用户数据
    @PostMapping("/update")
    public String update(Person person){
        personService.update(person);
        return "redirect:/";
    }

    //根据id删除
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        personService.delete(id);
        return "redirect:/";
    }
}
