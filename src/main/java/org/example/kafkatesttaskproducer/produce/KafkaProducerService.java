package org.example.kafkatesttaskproducer.produce;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.kafkatesttaskproducer.model.UserDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerService {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(UserDto userDto) {
        CompletableFuture<SendResult<String, Object>> mike = kafkaTemplate.send("mike", userDto);
        mike.whenComplete((result, ex) -> {
            if (ex != null) {
                log.error("ERROR Kafka error happened", ex);
            } else {
                log.info("SUCCESS!!! This is the result: {}", result);
            }
        });
        log.info("Produce Message - END {} {}", LocalTime.now(), userDto);
    }
}
