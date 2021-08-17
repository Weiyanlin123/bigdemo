package com.citycloud.dcm.street.mapper;

import com.citycloud.dcm.street.param.InputCityOperationLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public interface InputCityOperationLogMapper {
    void insertForeach(@Param("list") ArrayList<InputCityOperationLog> list) ;

    InputCityOperationLog findbyNameAndDateValue(@Param("name") String name, @Param("dateValue") String dateValue);

    List<InputCityOperationLog> findbyDateValue(@Param("dateValue") String dateValue);

    List<Map<String,Object>> findGroupByDateValue(@Param("page") Integer page, @Param("size") Integer size);

    Integer findCount();

    List<Map<String,Object>> findByDateValueStartAndEnd(@Param("startDate") String startDate, @Param("endDate") String endDate);

    Integer findCountStartAndEnd(@Param("startDate") String startDate, @Param("endDate") String endDate);
}
