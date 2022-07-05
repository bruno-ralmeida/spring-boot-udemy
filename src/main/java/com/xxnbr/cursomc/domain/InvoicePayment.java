package com.xxnbr.cursomc.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class InvoicePayment extends Payment{

    private static final long serialVersionUID = 1L;

    private Date dueDate;

    private Date payday;
}
