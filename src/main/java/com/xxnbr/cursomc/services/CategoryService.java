package com.xxnbr.cursomc.services;

import com.xxnbr.cursomc.domain.Category;
import com.xxnbr.cursomc.repositories.CategoryRepository;
import com.xxnbr.cursomc.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public Category fetchDataById(Integer id) {

        Optional<Category> optionalCategory = repository.findById(id);

        if (optionalCategory.isEmpty()) {
            throw new ObjectNotFoundException(new StringBuilder("Objeto com id: ").append(id).append(" não localizado na base de dados. Tipo: ").append(Category.class.getName()).toString());
        }

        return optionalCategory.get();
    }
}
