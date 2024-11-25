package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.config.BeanDefinition;

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
