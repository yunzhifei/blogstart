package com.bj.hai.yang.blog.start.convert;

import com.bj.hai.yang.blog.start.dto.UserAccountDO;
import com.bj.hai.yang.blog.start.model.UserAccountModel;

public class UserAccountModelConvert {
    public static UserAccountModel convertToModel(UserAccountDO userAccountDO) {
        UserAccountModel userAccountModel = new UserAccountModel();
        userAccountModel.setId(userAccountDO.getId());
        userAccountModel.setName(userAccountDO.getName());
        userAccountModel.setPwd(userAccountDO.getPwd());
        userAccountModel.setSalt(userAccountDO.getSalt());
        userAccountModel.setStatus(userAccountDO.getStatus());
        userAccountModel.setModified(userAccountDO.getModified());
        userAccountModel.setCreated(userAccountDO.getCreated());
        return userAccountModel;
    }
    public static UserAccountDO convertToDO(UserAccountModel accountModel) {
        UserAccountDO accountDO = new UserAccountDO();
        accountDO.setId(accountModel.getId());
        accountDO.setName(accountModel.getName());
        accountDO.setPwd(accountModel.getPwd());
        accountDO.setSalt(accountModel.getSalt());
        accountDO.setStatus(accountModel.getStatus());
        accountDO.setModified(accountModel.getModified());
        accountDO.setCreated(accountModel.getCreated());
        return accountDO;
    }
}
