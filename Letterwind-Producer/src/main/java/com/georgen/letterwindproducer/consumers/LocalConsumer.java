package com.georgen.letterwindproducer.consumers;

import com.georgen.letterwind.api.annotations.LetterwindConsumer;
import com.georgen.letterwindproducer.model.SampleMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LocalConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(LocalConsumer.class);

    @LetterwindConsumer
    public void receive(String message){
        printMessage(message);
    }

    @LetterwindConsumer
    public void receive(SampleMessage message){
        printMessage(message);
    }

    private void printMessage(Object message){
        LOGGER.info(
                "{} LocalConsumer received a message: {}{} Message type: {}",
                System.lineSeparator(), message,
                System.lineSeparator(), message.getClass().getSimpleName()
        );
    }
}
