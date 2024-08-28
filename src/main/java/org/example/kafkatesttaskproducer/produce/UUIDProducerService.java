package org.example.kafkatesttaskproducer.produce;

import java.time.LocalTime;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UUIDProducerService {

    private final KafkaTemplate<String, UUID> kafkaTemplateForUUID;

    public void sendUUID(UUID uuid) {
        CompletableFuture<SendResult<String, UUID>> future = kafkaTemplateForUUID.send("uuid_topic", uuid);
        future.whenComplete((result, ex) -> {
            if (ex != null) {
                log.error("ERROR Kafka error happened", ex);
            } else {
                log.info("SUCCESS!!! This is the result: {}", result);
            }
        });
        log.info("Produced UUID - END {} {}", LocalTime.now(), uuid);
    }
}
