package com.example.microservice_audit.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "audit_logs")

public class AuditLog {
    @Id
    private String id;
    private String eventType;
    private String payload;
    private LocalDateTime timestamp;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "AuditLog{" +
                "id='" + id + '\'' +
                ", eventType='" + eventType + '\'' +
                ", payload='" + payload + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}