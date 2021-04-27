package com.shdata.ai.meilong.test.kafka.sender.example.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.shdata.ai.meilong.test.kafka.sender.example.mapper.DwMetroPsgFlowInfoMapper;
import com.shdata.ai.meilong.test.kafka.sender.example.object.DwMetroPsgFlowInfoVO;
import com.shdata.ai.meilong.test.kafka.sender.example.service.DwMetroPsgFlowInfoService;
/**
 * 类名称: DwMetroPsgFlowInfoServiceImpl
 * 类描述：TODO
 * 创建人：张鸿铭 【zhanghm@shdata.com】
 * 创建时间： 2021/4/27 15:35
 * Copyright (c) 2020 上海市大数据股份有限公司
 * Version 1.0
 **/
@Service
public class DwMetroPsgFlowInfoServiceImpl implements DwMetroPsgFlowInfoService{

    @Resource
    private DwMetroPsgFlowInfoMapper dwMetroPsgFlowInfoMapper;

    @Override
    public int insert(DwMetroPsgFlowInfoVO record) {
        return dwMetroPsgFlowInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(DwMetroPsgFlowInfoVO record) {
        return dwMetroPsgFlowInfoMapper.insertSelective(record);
    }

    @Override
    public int batchInsert(List<DwMetroPsgFlowInfoVO> list) {
        return dwMetroPsgFlowInfoMapper.batchInsert(list);
    }

    @Override
    public List<DwMetroPsgFlowInfoVO> findall() {
        return dwMetroPsgFlowInfoMapper.findall();
    }
}
