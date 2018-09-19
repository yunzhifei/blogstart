package com.bj.hai.yang.blog.start.service.impl;


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
        UserAccountModel userAccountModel = UserAccountModel.builder().build();
        UserAccountDO userAccountDO = userAccountDao.selectById(1);
        if (null == userAccountDO) {
            return null;
        }
        return UserAccountModelConvert.convertToModel(userAccountDO);
    }
}
