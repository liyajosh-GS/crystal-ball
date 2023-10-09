package com.project.crystalball;

import com.project.crystalball.config.JwtAuthFilter;
import com.project.crystalball.config.UserAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Autowired
    OAuthSuccessHandler oAuthSuccessHandler;

    private final UserAuthenticationProvider userAuthenticationProvider;

//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .cors(Customizer.withDefaults())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> {
//                   auth.requestMatchers(HttpMethod.GET).permitAll();
//                    auth.requestMatchers(HttpMethod.OPTIONS).permitAll();
//                   auth.anyRequest().authenticated();
//                   // auth.anyRequest().permitAll();
//
//                })
//                //.exceptionHandling(handler -> handler.authenticationEntryPoint(new RestAuthenticationEntryPoint()))
//                .oauth2Login(oauth -> {
//                    //oauth.authorizationEndpoint(authorizationEndpointConfig -> authorizationEndpointConfig.baseUri("/oauth2/authorize"));
//                    //oauth.redirectionEndpoint(redirectionEndpointConfig -> redirectionEndpointConfig.baseUri("/login/oauth2/callback/*"));
//                    oauth.userInfoEndpoint(userInfoEndpointConfig -> userInfoEndpointConfig.userService(customOAuthUserService));
//
//                })
//                //.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
//                .build();
//    }

//    @Bean
//    public TokenAuthenticationFilter tokenAuthenticationFilter() {
//        return new TokenAuthenticationFilter();
//    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
       return httpSecurity
               .csrf(AbstractHttpConfigurer::disable)
               .headers(headers -> headers.httpStrictTransportSecurity(HeadersConfigurer.HstsConfig::disable))
               .cors(cors -> cors.configurationSource(corsConfigurationSource()))
               .authorizeHttpRequests(auth -> {
                   auth.requestMatchers("/login", "/register").permitAll();
               })
               .authorizeHttpRequests((auth) -> {
                   auth.requestMatchers(HttpMethod.GET).permitAll();
               })
               .authorizeHttpRequests(auth -> {
                   auth.anyRequest().authenticated();
               })
               .addFilterBefore(new JwtAuthFilter(userAuthenticationProvider), BasicAuthenticationFilter.class)
               .sessionManagement(customizer -> customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

               .build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(List.of("http://localhost:3000"));
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setExposedHeaders(List.of("x-token"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return urlBasedCorsConfigurationSource;
    }

}
