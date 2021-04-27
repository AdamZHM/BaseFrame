package com.shdata.ai.meilong.standalone.dataanalysis.service;

import java.util.List;
import com.shdata.ai.meilong.standalone.dataanalysis.object.dataobject.DwMetroPsgFlowInfo;

/**
 * 类名称: DwMetroPsgFlowInfoService
 * 类描述：TODO
 * 创建人：张鸿铭 【zhanghm@shdata.com】
 * 创建时间： 2021/4/27 13:39
 * Copyright (c) 2020 上海市大数据股份有限公司
 * Version 1.0
 **/
public interface DwMetroPsgFlowInfoService {


    int deleteByPrimaryKey(Long id);

    int insert(DwMetroPsgFlowInfo record);

    int insertSelective(DwMetroPsgFlowInfo record);

    DwMetroPsgFlowInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DwMetroPsgFlowInfo record);

    int updateByPrimaryKey(DwMetroPsgFlowInfo record);

    int batchInsert(List<DwMetroPsgFlowInfo> list);

}

