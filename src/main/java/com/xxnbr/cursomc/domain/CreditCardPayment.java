package com.xxnbr.cursomc.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class CreditCardPayment extends Payment {

    private static final long serialVersionUID = 1L;

    private Integer installments;
}
