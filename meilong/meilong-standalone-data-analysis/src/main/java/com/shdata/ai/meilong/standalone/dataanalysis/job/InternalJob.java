package com.shdata.ai.meilong.standalone.dataanalysis.job;

import com.shdata.ai.meilong.standalone.dataanalysis.conf.logtime.LoggingTime;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.scheduling.config.Task;
import org.springframework.scheduling.support.CronExpression;
import org.springframework.scheduling.support.ScheduledMethodRunnable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * @author zhufkt
 * @date 2020/11/18
 */

@Log4j2
@Component
public class InternalJob {

    final private Environment m_env;
    final private ScheduledAnnotationBeanPostProcessor m_scheduledProcessor;

    @Value("${spring.datasource.druid.url}")
    private String m_jdbcInfo;

    public InternalJob(@Autowired Environment env,
                       @Autowired(required = false) ScheduledAnnotationBeanPostProcessor scheduledProcessor
                        ) {
        this.m_env = env;
        this.m_scheduledProcessor = scheduledProcessor;
    }

    @LoggingTime("定期打印ScheduledJob中所有定时任务CronJob的信息(每 " + S_PRINT_CRON_INFO_FIXED_RATE_MS + " ms)")
    @Scheduled(fixedRate = S_PRINT_CRON_INFO_FIXED_RATE_MS)
    public void printAllScheduledTaskInformation() {
        if (m_scheduledProcessor == null) {
            log.warn("The Scheduled Job is disabled in this project currently");
            return;
        }

        log.info("数据库jdbc信息 {}", m_jdbcInfo);

        Set<ScheduledTask> tasks = m_scheduledProcessor.getScheduledTasks();
        if (tasks == null || tasks.size() == 0) {
            log.warn("There is no task defined in this project currently");
            return;
        }

        int cronJobCount = 0;
        for (ScheduledTask scheduledTask : tasks) {
            Task task = scheduledTask.getTask();

            Method method = ((ScheduledMethodRunnable) task.getRunnable()).getMethod();
            LoggingTime loggingTimeAnnotation = method.getAnnotation(LoggingTime.class);
            String jobName = loggingTimeAnnotation == null ? method.getName() : loggingTimeAnnotation.value();
            jobName = m_env.resolvePlaceholders(jobName);

            if (task instanceof CronTask) {
                CronExpression cronExpression = CronExpression.parse(((CronTask) task).getExpression());
                log.info("CronJob的信息 - 目前在项目拥有的定时任务名称: {}, Cron 定时策略: {}, 下一次执行时间: {}",
                        jobName, cronExpression, cronExpression.next(LocalDateTime.now()));
                cronJobCount++;
            } else {
                log.info("Only Cron Job Defined in the properties could be supported and printed currently. The JobName: {} is not Cron Job", jobName);
            }

        }

        log.info("总共有 {} 个 CronJob 正在运行", cronJobCount);
    }

    private final static int S_PRINT_CRON_INFO_FIXED_RATE_MS = 1200000;


}
