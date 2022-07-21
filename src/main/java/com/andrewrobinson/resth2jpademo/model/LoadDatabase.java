package com.andrewrobinson.resth2jpademo.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(NatwestUserRepository userRepository, SubscriptionRepository subscriptionRepository) {

        return args -> {

            log.info("Preloading " + userRepository.save(new NatwestUser("john", "password")));
            log.info("Preloading " + userRepository.save(new NatwestUser("jackie", "password")));
            log.info("Preloading " + userRepository.save(new NatwestUser("sally", "password")));

            log.info("Preloading " + subscriptionRepository.save(new Subscription("john", SubscriptionType.DEMO)));
            log.info("Preloading " + subscriptionRepository.save(new Subscription("jackie", SubscriptionType.SILVER)));
            log.info("Preloading " + subscriptionRepository.save(new Subscription("sally", SubscriptionType.GOLD)));

        };
    }
}