package com.xxnbr.cursomc.domain;

import java.io.Serializable;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String postalCode;
    private Customer customer;
    private City city;

}
