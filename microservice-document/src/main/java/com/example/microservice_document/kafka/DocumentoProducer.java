package com.example.microservice_document.kafka;

import com.example.microservice_document.model.Documento;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component

public class DocumentoProducer {

    private final KafkaTemplate<String, Documento> kafkaTemplate;
    private static final String TOPIC = "document-uploaded";

    public DocumentoProducer(KafkaTemplate<String, Documento> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendDocumentUploadedEvent(Documento document) {
        kafkaTemplate.send(TOPIC, document);
    }
}
