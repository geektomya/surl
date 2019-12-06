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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    /**
     * 判断字符串是否为URL
     * @param urls 需要判断的String类型url
     * @return true:是URL；false:不是URL
     */
    public boolean isHttpUrl(String urls) {
        boolean isurl = false;
        if (urls.startsWith("https")||urls.startsWith("http")){
            isurl =true;
        }
        return isurl;
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
    * 返回js
    * */
    public String getShortUrlInJs(){
        StringBuffer buffer =new StringBuffer();
        buffer.append("function setUrl(){\n" +
                "    var realUrl =document.getElementById('url').href;\n" +
                "    var ajax = new XMLHttpRequest();\n" +
                "    ajax.open('post','").append(Messsage.PERINJS).append("intoShortUrl');\n" +
                "    ajax.setRequestHeader(\"content-type\",\"application/x-www-form-urlencoded\");\n" +
                "    ajax.send(`realUrl=${realUrl}`);\n" +
                "    ajax.onreadystatechange = function () {\n" +
                "        if(ajax.readyState==4&&ajax.status==200){\n" +
                "            let obj = JSON.parse(ajax.responseText)\n" +
                "            let res = obj.data.shortUrl\n" +
                "            document.getElementById(\"url\").href=res;\n" +
                "            document.getElementById(\"url\").innerHTML=res;\n" +
                "        }  \n" +
                "    }\n" +
                "}");
        String js = buffer.toString();
        return js;
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



