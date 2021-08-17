package com.citycloud.dcm.street.constant;

/**
 * @ClassName BusinessNoEnum
 * @Description 业务编码生成枚举类
 * @Author dingguangda
 * @Date 2020/2/26 17:03
 * @Version 1.0
 **/
public enum BusinessNoEnum {

    FLOW_EVENT("sec:flowEventAlarmNo", "F","sec:flowEventCurrDate");

    private String atomicLongName;
    private String prefix;
    private String dateName;

    public String getAtomicLongName() {
        return atomicLongName;
    }

    public void setAtomicLongName(String atomicLongName) {
        this.atomicLongName = atomicLongName;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getDateName() {
        return dateName;
    }

    public void setDateName(String dateName) {
        this.dateName = dateName;
    }

    BusinessNoEnum(String atomicLongName, String prefix, String dateName) {
        this.atomicLongName = atomicLongName;
        this.prefix = prefix;
        this.dateName = dateName;
    }
}
