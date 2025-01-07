package com.company.oziva.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class SpringSecurity {
	
	private static final Logger log = LoggerFactory.getLogger(SpringSecurity.class);
	
//	@Autowired
//	private UserDetailsService userDetailsService;
//	 
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		log.info("securityFilterChain method start");

        http
                .authorizeHttpRequests((authorize) -> authorize
                                .requestMatchers("/register/**").permitAll()
                                .anyRequest().authenticated()
                ).csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.addAllowedOrigin("*");
                    config.addAllowedMethod("*");
                    config.addAllowedHeader("*");
                    return config;
                }))
                .httpBasic(Customizer.withDefaults());
        
        log.info("securityFilterChain method end");
      
		return http.build();
	}
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Bean
	AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
		log.info("authenticationManager method start");
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder);
		log.info("authenticationManager method end");
		return new ProviderManager(authenticationProvider);
	}


}
