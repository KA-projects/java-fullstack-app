package com.example.restservice.config;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    @Autowired
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/auth/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // @Bean
    // public CorsFilter corsFilter() {
    // UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new
    // UrlBasedCorsConfigurationSource();
    // CorsConfiguration corsConfiguration = new CorsConfiguration();
    // corsConfiguration.setAllowCredentials(true);
    // corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
    // corsConfiguration.setAllowedHeaders(Arrays.asList("Origin",
    // "Access-Control-Allow-Origin", "Content-Type",
    // "Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
    // "Access-Control-Request-Method", "Access-Control-Request-Headers"));
    // corsConfiguration
    // .setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept",
    // "Jwt-Token", "Authorization",
    // "Access-Control-Allow-Origin", "Access-Control-Allow-Origin",
    // "Access-Control-Allow-Credentials", "Filename"));
    // corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT",
    // "PATCH", "DELETE", "OPTIONS"));
    // urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",
    // corsConfiguration);
    // return new CorsFilter(urlBasedCorsConfigurationSource);
    // }
}
