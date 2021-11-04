package com.citycloud.dcm.street.mapper;

import com.citycloud.dcm.street.param.Aaa;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Aaa)表数据库访问层
 *
 * @author makejava
 * @date 2021-09-02 22:12:21
 */
@Repository("aaaMapper")
public interface AaaMapper {

    /**
     * 新增数据
     *
     * @param aaa 实例对象
     * @return 影响行数
     */
    int insert(Aaa aaa);

    /**
     * 修改数据
     *
     * @param aaa 实例对象
     * @return 影响行数
     */
    int update(Aaa aaa);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Aaa queryById(Long id);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param aaa 实例对象
     * @return 对象列表
     */
    List<Aaa> queryAll(Aaa aaa);

    /**
     * 分页总数
     *
     * @return 对象列表
     */
    int queryCountByPage();


    /**
     * 分页列表
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Aaa> queryListByPage(@Param("offset") int offset, @Param("limit") int limit);


}