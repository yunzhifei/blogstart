package com.bj.hai.yang.blog.start.dao;


import com.bj.hai.yang.blog.start.dto.UserAccountDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IUserAccountDao {
//    @Select({"select * from user_account where id=#{id}"})
    UserAccountDO selectById(@Param("id") int id);
}
