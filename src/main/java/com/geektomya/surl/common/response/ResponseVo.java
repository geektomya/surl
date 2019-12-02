package com.geektomya.surl.common.response;

import lombok.Data;


@Data
public class ResponseVo<T> {

    private Integer code;

    private String msg;

    private T data;

}