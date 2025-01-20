package com.example.springboot.restwebservice.controller;

import com.example.springboot.restwebservice.filtering.Details;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Filtering {

    @GetMapping("/IgnorePassword")
    public Details displayDetails(){
        return new Details("v1","v2","v3","v3");
    }

    @GetMapping("/IgnoreListPassword")
    public List<Details> displayListDetails(){
        return Arrays.asList(new Details("v2","v3","v4","v5"),new Details("v6","v7","v8","v9"));
    }

}
