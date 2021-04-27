package com.shdata.ai.meilong.standalone.dataanalysis.conf.logtime;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhufkt
 * @date 2020/11/19
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LoggingTime {
    String value() default "";
}
