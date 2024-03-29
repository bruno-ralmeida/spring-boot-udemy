package com.xxnbr.cursomc.resources;

import com.xxnbr.cursomc.domain.Category;
import com.xxnbr.cursomc.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "categories")
@RequiredArgsConstructor
public class CategoryResource {

    private final CategoryService categoryService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Category> find(@PathVariable Integer id) {

        Category category = categoryService.fetchDataById(id);

        return ResponseEntity.ok().body(category);
    }
}
