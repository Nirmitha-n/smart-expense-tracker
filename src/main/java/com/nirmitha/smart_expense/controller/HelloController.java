package com.nirmitha.smart_expense.controller;
import com.nirmitha.smart_expense.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController{
    private final GreetingService greetingService;

    public HelloController(GreetingService greetingService){
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public  String hello(){
        return greetingService.getGreeting("Hemalatha");
    }

}