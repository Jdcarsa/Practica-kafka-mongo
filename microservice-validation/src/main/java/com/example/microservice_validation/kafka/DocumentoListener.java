package com.example.microservice_validation.kafka;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class DocumentoListener {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public DocumentoListener(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "document-uploaded", groupId = "validation-group")
    public void listenDocumentUploaded(ConsumerRecord<String, String> record) {
        String rawData = record.value();
        System.out.println("Documento recibido: " + rawData);
        boolean isValid = rawData.contains("valid");
        String status = isValid ? "document-validated" : "document-rejected";
        System.out.println("Template Enviado, RespuestaTemplate" + kafkaTemplate.send(status, rawData));
    }
}