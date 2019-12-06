package com.geektomya.surl.controller;

import com.geektomya.surl.common.response.ResponseUtil;
import com.geektomya.surl.common.response.ResponseVo;
import com.geektomya.surl.common.util.CurrentId;
import com.geektomya.surl.model.UrlInfo;
import com.geektomya.surl.model.vo.UrlVo;
import com.geektomya.surl.service.SurlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("url")
public class SurlController {

    @Autowired
    private SurlService surlService;

    @PostMapping("intoShortUrl")
    public ResponseVo<UrlVo> insertUrlInfo(UrlInfo urlInfo){
        UrlVo urlVo= surlService.insertUrlinfo(urlInfo);
        return ResponseUtil.toResponseVo(200,"操作成功",urlVo);
    }

    @PostMapping("{realUrl}")
    public ResponseVo<UrlVo> getShrotUrl(@PathVariable String realUrl) {
        UrlInfo urlInfo = new UrlInfo();
        urlInfo.setRealUrl(realUrl);
        urlInfo.setType(0);
        UrlVo urlVo= surlService.insertUrlinfo(urlInfo);
        return ResponseUtil.toResponseVo(200,"操作成功",urlVo);
    }
}
