package com.spring.Spring.emloyee.controller;

import com.spring.Spring.emloyee.exception.UserNotFoundException;
import com.spring.Spring.emloyee.model.Ticket;
import com.spring.Spring.emloyee.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("https://spring-employee-management.netlify.app/")
public class TicketController {


    @Autowired
    private TicketRepository ticketRepository;

    @PostMapping("/ticket")
    Ticket newTicket(@RequestBody Ticket newTicket) {
        return ticketRepository.save(newTicket);
    }

    @GetMapping("/tickets")
    List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
    @DeleteMapping("/tickets/{id}")
    String deleteUser(@PathVariable Long id) {
        if (!ticketRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        ticketRepository.deleteById(id);
        return "Ticket with id " + id + " has been deleted success.";
    }
}
