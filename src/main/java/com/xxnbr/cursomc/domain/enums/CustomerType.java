package com.xxnbr.cursomc.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum CustomerType {
    PHYSICAL(1, "Physical person"),
    LEGAL(2, "Legal person");

    private int code;
    private String description;

    public static CustomerType toEnum(Integer code) {
        if (code == null)
            return null;

        Optional<CustomerType> optionalCustomerType = Arrays.stream(CustomerType.values())
                .filter(customerType -> customerType.getCode() == code).findFirst();

        if (optionalCustomerType.isEmpty())
            throw new IllegalArgumentException(String.format("ID: %d is invalid", code));

        return optionalCustomerType.get();
    }
}
