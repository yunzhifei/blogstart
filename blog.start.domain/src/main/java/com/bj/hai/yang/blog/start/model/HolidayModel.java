package com.bj.hai.yang.blog.start.model;

import lombok.Data;

import java.util.Date;

@Data
public class HolidayModel {
    //id
    private long id;
    //年份
    private int year;
    //月份
    private int month;
    //日期
    private String day;
    //节假日名称
    private String holidayName;
    //是否删除
    private int status;
    private Date created;
    private Date modified;


}
