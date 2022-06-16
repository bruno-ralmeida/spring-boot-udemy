package com.xxnbr.cursomc.resources;

import com.xxnbr.cursomc.domain.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "categories")
public class CategoryResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> list() {

        Category category01 = Category.builder()
                .id(1)
                .name("Xxnbr")
                .build();
        Category category02 = Category.builder()
                .id(2)
                .name("peta-poco")
                .build();

        List<Category> list = new ArrayList<>();
        list.add(category01);
        list.add(category02);

        return list;
    }
}
