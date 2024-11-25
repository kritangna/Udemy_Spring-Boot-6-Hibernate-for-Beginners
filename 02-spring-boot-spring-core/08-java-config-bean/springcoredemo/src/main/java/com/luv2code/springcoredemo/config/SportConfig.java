package com.luv2code.springcoredemo.config;

import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.common.swimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebInputException;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach()
    {
        return new swimCoach();
    }
}
