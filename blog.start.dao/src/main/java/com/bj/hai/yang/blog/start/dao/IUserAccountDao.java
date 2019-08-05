package com.bj.hai.yang.blog.start.dao;


import com.bj.hai.yang.blog.start.dto.UserAccountDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IUserAccountDao {

    int insert(@Param("pojo") UserAccountDO pojo);

    int insertList(@Param("pojos") List<UserAccountDO> pojo);

    List<UserAccountDO> select(@Param("pojo") UserAccountDO pojo);

    int update(@Param("pojo") UserAccountDO pojo);

    int delete(@Param("id") int id);

    UserAccountDO selectById(@Param("id") int id);

    UserAccountDO selectByName(@Param("name") String name);
}
