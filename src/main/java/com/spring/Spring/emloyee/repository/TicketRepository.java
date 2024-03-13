package com.spring.Spring.emloyee.repository;

import com.spring.Spring.emloyee.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket,Long> {
}
