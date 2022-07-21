package com.andrewrobinson.resth2jpademo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
//                .authenticationEntryPoint(authenticationEntryPoint);


//        http.authorizeRequests()
//                .antMatchers("/securityNone").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic()
//                .authenticationEntryPoint(authenticationEntryPoint);
//
//        http.addFilterAfter(new CustomFilter(),
//                BasicAuthenticationFilter.class);




    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {

        List<UserDetails> users = new ArrayList<UserDetails>();

        UserDetails user1 =
                User.withDefaultPasswordEncoder()
                        .username("john")
                        .password("password")
                        .roles("USER")
                        .build();

        UserDetails user2 =
                User.withDefaultPasswordEncoder()
                        .username("jackie")
                        .password("password")
                        .roles("USER")
                        .build();

        UserDetails user3 =
                User.withDefaultPasswordEncoder()
                        .username("sally")
                        .password("password")
                        .roles("USER")
                        .build();

        users.add(user1);
        users.add(user2);
        users.add(user3);

        return new InMemoryUserDetailsManager(users);
    }
}