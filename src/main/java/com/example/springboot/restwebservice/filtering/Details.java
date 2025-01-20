package com.example.springboot.restwebservice.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"f1","f3"})
public class Details {
    private String f1;
    @JsonIgnore
    private String f2;
    private String f3;
    private String f4;
    public Details(String f1, String f2, String f3, String f4) {
        this.f1=f1;
        this.f2=f2;
        this.f3=f3;
        this.f4=f4;
    }

    public String getF1() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }

    public String getF3() {
        return f3;
    }

    public void setF3(String f3) {
        this.f3 = f3;
    }

    public String getF4() {
        return f4;
    }

    public void setF4(String f4) {
        this.f4 = f4;
    }

    @Override
    public String toString() {
        return "Details{" +
                "f1='" + f1 + '\'' +
                ", f2='" + f2 + '\'' +
                ", f3='" + f3 + '\'' +
                ", f4='" + f4 + '\'' +
                '}';
    }
}
