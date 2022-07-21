package com.andrewrobinson.resth2jpademo.controllers;

import com.andrewrobinson.resth2jpademo.model.NatwestUser;
import com.andrewrobinson.resth2jpademo.model.NatwestUserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class UserController {

    private final NatwestUserRepository repository;

    UserController(NatwestUserRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/users")
    List<NatwestUser> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/users")
    NatwestUser newEmployee(@RequestBody NatwestUser newNatwestUser) {
        return repository.save(newNatwestUser);
    }

    // Single item

    @GetMapping("/users/{id}")
    NatwestUser one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    NatwestUser replaceZser(@RequestBody NatwestUser newNatwestUser, @PathVariable Long id) {

        return repository.findById(id)
                .map(zser -> {
                    zser.setUsername(newNatwestUser.getUsername());
                    zser.setPassword(newNatwestUser.getPassword());
                    return repository.save(zser);
                })
                .orElseGet(() -> {
                    newNatwestUser.setId(id);
                    return repository.save(newNatwestUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteZser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}