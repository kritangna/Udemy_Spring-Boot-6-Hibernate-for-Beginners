package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

public class swimCoach implements Coach {

    public swimCoach() {
        System.out.println("In constructor: " + getClass().getName());
    }
    @Override
    public String getDailyWorkout() {
        return "Swim 300 meters as a warm up";
    }
}
