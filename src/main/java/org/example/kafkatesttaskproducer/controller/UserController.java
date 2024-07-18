package org.example.kafkatesttaskproducer.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.kafkatesttaskproducer.model.UserDto;
import org.example.kafkatesttaskproducer.produce.KafkaProducerService;
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

    @PostMapping("/create")
    public ResponseEntity<String> postJsonMessage(@Valid @RequestBody UserDto user) {
        producerService.sendMessage(user);
        return ResponseEntity.ok("User sent to Kafka.....<<<.....>>>.");
    }
}
