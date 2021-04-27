package com.shdata.ai.meilong.standalone.dataanalysis.job;

import com.shdata.ai.meilong.standalone.dataanalysis.conf.logtime.LoggingTime;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author zhufkt
 * @date 2021/4/21
 */

@Log4j2
@Component
@PropertySource(value = "${schedule.info}", ignoreResourceNotFound = true, encoding = "utf-8")
public class MeilongMetroPassengerFlowJob {

    @LoggingTime("${predictMeilongMetroPassengerFlowData.name:预测梅陇地铁客流数据}")
    @Scheduled(cron = "${predictMeilongMetroPassengerFlowData.cron:-}")
    public void predictMeilongMetroPassengerFlowData() {

    }



}
