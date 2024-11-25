package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        System.out.println("In constructor: " + getClass().getName());
        return "Practice fast bowling for 20 minutes";
    }
}
