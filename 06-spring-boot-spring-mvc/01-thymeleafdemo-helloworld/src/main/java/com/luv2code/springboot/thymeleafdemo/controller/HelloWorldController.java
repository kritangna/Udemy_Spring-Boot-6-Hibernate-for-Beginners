package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // Need a  controller method to show initial HTML form

    @GetMapping("/showForm")
    public String showForm()
    {
        // This returns the name of the template
        // being used in the form of a string.
        // The name of our template being used is hello-world-form
        return "hello-world-form";
    }

    // Need a controller method to process the HTML form

    @RequestMapping("/processForm")
    public String processForm()
    {
        return "helloworld";
    }

    // need a controller method to read form data and
    // data ti the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model)
    {
        // read the request param from the html form
        String theName = request.getParameter("studentName");

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Yo! " + theName;

        // add message to the model
        model.addAttribute("message", result);
        return "helloworld";
    }

    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model)
    {
        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Hey my Friend from v3! " + theName;

        // add message to the model
        model.addAttribute("message", result);
        return "helloworld";
    }
}
