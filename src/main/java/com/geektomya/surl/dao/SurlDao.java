package com.geektomya.surl.dao;

import com.geektomya.surl.model.UrlInfo;
import com.geektomya.surl.model.vo.UrlVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yaoqiuhong
 * @description
 */
@Repository
public interface SurlDao {

    /**
     * 插入url信息
     * @param urlInfo
     * @return
     */
    boolean insertUrlInfo(UrlInfo urlInfo);

    /**
     * 更新最新值
     * @param id
     * @return
     */
    boolean upadteCurrntId(String id);

    /**
     * 获取短url对应的原始url信息
     * @param shortUrl
     * @return
     */
    UrlVo getRealUrlInfo(String shortUrl);

    /**
     * 获取最新的记录
     * @return
     */
    UrlInfo getCurrentUrlInfo();

    /**
     * 获取长Url对应的短Url
     * @param urlVo
     * @return
     */
    List<UrlVo> getRealUrlsByShortUrl(UrlVo urlVo);

    /**
     * 查找某个id是否被自定义的使用过了
     * @param id
     * @return
     */
    UrlInfo selectIdInUse(String id);
}
