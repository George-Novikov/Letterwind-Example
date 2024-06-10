package com.georgen.letterwindproducer.config;

import com.georgen.letterwind.api.LetterwindControls;
import com.georgen.letterwind.api.LetterwindTopic;
import com.georgen.letterwindproducer.service.LocalConsumerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LetterwindConfiguration {
    @Bean("localTopic")
    public LetterwindTopic localTopic() throws Exception {
        LetterwindTopic topic = LetterwindTopic.build()
                .setName("LocalTopic")
                .addConsumer(LocalConsumerService.class);

        LetterwindControls.set().topic(topic);

        return topic;
    }
}
