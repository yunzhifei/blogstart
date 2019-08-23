package com.bj.hai.yang.blog.start.vo.common;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = 5999134645817094383L;

    private T data;
    private boolean success;
    private String message;
}
