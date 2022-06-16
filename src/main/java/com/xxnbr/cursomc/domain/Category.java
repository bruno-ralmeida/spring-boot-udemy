package com.xxnbr.cursomc.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Category implements Serializable {

    private static long serialVersionUID = 1L;

    private Integer id;

    @EqualsAndHashCode.Exclude
    private String name;
}
