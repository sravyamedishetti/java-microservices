package com.example.springboot.restwebservice.repository;

import com.example.springboot.restwebservice.user.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts, Integer> {
}
