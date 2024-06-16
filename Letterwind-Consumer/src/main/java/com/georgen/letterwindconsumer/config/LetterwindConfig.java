package com.georgen.letterwindconsumer.config;

import com.georgen.letterwind.api.LetterwindControls;
import com.georgen.letterwind.api.LetterwindTopic;
import com.georgen.letterwindconsumer.consumer.RemoteConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** This is the minimum configuration for receiving incoming remote messages */
@Configuration
public class LetterwindConfig {
    @Bean
    public LetterwindTopic topic() throws Exception {
        LetterwindTopic topic = LetterwindTopic.builder()
                .name("RemoteTopic")
                .consumer(RemoteConsumer.class)
                .activate();

        LetterwindControls.set()
                .serverPort(8081)
                .serverActive(true);

        return topic;
    }
}
