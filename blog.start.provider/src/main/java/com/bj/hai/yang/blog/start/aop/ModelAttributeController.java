package com.bj.hai.yang.blog.start.aop;

import com.bj.hai.yang.blog.start.model.UserAccountModel;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@ControllerAdvice
public class ModelAttributeController {


    @ModelAttribute
    public UserAccountModel getUser(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            Arrays.stream(cookies).forEach(element -> {
                if (element.getName().equals("token")) {
                    System.out.println(element.toString());
                }
            });
        }
        return null;
    }

}
