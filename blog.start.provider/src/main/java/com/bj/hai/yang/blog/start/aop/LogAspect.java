package com.bj.hai.yang.blog.start.aop;


import com.bj.hai.yang.blog.start.common.utils.FieldUtil;
import com.bj.hai.yang.blog.start.util.ReturnValueUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Around("execution(public * com.bj.hai.yang.blog.start.controller.*.*(..))")
    public Object aroundInvoke(ProceedingJoinPoint point) throws Throwable {

        Object object = null;
        MDC.clear();
        long start = System.currentTimeMillis();
        try {
            object = point.proceed(point.getArgs());
            MDC.put("code", FieldUtil.getFiledValueByName(object, "code").toString());
        } catch (Exception e) {
            //设置默认异常
            object = ReturnValueUtil.getReturnValue(0, ",", point, e);
//            MDC.put("code", FieldUtil.getFiledValueByName(object, "code").toString());
        } finally {
            //打印耗时和code message
            long end = System.currentTimeMillis();
//            MDC.put("message", FieldUtil.getFiledValueByName(object, "message").toString());
//            MDC.put("timeCost", String.valueOf(end - start));

        }
        return object;
    }

}
