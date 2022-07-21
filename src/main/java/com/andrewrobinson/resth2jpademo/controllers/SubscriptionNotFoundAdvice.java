package com.andrewrobinson.resth2jpademo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class SubscriptionNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(SubscriptionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String subscriptionNotFoundHandler(SubscriptionNotFoundException ex) {
        return ex.getMessage();
    }
}