package com.shdata.ai.meilong.standalone.dataanalysis.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.shdata.ai.meilong.standalone.dataanalysis.object.dataobject.OdsMetroStationInfo;
import com.shdata.ai.meilong.standalone.dataanalysis.mapper.OdsMetroStationInfoMapper;
import com.shdata.ai.meilong.standalone.dataanalysis.service.OdsMetroStationInfoService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 类名称: OdsMetroStationInfoServiceImpl
 * 类描述：TODO
 * 创建人：张鸿铭 【zhanghm@shdata.com】
 * 创建时间： 2021/4/23 16:35
 * Copyright (c) 2020 上海市大数据股份有限公司
 * Version 1.0
 **/
@Service
@Transactional(rollbackFor=Exception.class)
public class OdsMetroStationInfoServiceImpl implements OdsMetroStationInfoService{

    @Resource
    private OdsMetroStationInfoMapper odsMetroStationInfoMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return odsMetroStationInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OdsMetroStationInfo record) {
        return odsMetroStationInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(OdsMetroStationInfo record) {
        return odsMetroStationInfoMapper.insertSelective(record);
    }

    @Override
    public OdsMetroStationInfo selectByPrimaryKey(Long id) {
        return odsMetroStationInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OdsMetroStationInfo record) {
        return odsMetroStationInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OdsMetroStationInfo record) {
        return odsMetroStationInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<OdsMetroStationInfo> list) {
        return odsMetroStationInfoMapper.batchInsert(list);
    }

    @Override
    public List<OdsMetroStationInfo> findAllByCity(String city) {
        return odsMetroStationInfoMapper.findAllByCity(city);
    }

}
