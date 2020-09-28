package com.sodamachine.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry corsRegistry) {
    	 corsRegistry.addMapping("/**")
         .allowedOrigins("http://localhost:4200")
         .allowedMethods("*")
         .maxAge(3600L)
         .allowedHeaders("*")
         .exposedHeaders("Authorization")
         .allowCredentials(true);
    }
}


