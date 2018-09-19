package com.bj.hai.yang.blog.start.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class UserAccountModel {
    private int id;
    private String name;
}
