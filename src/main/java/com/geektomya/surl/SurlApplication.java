package com.geektomya.surl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.geektomya.surl.dao")
public class SurlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurlApplication.class, args);
    }

}
