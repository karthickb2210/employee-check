package com.spring.Spring.emloyee.repository;

import com.spring.Spring.emloyee.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface UserRepository extends MongoRepository<User,Long> {


}
