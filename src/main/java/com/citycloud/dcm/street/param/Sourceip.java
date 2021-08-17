package com.citycloud.dcm.street.param;

import java.io.Serializable;


/**
 * @Type Sourceip.java
 * @Desc 
 * @author lizhihuihy
 * @date 2018-04-16
 * @version 
 */
public class Sourceip implements Serializable {
    private static final long serialVersionUID = 1L;
    private String sourceid;  // sourceid
    private String mask;  // ip地址或网络地址
    private String type;  //白名单类别(可自定义). 00|SDK TOKEN校验; 01|PC TOKEN校验; 02|签发PC TOKEN; 03|双创、开放平台白名单; 05|和飞信sip密码销户白名单
    private String allow;  // 是否允许, 000| 允许
    
    public void setSourceid(String sourceid) {
	this.sourceid = sourceid;
    }
    
    public String getSourceid() {
	return this.sourceid;
    }
    
    public void setIp(String mask) {
	this.mask = mask;
    }
    
    public String getMask() {
	return this.mask;
    }
    
    public void setType(String type) {
	this.type = type;
    }
    
    public String getType() {
	return this.type;
    }
    
    public void setAllow(String allow) {
	this.allow = allow;
    }
    
    public String getAllow() {
	return this.allow;
    }
}
