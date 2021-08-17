package com.citycloud.dcm.street.classloder;

public class Logback implements Log {
    @Override 
    public void log(String info) { 
        System.out.println("Logback:" + info); 
    } 
}