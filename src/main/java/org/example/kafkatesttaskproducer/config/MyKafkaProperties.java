package org.example.kafkatesttaskproducer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("mykafka")
public class MyKafkaProperties {
    public static final String CONSUMER_GROUP_ID = "mikesconsumergroup";
    private String bootstrapAddress;
}
