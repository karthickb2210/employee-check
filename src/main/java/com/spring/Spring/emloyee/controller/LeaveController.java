package com.spring.Spring.emloyee.controller;

import com.spring.Spring.emloyee.exception.UserNotFoundException;
import com.spring.Spring.emloyee.model.Leave;
import com.spring.Spring.emloyee.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("https://spring-employee-management.netlify.app/")
public class LeaveController {

    @Autowired
    private LeaveRepository leaveRepository;

    @PostMapping("/leave")
    Leave newUser(@RequestBody Leave newLeave) {
        return leaveRepository.save(newLeave);
    }

    @GetMapping("/leaves")
    List<Leave> getAllUsers() {
        return leaveRepository.findAll();
    }

    @GetMapping("/leave/{id}")
    Leave getUserById(@PathVariable Long id) {
        return leaveRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/leave/{id}")
    Leave updateUser(@RequestBody Leave newLeave, @PathVariable Long id) {
        return leaveRepository.findById(id)
                .map(leave -> {
                    leave.setName(newLeave.getName());
                    leave.setDate(newLeave.getDate());
                    leave.setStatus(newLeave.getStatus());
                    leave.setDays(newLeave.getDays());
                    leave.setDetails(newLeave.getDetails());
                    return leaveRepository.save(leave);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }
    @DeleteMapping("/leave/{id}")
    String deleteLeave(@PathVariable Long id) {
        if (!leaveRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        leaveRepository.deleteById(id);
        return "User with id " + id + " has been deleted success.";
    }

}
