package com.example.ecommercemono2.common.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig{


    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
    @Bean
    public ModelMapperService getModelMapperService(ModelMapper mapper){
        return new ModelMapperManager(mapper);
    }
}
