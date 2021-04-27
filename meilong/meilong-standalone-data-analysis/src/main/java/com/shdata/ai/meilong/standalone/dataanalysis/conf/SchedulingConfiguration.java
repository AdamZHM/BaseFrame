package com.shdata.ai.meilong.standalone.dataanalysis.conf;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zhufkt
 * @date 2020/11/19
 */

@Configuration
@EnableScheduling
@ConditionalOnProperty(prefix = "scheduling", name="enabled", havingValue="true", matchIfMissing = true)
public class SchedulingConfiguration {

}
