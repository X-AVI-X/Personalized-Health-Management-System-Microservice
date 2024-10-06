package com.mid.mentalhealthmicroservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/mental-health/exercises/all").permitAll()
                                .requestMatchers("/populate/exercise").hasAuthority("ADMIN")
                                .requestMatchers("/populate/exercise").hasAuthority("ADMIN")
                                .requestMatchers("/mental-health/exercise/create").hasAuthority("ADMIN")
                                .requestMatchers("/mental-health/search/{exercise}").hasAuthority("USER")
                                .requestMatchers("/mental-health/survey").hasAuthority("USER")
                                .requestMatchers("/mental-health/exercises/user-specific").hasAuthority("USER")
                                .requestMatchers("/mental-health/recommendations").hasAuthority("USER")
                                .requestMatchers("/mood/**").hasAuthority("USER")
                        .anyRequest().authenticated()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }
}
