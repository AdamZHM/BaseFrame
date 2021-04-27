package com.shdata.ai.meilong.test.kafka.sender.example;

import com.shdata.ai.meilong.test.kafka.sender.example.mapper.DwMetroPsgFlowInfoMapper;
import com.shdata.ai.meilong.test.kafka.sender.example.object.DwMetroPsgFlowInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhufkt
 * @date 2021/4/25
 */

@Slf4j
@Component
public class MeilongTestKafkaSenderExample {

    private KafkaTemplate<Object, Object> m_template;

    private DwMetroPsgFlowInfoMapper dwMetroPsgFlowInfoMapper;

    @Autowired
    public MeilongTestKafkaSenderExample(KafkaTemplate<Object, Object> template, DwMetroPsgFlowInfoMapper dwMetroPsgFlowInfoMapper)
    {
        this.m_template = template;
        this.dwMetroPsgFlowInfoMapper = dwMetroPsgFlowInfoMapper;
    }

    public void sendToKafkaExample() throws InterruptedException {

        String targetTopic = "topic_dw_passenger_flow_features";

        while(true)
        {
            PassengerFlowFeaturesVO passengerFlowFeaturesVO = PassengerFlowFeaturesVO.builder()
                    .city("上海")
                    .location("东兰路")
                    .build();


            log.info("Ready to send message to kafka");
            m_template.send(targetTopic, passengerFlowFeaturesVO);
            log.info("Message to kafka is sent: {}", passengerFlowFeaturesVO);


            Thread.sleep(3000);
        }
    }

    public void sendDwMetroPsgFlowInfoToKafka() throws InterruptedException{
        String topic = "topic_dw_metro_psg_flow_info";

        while(true)
        {
            log.info("Ready to send DwMetroPsgFlowInfow message to kafka");
            List<DwMetroPsgFlowInfoVO> dwMetroPsgFlowInfoVOS = dwMetroPsgFlowInfoMapper.findall();
            for (DwMetroPsgFlowInfoVO dwMetroPsgFlowInfoVO : dwMetroPsgFlowInfoVOS){
                m_template.send(topic, dwMetroPsgFlowInfoVO);
            }
//            log.info("Message to kafka is sent: {}", dwMetroPsgFlowInfoVOS);
            log.info("Message to kafka is sent: {}", dwMetroPsgFlowInfoVOS.size());
            Thread.sleep(3000);
        }
    }

}
