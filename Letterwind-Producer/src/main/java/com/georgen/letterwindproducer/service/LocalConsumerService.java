package com.georgen.letterwindproducer.service;

import com.georgen.letterwind.api.annotations.LetterwindConsumer;
import com.georgen.letterwind.api.annotations.LetterwindMessage;
import com.georgen.letterwindproducer.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalConsumerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocalConsumerService.class);

    @LetterwindConsumer
    public void receive(String message){
        LOGGER.info("Message received: {}", message);
    }

    @LetterwindConsumer
    public void receive(Message message){
        LOGGER.info("Message received: {}", message);
    }
}
