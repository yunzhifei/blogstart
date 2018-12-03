package com.bj.hai.yang.blog.start.dao.user;


import com.bj.hai.yang.blog.start.dto.UserAccountDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IUserAccountDao {
    UserAccountDO selectById(@Param("id") int id);

    UserAccountDO selectByName(@Param("name") String name);

    int insert(UserAccountDO userAccountDO);
}
