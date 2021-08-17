package com.citycloud.dcm.street.mapper;

import com.citycloud.dcm.street.param.Aaa;

public interface AaaMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Aaa record);

    int insertSelective(Aaa record);

    Aaa selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Aaa record);

    int updateByPrimaryKey(Aaa record);
}