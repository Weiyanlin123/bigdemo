package com.citycloud.dcm.street.module.area.service.impl;

import com.citycloud.dcm.street.module.area.service.TestAService;
import com.citycloud.dcm.street.module.area.service.TestBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author weiyl
 * @date 2021/9/12 12:27
 */
@Service
public class TestAServiceIImpl implements TestAService {
    @Autowired
    private TestBService testBService;

    @Override
    public String getA() {
        return testBService.getB();
    }

    @Override
    public String getC() {
        return "c";
    }
}
