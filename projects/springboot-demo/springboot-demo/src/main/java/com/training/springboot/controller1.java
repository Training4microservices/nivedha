package com.training.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class controller1{
    public static void main(String[] args){
        SpringApplication.run(controller1.class, args);
    }
}
@RestController
class MyController {
    @GetMapping(value ="/name")
    public String getName(){
        return "Nivedha";
    }
    @GetMapping(value ="/")
    public String getData(){
        return "Springboot is a string";
    }
}
