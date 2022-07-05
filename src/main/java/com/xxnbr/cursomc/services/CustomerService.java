package com.xxnbr.cursomc.services;

import com.xxnbr.cursomc.domain.Category;
import com.xxnbr.cursomc.domain.Customer;
import com.xxnbr.cursomc.repositories.CustomerRepository;
import com.xxnbr.cursomc.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public Customer fetchDataById(Integer id) {

        Optional<Customer> optionalCategory = repository.findById(id);

        if (optionalCategory.isEmpty()) {
            throw new ObjectNotFoundException(new StringBuilder("Objeto com id: ").append(id).append(" não localizado na base de dados. Tipo: ").append(Category.class.getName()).toString());
        }

        return optionalCategory.get();
    }
}
