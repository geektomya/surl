package com.geektomya.surl.service;

import com.geektomya.surl.common.message.Messsage;
import com.geektomya.surl.common.util.CurrentId;
import com.geektomya.surl.dao.SurlDao;
import com.geektomya.surl.exception.ServerException;
import com.geektomya.surl.model.UrlInfo;
import com.geektomya.surl.model.vo.UrlVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurlService {

    @Autowired
    private SurlDao surlDao;
    @Autowired
    private CurrentId currentId;
    private UrlVo urlVo;

    /*
    * 获取短Url对应的原始Url
    * */
    public String getRealUrl(String shortUrl){
       if (shortUrl != null){
           urlVo = surlDao.getRealUrlInfo(shortUrl);
           if (urlVo == null){
               return null;
           }else{
               return urlVo.getRealUrl();
           }
       }
       return null;
    }
    /*
    * 获取原始Url对应短Url
    * */
    public List<UrlVo> getRealUrlsByShortUrl(UrlVo urlVo){
        if (urlVo == null){
            return null;
        }
        try{
            List<UrlVo> urlVos = surlDao.getRealUrlsByShortUrl(urlVo);
            return urlVos;
        }catch (Exception e){
            throw new ServerException();
        }
    }
    /*
    * 插入生成的短url
    * */
    public UrlVo insertUrlinfo(UrlInfo urlInfo){
        long id = Long.parseLong(currentId.getCurrentId());
        long currentId = Long.parseLong(nextid(String.valueOf(id+1)));
        urlInfo.setId(String.valueOf(currentId));
        if (urlInfo.getType()==1){
            urlInfo.setCurrent(0);
        }else{
            urlInfo.setCurrent(1);
            urlInfo.setShortUrl(String.valueOf(currentId));
        }
        try {
            surlDao.upadteCurrntId(String.valueOf(id));
            boolean flag = surlDao.insertUrlInfo(urlInfo);
            if (flag == true){
                UrlVo urlVo =new UrlVo();
                urlVo.setRealUrl(urlInfo.getRealUrl());
                urlVo.setShortUrl(Messsage.PERURL+urlInfo.getShortUrl());
                return  urlVo;
            }
        }catch (Exception e){
            throw new ServerException();
        }

       return null;
    }

    /*
    * 得到下次的id，绕过自定义的id
    * */
    public String nextid(String id){
        while (surlDao.selectIdInUse(id)!=null){
           long nextid = Long.parseLong(id)+1;
           id = String.valueOf(nextid);
        }
        return id;
    }


}
