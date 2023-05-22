package com.example.todoapp.repository;

import com.example.todoapp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMongoRepository extends JpaRepository<Users,Integer> {
    Users findByUsername(String userName);

}
