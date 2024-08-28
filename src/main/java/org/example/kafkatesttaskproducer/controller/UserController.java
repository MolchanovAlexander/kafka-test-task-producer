package org.example.kafkatesttaskproducer.controller;


import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.kafkatesttaskproducer.model.FindUserDto;
import org.example.kafkatesttaskproducer.model.UserDto;
import org.example.kafkatesttaskproducer.model.UserResponseDto;
import org.example.kafkatesttaskproducer.produce.KafkaProducerService;
import org.example.kafkatesttaskproducer.produce.UUIDProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final KafkaProducerService producerService;
    private final UUIDProducerService uuidProducerService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDto user) {
        producerService.sendMessage(user);
        return ResponseEntity.ok("User sent to Kafka.....<<<.....>>>.");
    }

    @PostMapping("/find")
    public ResponseEntity<String> findUser(@Valid @RequestBody FindUserDto userDto) {
        UUID uuid = UUID.fromString(userDto.getUuidRequest());
        uuidProducerService.sendUUID(uuid);
        return ResponseEntity.ok("User sent to Kafka.....<<<.....>>>.");
    }
}
