package com.bj.hai.yang.blog.start.vo.common;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private T data;
    private boolean success;
    private String message;
}
