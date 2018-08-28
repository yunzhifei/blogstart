package com.bj.hai.yang.blog.start.test;

import com.bj.hai.yang.blog.start.model.UserAccountModel;
import com.bj.hai.yang.blog.start.service.IUserAccountService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootUnitTest {

    @Autowired
    private IUserAccountService userAccountService;

    @org.junit.Test
    public void test() {
        UserAccountModel userAccountModel = userAccountService.selectById(1);
        System.out.println("userAccountModel = " + userAccountModel);
    }
}
