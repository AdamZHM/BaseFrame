package com.shdata.ai.meilong.test.kafka.sender.example.service;

import java.util.List;
import com.shdata.ai.meilong.test.kafka.sender.example.object.DwMetroPsgFlowInfoVO;
    /**
 * 类名称: DwMetroPsgFlowInfoService
 * 类描述：TODO
 * 创建人：张鸿铭 【zhanghm@shdata.com】
 * 创建时间： 2021/4/27 15:35
 * Copyright (c) 2020 上海市大数据股份有限公司
 * Version 1.0
 **/
public interface DwMetroPsgFlowInfoService {


    int insert(DwMetroPsgFlowInfoVO record);

    int insertSelective(DwMetroPsgFlowInfoVO record);

    int batchInsert(List<DwMetroPsgFlowInfoVO> list);

    List<DwMetroPsgFlowInfoVO> findall();

}
