package com.xxnbr.cursomc.domain;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderedItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrderedItemPK orderedItemPK = new OrderedItemPK();

    @EqualsAndHashCode.Exclude
    private Double discount;

    @EqualsAndHashCode.Exclude
    private Integer quantity;

    @EqualsAndHashCode.Exclude
    private Double price;

}
