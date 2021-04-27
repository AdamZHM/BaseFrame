package com.shdata.ai.meilong.standalone.dataanalysis.kafka;

import com.shdata.ai.meilong.standalone.dataanalysis.conf.KafkaConfig;
import com.shdata.ai.meilong.standalone.dataanalysis.object.dataobject.DwMetroPsgFlowInfo;
import com.shdata.ai.meilong.standalone.dataanalysis.object.viewobject.DwMetroPsgFlowInfoVO;
import com.shdata.ai.meilong.standalone.dataanalysis.service.DwMetroPsgFlowInfoService;
import com.shdata.ai.meilong.standalone.dataanalysis.util.JsonUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 类名称: DwMetroPsgFlowInfoKafka
 * 类描述：TODO
 * 创建人：张鸿铭 【zhanghm@shdata.com】
 * 创建时间： 2021/4/27 14:30
 * Copyright (c) 2020 上海市大数据股份有限公司
 * Version 1.0
 **/
@Log4j2
@Component
public class DwMetroPsgFlowInfoKafka {
    private DwMetroPsgFlowInfoService dwMetroPsgFlowInfoService;
    private JsonUtil jsonUtil;

    @Autowired
    public DwMetroPsgFlowInfoKafka(DwMetroPsgFlowInfoService dwMetroPsgFlowInfoService, JsonUtil jsonUtil){
        this.dwMetroPsgFlowInfoService = dwMetroPsgFlowInfoService;
        this.jsonUtil = jsonUtil;
    }

    @KafkaListener(topics = KafkaConfig.S_TOPIC_DW_METRO_PASSENGER_FLOW_INFO, groupId = KafkaConfig.S_IMPORT_MEILONG_DATA_TO_DATABASE_CONSUME_GROUP_ID)
    public void receiveDwMetroPsgFlowInfoFromKafka(String jsonString){
        log.info("receiveDwMetroPsgFlowInfoFromKafka - receive jsonString from Kafka - {}", jsonString);

        DwMetroPsgFlowInfoVO dwMetroPsgFlowInfoVO = jsonUtil.stringToObject(jsonString, DwMetroPsgFlowInfoVO.class);
        DwMetroPsgFlowInfo dwMetroPsgFlowInfo = new DwMetroPsgFlowInfo();
        BeanUtils.copyProperties(dwMetroPsgFlowInfoVO, dwMetroPsgFlowInfo);
        dwMetroPsgFlowInfoService.insertSelective(dwMetroPsgFlowInfo);
        log.info("receiveDwMetroPsgFlowInfoFromKafka - Done");
    }
}
