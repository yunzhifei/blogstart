package com.bj.hai.yang.blog.start.util;

import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReturnValueUtil {
    public static Object getReturnValue(int code, String message, ProceedingJoinPoint proceedingJoinPoint, Exception e) throws Exception {
        //获取参数
        Object[] args = proceedingJoinPoint.getArgs();
        Class<?>[] paramsCls = new Class<?>[args.length];
        for (int i = 0; i < args.length; ++i) {
            paramsCls[i] = args[i].getClass();
        }
        Method method = proceedingJoinPoint.getTarget().getClass().getMethod(proceedingJoinPoint.getSignature().getName(), paramsCls);
        //通过参数和方法来获取返回值类型
        Class clazz = method.getReturnType();
        Object result = clazz.newInstance();
        Field[] declaredFields = result.getClass().getDeclaredFields();
        Field.setAccessible(declaredFields, true);
        boolean isCode = false;
        for (Field declaredField : declaredFields) {
            if ("code".equals(declaredField.getName())) {
                declaredField.setInt(result, code);
                isCode = true;
            }
            if ("message".equals(declaredField.getName())) {
                declaredField.set(result, message);
            }
        }
        if (!isCode) {
            throw e;
        }
        return result;
    }
}
