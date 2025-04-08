package com.example.microservice_audit.kafka;

import com.example.microservice_audit.model.AuditLog;
import com.example.microservice_audit.repository.IAuditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Listener {

    private final IAuditRepository repository;

    public Listener(IAuditRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = {"document-uploaded", "document-validated",
            "document-rejected"}, groupId = "audit-group")
    public void listen(String message,
                       org.apache.kafka.clients.consumer.ConsumerRecord<String, String> record) {
        AuditLog log = new AuditLog();
        log.setEventType(record.topic());
        log.setPayload(message);
        log.setTimestamp(LocalDateTime.now());

        repository.save(log);
        System.out.println("Audit Log registrado: " + log.toString());
    }
}
