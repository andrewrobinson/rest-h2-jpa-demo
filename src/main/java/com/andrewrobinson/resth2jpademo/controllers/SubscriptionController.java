package com.andrewrobinson.resth2jpademo.controllers;

import com.andrewrobinson.resth2jpademo.model.Subscription;
import com.andrewrobinson.resth2jpademo.model.SubscriptionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class SubscriptionController {

    private final SubscriptionRepository repository;

    SubscriptionController(SubscriptionRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/subscriptions")
    List<Subscription> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/subscriptions")
    Subscription newSubscription(@RequestBody Subscription newSubscription) {
        return repository.save(newSubscription);
    }

    // Single item

    @GetMapping("/subscriptions/{id}")
    Subscription one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new SubscriptionNotFoundException(id));
    }

    @PutMapping("/subscriptions/{id}")
    Subscription replaceSubscription(@RequestBody Subscription newSubscription, @PathVariable Long id) {

        return repository.findById(id)
                .map(subscription -> {
                    subscription.setZser(newSubscription.getZser());
                    subscription.setSubscriptionType(newSubscription.getSubscriptionType());
                    return repository.save(subscription);
                })
                .orElseGet(() -> {
                    newSubscription.setId(id);
                    return repository.save(newSubscription);
                });
    }

    @DeleteMapping("/subscriptions/{id}")
    void deleteSubscription(@PathVariable Long id) {
        repository.deleteById(id);
    }
}