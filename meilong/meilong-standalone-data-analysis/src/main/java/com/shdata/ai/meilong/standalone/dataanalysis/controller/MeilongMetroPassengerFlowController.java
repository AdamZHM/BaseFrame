package com.shdata.ai.meilong.standalone.dataanalysis.controller;

import com.shdata.ai.meilong.standalone.dataanalysis.conf.KafkaConfig;
import com.shdata.ai.meilong.standalone.dataanalysis.object.viewobject.PassengerFlowFeaturesVO;
import com.shdata.ai.meilong.standalone.dataanalysis.service.DwPassengerFlowFeaturesService;
import com.shdata.ai.meilong.standalone.dataanalysis.util.JsonUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhufkt
 * @date 2021/4/21
 */


@Log4j2
@RestController
@RequestMapping("/api")
public class MeilongMetroPassengerFlowController {


    private DwPassengerFlowFeaturesService m_dwPassengerFlowFeaturesService;
    private KafkaTemplate<String, String> m_template;
    private JsonUtil m_jsonUtil;

    @Autowired
    public MeilongMetroPassengerFlowController(DwPassengerFlowFeaturesService dwPassengerFlowFeaturesService,
                                               KafkaTemplate<String, String> template,
                                               JsonUtil jsonUtil)
    {
        this.m_dwPassengerFlowFeaturesService = dwPassengerFlowFeaturesService;
        this.m_template = template;
        this.m_jsonUtil = jsonUtil;
    }

    @GetMapping(value = "selectFromDataBaseExample", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public PassengerFlowFeaturesVO selectFromDataBaseExample() {
        return m_dwPassengerFlowFeaturesService.selectByPrimaryKey(1L);
    }


    @GetMapping(value = "insertIntoKafkaExample", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String insertIntoKafkaExample() {

        PassengerFlowFeaturesVO passengerFlowFeaturesVO = m_dwPassengerFlowFeaturesService.selectByPrimaryKey(1L);
        String jsonString = m_jsonUtil.objectToString(passengerFlowFeaturesVO);

        m_template.send(KafkaConfig.S_TOPIC_DW_PASSENGER_FLOW_FEATURES, jsonString);

        return "success";
    }

}
