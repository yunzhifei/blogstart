package com.bj.hai.yang.blog.start.controller;

import com.bj.hai.yang.blog.start.model.UserAccountModel;
import com.bj.hai.yang.blog.start.service.IUserAccountService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class TestController {

    @Autowired
    private IUserAccountService userAccountService;

    private ExecutorService executorService = Executors.newCachedThreadPool();


    @RequestMapping("/")
    @CrossOrigin(origins = "*")
    public String test() {
        UserAccountModel userAccountModel = userAccountService.selectById(1);
        System.out.println("userAccountModel = " + userAccountModel);
        for (int i = 0; i < 6; i++) {
            executorService.execute(new TestThread(userAccountService));
        }
        return "( " + "test" + " )";
    }
}
