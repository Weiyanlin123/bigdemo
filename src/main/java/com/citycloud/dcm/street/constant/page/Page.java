package com.citycloud.dcm.street.constant.page;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Page<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("第几页（默认1）")
    private int start = 0;
    @ApiModelProperty("页数")
    private int rows = 10;
    @ApiModelProperty("总数")
    private long hits = 0;
    @ApiModelProperty("数据")
    private List<T> data;

    public Page(int start, int rows, long hits, List<T> data) {
        this.start = start;
        this.rows = rows;
        this.hits = hits;
        this.data = data;
    }

    public Page(long hits, List<T> data) {
        this.hits = hits;
        this.data = data;
    }

}
