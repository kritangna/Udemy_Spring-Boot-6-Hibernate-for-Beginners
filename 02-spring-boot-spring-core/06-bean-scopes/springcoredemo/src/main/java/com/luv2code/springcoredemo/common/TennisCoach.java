package com.luv2code.springcoredemo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    public TennisCoach() {

    }

    @Override
    public String getDailyWorkout()
    {
        return "Practice your backhand volley";
    }
}
