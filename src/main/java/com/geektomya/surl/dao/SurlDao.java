package com.geektomya.surl.dao;

import com.geektomya.surl.model.UrlInfo;
import com.geektomya.surl.model.vo.UrlVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurlDao {

    /*
    * 插入url信息
    * */
    boolean insertUrlInfo(UrlInfo urlInfo);
    /*
    * 更新最新值
    * */
    boolean upadteCurrntId(String id);
    /*
    * 获取短url对应的原始url信息
    * */
    UrlVo getRealUrlInfo(String shortUrl);
    /*
    * 获取最新的记录
    * */
    UrlInfo getCurrentUrlInfo();
    /*
    * 获取长Url对应的短Url
    * */
    List<UrlVo> getRealUrlsByShortUrl(UrlVo urlVo);
    /*
    * 查找某个id是否被自定义的使用过了
    * */
    UrlInfo selectIdInUse(String id);
}
