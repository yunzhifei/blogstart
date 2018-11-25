package com.bj.hai.yang.blog.start.controller;

import com.bj.hai.yang.blog.start.common.utils.CommonConstant;
import com.bj.hai.yang.blog.start.common.utils.MD5Utils;
import com.bj.hai.yang.blog.start.common.utils.SaltUtils;
import com.bj.hai.yang.blog.start.model.UserAccountModel;
import com.bj.hai.yang.blog.start.service.IUserAccountService;
import com.bj.hai.yang.blog.start.vo.common.ApiResponse;
import com.bj.hai.yang.blog.start.vo.common.login.LoginReq;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@CrossOrigin(origins = "*")
public class HomeController {

    @Autowired
    private IUserAccountService userAccountService;

    private ExecutorService executorService = Executors.newCachedThreadPool();


    @RequestMapping("/")
    public String test(int i) {
        UserAccountModel userAccountModel = userAccountService.selectById(1);
        System.out.println("userAccountModel = " + userAccountModel);
        return "test";


    }

    @RequestMapping("/login")
    @ResponseBody
    public ApiResponse loginByName(LoginReq loginReq) {
        if (StringUtils.isNotEmpty(checkLoginParams(loginReq))) {
            return ApiResponse.builder().success(false).message(checkLoginParams(loginReq)).build();
        }
        String login = userAccountService.login(loginReq.getName(), loginReq.getPassword());
        if (StringUtils.isNotEmpty(login)) {
            return ApiResponse.builder().success(false).message(login).build();
        }
        return ApiResponse.builder().success(true).message(login).build();
    }

    @RequestMapping("/register.json")
    @ResponseBody
    public ApiResponse register(LoginReq loginReq) {
        if (StringUtils.isNotEmpty(checkLoginParams(loginReq))) {
            return ApiResponse.builder().success(false).message(checkLoginParams(loginReq)).build();
        }
        String salt = SaltUtils.getSalt();
        UserAccountModel userAccountModel = UserAccountModel.builder()
                .name(loginReq.getName())
                .pwd(MD5Utils.MD5Encode(loginReq.getPassword() + salt, CommonConstant.UTF_8))
                .status(0)
                .created(new Date())
                .modified(new Date())
                .salt(salt)
                .build();
        int insert = userAccountService.insert(userAccountModel);
        if (0 == insert) {
            return ApiResponse.builder().success(false).message("注册失败！").build();
        }
        return ApiResponse.builder().success(true).message("注册成功！").build();
    }

    private String checkLoginParams(LoginReq loginReq) {
        if (StringUtils.isEmpty(loginReq.getName())) {
            return "用户名不能为空";
        }
        if (StringUtils.isEmpty(loginReq.getPassword())) {
            return "密码不能为空";
        }
        return "";
    }

    public static void main(String[] args) {
        Integer i = 1;
        System.out.println("args = " + (i instanceof Object));
    }

}
