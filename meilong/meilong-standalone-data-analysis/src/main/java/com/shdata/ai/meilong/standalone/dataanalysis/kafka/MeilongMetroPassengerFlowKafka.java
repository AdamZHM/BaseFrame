package com.shdata.ai.meilong.standalone.dataanalysis.kafka;

import com.shdata.ai.meilong.standalone.dataanalysis.conf.KafkaConfig;
import com.shdata.ai.meilong.standalone.dataanalysis.object.viewobject.PassengerFlowFeaturesVO;
import com.shdata.ai.meilong.standalone.dataanalysis.service.DwPassengerFlowFeaturesService;
import com.shdata.ai.meilong.standalone.dataanalysis.util.JsonUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author zhufkt
 * @date 2021/4/22
 */

@Log4j2
@Component
public class MeilongMetroPassengerFlowKafka {

    private DwPassengerFlowFeaturesService m_dwPassengerFlowFeaturesService;
    private JsonUtil m_jsonUtil;

    @Autowired
    public MeilongMetroPassengerFlowKafka(DwPassengerFlowFeaturesService dwPassengerFlowFeaturesService,
                                          JsonUtil jsonUtil)
    {
        this.m_dwPassengerFlowFeaturesService = dwPassengerFlowFeaturesService;
        this.m_jsonUtil = jsonUtil;
    }

    @KafkaListener(topics = KafkaConfig.S_TOPIC_DW_PASSENGER_FLOW_FEATURES,
            groupId = KafkaConfig.S_IMPORT_MEILONG_DATA_TO_DATABASE_CONSUME_GROUP_ID)
    public void receiveFromKafkaExample(String jsonString)
    {
        log.info("receiveFromKafkaExample - Receive jsonString from Kafka - {}", jsonString);

        PassengerFlowFeaturesVO passengerFlowFeaturesVO =
                m_jsonUtil.stringToObject(jsonString, PassengerFlowFeaturesVO.class);
        m_dwPassengerFlowFeaturesService.insertSelective(passengerFlowFeaturesVO);

        log.info("receiveFromKafkaExample - Done");
        return;
    }

}
