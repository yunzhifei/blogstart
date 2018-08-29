package com.bj.hai.yang.blog.start.test;


import org.junit.Test;

import javax.validation.constraints.NotNull;

public class NormalTest {

    @Test
    public void testNotNull() {
    }

    private int test(@NotNull Integer integer) {
        return integer;
    }
}
