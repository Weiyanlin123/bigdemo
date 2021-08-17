package com.citycloud.dcm.street.vo;

import com.citycloud.dcm.street.constant.MessageConstants;
import com.citycloud.dcm.street.util.TimeUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;


/**
 * http结果返回结构体
 */
@Data
@JsonInclude(JsonInclude.Include.ALWAYS)
public class JsonData {
    private boolean success = true;
    private String message;
    private String dateTime;
    private Object data;
    private String code;
    private Long totalCount;

    public JsonData() {
        this.success = true;
        this.message = MessageConstants.RESPONSE_MESSAGE_SUCCESS;
        this.code = "200";
        this.dateTime = TimeUtils.formatDateToStr(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @param data
     */
    public JsonData(Object data) {
        this.success = true;
        this.message = "";
        this.dateTime = TimeUtils.formatDateToStr(new Date(), "yyyy-MM-dd HH:mm:ss");
        this.code = "200";
        this.data = data;
    }

    public JsonData(Object data, long totalCount) {
        this.success = true;
        this.message = "";
        this.dateTime = TimeUtils.formatDateToStr(new Date(), "yyyy-MM-dd HH:mm:ss");
        this.code = "200";
        this.data = data;
        this.totalCount = totalCount;
    }

    public JsonData(Object data, String msg) {
        this.success = true;
        this.message = msg;
        this.dateTime = TimeUtils.formatDateToStr(new Date(), "yyyy-MM-dd HH:mm:ss");
        this.code = "200";
        this.data = data;
    }

}
