/*
 * Project: umcweb-richinfo
 * 
 * File Created at 2019年6月2日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package com.citycloud.dcm.street.constant;

import java.io.Serializable;

public class RiskcontrolBean implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 6525191048460207011L;
    
    private  String suggestion;//拦截建议
    
    private String InterceptionDimension;//拦截维度
    
    private String resultCode;//错误返回码
    
    private String resultDesc;//错误描述
    
    private String  interceptTime;//拦截时间

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getInterceptionDimension() {
        return InterceptionDimension;
    }

    public void setInterceptionDimension(String interceptionDimension) {
        InterceptionDimension = interceptionDimension;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public String getInterceptTime() {
        return interceptTime;
    }

    public void setInterceptTime(String interceptTime) {
        this.interceptTime = interceptTime;
    }

    @Override
    public String toString() {
        return "RiskcontrolBean [suggestion=" + suggestion + ", InterceptionDimension="
                + InterceptionDimension + ", resultCode=" + resultCode + ", resultDesc="
                + resultDesc + ", interceptTime=" + interceptTime + "]";
    }
    
    
    
    
}


/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2019年6月2日 1 create
 */