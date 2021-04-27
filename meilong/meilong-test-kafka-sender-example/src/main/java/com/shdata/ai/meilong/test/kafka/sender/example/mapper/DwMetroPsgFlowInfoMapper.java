package com.shdata.ai.meilong.test.kafka.sender.example.mapper;

import com.shdata.ai.meilong.test.kafka.sender.example.object.DwMetroPsgFlowInfoVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 类名称: DwMetroPsgFlowInfoMapper
 * 类描述：TODO
 * 创建人：张鸿铭 【zhanghm@shdata.com】
 * 创建时间： 2021/4/27 15:35
 * Copyright (c) 2020 上海市大数据股份有限公司
 * Version 1.0
 **/
@Mapper
public interface DwMetroPsgFlowInfoMapper {
    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(DwMetroPsgFlowInfoVO record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(DwMetroPsgFlowInfoVO record);

    int batchInsert(@Param("list") List<DwMetroPsgFlowInfoVO> list);

    List<DwMetroPsgFlowInfoVO> findall();
}