package com.bj.hai.yang.blog.start.common.utils;

import java.util.Random;

public class SaltUtils {

    private static final String hexDigIts[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String getSalt() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            stringBuilder.append(hexDigIts[new Random().nextInt(15)]);
        }
        return stringBuilder.toString();
    }
}
