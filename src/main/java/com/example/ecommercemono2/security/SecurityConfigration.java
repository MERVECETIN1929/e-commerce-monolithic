package com.example.ecommercemono2.security;

import com.example.ecommercemono2.entities.enums.Authority;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
                                        .requestMatchers(HttpMethod.POST,
                                                "/api/address",
                                                "/api/cart",
                                                "/api/invoice",
                                                "/api/payment",
                                                "/api/user/login",
                                                "/api/user",
                                                "/api/user/admin/login")
                                        .permitAll()

                                        .requestMatchers(HttpMethod.GET,
                                                "/api/address",
                                                "/api/address/{id}",
                                                "/api/brand",
                                                "/api/brand/{id}",
                                                "/api/cartItem",
                                                "/api/address/{id}",
                                                "/api/category",
                                                "/api/category/{id}",
                                                "/api/product",
                                                "/api/product/{id}",
                                                "/api/invoice",
                                                "/swagger-ui.html/**",
                                                "/swagger-ui/**",
                                                "/v3/api-docs/**"
                                        )
                                        .permitAll()

                                        .requestMatchers(HttpMethod.GET,
                                                "/api/cart/{id}",
                                                "/api/cartItem/{id}",
                                                "/api/invoice/{id}",
                                                "/api/invoice/getByUserId",
                                                "/api/order/{userId}",
                                                "/api/order-detail/{orderId}",
                                                "/api/payment/{id}",
                                                "/api/user/{id}",
                                                "/api/user-address/{userId}",
                                                "/api/user-address/{userId}/{addressId}")
                                        .hasRole(Authority.USER.name())

                                        .requestMatchers(HttpMethod.POST,
                                                "/api/cart",
                                                "/api/cartItem",
                                                "/api/order",
                                                "/api/user-address/{userId}")
                                        .hasRole(Authority.USER.name())

                                        .requestMatchers(HttpMethod.DELETE,
                                                "/api/cartItem/{id}",
                                                "/api/order/{userId}/{orderId}",
                                                "/api/payment/{id}",
                                                "/api/user/{id}",
                                                "/api/user-address/{id}")
                                        .hasRole(Authority.USER.name())

                                        .requestMatchers(HttpMethod.PUT,
                                                "/api/cartItem/increaseQuantity/{id}",
                                                "/api/cartItem/{id}",
                                                "/api/cartItem/reduceQuantity/{id}",
                                                "/api/payment/{id}",
                                                "/api/user/{id}",
                                                "/api/user-address/{usersAddressId}")
                                        .hasRole(Authority.USER.name())

                                        .requestMatchers(HttpMethod.PUT,
                                                "/api/address",
                                                "/api/brand/{id}",
                                                "/api/cart/{id}",
                                                "/api/cartItem/{id}",
                                                "/api/category/{id}",
                                                "/api/product/{id}",
                                                "/api/product/change-product-unit-price/{id}")
                                        .hasRole(Authority.ADMIN.name())

                                        .requestMatchers(HttpMethod.DELETE,
                                                "/api/address",
                                                "/api/brand/{id}",
                                                "/api/cart/{id}",
                                                "/api/category/{id}",
                                                "/api/invoice/{id}",
                                                "/api/product/{id}",
                                                "/api/user/{id}")
                                        .hasRole(Authority.ADMIN.name())

                                        .requestMatchers(HttpMethod.POST,
                                                "/api/brand",
                                                "/api/cart",
                                                "/api/category",
                                                "/api/category/{id}",
                                                "/api/product")
                                        .hasRole(Authority.ADMIN.name())

                                        .requestMatchers(HttpMethod.GET,
                                                "/api/cart",
                                                "/api/cartItem",

                                                "/api/order",
                                                "/api/payment",
                                                "/api/user",
                                                "/api/user-address/{userId}",
                                                "/api/user-address/{userId}/{addressId}")
                                        .hasRole(Authority.ADMIN.name())
                )
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class );

        return http.build();
    }

}
