package com.example.springboot.restwebservice.controller;

import com.example.springboot.restwebservice.person.Name;
import com.example.springboot.restwebservice.person.PersonV1;
import com.example.springboot.restwebservice.person.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionPersonData {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Sravya");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Sravya","Medishetti"));
    }

    @GetMapping(path="/v1", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParam(){
        return new PersonV1("Sravya");
    }

    @GetMapping(path="/v2", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParam(){
        return new PersonV2(new Name("Sravya", "Medishetti"));
    }


}
