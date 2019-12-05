package com.geektomya.surl.model;

import lombok.Data;

@Data
public class UrlInfo {

    private String id;

    private String realUrl;

    private String shortUrl;

    private String type;

    private String current;
}
