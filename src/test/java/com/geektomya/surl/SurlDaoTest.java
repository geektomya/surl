package com.geektomya.surl;

import com.geektomya.surl.dao.SurlDao;
import com.geektomya.surl.model.UrlInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SurlDaoTest {

    @Autowired
    private SurlDao surlDao;

    private UrlInfo urlInfo;

    @Before
    public void before(){
        urlInfo = new UrlInfo();
        urlInfo.setId("8888");
        urlInfo.setRealUrl("http://zhqy,xyz");
        urlInfo.setShortUrl("8888");
        urlInfo.setType(1);
        urlInfo.setCurrent(1);
    }

    @Test
    public void inserSuerlTest(){
        boolean flag = surlDao.insertUrlInfo(urlInfo);
        assertEquals(true,flag);
    }
}
