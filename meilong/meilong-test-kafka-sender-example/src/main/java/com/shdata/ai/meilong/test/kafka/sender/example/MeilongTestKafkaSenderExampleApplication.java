package com.shdata.ai.meilong.test.kafka.sender.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class MeilongTestKafkaSenderExampleApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context =
                SpringApplication.run(MeilongTestKafkaSenderExampleApplication.class, args);

        MeilongTestKafkaSenderExample sender = context.getBean(MeilongTestKafkaSenderExample.class);
//        sender.sendToKafkaExample();
        sender.sendDwMetroPsgFlowInfoToKafka();
    }




}
