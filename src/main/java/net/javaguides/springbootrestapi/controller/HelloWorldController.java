package net.javaguides.springbootrestapi.controller;

import org.springframework.data.jpa.repository.query.JpaParameters;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "hi";
    }
}
