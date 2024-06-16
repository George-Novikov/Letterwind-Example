package com.georgen.letterwindproducer.controller;

import com.georgen.letterwindproducer.model.SampleMessage;
import com.georgen.letterwindproducer.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/message")
public class ProducerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerController.class);

    private ProducerService service;

    public ProducerController(ProducerService service) {
        this.service = service;
    }

    @PostMapping("/send")
    public ResponseEntity sendStringMessage(@RequestParam("message") @NonNull String message){
        try {
            return service.sendStringMessage(message);
        } catch (Exception e){
            LOGGER.info(e.getMessage(), e);
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/send/json")
    public ResponseEntity sendComplexMessage(@RequestBody @NonNull SampleMessage message){
        try {
            return service.sendComplexMessage(message);
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/send/locally")
    public ResponseEntity sendLocally(@RequestParam("message") @NonNull String message){
        try {
            return service.sendWithRouting(message, true);
        } catch (Exception e){
            LOGGER.info(e.getMessage(), e);
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/send/remotely")
    public ResponseEntity sendRemotely(@RequestParam("message") @NonNull String message){
        try {
            return service.sendWithRouting(message, false);
        } catch (Exception e){
            LOGGER.info(e.getMessage(), e);
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/send/{topicName}")
    public ResponseEntity sendToTopic(
            @RequestParam("message") @NonNull String message,
            @PathVariable("topicName") @NonNull String topicName
    ){
        try {
            return service.sendToTopic(message, topicName);
        } catch (Exception e){
            LOGGER.info(e.getMessage(), e);
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
