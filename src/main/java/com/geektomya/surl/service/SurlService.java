package com.geektomya.surl.service;

import com.geektomya.surl.dao.SurlDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurlService {

    @Autowired
    private SurlDao surlDao;

}
