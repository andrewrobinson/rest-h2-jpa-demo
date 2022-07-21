package com.andrewrobinson.resth2jpademo.controllers;

import com.andrewrobinson.resth2jpademo.model.Subscription;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PredictionController {

        //https://www.section.io/engineering-education/implement-rate-limiting-in-spring-boot/

    @GetMapping("/predictions/")
    List<Integer> getPrediction() {

        //TODO - stock ticker in url and duration from query param
        //TODO - stock ticker http call
        //TODO - look up subscription of logged in user
        //TODO - rate limiter

        var results = new ArrayList<Integer>();
        results.add(1);
        results.add(2);
        results.add(3);
        results.add(7);
        return results;
    }

    private String getLoggedInUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;
        } else {
            throw new RuntimeException("No User");
        }

    }

}
