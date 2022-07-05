package com.xxnbr.cursomc.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Date orderTime;
    private Payment payment;
    private Customer customer;
    private Address shippingAddress;

}
