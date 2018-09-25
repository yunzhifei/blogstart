package com.bj.hai.yang.blog.start.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserAccountDO {
    private int id;
    private String name;
    private String pwd;
    private String salt;
    private int status;
    private Date created;
    private Date modified;
}
