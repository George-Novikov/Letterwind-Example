package com.georgen.letterwindproducer.controller;

import com.georgen.letterwindproducer.model.Message;
import com.georgen.letterwindproducer.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/broadcasting")
public class ProducerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerController.class);

    private ProducerService service;

    public ProducerController(ProducerService service) {
        this.service = service;
    }

    @PostMapping("/sendString")
    public ResponseEntity sendSimpleMessage(
            @RequestParam(name = "message", defaultValue = "") String message
    ){
        try {
            return service.sendSimpleMessage(message);
        } catch (Exception e){
            LOGGER.info(e.getMessage(), e);
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/send")
    public ResponseEntity sendComplexMessage(
            @RequestBody Message message
    ){
        try {
            return service.sendComplexMessage(message);
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
