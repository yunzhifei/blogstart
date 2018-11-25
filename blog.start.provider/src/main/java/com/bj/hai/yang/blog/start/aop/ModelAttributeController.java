package com.bj.hai.yang.blog.start.aop;

import com.bj.hai.yang.blog.start.model.UserAccountModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@ControllerAdvice
public class ModelAttributeController {

    private Logger logger = LoggerFactory.getLogger(ModelAttributeController.class);

    @ModelAttribute
    public UserAccountModel getUser(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            Arrays.stream(cookies).forEach(element -> {
                if (element.getName().equals("token")) {
                    //校验cookie,同时返回用户model
                }
            });
        }
        return null;
    }

//    @ExceptionHandler(value = Exception.class)
//    public String exceptionHandler(Exception e) {
//        logger.error("系统异常！", e);
//        return "index.html";
//    }
}
