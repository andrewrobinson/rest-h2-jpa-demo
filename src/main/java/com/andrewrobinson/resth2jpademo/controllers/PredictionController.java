package com.andrewrobinson.resth2jpademo.controllers;

import com.andrewrobinson.resth2jpademo.model.Subscription;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PredictionController {

//    @GetMapping("/predictions/")
//    List<Subscription> getPrediction() {
//
//        return repository.findAll();
//    }

    private String getLoggedInUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
//        return currentPrincipalName;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;
        } else {
            throw new RuntimeException("No User");
        }

    }

}
