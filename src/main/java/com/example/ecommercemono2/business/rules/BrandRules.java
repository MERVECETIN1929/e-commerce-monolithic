package com.example.ecommercemono2.business.rules;

import com.example.ecommercemono2.common.constants.Message;
import com.example.ecommercemono2.common.exception.BusinessException;
import com.example.ecommercemono2.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class BrandRules {
    private BrandRepository repository;
    public void existByName(String brandName){
        if(repository.existsByName(brandName)){
            throw new BusinessException(Message.Brand.AlreadyExistName);
        }
    }
    public void  existById(UUID categoryId){
        if(!repository.existsBrandById(categoryId)){
            throw new BusinessException(Message.Brand.NotExistId);
        }
    }
}
