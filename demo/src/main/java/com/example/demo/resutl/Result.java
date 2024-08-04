package com.example.demo.resutl;

import com.example.demo.enums.ResultEnum;
import lombok.Data;

@Data
public class Result<T> {

    private String message;

    private T data;

    private Integer code;

    public Result() {
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<T>();
        result.setData(data);
        result.setCode(ResultEnum.success.getCode());
        result.setMessage("success");
        return result;
    }

}
