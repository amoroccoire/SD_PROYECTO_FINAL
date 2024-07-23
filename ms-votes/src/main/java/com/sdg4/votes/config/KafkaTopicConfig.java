package com.sdg4.votes.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic generateTopic() {
        Map<String, String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE); //delete borra, compact mantiene el mas actual
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000"); //tiempo de duracion del mensaje, 1 dia, por defecto es -1 sino no se borra
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); //maximo de bytes del segmento, default es 1GB
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012"); //maximo del tamaño del mensaje en bytes, defalut es 1

        return TopicBuilder.name("votes-topic")
                .partitions(2)
                .replicas(3)
                .configs(configurations)
                .build();
    }
}
