package com.shdata.ai.meilong.standalone.dataanalysis.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.shdata.ai.meilong.standalone.dataanalysis.mapper.DwMetroPsgFlowInfoMapper;
import com.shdata.ai.meilong.standalone.dataanalysis.object.dataobject.DwMetroPsgFlowInfo;
import com.shdata.ai.meilong.standalone.dataanalysis.service.DwMetroPsgFlowInfoService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 类名称: DwMetroPsgFlowInfoServiceImpl
 * 类描述：TODO
 * 创建人：张鸿铭 【zhanghm@shdata.com】
 * 创建时间： 2021/4/27 13:39
 * Copyright (c) 2020 上海市大数据股份有限公司
 * Version 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class DwMetroPsgFlowInfoServiceImpl implements DwMetroPsgFlowInfoService {

    @Resource
    private DwMetroPsgFlowInfoMapper dwMetroPsgFlowInfoMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return dwMetroPsgFlowInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DwMetroPsgFlowInfo record) {
        return dwMetroPsgFlowInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(DwMetroPsgFlowInfo record) {
        return dwMetroPsgFlowInfoMapper.insertSelective(record);
    }

    @Override
    public DwMetroPsgFlowInfo selectByPrimaryKey(Long id) {
        return dwMetroPsgFlowInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DwMetroPsgFlowInfo record) {
        return dwMetroPsgFlowInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DwMetroPsgFlowInfo record) {
        return dwMetroPsgFlowInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<DwMetroPsgFlowInfo> list) {
        return dwMetroPsgFlowInfoMapper.batchInsert(list);
    }

}

