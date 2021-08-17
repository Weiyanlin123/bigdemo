package com.citycloud.dcm.street.constant.page;

import io.swagger.annotations.ApiModelProperty;

/**
 * <b> 分页参数
 * <p>
 * 只需要在xml文件中添加start、limit即可，如 ： LIMIT #{start }, #{rows }
 *
 * @author He.hp
 * @version 1.0
 * @date 2019年11月8日 下午2:32:29
 */
public class PageParam {
    private static final int DEFAULT_ROW = 10;

    @ApiModelProperty("第几页（默认1）")
    private int start = 0;

    @ApiModelProperty("每页大小（默认10）")
    private int rows = DEFAULT_ROW;


    public int getStart() {
        return start <= 0 ? 0 : (start - 1) * getRows();
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getRows() {
        return rows <= 0 ? DEFAULT_ROW : rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
