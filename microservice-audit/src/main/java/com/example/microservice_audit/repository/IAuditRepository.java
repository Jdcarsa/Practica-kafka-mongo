package com.example.microservice_audit.repository;

import com.example.microservice_audit.model.AuditLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IAuditRepository extends MongoRepository<AuditLog, String> {
}