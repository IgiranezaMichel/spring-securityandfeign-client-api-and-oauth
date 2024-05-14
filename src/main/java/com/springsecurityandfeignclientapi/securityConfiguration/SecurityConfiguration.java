package com.springsecurityandfeignclientapi.securityConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    return http.
    cors(crs->crs.disable())
    .authorizeHttpRequests(
    req->{
        req.requestMatchers("/login","").permitAll();
        req.anyRequest().authenticated();
}
    )
    .formLogin(
        login->{
            login.defaultSuccessUrl("/login/success");
            // login.loginPage("").permitAll();
        }
    )
    .
    build();
}
}
