package com.spring.Spring.emloyee.repository;

import com.spring.Spring.emloyee.model.Leave;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeaveRepository extends MongoRepository<Leave,Long> {
}
