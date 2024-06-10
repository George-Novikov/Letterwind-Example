package com.georgen.letterwindproducer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.georgen.letterwind.api.annotations.LetterwindMessage;

import java.time.LocalDateTime;

@LetterwindMessage
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {
    private int id;
    private LocalDateTime creationDate;
    private String title;
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", title='" + title + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
