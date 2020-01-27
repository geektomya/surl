package com.geektomya.surl.model;

import lombok.Data;

/**
 * @author yaoqiuhong
 * @description
 */
@Data
public class UrlInfo {

    private String id;

    private String realUrl;

    private String shortUrl;

    private int type;

    private int current;
}
