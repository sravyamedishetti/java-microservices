package com.example.springboot.restwebservice.controller;

import com.example.springboot.restwebservice.bean.PrintHello;
import com.example.springboot.restwebservice.exception.UserNotFoundException;
import com.example.springboot.restwebservice.user.User;
import com.example.springboot.restwebservice.user.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
public class RestApi {

    private MessageSource messageSource;

    public RestApi(MessageSource messageSource){
        this.messageSource=messageSource;
    }

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

    @GetMapping("/hello-world-i18n")
    public String helloWorldPrintI18n(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null, "Default Message", locale);
       // return new PrintHello("Hello-World");
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
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        userDaoService.addUser(user);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteUserById(@PathVariable int id){
        return userDaoService.deleteById(id);
    }
}
