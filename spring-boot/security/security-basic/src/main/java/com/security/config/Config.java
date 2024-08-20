package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity      //enables custom spring-security configuration
public class Config {

    @Autowired
    private UserDetailsService userDetailsService;
        
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        return httpSecurity
            .csrf(customizer -> customizer.disable())
            .authorizeHttpRequests(request -> request.anyRequest().authenticated())
            .formLogin(Customizer.withDefaults())   //enables web based form login
            .httpBasic(Customizer.withDefaults())   //enables login through rest client
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))   //makes the sessions stateless
            .build();
    }

    // @Bean
    // public UserDetailsService userDetailsService(){
        
    //     UserDetails userDetails = User
    //         .withDefaultPasswordEncoder()
    //         .username("test")
    //         .password("pass")
    //         .roles("USER")
    //         .build();

        
    //     UserDetails userDetails2 = User
    //         .withDefaultPasswordEncoder()
    //         .username("test2")
    //         .password("pass")
    //         .roles("USER")
    //         .build();
            
    //     return new InMemoryUserDetailsManager(userDetails, userDetails2);
    // }

    
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        authProvider.setUserDetailsService(userDetailsService);
        return authProvider;
    }
}
