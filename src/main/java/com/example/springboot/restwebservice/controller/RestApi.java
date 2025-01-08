package com.example.springboot.restwebservice.controller;

import com.example.springboot.restwebservice.bean.PrintHello;
import com.example.springboot.restwebservice.exception.UserNotFoundException;
import com.example.springboot.restwebservice.user.User;
import com.example.springboot.restwebservice.user.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestApi {

    @Autowired
    UserDaoService userDaoService;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello-world")
    public PrintHello helloWorldPrint(){
        return new PrintHello("Hello-World");
    }

    @GetMapping("/path-variable/{name}")
    public PrintHello pathVariable(@PathVariable String name) {
        return new PrintHello(name);
    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/findById/{id}")
    public User findUserById(@PathVariable Integer id) throws UserNotFoundException {
        User user= userDaoService.findById(id);
        if(user == null){
            throw new UserNotFoundException("User Not Found11");
        }
        return user;
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userDaoService.addUser(user);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteUserById(@PathVariable int id){
        return userDaoService.deleteById(id);
    }
}
