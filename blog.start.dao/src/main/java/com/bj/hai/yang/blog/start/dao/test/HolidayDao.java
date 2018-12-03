package com.bj.hai.yang.blog.start.dao.test;

import com.bj.hai.yang.blog.start.dto.Holiday;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HolidayDao {

    int insert(@Param("pojo") Holiday pojo);

    int insertList(@Param("pojos") List<Holiday> pojo);

    List<Holiday> select(@Param("pojo") Holiday pojo);

    int update(@Param("pojo") Holiday pojo);

    List<Holiday> selectByMonth(@Param("month") int month);

}
