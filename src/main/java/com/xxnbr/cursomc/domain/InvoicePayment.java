package com.xxnbr.cursomc.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class InvoicePayment extends Payment{

    private static final long serialVersionUID = 1L;

    private Date dueDate;

    private Date payday;
}
