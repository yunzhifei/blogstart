package com.bj.hai.yang.blog.start.controller;

import com.bj.hai.yang.blog.start.model.UserAccountModel;
import com.bj.hai.yang.blog.start.service.IUserAccountService;
import org.springframework.stereotype.Service;

@Service
public class TestThread implements Runnable {


    private IUserAccountService userAccountService;

    public TestThread(IUserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Override
    public void run() {
        UserAccountModel userAccountModel = userAccountService.selectById(1);
        System.out.println("thread = " + userAccountModel);
    }
}
