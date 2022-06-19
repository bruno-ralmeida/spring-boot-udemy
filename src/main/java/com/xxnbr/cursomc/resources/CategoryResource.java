package com.xxnbr.cursomc.resources;

import com.xxnbr.cursomc.domain.Category;
import com.xxnbr.cursomc.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "categories")
@RequiredArgsConstructor
public class CategoryResource {

    private final CategoryService categoryService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id) {

        Category category = categoryService.fetchDataById(id);

        if(category == null) return ResponseEntity.noContent().build();

        return ResponseEntity.ok().body(category);
    }
}
