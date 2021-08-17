package com.citycloud.dcm.street.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingerService {
    private static final Logger logger = LoggerFactory.getLogger(SingerService.class);
    @Autowired
    private Singer singer;
    public String sing(){
        return singer.sing("song lyrics");
    }



}