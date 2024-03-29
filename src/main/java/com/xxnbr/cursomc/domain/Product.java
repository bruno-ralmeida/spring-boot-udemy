package com.xxnbr.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @EqualsAndHashCode.Exclude
    private String name;

    @EqualsAndHashCode.Exclude
    private BigDecimal price;

    @EqualsAndHashCode.Exclude
    @ManyToMany
    @JoinTable(name = "PRODUCT_CATEGORY", joinColumns = @JoinColumn(name = "PRODUCT_ID"), inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
    @Builder.Default
    @ToString.Exclude
    @JsonBackReference
    private List<Category> categories = new ArrayList<>(0);

    @OneToMany(mappedBy = "orderedItemPK.product")
    private Set<OrderedItem> items = new HashSet<>();

    private List<PurchaseOrder> getPurchaseOrder(){
        List<PurchaseOrder> purchaseOrderList = new ArrayList<>(0);

        for (OrderedItem orderedItem : items){
            purchaseOrderList.add(orderedItem.getOrderedItemPK().getPurchaseOrder());
        }

        return purchaseOrderList;
    }

}
