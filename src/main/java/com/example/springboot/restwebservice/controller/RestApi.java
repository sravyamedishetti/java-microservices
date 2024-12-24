package com.example.springboot.restwebservice.controller;

import com.example.springboot.restwebservice.bean.PrintHello;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApi {
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
}
