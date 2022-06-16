package com.xxnbr.cursomc.services;

import com.xxnbr.cursomc.domain.Category;
import com.xxnbr.cursomc.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category fetchDataById(Integer id){

        Optional<Category> optionalCategory = repository.findById(id);

        if(optionalCategory.isEmpty()) return null;

        return optionalCategory.get();
    }
}
