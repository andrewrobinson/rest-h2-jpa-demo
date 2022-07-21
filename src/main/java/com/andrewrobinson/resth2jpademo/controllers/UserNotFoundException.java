package com.andrewrobinson.resth2jpademo.controllers;

class UserNotFoundException extends RuntimeException {

    UserNotFoundException(Long id) {
        super("Could not find user " + id);
    }
}