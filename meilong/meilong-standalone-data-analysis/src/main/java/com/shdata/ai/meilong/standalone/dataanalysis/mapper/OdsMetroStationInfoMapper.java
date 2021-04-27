package com.shdata.ai.meilong.standalone.dataanalysis.mapper;

import com.shdata.ai.meilong.standalone.dataanalysis.object.dataobject.OdsMetroStationInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 类名称: OdsMetroStationInfoMapper
 * 类描述：TODO
 * 创建人：张鸿铭 【zhanghm@shdata.com】
 * 创建时间： 2021/4/23 16:35
 * Copyright (c) 2020 上海市大数据股份有限公司
 * Version 1.0
 **/
@Mapper
public interface OdsMetroStationInfoMapper {
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
    int insert(OdsMetroStationInfo record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(OdsMetroStationInfo record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    OdsMetroStationInfo selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(OdsMetroStationInfo record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(OdsMetroStationInfo record);

    int batchInsert(@Param("list") List<OdsMetroStationInfo> list);

    List<OdsMetroStationInfo> findAllByCity(@Param("city")String city);


}