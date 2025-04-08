package com.example.microservice_document.repository;

import com.example.microservice_document.model.Documento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IDocumentoRepository extends MongoRepository<Documento,String> {
}
