package com.luv2code.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define the private fields for the dependency

    private  Coach myCoach;

    // Constructor
    @Autowired
    public DemoController(Coach coach) {
        myCoach = coach;
    }

    // endpoint for dailyworkout
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
