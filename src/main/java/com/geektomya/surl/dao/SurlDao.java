package com.geektomya.surl.dao;

import com.geektomya.surl.model.UrlInfo;
import com.geektomya.surl.model.vo.UrlVo;
import org.springframework.stereotype.Repository;

@Repository
public interface SurlDao {

    /*
    * 插入url信息
    * */
    boolean insertUrlInfo(UrlInfo urlInfo);
    /*
    * 获取url信息
    * */
    UrlVo getRealUrlInfo(UrlVo urlVo);
}
