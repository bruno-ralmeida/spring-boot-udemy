package com.xxnbr.cursomc.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date orderTime;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "purchaseOrder")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "shipping_address_id")
    private Address shippingAddress;

    @OneToMany(mappedBy = "orderedItemPK.purchaseOrder")
    private Set<OrderedItem> items = new HashSet<>(0);

    private List<Product> getProducts(){
        List<Product> productList = new ArrayList<>(0);

        for (OrderedItem orderedItem : items){
            productList.add(orderedItem.getOrderedItemPK().getProduct());
        }

        return productList;
    }

}
