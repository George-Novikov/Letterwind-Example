package com.georgen.letterwindconsumer.consumer;

import com.georgen.letterwind.api.annotations.LetterwindConsumer;
import com.georgen.letterwindconsumer.model.SampleMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class does NOT need to be marked with the @Component annotation.
 * Letterwind itself will create an instance of this class.
 * */
public class RemoteConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(RemoteConsumer.class);

    @LetterwindConsumer
    public void receive(String message){ printMessage(message); }

    @LetterwindConsumer
    public void receive(SampleMessage message){
        printMessage(message);
    }

    private void printMessage(Object message){
        LOGGER.info(
                "{} RemoteConsumer received a message: {}{} Message type: {}",
                System.lineSeparator(), message,
                System.lineSeparator(), message.getClass().getSimpleName()
        );
    }
}
