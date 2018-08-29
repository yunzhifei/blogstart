package com.bj.hai.yang.blog.start.convert;

import com.bj.hai.yang.blog.start.dto.UserAccountDO;
import com.bj.hai.yang.blog.start.model.UserAccountModel;

public class UserAccountModelConvert {
    public static UserAccountModel convertToModel(UserAccountDO userAccountDO) {
        UserAccountModel userAccountModel = new UserAccountModel();
        userAccountModel.setId(userAccountDO.getId());
        userAccountModel.setName(userAccountDO.getName());
        return userAccountModel;
    }
}
