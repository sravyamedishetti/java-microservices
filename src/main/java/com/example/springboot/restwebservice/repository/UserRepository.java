package com.example.springboot.restwebservice.repository;

import com.example.springboot.restwebservice.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
