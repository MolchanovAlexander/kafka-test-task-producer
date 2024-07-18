package org.example.kafkatesttaskproducer;

import org.example.kafkatesttaskproducer.config.MyKafkaProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value={MyKafkaProperties.class})
public class KafkaTestTaskProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaTestTaskProducerApplication.class, args);
    }

}
