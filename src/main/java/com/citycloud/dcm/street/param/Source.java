package com.citycloud.dcm.street.param;

import java.io.Serializable;
import java.util.Date;

/**
 * 接入的业务产品
 * 
 * @author 潘海春
 * @date 2017年6月9日
 */
public class Source implements Serializable {

    private static final long serialVersionUID = 1L;
    // 状态
    public static final int STATUS_NORMAL = 1; // 正常
    public static final int STATUS_DISABLE = 2; // 停用

    // 类型
    public static final int TYPE_INTERNAL = 1; // 内部
    public static final int TYPE_BUDDY = 2; // 合作方
    public static final int TYPE_3RD = 3; // 第三方

    private String id;
    private String name;
    private String openidRandKey;

    private String key; // 密钥

    private int type; // 区分内部还是外部
    private int status; // STATUS_NORMAL, STATUS_DISABLE

    private String developer; // 开发者(企业ID)

    private Date createTime;
    private Date updateTime;
    //数据库添加字段
    private String sourceid;
    private String pSourceid;//父类sourceid
    private String appUrl;
    private String appDomainName;
    private Long userId;
    private Byte trustRate;
    private String umcSourceid;  // 与sourceid一一对应，但可以转换为唯一的32位整数

    public String getOpenidRandKey() {
        return openidRandKey;
    }

    public void setOpenidRandKey(String openidRandKey) {
        this.openidRandKey = openidRandKey;
    }

    public String getSourceid() {
        return sourceid;
    }

    public void setSourceid(String sourceid) {
        this.sourceid = sourceid;
    }

    public String getPSourceid() {
        return pSourceid;
    }

    public void setPSourceid(String pSourceid) {
        this.pSourceid = pSourceid;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getAppDomainName() {
        return appDomainName;
    }

    public void setAppDomainName(String appDomainName) {
        this.appDomainName = appDomainName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getTrustRate() {
        return trustRate;
    }

    public void setTrustRate(Byte trustRate) {
        this.trustRate = trustRate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isInternal() {
        return type == TYPE_INTERNAL;
    }

    public boolean isNormal() {
        return status == STATUS_NORMAL;
    }
    
    public String getUmcSourceid() {
        return umcSourceid;
    }

    public void setUmcSourceid(String umcSourceid) {
        this.umcSourceid = umcSourceid;
    }

    @Override
    public String toString() {
        return "Source [id=" + id + ", name=" + name + ", openidRandKey=" + openidRandKey
            + ", key=" + key + ", type=" + type + ", status=" + status + ", developer=" + developer
            + ", createTime=" + createTime + ", updateTime=" + updateTime + ", sourceid="
            + sourceid + ", pSourceid=" + pSourceid + ", umcSourceid=" + umcSourceid + ", appUrl=" + appUrl + ", appDomainName="
            + appDomainName + ", userId=" + userId + ", trustRate=" + trustRate + "]";
    }

}
