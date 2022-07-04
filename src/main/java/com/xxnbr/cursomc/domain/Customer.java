package com.xxnbr.cursomc.domain;

import com.xxnbr.cursomc.domain.enums.CustomerType;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String email;
    private String cpfCnpj;

    @Getter(AccessLevel.NONE)
    private Integer typeCode;

    @Builder.Default
    private List<Address> addresses = new ArrayList<>(0);

    @Builder.Default
    private Set<String> phones = new HashSet<>();

    public CustomerType getTypeCode() {
        return CustomerType.toEnum(this.typeCode);
    }
}
