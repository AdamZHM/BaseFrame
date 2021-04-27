package com.shdata.ai.meilong.standalone.dataanalysis.service.impl;

import com.shdata.ai.meilong.standalone.dataanalysis.object.viewobject.TrafficEntityVO;
import com.shdata.ai.meilong.standalone.dataanalysis.object.viewobject.WeatherEntityVO;
import com.shdata.ai.meilong.standalone.dataanalysis.util.RestUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import com.shdata.ai.meilong.standalone.dataanalysis.mapper.DwTrafficStatusInfoMapper;
import com.shdata.ai.meilong.standalone.dataanalysis.object.dataobject.DwTrafficStatusInfo;
import com.shdata.ai.meilong.standalone.dataanalysis.service.DwTrafficStatusInfoService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 类名称: DwTrafficStatusInfoServiceImpl
 * 类描述：TODO
 * 创建人：张鸿铭 【zhanghm@shdata.com】
 * 创建时间： 2021/4/23 10:01
 * Copyright (c) 2020 上海市大数据股份有限公司
 * Version 1.0
 **/
@Service
@Transactional(rollbackFor=Exception.class)
public class DwTrafficStatusInfoServiceImpl implements DwTrafficStatusInfoService{
    private final String API_KEY = "fd52c5c9c3f4b123d14e553ea0d5b9e7";

    @Autowired
    RestUtil restUtil;

    @Resource
    private DwTrafficStatusInfoMapper dwTrafficStatusInfoMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return dwTrafficStatusInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DwTrafficStatusInfo record) {
        return dwTrafficStatusInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(DwTrafficStatusInfo record) {
        return dwTrafficStatusInfoMapper.insertSelective(record);
    }

    @Override
    public DwTrafficStatusInfo selectByPrimaryKey(Long id) {
        return dwTrafficStatusInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DwTrafficStatusInfo record) {
        return dwTrafficStatusInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DwTrafficStatusInfo record) {
        return dwTrafficStatusInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<DwTrafficStatusInfo> list) {
        return dwTrafficStatusInfoMapper.batchInsert(list);
    }

    @Override
    public void insertTrafficStatusInfo(String roadName, String addressCode, String cityName) {
        DwTrafficStatusInfo dwTrafficStatusInfo = new DwTrafficStatusInfo();

        String trafficUrl = "https://restapi.amap.com/v3/traffic/status/road?key=" + API_KEY + "&name=" + roadName + "&city=" + cityName;
        TrafficEntityVO trafficData = restUtil.get(trafficUrl, new ParameterizedTypeReference<TrafficEntityVO>() {});
        TrafficEntityVO.TrafficinfoBean trafficInfoBean = trafficData.getTrafficinfo();
        TrafficEntityVO.TrafficinfoBean.EvaluationBean evaluationBean = trafficInfoBean.getEvaluation();
        BeanUtils.copyProperties(evaluationBean, dwTrafficStatusInfo);
        dwTrafficStatusInfo.setLocation(roadName);
        dwTrafficStatusInfo.setTrafficDesc(trafficInfoBean.getDescription());

        String weatherUrl = "https://restapi.amap.com/v3/weather/weatherInfo?key=" + API_KEY + "&city=" + addressCode;
        WeatherEntityVO weatherEntity = restUtil.get(weatherUrl, new ParameterizedTypeReference<WeatherEntityVO>() {});
        WeatherEntityVO.LivesBean livesBean = weatherEntity.getLives().get(0);
        BeanUtils.copyProperties(livesBean, dwTrafficStatusInfo);
        dwTrafficStatusInfo.setCreateTime(new Date());
        dwTrafficStatusInfo.setUpdateTime(new Date());

        this.insert(dwTrafficStatusInfo);
    }

}
