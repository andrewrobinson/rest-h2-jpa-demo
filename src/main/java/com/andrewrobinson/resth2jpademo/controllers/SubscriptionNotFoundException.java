package com.andrewrobinson.resth2jpademo.controllers;

class SubscriptionNotFoundException extends RuntimeException {

    SubscriptionNotFoundException(Long id) {
        super("Could not find subscription " + id);
    }
}