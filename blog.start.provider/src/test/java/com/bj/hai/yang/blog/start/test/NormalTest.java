package com.bj.hai.yang.blog.start.test;


import com.alibaba.fastjson.JSON;
import com.bj.hai.yang.blog.start.model.UserAccountModel;
import org.junit.Test;

import javax.validation.constraints.NotNull;

public class NormalTest {

    @Test
    public void testNotNull() {
        UserAccountModel userAccountModel = UserAccountModel.builder().status(1).build();
        Object o = userAccountModel;
        System.out.println("o = " + JSON.toJSONString(o));
    }

    private int test(@NotNull Integer integer) {
        return integer;
    }
}
