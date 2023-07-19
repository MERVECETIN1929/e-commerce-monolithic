package com.example.ecommercemono2.common.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;


@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService {
    private ModelMapper mapper;

    @Override
    public ModelMapper forResponse() {
        mapper.getConfiguration().setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);// loose: her alan birbirine uymak zorunda değil
        return mapper;
    }

    @Override
    public ModelMapper forRequest() {
        mapper.getConfiguration().setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper;
    }
}
