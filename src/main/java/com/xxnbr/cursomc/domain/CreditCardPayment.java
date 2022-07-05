package com.xxnbr.cursomc.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class CreditCardPayment extends Payment {

    private static final long serialVersionUID = 1L;

    private Integer installments;
}
