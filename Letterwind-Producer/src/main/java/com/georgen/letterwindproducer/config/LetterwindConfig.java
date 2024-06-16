package com.georgen.letterwindproducer.config;

import com.georgen.letterwind.api.LetterwindTopic;
import com.georgen.letterwindproducer.consumers.LocalConsumer;
import com.georgen.letterwindproducer.consumers.RemoteConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LetterwindConfig {
    @Bean("localTopic")
    public LetterwindTopic localTopic() throws Exception {
        return LetterwindTopic.builder()
                .name("LocalTopic")
                .consumer(LocalConsumer.class)
                .activate();
    }

    @Bean("remoteTopic")
    public LetterwindTopic remoteTopic() throws Exception {
        return LetterwindTopic.builder()
                .name("RemoteTopic")
                .consumer(RemoteConsumer.class)
                .remoteHost("127.0.0.1")
                .remotePort(8081)
                .activate();
    }
}
