package com.andrewrobinson.resth2jpademo.controllers;

import com.andrewrobinson.resth2jpademo.model.Zser;
import com.andrewrobinson.resth2jpademo.model.ZserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class ZserController {

    private final ZserRepository repository;

    ZserController(ZserRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/users")
    List<Zser> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/users")
    Zser newEmployee(@RequestBody Zser newZser) {
        return repository.save(newZser);
    }

    // Single item

    @GetMapping("/users/{id}")
    Zser one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    Zser replaceZser(@RequestBody Zser newZser, @PathVariable Long id) {

        return repository.findById(id)
                .map(zser -> {
                    zser.setUsername(newZser.getUsername());
                    zser.setPassword(newZser.getPassword());
                    return repository.save(zser);
                })
                .orElseGet(() -> {
                    newZser.setId(id);
                    return repository.save(newZser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteZser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}