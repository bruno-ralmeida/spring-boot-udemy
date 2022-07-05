package com.xxnbr.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.xxnbr.cursomc.domain.enums.CustomerType;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String cpfCnpj;

    @Getter(AccessLevel.NONE)
    private Integer typeCode;

    @Builder.Default
    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private List<Address> addresses = new ArrayList<>(0);

    @Builder.Default
    @ElementCollection
    @CollectionTable(name = "phones")
    private Set<String> phones = new HashSet<>();

    public CustomerType getTypeCode() {
        return CustomerType.toEnum(this.typeCode);
    }
}
