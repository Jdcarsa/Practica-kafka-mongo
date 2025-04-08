package com.example.microservice_document.controller;

import com.example.microservice_document.model.Documento;
import com.example.microservice_document.service.DocumentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/documents")

public class DocumentoController {

    private final DocumentoService service;

    public DocumentoController(DocumentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Documento> uploadDocumento(@RequestBody Documento documento) {
        return ResponseEntity.ok(service.uploadDocument(documento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Documento> getById(@PathVariable String id) {
        Documento doc = service.getDocument(id);
        return (doc != null) ? ResponseEntity.ok(doc) : ResponseEntity.notFound().build();
    }
}
