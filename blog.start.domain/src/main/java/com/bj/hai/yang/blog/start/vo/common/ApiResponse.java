package com.bj.hai.yang.blog.start.vo.common;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class ApiResponse<T> {
    private T data;
    private boolean success;
    private String message;
}
