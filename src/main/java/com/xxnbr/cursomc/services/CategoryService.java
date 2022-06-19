package com.xxnbr.cursomc.services;

import com.xxnbr.cursomc.domain.Category;
import com.xxnbr.cursomc.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public Category fetchDataById(Integer id){

        Optional<Category> optionalCategory = repository.findById(id);

        if(optionalCategory.isEmpty()) return null;

        return optionalCategory.get();
    }
}
