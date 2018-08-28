package com.bj.hai.yang.blog.start.controller;

import com.bj.hai.yang.blog.start.model.UserAccountModel;
import com.bj.hai.yang.blog.start.service.IUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private IUserAccountService userAccountService;

    @RequestMapping("/")
    public String test() {
        UserAccountModel userAccountModel = userAccountService.selectById(1);
        System.out.println("userAccountModel = " + userAccountModel);
        return "";
    }
}
