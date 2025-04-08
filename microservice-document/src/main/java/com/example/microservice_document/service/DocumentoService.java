package com.example.microservice_document.service;

import com.example.microservice_document.kafka.DocumentoProducer;
import com.example.microservice_document.model.Documento;
import com.example.microservice_document.repository.IDocumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DocumentoService {

    private final IDocumentoRepository repository;
    private final DocumentoProducer producer;

    public DocumentoService(IDocumentoRepository repository, DocumentoProducer producer) {
        this.repository = repository;
        this.producer = producer;
    }

    public Documento uploadDocument(Documento doc) {
        doc.setStatus("UPLOADED");
        doc.setUploadDate(LocalDateTime.now());
        Documento saved = repository.save(doc);
        producer.sendDocumentUploadedEvent(saved);
        return saved;
    }

    public Documento getDocument(String id) {
        return repository.findById(id).orElse(null);
    }
}
