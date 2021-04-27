package com.shdata.ai.meilong.standalone.dataanalysis.conf;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.TopicPartition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.listener.ConsumerRecordRecoverer;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

/**
 * @author zhufkt
 * @date 2021/4/22
 */


@Log4j2
@Configuration
public class KafkaConfig {


    public final static String S_TOPIC_DW_PASSENGER_FLOW_FEATURES = "topic_dw_passenger_flow_features";

    @Bean
    public NewTopic createTopicDwPassengerFlowFeatures() {
        return new NewTopic(S_TOPIC_DW_PASSENGER_FLOW_FEATURES, S_GLOBAL_NUM_PARTITIONS, S_REPLICATION_FACTOR);
    }

    public final static String S_TOPIC_DW_METRO_PASSENGER_FLOW_INFO = "topic_dw_metro_psg_flow_info";

    @Bean
    public NewTopic createTopicDwMetroPassengerFlowInfo() {
        return new NewTopic(S_TOPIC_DW_METRO_PASSENGER_FLOW_INFO, S_GLOBAL_NUM_PARTITIONS, S_REPLICATION_FACTOR);
    }

    @Bean
    ErrorHandler errorHandler(KafkaOperations<?, ?> kafkaOperations) {
        // https://blog.csdn.net/yangshangwei/article/details/113846000
        // https://kagamihoge.hatenablog.com/entry/2021/01/07/220218
        // https://stackoverflow.com/questions/63301785/unable-to-send-messages-to-dead-letter-topic-from-consumer-in-kafka

        ConsumerRecordRecoverer recoverer = new DeadLetterPublishingRecoverer(
                    kafkaOperations,
                    (cr, e) ->
                    {
                        String dltTopic = getDefaultDeadLetterTopic(cr.topic());
                        log.error(
                                "Error when processing the message from kafka: {}. Sending the message to the dead letter topic: {}.",
                                cr.toString(),
                                dltTopic,
                                e
                        );
                        // If the returned TopicPartition has a negative partition, the partition is not set in the ProducerRecord, so the partition is selected by Kafka.
                        // https://stackoverflow.com/questions/57309027/how-can-we-use-deadletterpublishingrecoverer-with-retrytemplate
                        return new TopicPartition(dltTopic, -1 );
                    }
                );

        return new SeekToCurrentErrorHandler(
                recoverer,
                new FixedBackOff(0, 0)
        );
    }

    private String getDefaultDeadLetterTopic(String topic)
    {
        //DLT means "dead letter topic"
        return topic + ".DLT";
    }

    public final static int S_GLOBAL_NUM_PARTITIONS = 3;
    public final static short S_REPLICATION_FACTOR = 3;

    public final static String S_IMPORT_MEILONG_DATA_TO_DATABASE_CONSUME_GROUP_ID =
            "import_meilong_data_to_database_consume_group_id";
}
