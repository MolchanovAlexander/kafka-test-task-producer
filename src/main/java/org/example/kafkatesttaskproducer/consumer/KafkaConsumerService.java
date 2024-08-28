package org.example.kafkatesttaskproducer.consumer;

import java.time.LocalTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.kafkatesttaskproducer.config.MyKafkaProperties;
import org.example.kafkatesttaskproducer.model.UserResponseDto;
import org.example.kafkatesttaskproducer.websocket.WebSocketHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final WebSocketHandler webSocketHandler;

    @KafkaListener(
            topics = "hvedya",
            groupId = MyKafkaProperties.CONSUMER_GROUP_ID,
            containerFactory = "containerFactory"
    )
    public void consumeMessage(UserResponseDto response) {
        LocalTime time = LocalTime.now();
        log.info("Response from Queue: {} {}", response, time);

        String message = response.getPassword() != null ? response.toString()
                : response.getFailure() != null ? response.getFailure()
                : response.getId().toString();
        webSocketHandler.sendMessageToAll("Kafka Response: " + message);
    }
}