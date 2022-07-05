package com.xxnbr.cursomc.resources;

import com.xxnbr.cursomc.domain.Customer;
import com.xxnbr.cursomc.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "customers")
@RequiredArgsConstructor
public class CustomerResource {

    private final CustomerService customerService;


    @GetMapping(path = "/{id}")
    public ResponseEntity<Customer> find(@PathVariable Integer id){
        Customer customer = customerService.fetchDataById(id);

        return ResponseEntity.ok().body(customer);
    }
}
