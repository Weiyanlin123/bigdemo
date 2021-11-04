package com.citycloud.dcm.street.param;

/**
 * (Aaa)实体类
 *
 * @author makejava
 * @date 2021-09-02 22:08:59
 */


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@ApiModel("$tableInfo.comment")
public class Aaa implements Serializable {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
    //@JsonSerialize(using = DateEditorUtil.class)
    public Date getCreateTime() {
        return createTime;
    }

  //  @JsonDeserialize(using = CustomJsonDateDeserializerUtlls.class)
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @ApiModelProperty("$column.comment")
    private Long id;

    @ApiModelProperty("$column.comment")
    private Integer name;

    @ApiModelProperty("$column.comment")
    private Integer age;

    @ApiModelProperty("$column.comment")
    private String address;

    @ApiModelProperty("$column.comment")
    private Integer score;



//    @JSONField(format ="yyyy-MM-dd HH:mm:ss")
//    @ApiModelProperty("$column.comment")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date createTime;

    @ApiModelProperty("$column.comment")
    private String updateTime;


}