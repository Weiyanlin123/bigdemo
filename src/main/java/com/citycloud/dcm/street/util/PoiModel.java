package com.citycloud.dcm.street.util;

import lombok.Data;

@Data
public class PoiModel {
    private String content;

    private String oldContent;

    private int rowIndex;

    private int cellIndex;

}