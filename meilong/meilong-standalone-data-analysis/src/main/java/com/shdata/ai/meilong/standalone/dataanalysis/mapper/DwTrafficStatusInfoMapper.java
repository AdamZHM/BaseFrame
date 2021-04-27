package com.shdata.ai.meilong.standalone.dataanalysis.mapper;

import com.shdata.ai.meilong.standalone.dataanalysis.object.dataobject.DwTrafficStatusInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 类名称: DwTrafficStatusInfoMapper
 * 类描述：TODO
 * 创建人：张鸿铭 【zhanghm@shdata.com】
 * 创建时间： 2021/4/23 10:01
 * Copyright (c) 2020 上海市大数据股份有限公司
 * Version 1.0
 **/
@Mapper
@Repository
public interface DwTrafficStatusInfoMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(DwTrafficStatusInfo record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(DwTrafficStatusInfo record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    DwTrafficStatusInfo selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(DwTrafficStatusInfo record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(DwTrafficStatusInfo record);

    int batchInsert(@Param("list") List<DwTrafficStatusInfo> list);
}