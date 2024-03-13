package com.spring.Spring.emloyee.controller;


import com.spring.Spring.emloyee.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.spring.Spring.emloyee.model.User;
import com.spring.Spring.emloyee.repository.UserRepository;
import java.util.List;

@RestController
@CrossOrigin("https://spring-employee-management.netlify.app/")
public class EmployeeController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setDate(newUser.getDate());
                    user.setInTime(newUser.getInTime());
                    user.setEmail(newUser.getEmail());
                    user.setLogOut(newUser.getLogOut());
                    user.setWorkdone(newUser.getWorkdone());
                    user.setWorkTime(newUser.getWorkTime());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }



    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id " + id + " has been deleted success.";
    }

}
