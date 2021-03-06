package com.bj.hai.yang.blog.start.controller;

import com.bj.hai.yang.blog.start.model.UserAccountModel;
import com.bj.hai.yang.blog.start.service.IUserAccountService;
import com.bj.hai.yang.blog.start.vo.common.ApiResponse;
import com.bj.hai.yang.blog.start.vo.common.login.LoginReq;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class HomeController {

    @Resource
    private IUserAccountService userAccountService;

    @RequestMapping(value = "/")
    public String test() {
        UserAccountModel userAccountModel = userAccountService.selectById(1);
        System.out.println("userAccountModel = " + userAccountModel);
        return "index.html";
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public ApiResponse loginByName(LoginReq loginReq) {
        if (StringUtils.isNotEmpty(checkLoginParams(loginReq))) {
            return ApiResponse.builder().success(false).message(checkLoginParams(loginReq)).build();
        }
        String login = userAccountService.login(loginReq.getName(), loginReq.getPwd());
        if (StringUtils.isNotEmpty(login)) {
            return ApiResponse.builder().success(false).message(login).build();
        }
        return ApiResponse.builder().success(true).message(login).build();
    }

    private String checkLoginParams(LoginReq loginReq) {
        if (StringUtils.isEmpty(loginReq.getName())) {
            return "用户名不能为空";
        }
        if (StringUtils.isEmpty(loginReq.getPwd())) {
            return "密码不能为空";
        }
        return "";
    }
}
