package com.example.ecommercemono2.business.rules;

import com.example.ecommercemono2.common.constants.Message;
import com.example.ecommercemono2.common.exception.BusinessException;
import com.example.ecommercemono2.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryRules {
    private CategoryRepository repository;
    public void existByName(String categoryName){
        if(repository.existsByName(categoryName)){
            throw new BusinessException(Message.Category.AlreadyExistName);
        }
    }
    public void  existById(UUID categoryId){
        if(!repository.existsCategoryById(categoryId)){
            throw new BusinessException(Message.Category.NotExistId);
        }
    }
}
