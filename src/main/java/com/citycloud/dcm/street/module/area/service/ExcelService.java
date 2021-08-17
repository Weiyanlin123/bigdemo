package com.citycloud.dcm.street.module.area.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ExcelService {
    void getExcel(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
