package com.example.springboot.restwebservice.controller;

import com.example.springboot.restwebservice.exception.PostNotFoundException;
import com.example.springboot.restwebservice.exception.UserNotFoundException;
import com.example.springboot.restwebservice.repository.PostRepository;
import com.example.springboot.restwebservice.repository.UserRepository;
import com.example.springboot.restwebservice.user.Posts;
import com.example.springboot.restwebservice.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpa {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @GetMapping("/jpa/allUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/jpa/findById/{id}")
    public User findUserById(@PathVariable Integer id) throws UserNotFoundException {
        Optional<User> user= userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("User Not Found11");
        }
        return user.get();
    }

    @PostMapping("/jpa/addUser")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        userRepository.save(user);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/jpa/deleteById/{id}")
    public void deleteUserById(@PathVariable Integer id){
        userRepository.deleteById(id);
    }

    @GetMapping("/jpa/user/{userId}/posts")
    public List<Posts> retrievePostsOfUser(@PathVariable Integer userId){
        Optional<User> user= userRepository.findById(userId);
        if(user.isEmpty()){
            throw new UserNotFoundException("User Not Found11");
        }
        return user.get().getPosts();
    }

    @PostMapping("/jpa/createPost/{userId}")
    public ResponseEntity<Object> addPosts(@PathVariable Integer userId, @RequestBody Posts posts){
        Optional<User> user= userRepository.findById(userId);
        if(user.isEmpty()){
            throw new UserNotFoundException("User Not Found11");
        }
        posts.setUser(user.get());
        Posts posts1 = postRepository.save(posts);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(posts1.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/jpa/posts/{postId}")
    public Posts retrievePosts(@PathVariable Integer postId){
        Optional<Posts> post = postRepository.findById(postId);
        if(post.isEmpty()){
            throw new PostNotFoundException("Post Not Found");
        }
        return post.get();
    }
}
