package com.bj.hai.yang.blog.start.service.impl;


import com.bj.hai.yang.blog.start.common.utils.MD5Utils;
import com.bj.hai.yang.blog.start.convert.UserAccountModelConvert;
import com.bj.hai.yang.blog.start.dao.IUserAccountDao;
import com.bj.hai.yang.blog.start.dto.UserAccountDO;
import com.bj.hai.yang.blog.start.model.UserAccountModel;
import com.bj.hai.yang.blog.start.service.IUserAccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserAccountServiceImpl implements IUserAccountService {

    @Resource
    private IUserAccountDao userAccountDao;

    public UserAccountModel selectById(int id) {
        UserAccountDO userAccountDO = userAccountDao.selectById(1);
        if (null == userAccountDO) {
            return null;
        }
        return UserAccountModelConvert.convertToModel(userAccountDO);
    }

    @Override
    public UserAccountModel selectByName(String name) {
        UserAccountDO userAccountDO = userAccountDao.selectByName(name);
        if (null == userAccountDO) {
            return null;
        }
        return UserAccountModelConvert.convertToModel(userAccountDO);
    }

    @Override
    public String login(String userName, String pwd) {
        UserAccountModel userAccountModel = selectByName(userName);
        if (null != userAccountModel && pwd.equals(MD5Utils.encryption(userAccountModel.getPwd() + userAccountModel.getSalt()))) {
            return "";
        } else {
            return "账户密码不匹配";
        }

    }

    @Override
    public int insert(UserAccountModel userAccountModel) {
//        return userAccountDao;
        UserAccountDO userAccountDO = UserAccountModelConvert.convertToDO(userAccountModel);
        int insert = userAccountDao.insert(userAccountDO);
        return userAccountDO.getId();
    }
}
