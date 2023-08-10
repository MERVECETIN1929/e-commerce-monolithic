package com.example.ecommercemono2.security;

import com.example.ecommercemono2.entities.enums.Authority;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity
@AllArgsConstructor
public class SecurityConfigration {
    private final JwtAuthFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth->
                                auth
                                        .requestMatchers(
                                                "/api/address",
                                                "/api/brand",
                                                "/api/category",
                                                "/api/product",
                                                "/api/user/login",
                                                "/api/user/admin/login",
                                                "/swagger-ui.html/**",
                                                "/swagger-ui/**",
                                                "/v3/api-docs/**"
                                               )
                                        .permitAll()

                                        .requestMatchers(
                                                "/api/cart",
                                                "/api/cartItem",
                                                "/api/invoice",
                                                "/api/order",
                                                "/api/order-detail",
                                                "/api/user/payment",
                                                "/api/user-address",
                                                "/api/registered-user"
                                                )
                                        .hasRole(Authority.USER.name())

                                        .requestMatchers(

                                                "/api/admin/**"
                                        )
                                        .hasRole(Authority.ADMIN.name())
                )
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class );

        return http.build();
    }

}
