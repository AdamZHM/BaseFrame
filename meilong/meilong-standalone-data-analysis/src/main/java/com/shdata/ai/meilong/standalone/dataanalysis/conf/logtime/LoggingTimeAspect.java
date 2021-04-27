package com.shdata.ai.meilong.standalone.dataanalysis.conf.logtime;

/**
 * @author zhufkt
 * @date 2020/11/19
 */


//reference on https://medium.com/@kanhu.aum/log-the-method-execution-time-using-aop-for-a-spring-boot-application-c90e85b4d3b9

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Log4j2
public class LoggingTimeAspect {

    private Environment env;

    @Autowired
    public LoggingTimeAspect(Environment env)
    {
        this.env = env;
    }

    @Around("@annotation(loggingTime)")
    public Object methodTimeLogger(ProceedingJoinPoint proceedingJoinPoint,
                                   LoggingTime loggingTime) throws Throwable {

        String taskName = loggingTime == null ? "Warning: Empty task name" : env.resolvePlaceholders(loggingTime.value());

        log.info("LoggingTime: (Start) Task {} ", taskName);

        StopWatch stopWatch = new StopWatch(taskName);

        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        log.info("LoggingTime: (End) Task {} took {} ms", taskName,
                stopWatch.getTotalTimeMillis());


        return result;
    }
}