package com.geektomya.surl;

import com.geektomya.surl.dao.SurlDao;
import com.geektomya.surl.model.UrlInfo;
import com.geektomya.surl.model.vo.UrlVo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SurlDaoTest {

    @Autowired
    private SurlDao surlDao;

    private UrlInfo urlInfo;

    private UrlVo urlVo;

    @Before
    public void before(){
        urlInfo = new UrlInfo();
        urlInfo.setId("8888");
        urlInfo.setRealUrl("http://zhqy.xyz");
        urlInfo.setShortUrl("8888");
        urlInfo.setType(1);
        urlInfo.setCurrent(1);
        urlVo = new UrlVo();
        urlVo.setShortUrl("8888");
        urlVo.setRealUrl("http://zhqy.xyz");
    }

    @Test
    public void inserSuerlTest(){
        boolean flag = surlDao.insertUrlInfo(urlInfo);
        assertEquals(true,flag);
    }

    @Test
    public void getCurrentUrlInfoTest(){
        urlInfo = surlDao.getCurrentUrlInfo();
        assertEquals("8888",urlInfo.getId());
    }

    @Test
    public void getRealUrl(){
        urlVo = surlDao.getRealUrlInfo(urlVo.getShortUrl());
        assertEquals("http://zhqy.xyz",urlVo.getRealUrl());
    }

    @Test
    public void getRealUrls(){
        List<UrlVo> lists =  surlDao.getRealUrlsByShortUrl(urlVo);
        assertEquals(2,lists.size());
    }
    @Test
    public void selectIdInUseTest(){
        urlInfo = surlDao.selectIdInUse("8888");
        assertEquals("8888",urlInfo.getId());
    }
}
