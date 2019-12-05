package com.geektomya.surl.controller;

import com.geektomya.surl.service.SurlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/surl")
public class SurlController {

    @Autowired
    private SurlService surlService;
}
