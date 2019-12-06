package com.geektomya.surl.controller;

import com.geektomya.surl.common.message.Messsage;
import com.geektomya.surl.common.response.ResponseUtil;
import com.geektomya.surl.common.response.ResponseVo;
import com.geektomya.surl.common.util.CurrentId;
import com.geektomya.surl.model.UrlInfo;
import com.geektomya.surl.model.vo.UrlVo;
import com.geektomya.surl.service.SurlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("url")
public class SurlController {

    @Autowired
    private SurlService surlService;

    /*
    * @description 根据长链变换为短链
    * @param realUrl  原始的url
    * @param  type     用户自定义为1，系统自动为0
    * */
    @PostMapping("intoShortUrl")
    public ResponseVo<UrlVo> insertUrlInfo(UrlInfo urlInfo){
        UrlVo urlVo= surlService.insertUrlinfo(urlInfo);
        return ResponseUtil.toResponseVo(200, Messsage.SUCCESS,urlVo);
    }

    @PostMapping("{realUrl}")
    public ResponseVo<UrlVo> getShrotUrl(@PathVariable String realUrl) {
        UrlInfo urlInfo = new UrlInfo();
        urlInfo.setRealUrl(realUrl);
        urlInfo.setType(0);
        UrlVo urlVo= surlService.insertUrlinfo(urlInfo);
        return ResponseUtil.toResponseVo(200,Messsage.SUCCESS,urlVo);
    }

    @GetMapping("js")
    public String getShrotUrlJs(){
        String js = surlService.getShortUrlInJs();
        System.out.println(js);
        return js;
    }
}
