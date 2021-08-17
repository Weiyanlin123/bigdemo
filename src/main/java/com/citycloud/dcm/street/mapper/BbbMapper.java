package com.citycloud.dcm.street.mapper;

import com.citycloud.dcm.street.param.Bbb;

public interface BbbMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Bbb record);

    int insertSelective(Bbb record);

    Bbb selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Bbb record);

    int updateByPrimaryKey(Bbb record);
}