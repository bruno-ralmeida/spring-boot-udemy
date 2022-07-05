package com.xxnbr.cursomc.domain;

import com.xxnbr.cursomc.domain.enums.PaymentStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode
@NoArgsConstructor
public class Payment  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private PaymentStatus status;
    private PurchaseOrder purchaseOrder;

}
