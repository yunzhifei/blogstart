package com.bj.hai.yang.blog.start.test;

import com.bj.hai.yang.blog.start.model.UserAccountModel;
import com.bj.hai.yang.blog.start.service.IUserAccountService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootUnitTest {


    @Autowired
    private IUserAccountService userAccountService;

    @org.junit.Test
    public void test() {
        UserAccountModel userAccountModel = UserAccountModel.builder().name("test").created(new Date()).modified(new Date()).pwd("test").salt("salt").status(1).build();
        int insert = userAccountService.insert(userAccountModel);
        Integer test = null;
        userAccountService.insert(userAccountModel);
        userAccountService.insert(userAccountModel);
        userAccountService.insert(userAccountModel);
        userAccountService.insert(userAccountModel);

        userAccountService.insert(userAccountModel);
        userAccountService.insert(userAccountModel);


        System.out.println("insert = " + insert);
    }
}
