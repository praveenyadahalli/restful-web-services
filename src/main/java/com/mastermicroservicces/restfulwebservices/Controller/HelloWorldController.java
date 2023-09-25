package com.mastermicroservicces.restfulwebservices.Controller;

import com.mastermicroservicces.restfulwebservices.Bean.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping(path ="/hello-world" )
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path ="/hello-world-bean" )
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }


}
