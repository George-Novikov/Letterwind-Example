package com.georgen.letterwindproducer.service;

import com.georgen.letterwind.api.Letterwind;
import com.georgen.letterwind.api.LetterwindTopic;
import com.georgen.letterwindproducer.model.Message;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProducerService {
    private LetterwindTopic topic;

    private ProducerService(@Qualifier("localTopic") LetterwindTopic topic){
        this.topic = topic;
    }

    public ResponseEntity sendSimpleMessage(String message) throws Exception {
        Letterwind.send(message, topic);
        return ResponseEntity.ok("Message successfully sent: " + message);
    }

    public ResponseEntity sendComplexMessage(Message message) throws Exception {
        message.setId((int) Math.random());
        message.setCreationDate(LocalDateTime.now());

        Letterwind.send(message, topic);
        return ResponseEntity.ok("Message successfully sent: " + message);
    }
}
