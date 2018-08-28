package com.bj.hai.yang.blog.start.service.impl;


import com.bj.hai.yang.blog.start.convert.UserAccountModelConvert;
import com.bj.hai.yang.blog.start.dao.IUserAccountDao;
import com.bj.hai.yang.blog.start.dto.UserAccountDO;
import com.bj.hai.yang.blog.start.model.UserAccountModel;
import com.bj.hai.yang.blog.start.service.IUserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements IUserAccountService {

    @Autowired
    private IUserAccountDao userAccountDao;

    public UserAccountModel selectById(int id) {
        UserAccountModel userAccountModel = new UserAccountModel();
        UserAccountDO userAccountDO = userAccountDao.selectById(1);
        if (null == userAccountDO) {
            return null;
        }
        return UserAccountModelConvert.convertToModel(userAccountDO);
    }
}
