package com.example.springboot.restwebservice.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


public class User {
    private Integer id;

    @Size(min=2, message = "Username should have minimum of two characters")
    @JsonProperty("user_name")
    private String username;
    @Past(message = "Birth date should be in past")
    @JsonProperty("birth_date")
    private LocalDate birthDate;

    User(Integer id, String username, LocalDate birthDate) {
        super();
        this.id = id;
        this.username = username;
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
