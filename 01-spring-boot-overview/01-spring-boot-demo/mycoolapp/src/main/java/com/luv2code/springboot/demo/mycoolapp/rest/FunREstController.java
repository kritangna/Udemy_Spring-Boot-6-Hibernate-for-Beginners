package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunREstController {
    // expose "/" that return "Hello World"
    public String reply;
    @GetMapping("/")
    public String sayHello()
    {
        return reply;
    }
    @PostMapping("/")
    public void replyHello(@RequestBody String body)
    {
        reply = body;
    }
}
