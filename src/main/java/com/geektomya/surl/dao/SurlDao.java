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
    * 获取短url对应的原始url信息
    * */
    UrlVo getRealUrlInfo(UrlVo urlVo);
    /*
    * 获取最新的记录
    * */
    UrlInfo getCurrentUrlInfo();

}
