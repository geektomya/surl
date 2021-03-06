package com.geektomya.surl.controller;

import com.geektomya.surl.common.message.Messsage;
import com.geektomya.surl.dao.SurlDao;
import com.geektomya.surl.model.vo.UrlVo;
import com.geektomya.surl.service.SurlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yaoqiuhong
 * @description 用于对短链接重定向到原始链接
 */
@Controller
public class Redirect {

    @Autowired
    private SurlService surlService;

    @GetMapping("{shortUrl}")
    public ModelAndView redirect(@PathVariable String shortUrl, ModelAndView mav, HttpServletRequest request){
        String realUrl = surlService.getRealUrl(shortUrl);
        if (realUrl == null){
            realUrl = Messsage.INDEX;
        }
        if (!surlService.isHttpUrl(realUrl)){
            mav.setViewName("redirect:" + "http://"+realUrl);
        }
        else{
            mav.setViewName("redirect:" + realUrl);
        }

        return mav;
    }
}
