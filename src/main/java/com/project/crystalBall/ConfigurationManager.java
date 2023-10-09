package com.project.crystalBall;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationManager {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
