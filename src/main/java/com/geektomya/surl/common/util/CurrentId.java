package com.geektomya.surl.common.util;

import com.geektomya.surl.dao.SurlDao;
import com.geektomya.surl.exception.ServerException;
import com.geektomya.surl.model.UrlInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yaoqiuhong
 * @description 用来获取到当前的自增Id的位置
 */
@Service
public class CurrentId {

    @Autowired
    private SurlDao surlDao;

    public String getCurrentId(){
        try{
            UrlInfo urlInfo = surlDao.getCurrentUrlInfo();
            return urlInfo.getId();
        }catch (Exception e){
            throw new ServerException();
        }
    }
}
