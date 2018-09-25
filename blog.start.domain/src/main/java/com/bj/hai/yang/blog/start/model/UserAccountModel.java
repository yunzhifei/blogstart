package com.bj.hai.yang.blog.start.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountModel {
    private int id;
    private String name;
    private String pwd;
    private String salt;
    private int status;
    private Date created;
    private Date modified;
}
