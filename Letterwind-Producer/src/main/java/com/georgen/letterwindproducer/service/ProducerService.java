package com.georgen.letterwindproducer.service;

import com.georgen.letterwind.api.Letterwind;
import com.georgen.letterwind.api.LetterwindTopic;
import com.georgen.letterwindproducer.model.SampleMessage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class ProducerService {
    private static final Random RANDOM = new Random();
    private LetterwindTopic localTopic;
    private LetterwindTopic remoteTopic;

    private ProducerService(
            @Qualifier("localTopic") LetterwindTopic localTopic,
            @Qualifier("remoteTopic") LetterwindTopic remoteTopic
    ){
        this.localTopic = localTopic;
        this.remoteTopic = remoteTopic;
    }

    /**
     * This is a "fan-out" distribution when the message is sent to all topics with this message type.
     * RemoteTopic won't receive anything because its descriptor class doesn't have a method of type String.
     * */
    public ResponseEntity sendStringMessage(String message) throws Exception {
        Letterwind.send(message);
        return ResponseEntity.ok("Message sent successfully: " + message);
    }

    /**
     * This is a "fan-out" distribution when the message is sent to all topics with this message type.
     * The SampleMessage object will be received by both LocalTopic and RemoteTopic.
     * */
    public ResponseEntity sendComplexMessage(SampleMessage message) throws Exception {
        message.setId(RANDOM.nextInt());
        message.setCreationDate(LocalDateTime.now());
        Letterwind.send(message);
        return ResponseEntity.ok("Message sent successfully: " + message);
    }

    /**
     * Topic-related distribution: you can pass the topic object itself to route the message.
     * In this example you can pass the message to LocalTopic or RemoteTopic regardless of their descriptors.
     * */
    public ResponseEntity sendWithRouting(String message, boolean isLocal) throws Exception {
        LetterwindTopic topic = isLocal ? localTopic : remoteTopic;
        Letterwind.send(message, topic);
        return ResponseEntity.ok(String.format("Message sent to %s: %s", topic.getName(), message));
    }

    /**
     * Topic-related distribution: the topic will be found by its name automatically.
     * In this example you can pass the message to LocalTopic or RemoteTopic regardless of their descriptors.
     * */
    public ResponseEntity sendToTopic(String message, String topicName) throws Exception {
        Letterwind.send(message, topicName);
        return ResponseEntity.ok(String.format("Message sent to %s: %s", topicName, message));
    }
}
