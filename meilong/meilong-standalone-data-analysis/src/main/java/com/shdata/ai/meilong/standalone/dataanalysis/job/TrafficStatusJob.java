package com.shdata.ai.meilong.standalone.dataanalysis.job;

import com.shdata.ai.meilong.standalone.dataanalysis.conf.logtime.LoggingTime;
import com.shdata.ai.meilong.standalone.dataanalysis.object.dataobject.DwTrafficStatusInfo;
import com.shdata.ai.meilong.standalone.dataanalysis.object.dataobject.OdsMetroStationInfo;
import com.shdata.ai.meilong.standalone.dataanalysis.service.DwTrafficStatusInfoService;
import com.shdata.ai.meilong.standalone.dataanalysis.service.OdsMetroStationInfoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * 类名称: TrafficStatusJob
 * 类描述：TODO
 * 创建人：张鸿铭 【zhanghm@shdata.com】
 * 创建时间： 2021/4/23 15:40
 * Copyright (c) 2020 上海市大数据股份有限公司
 * Version 1.0
 **/
@Component
@Log4j2
@PropertySource(value = "${schedule.info}", ignoreResourceNotFound = true, encoding = "utf-8")
public class TrafficStatusJob {
    @Autowired
    OdsMetroStationInfoService odsMetroStationInfoService;

    @Autowired
    DwTrafficStatusInfoService dwTrafficStatusInfoService;

    @LoggingTime("${trafficStatusInfo.name:天气交通态势数据}")
    @Scheduled(cron = "${trafficStatusInfo.cron:-}")
    public void saveTrafficStatus () throws IOException {
        List<OdsMetroStationInfo> odsMetroStationInfoList = odsMetroStationInfoService.findAllByCity("上海市");
        for (OdsMetroStationInfo o : odsMetroStationInfoList){
            String roadName = o.getLocation();
            String addressCode = o.getAddressCode();
            String cityName = o.getCity();
            dwTrafficStatusInfoService.insertTrafficStatusInfo(roadName, addressCode, cityName);
        }
    }
}
