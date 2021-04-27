package com.shdata.ai.meilong.standalone.dataanalysis.service;

import java.util.List;
import com.shdata.ai.meilong.standalone.dataanalysis.object.dataobject.OdsMetroStationInfo;
import org.apache.ibatis.annotations.Param;

/**
 * 类名称: OdsMetroStationInfoService
 * 类描述：TODO
 * 创建人：张鸿铭 【zhanghm@shdata.com】
 * 创建时间： 2021/4/23 16:35
 * Copyright (c) 2020 上海市大数据股份有限公司
 * Version 1.0
 **/
public interface OdsMetroStationInfoService{


    int deleteByPrimaryKey(Long id);

    int insert(OdsMetroStationInfo record);

    int insertSelective(OdsMetroStationInfo record);

    OdsMetroStationInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OdsMetroStationInfo record);

    int updateByPrimaryKey(OdsMetroStationInfo record);

    int batchInsert(List<OdsMetroStationInfo> list);

    List<OdsMetroStationInfo> findAllByCity(String city);
}
