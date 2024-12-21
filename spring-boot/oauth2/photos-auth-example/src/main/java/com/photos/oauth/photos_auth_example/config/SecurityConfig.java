package com.photos.oauth.photos_auth_example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests((request) -> {
            request.requestMatchers("/photos").authenticated().anyRequest().permitAll();
        }).formLogin(Customizer.withDefaults())
                .oauth2Login(oauth ->{
                    oauth.successHandler((request, response, authentication) ->{
                        System.out.println("authentication success");
                        System.out.println(authentication.toString());

                        OAuth2User user = (OAuth2User) authentication.getPrincipal();
                        String username = user.getAttribute("login");
                        System.out.println("username : " + username);
                        System.out.println("email : " + user.getAttribute("email"));
                        response.sendRedirect("/");
                    }).failureHandler((request, response, exception)->{
                        System.out.println("authentication failed");
                        exception.printStackTrace();
                    });
                });

        return httpSecurity.build();
    }
}