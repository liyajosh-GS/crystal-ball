package com.project.crystalBall;

import com.project.crystalBall.dto.project.Project;
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
