package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define the private fields for the dependency

    private Coach myCoach;

    @Autowired
    public void DemoController(@Qualifier("cricketCoach") Coach theCoach) {

        myCoach = theCoach;
    }

    // endpoint for dailyworkout
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
