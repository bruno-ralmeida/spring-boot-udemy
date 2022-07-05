package com.xxnbr.cursomc.domain;

import com.xxnbr.cursomc.domain.enums.PaymentStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode
@NoArgsConstructor
public abstract class Payment  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    @Getter(AccessLevel.NONE)
    private Integer status;

    @MapsId
    @OneToOne
    @JoinColumn(name = "purchase_order_id")
    private PurchaseOrder purchaseOrder;
    public PaymentStatus getStatus() {
        return PaymentStatus.toEnum(this.status);
    }

}
