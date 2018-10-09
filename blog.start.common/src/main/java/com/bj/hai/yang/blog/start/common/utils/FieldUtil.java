package com.bj.hai.yang.blog.start.common.utils;

import java.lang.reflect.Field;

public class FieldUtil {
    //根据名字获取对象中指定的字段的值
    public static Object getFiledValueByName(Object object, String name) throws  IllegalAccessException {
        Class<?> aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();
        Field.setAccessible(fields, true);
        for (Field declaredField : fields) {
            if (declaredField.getName().equals(name)) {
                Object filedValue = declaredField.get(object);
                return filedValue;
            }
        }
        return null;
    }
}

