package com.citycloud.dcm.street.mapper;


import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


public interface UserMapper {
    List<Map<String,Object>> findAll();
}
