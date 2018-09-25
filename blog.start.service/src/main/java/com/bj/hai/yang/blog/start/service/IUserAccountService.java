package com.bj.hai.yang.blog.start.service;


import com.bj.hai.yang.blog.start.model.UserAccountModel;

public interface IUserAccountService {
    UserAccountModel selectById(int id);

    UserAccountModel selectByName(String name);

    String login(String userName, String pwd);

    int insert(UserAccountModel userAccountModel);
}
