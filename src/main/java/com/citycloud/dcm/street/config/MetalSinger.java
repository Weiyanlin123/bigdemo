package com.citycloud.dcm.street.config;

import org.springframework.stereotype.Component;

@Component("metalSinger") // 加注解，让spring识别
public class MetalSinger implements Singer{

    @Override
    public String sing(String lyrics) {
        return "I am singing with DIO voice: "+lyrics;
    }
}





